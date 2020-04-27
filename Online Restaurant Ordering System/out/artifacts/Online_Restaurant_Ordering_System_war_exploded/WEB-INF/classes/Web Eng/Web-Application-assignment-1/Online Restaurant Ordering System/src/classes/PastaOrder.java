package classes;

import utilities.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PastaOrder implements OrderInterface {
    private String name;
    private String meatType;
    private String orderId;
    private double totalPrice;

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PastaOrder that = (PastaOrder) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(meatType, that.meatType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, meatType);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMeatType() {
        return meatType;
    }

    public void setMeatType(String meatType) {
        this.meatType = meatType;
    }

    public String getOrderId() {
        return orderId;
    }

    @Override
    public List<Pair> getItems() {
        List<Pair> temp = new ArrayList<>();
        temp.add(new Pair("Meat Type", getMeatType()));
        return temp;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
