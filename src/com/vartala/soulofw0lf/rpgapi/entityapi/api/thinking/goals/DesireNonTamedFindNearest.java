package com.vartala.soulofw0lf.rpgapi.entityapi.api.thinking.goals;

import net.minecraft.server.v1_6_R2.EntityLiving;
import net.minecraft.server.v1_6_R2.EntityTameableAnimal;
import com.vartala.soulofw0lf.rpgapi.entityapi.api.RemoteEntity;
import com.vartala.soulofw0lf.rpgapi.entityapi.api.features.TamingFeature;
import com.vartala.soulofw0lf.rpgapi.entityapi.exceptions.NotTameableException;

/**
 * Using this desire the entity will move towards the nearest entity of the given type which is not tamed.
 */
public class DesireNonTamedFindNearest extends DesireFindNearestTarget
{
	protected EntityLiving m_animal;

	@Deprecated
	public DesireNonTamedFindNearest(RemoteEntity inEntity, Class<?> inTargetClass, float inDistance, boolean inShouldCheckSight, boolean inShouldMelee, int inChance)
	{
		super(inEntity, inTargetClass, inDistance, inShouldCheckSight, inShouldMelee, inChance);
		if(!(this.getEntityHandle() instanceof EntityTameableAnimal) && !this.getRemoteEntity().getFeatures().hasFeature(TamingFeature.class))
			throw new NotTameableException();

		this.m_animal = this.getEntityHandle();
	}

	public DesireNonTamedFindNearest(Class<?> inTargetClass, float inDistance, boolean inShouldCheckSight, boolean inShouldMelee, int inChance)
	{
		super(inTargetClass, inDistance, inShouldCheckSight, inShouldMelee, inChance);
	}

	@Override
	public void onAdd(RemoteEntity inEntity)
	{
		super.onAdd(inEntity);
		if(!(this.getEntityHandle() instanceof EntityTameableAnimal) && !this.getRemoteEntity().getFeatures().hasFeature(TamingFeature.class))
			throw new NotTameableException();

		this.m_animal = this.getEntityHandle();
	}

	@Override
	public boolean shouldExecute()
	{
		return this.m_animal != null && !this.isTamed() && super.shouldExecute();
	}

	protected boolean isTamed()
	{
		if(this.m_animal instanceof EntityTameableAnimal)
			return ((EntityTameableAnimal)this.m_animal).isTamed();
		else
			return this.getRemoteEntity().getFeatures().getFeature(TamingFeature.class).isTamed();
	}
}