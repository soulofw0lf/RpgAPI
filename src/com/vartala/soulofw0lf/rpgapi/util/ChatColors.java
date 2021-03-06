package com.vartala.soulofw0lf.rpgapi.util;

import org.bukkit.ChatColor;

/**
 * Created by: soulofw0lf
 * Date: 6/23/13
 * Time: 12:52 PM
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
public class ChatColors {
    /**
     * This converts all chat color segments with &# into bukkit chat colors
     *
     * @param s The string to be changed
     * @return the string after it is changed
     */
    public static String ChatString(String s) {
        s = ChatColor.translateAlternateColorCodes('&', s);
        return s;
    }
}
