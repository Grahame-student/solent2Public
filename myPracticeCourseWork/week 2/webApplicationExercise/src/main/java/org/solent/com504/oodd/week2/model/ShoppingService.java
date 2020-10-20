package org.solent.com504.oodd.week2.model;

import java.util.List;

/**
 *
 * @author cgallen
 */
public interface ShoppingService
{
    public List<ShoppingItem> getAvailableItems();

    public boolean purchaseItems(ShoppingCart shoppinCart);

    public ShoppingItem getNewItemByName(String uuid);
}
