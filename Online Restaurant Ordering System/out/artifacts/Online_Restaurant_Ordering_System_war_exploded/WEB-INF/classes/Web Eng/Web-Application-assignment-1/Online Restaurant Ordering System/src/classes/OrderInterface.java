package classes;

import utilities.Pair;

import java.util.List;

public interface OrderInterface {
    public String getName();
    public String getOrderId();
    public List<Pair> getItems();
    public double getTotalPrice();
}
