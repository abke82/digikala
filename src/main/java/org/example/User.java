package org.example;
import java.io.Serializable;
import java.util.ArrayList;
public class User implements Serializable {
    //coment to product, order va mokhalafat
    private String username, password, email, phone, address;
    private float wallet;
    private ArrayList <Product> shoppingCart;
    private ArrayList <Product> orders;
    private ArrayList <Product> purchasedProducts;
    private float moneyRequested;

    public User(String username, String password, String email, String phone, String address) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.shoppingCart = new ArrayList<>();
        this.orders = new ArrayList<>();
        this.purchasedProducts = new ArrayList<>();
        this.wallet=0;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public float getWallet() {
        return wallet;
    }

    public float getMoneyRequested() {
        return moneyRequested;
    }

    public void setMoneyRequested(float moneyRequested) {
        this.moneyRequested = moneyRequested;
    }

    public void addWallet(float wallet) {
        this.wallet += wallet;
    }

    public boolean userPassCheck(String passInput){
        if (passInput.equals(password)) return true;
        return false;
    }

    public ArrayList<Product> getShoppingCart() {
        return shoppingCart;
    }

    public void addShoppingCart(Product product) {
        this.shoppingCart.add(product);
    }

    public ArrayList<Product> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Product> orders) {
        this.orders = orders;
    }

    public ArrayList<Product> getPurchasedProducts() {
        return purchasedProducts;
    }

    public void setPurchasedProducts(ArrayList<Product> purchasedProducts) {
        this.purchasedProducts = purchasedProducts;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", wallet=" + wallet +
                ", shoppingCart=" + shoppingCart +
                ", orders=" + orders +
                ", purchasedProducts=" + purchasedProducts +
                ", moneyRequested=" + moneyRequested +
                '}';
    }
}
