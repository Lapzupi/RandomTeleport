package de.themoep.randomteleport.api;

/*
 * RandomTeleport - randomteleport-plugin - $project.description
 * Copyright (c) 2019 Max Lee aka Phoenix616 (mail@moep.tv)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


import java.util.concurrent.CompletableFuture;

public interface RandomTeleportAPI<T extends Searcher, R extends Validator<T>> {
    
    /**
     * Returns a random Location
     *
     * @param player the Player initiating the search
     * @param center the location where the search should begin
     * @param minRange the minimum distance a found location has to the center location
     * @param maxRange the maximum distance a found location has to the center location
     * @param validators additional LocationValidators to customize validity check of a location
     * @return a random CompletableFuture<Location>
     */
    CompletableFuture<Location> getRandomLocation(Player player, Location center, int minRange, int maxRange, R... validators);

    /**
     * Teleports the passed Player to a random Location
     *
     * @param player the Player initiating the search
     * @param center the location where the search should begin
     * @param minRange the minimum distance a found location has to the center location
     * @param maxRange the maximum distance a found location has to the center location
     * @param validators additional LocationValidators to customize validity check of a location
     * @return a CompletableFuture<Boolean> true if teleport was successful else false
     */
    CompletableFuture<Boolean> teleportToRandomLocation(Player player, Location center, int minRange, int maxRange, R... validators);

    /**
     * Creates a RandomSearcher instance with the passed parameters
     *
     * @param player the Player initiating the search
     * @param center the location where the search should begin
     * @param minRange the minimum distance a found location has to the center location
     * @param maxRange the maximum distance a found location has to the center location
     * @param validators additional LocationValidators to customize validity check of a location
     * @return a randomSearcher instance
     */
    T getRandomSearcher(Player player, Location center, int minRange, int maxRange, R... validators);

    /**
     * Teleports the passed Player to a random Location
     *
     * @param player the Player initiating the search
     * @param preset the preset to use
     * @param center can be null
     */
    void runPreset(CommandSender sender, Player player, String preset, Location center);
}
