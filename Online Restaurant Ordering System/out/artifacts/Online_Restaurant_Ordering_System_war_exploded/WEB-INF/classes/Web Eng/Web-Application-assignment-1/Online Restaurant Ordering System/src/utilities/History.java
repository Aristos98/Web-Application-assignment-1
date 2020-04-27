package utilities;

import classes.Cart;

import java.util.ArrayList;
import java.util.List;

public class History {
    List<Cart> pastOrders;

    public void addOrders(Cart item){
        if(pastOrders == null)
            pastOrders = new ArrayList<>();
        pastOrders.add(item);
    }

    public List<Cart> getHistory(){
        return pastOrders;
    }
}
