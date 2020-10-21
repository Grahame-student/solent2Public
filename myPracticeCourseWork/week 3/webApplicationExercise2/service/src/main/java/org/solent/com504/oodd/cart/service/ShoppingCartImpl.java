/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.solent.com504.oodd.cart.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.solent.com504.oodd.cart.model.service.ShoppingCart;
import org.solent.com504.oodd.cart.model.dto.ShoppingItem;

/**
 *
 * @author cgallen
 */
public class ShoppingCartImpl implements ShoppingCart
{
    private HashMap<String, ShoppingItem> itemMap = new HashMap<String, ShoppingItem>();

    @Override
    public List<ShoppingItem> getShoppingCartItems()
    {
        List<ShoppingItem> itemlist = new ArrayList();
        for (String itemUUID : itemMap.keySet())
        {
            ShoppingItem shoppingCartItem = itemMap.get(itemUUID);
            itemlist.add(shoppingCartItem);
        }
        return itemlist;
    }

    @Override
    public void addItemToCart(ShoppingItem shoppingItem)
    {
        ShoppingItem item = itemMap.get(shoppingItem.getUuid());

        if (item == null)
        {
            // item has not been previously added to the cart
            incrementQuantity(shoppingItem);
            itemMap.put(shoppingItem.getUuid(), shoppingItem);
        }
        else
        {
            incrementQuantity(item);
        }
    }

    private static void incrementQuantity(ShoppingItem shoppingItem)
    {
        shoppingItem.setQuantity(shoppingItem.getQuantity() + 1);
    }

    @Override
    public void removeItemFromCart(String itemUuid)
    {
        itemMap.remove(itemUuid);
    }

    @Override
    public double getTotal()
    {
        double total = 0;

        for (String itemUUID : itemMap.keySet())
        {
            ShoppingItem shoppingCartItem = itemMap.get(itemUUID);
            total += (shoppingCartItem.getPrice() * shoppingCartItem.getQuantity());
        }

        return total;
    }
}
