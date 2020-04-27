package classes;

import utilities.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PizzaOrder implements OrderInterface {
    private String name;
    private String orderId;
    private String olive;
    private String onion;
    private String corn;
    private double totalPrice;

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrderId() {
        return orderId;
    }

    @Override
    public List<Pair> getItems() {
        List<Pair> temp = new ArrayList<>();
        temp.add(new Pair("Olive", getOlive()));
        temp.add(new Pair("Corn", getCorn()));
        temp.add(new Pair("Onion", getOnion()));
        return temp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PizzaOrder that = (PizzaOrder) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(olive, that.olive) &&
                Objects.equals(onion, that.onion) &&
                Objects.equals(corn, that.corn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, olive, onion, corn);
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOlive() {
        return olive;
    }

    public int getOliveInt() {
        if(olive.equalsIgnoreCase("none"))
            return 0;
        if(olive.equalsIgnoreCase("extra"))
            return 2;
        return 1;
    }

    public void setOlive(String olive) {
        this.olive = olive;
    }

    public void setOlive(int olive) {
        if(olive == 0)
            this.olive = "None";
        else if(olive == 1)
            this.olive = "Medium";
        else
            this.olive = "Extra";
    }

    public String getOnion() {
        return onion;
    }

    public int getOnionInt() {
        if(onion.equalsIgnoreCase("none"))
            return 0;
        if(onion.equalsIgnoreCase("extra"))
            return 2;
        return 1;
    }

    public void setOnion(String onion) {
        this.onion = onion;
    }

    public void setOnion(int onion) {
        if(onion == 0)
            this.onion = "None";
        else if(onion == 1)
            this.onion = "Medium";
        else
            this.onion = "Extra";
    }

    public String getCorn() {
        return corn;
    }

    public int getCornInt() {
        if(corn.equalsIgnoreCase("none"))
            return 0;
        if(corn.equalsIgnoreCase("extra"))
            return 2;
        return 1;
    }

    public void setCorn(String corn) {
        this.corn = corn;
    }

    public void setCorn(int corn) {
        if(corn == 0)
            this.corn = "None";
        else if(corn == 1)
            this.corn = "Medium";
        else
            this.corn = "Extra";
    }
}
