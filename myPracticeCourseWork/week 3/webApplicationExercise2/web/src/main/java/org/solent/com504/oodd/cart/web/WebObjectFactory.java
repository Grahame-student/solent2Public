package org.solent.com504.oodd.cart.web;

import org.solent.com504.oodd.cart.model.service.ShoppingCart;
import org.solent.com504.oodd.cart.model.service.ShoppingService;
import org.solent.com504.oodd.cart.service.ServiceObjectFactory;

/**
 *
 * @author cgallen
 */
public class WebObjectFactory
{
    static ShoppingService shoppingService = ServiceObjectFactory.getShoppingService();

    // cannot instantiate
    private WebObjectFactory()
    {

    }

    public static ShoppingService getShoppingService()
    {
        return shoppingService;
    }

    public static ShoppingCart getNewShoppingCart()
    {
        return ServiceObjectFactory.getNewShoppingCart();
    }
}
