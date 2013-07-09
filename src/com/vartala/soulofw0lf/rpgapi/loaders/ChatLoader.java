package com.vartala.soulofw0lf.rpgapi.loaders;

import com.vartala.soulofw0lf.rpgapi.RpgAPI;
import com.vartala.soulofw0lf.rpgapi.chatapi.*;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

/**
 * Created by: soulofw0lf
 * Date: 7/8/13
 * Time: 5:59 PM
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
public class ChatLoader {
    RpgAPI rpg;
    public ChatLoader(RpgAPI Rpg){
        this.rpg = Rpg;
    this.rpg.chatListener = new ChatListener(this.rpg);
        RpgAPI.chatLocaleConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/Locale/RpgChat.yml"));
        RpgAPI.chatConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/RpgChat.yml"));
        RpgAPI.cityConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/RpgChat/RpgCities.yml"));
        RpgAPI.cityLocaleConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/Locale/RpgCities.yml"));
        RpgAPI.regionConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/RpgChat/RpgRegions.yml"));
        RpgAPI.regionLocaleConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/Locale/RpgRegions.yml"));

    if (RpgAPI.cityConfig.get("Rpg Cities") == null) {
        RpgAPI.chatLocaleConfig.set("Translations.Chat Left Click", "&2Left click to join this channel or switch it's color");
        RpgAPI.chatLocaleConfig.set("Translations.Chat Right Click", "&4Right click to leave this channel");
        RpgAPI.chatLocaleConfig.set("Translations.Chat Shift Click", "&9Shift click to set this as your active channel");
        RpgAPI.cityConfig.set("Rpg Cities.Example City.Radius", 100);
        RpgAPI.cityConfig.set("Rpg Cities.Example City.X", 0.0);
        RpgAPI.cityConfig.set("Rpg Cities.Example City.Y", 0.0);
        RpgAPI.cityConfig.set("Rpg Cities.Example City.Z", 0.0);
        RpgAPI.cityConfig.set("Rpg Cities.Example City.World", "World");
    }
    if (RpgAPI.regionConfig.get("Rpg Regions") == null) {
        RpgAPI.regionConfig.set("Rpg Regions.Example Region.Radius", 100);
        RpgAPI.regionConfig.set("Rpg Regions.Example Region.X", 0.0);
        RpgAPI.regionConfig.set("Rpg Regions.Example Region.Y", 0.0);
        RpgAPI.regionConfig.set("Rpg Regions.Example Region.Z", 0.0);
        RpgAPI.regionConfig.set("Rpg Regions.Example Region.World", "World");
    }
    if (RpgAPI.chatConfig.get("Channels") == null) {
        RpgAPI.chatConfig.set("Titles and Names", "&7[@World]&2[@Guild]&3[@Channel]&r[@Prefix @Pname @Suffix&F]");
        //whisper Chat
        RpgAPI.chatConfig.set("Chats.Whisper.Name", "Whisper");
        RpgAPI.chatConfig.set("Chats.Whisper.Nick Name", "W");
        RpgAPI.chatConfig.set("Chats.Whisper.Enabled", true);
        RpgAPI.chatConfig.set("Chats.Whisper.Spy Enabled", true);
        RpgAPI.chatConfig.set("Chats.Whisper.Use Basic", true);
        RpgAPI.chatConfig.set("Chats.Whisper.Use Language", true);
        RpgAPI.chatConfig.set("Chats.Whisper.Use Distance", true);
        RpgAPI.chatConfig.set("Chats.Whisper.Distance", 5);
        RpgAPI.chatConfig.set("Chats.Whisper.Use Party", false);
        RpgAPI.chatConfig.set("Chats.Whisper.Use Guild", false);
        RpgAPI.chatConfig.set("Chats.Whisper.Use Region", false);
        RpgAPI.chatConfig.set("Chats.Whisper.Use City", false);
        RpgAPI.chatConfig.set("Chats.Whisper.Use World", false);

        //local chat
        RpgAPI.chatConfig.set("Chats.Local.Name", "Local");
        RpgAPI.chatConfig.set("Chats.Local.Nick Name", "L");
        RpgAPI.chatConfig.set("Chats.Local.Enabled", true);
        RpgAPI.chatConfig.set("Chats.Local.Spy Enabled", true);
        RpgAPI.chatConfig.set("Chats.Local.Use Basic", true);
        RpgAPI.chatConfig.set("Chats.Local.Use Language", true);
        RpgAPI.chatConfig.set("Chats.Local.Use Distance", true);
        RpgAPI.chatConfig.set("Chats.Local.Distance", 50);
        RpgAPI.chatConfig.set("Chats.Local.Use Party", false);
        RpgAPI.chatConfig.set("Chats.Local.Use Guild", false);
        RpgAPI.chatConfig.set("Chats.Local.Use Region", false);
        RpgAPI.chatConfig.set("Chats.Local.Use City", false);
        RpgAPI.chatConfig.set("Chats.Local.Use World", false);

        //shout Chat
        RpgAPI.chatConfig.set("Chats.Shout.Name", "Shout");
        RpgAPI.chatConfig.set("Chats.Shout.Nick Name", "Yell");
        RpgAPI.chatConfig.set("Chats.Shout.Enabled", true);
        RpgAPI.chatConfig.set("Chats.Shout.Spy Enabled", true);
        RpgAPI.chatConfig.set("Chats.Shout.Use Basic", true);
        RpgAPI.chatConfig.set("Chats.Shout.Use Language", true);
        RpgAPI.chatConfig.set("Chats.Shout.Use Distance", true);
        RpgAPI.chatConfig.set("Chats.Shout.Distance", 150);
        RpgAPI.chatConfig.set("Chats.Shout.Use Party", false);
        RpgAPI.chatConfig.set("Chats.Shout.Use Guild", false);
        RpgAPI.chatConfig.set("Chats.Shout.Use Region", false);
        RpgAPI.chatConfig.set("Chats.Shout.Use City", false);
        RpgAPI.chatConfig.set("Chats.Shout.Use World", false);

        //General chat
        RpgAPI.chatConfig.set("Chats.General.Name", "General");
        RpgAPI.chatConfig.set("Chats.General.Nick Name", "Gen");
        RpgAPI.chatConfig.set("Chats.General.Enabled", true);
        RpgAPI.chatConfig.set("Chats.General.Spy Enabled", true);
        RpgAPI.chatConfig.set("Chats.General.Use Basic", true);
        RpgAPI.chatConfig.set("Chats.General.Use Language", true);
        RpgAPI.chatConfig.set("Chats.General.Use Distance", false);
        RpgAPI.chatConfig.set("Chats.General.Use Party", false);
        RpgAPI.chatConfig.set("Chats.General.Use Guild", false);
        RpgAPI.chatConfig.set("Chats.General.Use Region", false);
        RpgAPI.chatConfig.set("Chats.General.Use City", false);
        RpgAPI.chatConfig.set("Chats.General.Use World", false);

        //party Chat
        RpgAPI.chatConfig.set("Chats.Party.Name", "Party");
        RpgAPI.chatConfig.set("Chats.Party.Nick Name", "Pc");
        RpgAPI.chatConfig.set("Chats.Party.Enabled", true);
        RpgAPI.chatConfig.set("Chats.Party.Spy Enabled", true);
        RpgAPI.chatConfig.set("Chats.Party.Use Basic", true);
        RpgAPI.chatConfig.set("Chats.Party.Use Language", true);
        RpgAPI.chatConfig.set("Chats.Party.Use Distance", false);
        RpgAPI.chatConfig.set("Chats.Party.Use Party", true);
        RpgAPI.chatConfig.set("Chats.Party.Use Guild", false);
        RpgAPI.chatConfig.set("Chats.Party.Use Region", false);
        RpgAPI.chatConfig.set("Chats.Party.Use City", false);
        RpgAPI.chatConfig.set("Chats.Party.Use World", false);

        //guild chat
        RpgAPI.chatConfig.set("Chats.Guild.Name", "Guild");
        RpgAPI.chatConfig.set("Chats.Guild.Nick Name", "G");
        RpgAPI.chatConfig.set("Chats.Guild.Enabled", true);
        RpgAPI.chatConfig.set("Chats.Guild.Spy Enabled", true);
        RpgAPI.chatConfig.set("Chats.Guild.Use Basic", true);
        RpgAPI.chatConfig.set("Chats.Guild.Use Language", true);
        RpgAPI.chatConfig.set("Chats.Guild.Use Distance", false);
        RpgAPI.chatConfig.set("Chats.Guild.Use Party", false);
        RpgAPI.chatConfig.set("Chats.Guild.Use Guild", true);
        RpgAPI.chatConfig.set("Chats.Guild.Use Region", false);
        RpgAPI.chatConfig.set("Chats.Guild.Use City", false);
        RpgAPI.chatConfig.set("Chats.Guild.Use World", false);

        //world chat
        RpgAPI.chatConfig.set("Chats.World.Name", "World");
        RpgAPI.chatConfig.set("Chats.Guild.Nick Name", "world");
        RpgAPI.chatConfig.set("Chats.World.Enabled", true);
        RpgAPI.chatConfig.set("Chats.World.Spy Enabled", true);
        RpgAPI.chatConfig.set("Chats.World.Use Basic", true);
        RpgAPI.chatConfig.set("Chats.World.Use Language", true);
        RpgAPI.chatConfig.set("Chats.World.Use Distance", false);
        RpgAPI.chatConfig.set("Chats.World.Use Party", false);
        RpgAPI.chatConfig.set("Chats.World.Use Guild", false);
        RpgAPI.chatConfig.set("Chats.World.Use Region", false);
        RpgAPI.chatConfig.set("Chats.World.Use City", false);
        RpgAPI.chatConfig.set("Chats.World.Use World", true);

        //region Chat
        RpgAPI.chatConfig.set("Chats.Region.Name", "Region");
        RpgAPI.chatConfig.set("Chats.Region.Nick Name", "Reg");
        RpgAPI.chatConfig.set("Chats.Region.Enabled", true);
        RpgAPI.chatConfig.set("Chats.Region.Spy Enabled", true);
        RpgAPI.chatConfig.set("Chats.Region.Use Basic", true);
        RpgAPI.chatConfig.set("Chats.Region.Use Language", true);
        RpgAPI.chatConfig.set("Chats.Region.Use Distance", false);
        RpgAPI.chatConfig.set("Chats.Region.Use Party", false);
        RpgAPI.chatConfig.set("Chats.Region.Use Guild", false);
        RpgAPI.chatConfig.set("Chats.Region.Use Region", true);
        RpgAPI.chatConfig.set("Chats.Region.Use City", false);
        RpgAPI.chatConfig.set("Chats.Region.Use World", true);

        //trade chat
        RpgAPI.chatConfig.set("Chats.Trade.Name", "Trade");
        RpgAPI.chatConfig.set("Chats.Trade.Nick Name", "Tr");
        RpgAPI.chatConfig.set("Chats.Trade.Enabled", true);
        RpgAPI.chatConfig.set("Chats.Trade.Spy Enabled", true);
        RpgAPI.chatConfig.set("Chats.Trade.Use Basic", true);
        RpgAPI.chatConfig.set("Chats.Trade.Use Language", true);
        RpgAPI.chatConfig.set("Chats.Trade.Use Distance", false);
        RpgAPI.chatConfig.set("Chats.Trade.Use Party", false);
        RpgAPI.chatConfig.set("Chats.Trade.Use Guild", false);
        RpgAPI.chatConfig.set("Chats.Trade.Use Region", false);
        RpgAPI.chatConfig.set("Chats.Trade.Use City", true);
        RpgAPI.chatConfig.set("Chats.Trade.Use World", false);
        }
        try {
            RpgAPI.chatLocaleConfig.save(new File("plugins/RpgAPI/Locale/RpgChat.yml"));
            RpgAPI.chatConfig.save(new File("plugins/RpgAPI/RpgChat.yml"));
            RpgAPI.cityConfig.save(new File("plugins/RpgAPI/RpgChat/RpgCities.yml"));
            RpgAPI.cityLocaleConfig.save(new File("plugins/RpgAPI/Locale/RpgCities.yml"));
            RpgAPI.regionConfig.save(new File("plugins/RpgAPI/RpgChat/RpgRegions.yml"));
            RpgAPI.regionLocaleConfig.save(new File("plugins/RpgAPI/Locale/RpgRegions.yml"));
        } catch (IOException e) {
        }
        //after file is saved
        LoadCities.FromFile();
        LoadRegions.FromFile();
        RpgAPI.nameDisplays = RpgAPI.chatConfig.getString("Titles and Names");
        for (String chats : RpgAPI.chatConfig.getConfigurationSection("Chats").getKeys(false)) {
            //general chat
            if (RpgAPI.chatConfig.getBoolean("Chats." + chats + ".Enabled")) {
                ChatClass chatClass = new ChatClass();
                chatClass.setChannelName(chats);
                chatClass.setChannelNick(RpgAPI.chatConfig.getString("Chats." + chats + ".Nick Name"));
                RpgAPI.chatRealNames.put(RpgAPI.chatConfig.getString("Chats." + chats + ".Nick Name"), chats);
                RpgAPI.commands.add(chatClass.getChannelNick());
                chatClass.setChatSpy(RpgAPI.chatConfig.getBoolean("Chats." + chats + ".Spy Enabled"));
                if (RpgAPI.chatConfig.getBoolean("Chats." + chats + ".Use Basic")) {
                    chatClass.addBehavior(new BasicChatBehavior());
                }
                if (RpgAPI.chatConfig.getBoolean("Chats." + chats + ".Use Language")) {
                    chatClass.addBehavior(new LanguageBehavior());
                }
                if (RpgAPI.chatConfig.getBoolean("Chats." + chats + ".Use Distance")) {
                    chatClass.addBehavior(new DistanceChatBehavior());
                    RpgAPI.chatDistances.put(chats, RpgAPI.chatConfig.getInt("Chats." + chats + ".Distance"));
                }
                if (RpgAPI.chatConfig.getBoolean("Chats." + chats + ".Use Party")) {
                    chatClass.addBehavior(new PartyChatBehavior());
                }
                if (RpgAPI.chatConfig.getBoolean("Chats." + chats + ".Use Guild")) {
                    chatClass.addBehavior(new GuildChatBehavior());
                }
                if (RpgAPI.chatConfig.getBoolean("Chats." + chats + ".Use Region")) {
                    chatClass.addBehavior(new RegionChatBehavior());
                }
                if (RpgAPI.chatConfig.getBoolean("Chats." + chats + ".Use City")) {
                    chatClass.addBehavior(new CityChatBehavior());
                }
                if (RpgAPI.chatConfig.getBoolean("Chats." + chats + ".Use World")) {
                    chatClass.addBehavior(new WorldChatBehavior());
                }
                RpgAPI.chatClasses.add(chatClass);
            }
        }
    }
}