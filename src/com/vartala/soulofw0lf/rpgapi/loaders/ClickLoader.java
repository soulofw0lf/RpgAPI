package com.vartala.soulofw0lf.rpgapi.loaders;

import com.vartala.soulofw0lf.rpgapi.RpgAPI;
import com.vartala.soulofw0lf.rpgapi.guiapi.ClickInvListener;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

/**
 * Created by: soulofw0lf
 * Date: 7/8/13
 * Time: 6:08 PM
 * <p/>
 * This file is part of the Rpg Suite Created by Soulofw0lf and Linksy.
 * <p/>
 * The Rpg Suite is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p/>
 * The Rpg Suite is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p/>
 * You should have received a copy of the GNU General Public License
 * along with The Rpg Suite Plugin you have downloaded.  If not, see <http://www.gnu.org/licenses/>.
 */
public class ClickLoader {
    RpgAPI rpg;

    /**
     *
     * @param Rpg
     */
    public ClickLoader(RpgAPI Rpg){
        this.rpg = Rpg;
        this.rpg.clickListener = new ClickInvListener(this.rpg);
        RpgAPI.clickLocaleConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgClick/Locale/Clicks.yml"));
        RpgAPI.clickConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgClick/Clicks.yml"));
        if (RpgAPI.clickConfig.get("Click Settings") == null) {
            RpgAPI.clickConfig.set("Click Settings", "This File is used to save all your click setting's");
        }
        try {
            RpgAPI.clickLocaleConfig.save(new File("plugins/RpgClick/Locale/Clicks.yml"));
            RpgAPI.clickConfig.save(new File("plugins/RpgClick/Clicks.yml"));
        } catch (IOException e) {
        }
        //after file is saved
    }
}
