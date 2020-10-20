package org.solent.com504.oodd.week2.model;

import java.util.List;

/**
 *
 * @author cgallen
 */
public interface ShoppingCart
{
    public List<ShoppingItem> getShoppingCartItems();

    public void addItemToCart(ShoppingItem shoppingItem);

    public void removeItemFromCart(String itemUuid);

    public double getTotal();
}
