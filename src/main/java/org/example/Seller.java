package org.example;
import java.io.Serializable;
import java.util.HashMap;

public class Seller implements Serializable {
    private String company, password;
    private HashMap<String,Product> availableProducts;
    private double wallet;

    public Seller(String company, String password) {
        this.company = company;
        this.password = password;
        this.availableProducts = new HashMap<>();
    }
    public boolean sellerPassCheck(String passInput){
        if (passInput.equals(password)) return true;
        return false;
    }

    public void addAvailableSellerProducts(Product products) {
        this.availableProducts.put(products.getName(),products);
    }
    public void printAvailableSellerProducts() {
        System.out.println(availableProducts);
    }

    public int getQuantityAvailableProducts(String productName){
        return availableProducts.get(productName).getQuantity();
    }
    public void setAvailableProducts(String productName, int i){
        availableProducts.get(productName).setQuantity(i);
    }

    public double getWallet() {
        return wallet;
    }
}
