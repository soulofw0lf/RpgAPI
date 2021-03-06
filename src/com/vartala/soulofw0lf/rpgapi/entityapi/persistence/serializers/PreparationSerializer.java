package com.vartala.soulofw0lf.rpgapi.entityapi.persistence.serializers;

import com.vartala.soulofw0lf.rpgapi.entityapi.CreateEntityContext;
import com.vartala.soulofw0lf.rpgapi.entityapi.EntityManager;
import com.vartala.soulofw0lf.rpgapi.entityapi.RemoteEntities;
import org.bukkit.plugin.Plugin;
import com.vartala.soulofw0lf.rpgapi.entityapi.api.RemoteEntity;
import com.vartala.soulofw0lf.rpgapi.entityapi.api.thinking.DesireItem;
import com.vartala.soulofw0lf.rpgapi.entityapi.persistence.*;

/**
 * This is a base seralizer which creates the data from an entity and creates an entity from the data, but it does not save it or load it to a file.
 */
public abstract class PreparationSerializer implements IEntitySerializer
{
	protected final Plugin m_plugin;

	public PreparationSerializer(Plugin inPlugin)
	{
		this.m_plugin = inPlugin;
	}

	@Override
	public EntityData prepare(RemoteEntity inEntity)
	{
		return new EntityData(inEntity);
	}

	@Override
	public RemoteEntity create(EntityData inData)
	{
		EntityManager manager = RemoteEntities.getManagerOfPlugin(this.m_plugin.getName());
		CreateEntityContext context = manager.prepareEntity(inData.type);
		context.withName(inData.name).asPushable(inData.pushable).asStationary(inData.stationary).withID(inData.id);
		context.withSpeed(inData.speed).withPathfindingRange(inData.pathfindingRange);
		if(inData.location != null)
			context.atLocation(inData.location.toBukkitLocation());

		RemoteEntity entity = context.create();
		for(DesireData data : inData.movementDesires)
		{
			DesireItem item = data.create(entity);
			entity.getMind().addMovementDesire(item.getDesire(), item.getPriority());
		}

		for(DesireData data : inData.actionDesires)
		{
			DesireItem item = data.create(entity);
			entity.getMind().addTargetingDesire(item.getDesire(), item.getPriority());
		}

		for(BehaviorData data : inData.behaviors)
		{
			entity.getMind().addBehaviour(data.create(entity));
		}

		return entity;
	}
}