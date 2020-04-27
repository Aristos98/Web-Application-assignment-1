package classes;

import utilities.DbUtility;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Cart {
    private String orderId;
    private List<OrderInterface> orders;
    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public List<OrderInterface> getOrders(){
        return orders;
    }

    public boolean deleteOrder(OrderInterface orderDelete){
        if(orders == null)
            return false;

        for(OrderInterface order : orders){
            if(order.equals(orderDelete)){
                orders.remove(order);
                return true;
            }
        }
        return false;
    }

    public void addOrder(OrderInterface order){
        if(orders == null)
            orders = new ArrayList<>();
        DbUtility.addOrder(order);
        orders.add(order);
    }

    public void addOrders(List<OrderInterface> orders){
        if(this.orders == null)
            this.orders = new ArrayList<>();
        this.orders.addAll(orders);
    }
}
