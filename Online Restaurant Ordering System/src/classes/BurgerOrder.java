package classes;

import utilities.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BurgerOrder implements OrderInterface {
    private String name;
    private String orderId;
    private String meatWeight;
    private String cheese;
    private String tomato;
    private String lettuce;
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
        temp.add(new Pair("Cheese", getCheese()));
        temp.add(new Pair("Lettuce", getLettuce()));
        temp.add(new Pair("Meat Weight", getMeatWeight()));
        temp.add(new Pair("Tomato", getTomato()));
        return temp;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getMeatWeight() {
        return meatWeight;
    }

    public int getMeatWeightInt() {
        return Integer.parseInt(meatWeight.substring(0, meatWeight.length() - 1));
    }

    public void setMeatWeight(int meatWeight) {
        this.meatWeight = meatWeight + "g";
    }

    public void setMeatWeight(String meatWeight) {
        this.meatWeight = meatWeight;
    }

    public String getCheese() {
        return cheese;
    }

    public int getCheeseInt() {
        if(cheese.equalsIgnoreCase("none"))
            return 0;
        if(cheese.equalsIgnoreCase("extra"))
            return 2;
        return 1;
    }

    public void setCheese(String cheese) {
        this.cheese = cheese;
    }

    public void setCheese(int cheese) {
        if(cheese == 0)
            this.cheese = "None";
        else if(cheese == 1)
            this.cheese = "Medium";
        else
            this.cheese = "Extra";
    }

    public String getTomato() {
        return tomato;
    }

    public int getTomatoInt() {
        if(tomato.equalsIgnoreCase("none"))
            return 0;
        if(tomato.equalsIgnoreCase("extra"))
            return 2;
        return 1;
    }

    public void setTomato(String tomato) {
        this.tomato = tomato;
    }

    public void setTomato(int tomato) {
        if(tomato == 0)
            this.tomato = "None";
        else if(tomato == 1)
            this.tomato = "Medium";
        else
            this.tomato = "Extra";
    }

    public String getLettuce() {
        return lettuce;
    }

    public int getLettuceInt() {
        if(lettuce.equalsIgnoreCase("none"))
            return 0;
        if(lettuce.equalsIgnoreCase("extra"))
            return 2;
        return 1;
    }

    public void setLettuce(String lettuce) {
        this.lettuce = lettuce;
    }

    public void setLettuce(int lettuce) {
        if(lettuce == 0)
            this.lettuce = "None";
        else if(lettuce == 1)
            this.lettuce = "Medium";
        else
            this.lettuce = "Extra";
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BurgerOrder that = (BurgerOrder) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(meatWeight, that.meatWeight) &&
                Objects.equals(cheese, that.cheese) &&
                Objects.equals(tomato, that.tomato) &&
                Objects.equals(lettuce, that.lettuce);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, meatWeight, cheese, tomato, lettuce);
    }
}
