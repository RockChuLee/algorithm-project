package com.nyu.oa.twitter;


/**
 * A purchasing manager must buy a specific number of units of an item to replenish the warehouse.
 * The primary supplier has a list of containers, each with a number of units. The manager must buy
 * contiguous containers,starting at container 0 and continuing until at least the desired number have
 * been purchased.If there are not enough units available, they must be purchased from an additional supplier.
 * If any excess items must be purchased, there is no room for storage and they must be resold.
 * Determine the remaining number of items to be purchased or the number that must be sold after
 * the purchase from the primary supplier.
 * For example, there are containers with itemCount=[10,20,30,40,15].
 * If the target quantity target= 80, the manager will start buying at index 0 and continue until
 * all available units are purchased or until at least 80 units have been purchased. The manager
 * will buy containers with itemCounts = 10 + 20 + 30 + 40 = 100. In this case, the number sold is
 * purchased - target = 100 - 80 = 20 units.If the goal is target = 130, the manager will
 * purchase all of the units for a total of purchase 115 and an additional target - purchases= 130-
 *
 */

public class RestockingtheWarehouse {
}
