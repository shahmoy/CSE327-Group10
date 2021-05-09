package com.example.csesabihaproject.Models;
import com.google.firebase.firestore.DocumentId;
public class Product {

    @DocumentId
    String Productid;
    String title, imageUrl;
    int price, quantity;


    public Product() {


    }

    public Product(String productid, String title, String imageUrl, int price, int quantity) {

        Productid = productid;
        this.title = title;
        this.imageUrl = imageUrl;
        this.price = price;
        this.quantity = quantity;
    }

    public String getProductid() {
        return Productid;
    }

    public void setProductid(String productid) {
        Productid = productid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
