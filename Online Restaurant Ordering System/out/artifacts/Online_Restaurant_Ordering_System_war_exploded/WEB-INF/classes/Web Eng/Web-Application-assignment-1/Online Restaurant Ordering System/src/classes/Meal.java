package classes;

import utilities.ImagesUrl;

public class Meal {
    private String name;
    private String urlKey;
    private String url;
    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUrlKey(String urlKey) {
        this.urlKey = urlKey;
    }

    public String getUrl() {
        if(url != null)
            return url;
        url =  ImagesUrl.getUrl(urlKey);
        return url;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
