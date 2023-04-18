package org.example;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Shop implements Serializable {
    private String name, webAddress, phoneNum;
    private double profit;
    private HashMap<String,User> users;
    private HashMap<String,Admin> admins;
    private HashMap<String,Seller> sellers;
    private HashMap<String,User> moneyRequesteds;
    private HashMap<String,Seller> sellerRequest;
    private HashMap <String,Product> products;
    private HashMap <String,Category> categories;
    private HashMap<String,SubCategory> subCategories;

    public Shop(String name, String webAddress, String phoneNum) {
        this.name = name;
        this.webAddress = webAddress;
        this.phoneNum = phoneNum;
        this.users = new HashMap<>();
        this.admins = new HashMap<>();
        this.sellers = new HashMap<>();
        this.moneyRequesteds = new HashMap<>();
        this.sellerRequest= new HashMap<>();
        this.categories= new HashMap<>();
        this.subCategories = new HashMap<>();
        this.products = new HashMap<>();

        profit=0;
        Admin admin = new Admin("admin","admin","admin@gmail.com");
        admins.put("admin",admin);
    }


    //////////////////////////////////////////////product
    public void printProduct(){
        System.out.println(products);
    }
    public boolean doesProductExist(String name){
        return products.containsKey(name);
    }
    public int getQuantity (String productname){ return products.get(productname).getQuantity();}
    public void addToShoppingCart(String username, Product product){
        users.get(username).addShoppingCart(product);
    }
    public void decreaseQuanttiy(String productName,int i){
        int x = products.get(productName).getQuantity()-i;
        products.get(productName).setQuantity(x);
        String company = products.get(productName).getCompany();
        sellers.get(company).setAvailableProducts(productName,x);
    }
    public void increaseQuanttiy(String productName,int i){
        int x = products.get(productName).getQuantity() + i;
        products.get(productName).setQuantity(x);
        String company = products.get(productName).getCompany();
        sellers.get(company).setAvailableProducts(productName,x);
    }
    public Product getProductByName(String producName){
        return products.get(producName);
    }
    public int getQuantityOfsellerProduct(String productName){
        String company = products.get(productName).getCompany();
        return sellers.get(company).getQuantityAvailableProducts(productName);
    }


    ///////////////////////////////////////////////admin
    public void addAdmin(String username,String pass,String email){
        Admin admin=new Admin(username,pass,email);
        admins.put(username,admin);
    }

    public boolean doesAdminExist(String username){
        return admins.containsKey(username);
    }
    public void printMonyRequesteds(){
        int i =1;
        for (String name: moneyRequesteds.keySet()) {

            String key = name.toString();
            float value = moneyRequesteds.get(name).getMoneyRequested();
            System.out.println(i +"-"+ key + " " + value);
            i++;
        }
    }

    public void depositMoneyRequestend(int i){
        int j=0;
        for (String name: moneyRequesteds.keySet()) {
            j++;
            if(j==i){
                float value = moneyRequesteds.get(name).getMoneyRequested();
                moneyRequesteds.get(name).addWallet(value);
                moneyRequesteds.get(name).setMoneyRequested(0);
                moneyRequesteds.remove(name);
                break;
            }
        }
    }

    public void printsellerRequest(){
        int i =1;
        for (String name: sellerRequest.keySet()) {
            String key = name.toString();
            System.out.println(i +"-"+ key);
            i++;
        }
    }

    public void confirmSeller(int i){
        int j=0;
        for (String name: sellerRequest.keySet()) {
            j++;
            if(j==i){
                sellers.put(name,sellerRequest.get(name));
                sellerRequest.remove(name);
                break;
            }
        }

    }

    public void printUsers(){
        int i =1;
        for (String name: users.keySet()) {
            System.out.println(i +"-"+ users.get(name).toString());
            i++;
        }
    }

    public boolean AdminPassChack(String username ,String pass){
        return admins.get(username).adminPassCheck(pass);
    }
    public String getAdminEmail(String name) {
        return admins.get(name).getEmail();
    }

    ///////////////////////////////////////////////seller
    public void addSeller(String company,String pass){
        Seller seller=new Seller(company, pass);
        sellerRequest.put(company,seller);
        System.out.println("After confirmation, you will be add to our sellers.");
    }

    public boolean doesSellerExist(String company){
        return ( sellers.containsKey(company));
    }

    public boolean SellerPassChack(String username ,String pass){
        return sellers.get(username).sellerPassCheck(pass);
    }

    public void addProduct(String username ,Product product){
        products.put(product.getName(),product);
        sellers.get(username).addAvailableSellerProducts(product);
    }

    public void printSellerProduct(String sellername){sellers.get(sellername).printAvailableSellerProducts();}
    public double getSellerWallet(String name) {
        return sellers.get(name).getWallet();
    }

    ///////////////////////////////////////////////user
    public void RequestMoney(String name,float size){
        users.get(name).setMoneyRequested(size);
        moneyRequesteds.put(name,users.get(name));
    }

    public void addUser(String username,String pass,String email, String phone, String address){
        User user=new User(username,pass,email,phone,address);
        users.put(username,user);
    }
    public boolean doesUserExist(String username){
        return users.containsKey(username);
    }

    public void changeUserPass(String username,String newPass){
        users.get(username).setPassword(newPass);
    }

    public void changeUserEmail(String username, String newEmail){
        users.get(username).setEmail(newEmail);
    }

    public void changeUserphone (String username, String newPhone){
        users.get(username).setPhone(newPhone);
    }

    public void changeUseraddress(String username, String newAddress){
        users.get(username).setAddress(newAddress);
    }

    public boolean userPassChack(String username, String pass){
        return users.get(username).userPassCheck(pass);
    }
    public String getUserEmail(String name) {
       return users.get(name).getEmail();
    }

    public String getUserphone(String name) {
        return users.get(name).getPhone();
    }

    public String getUserAddress(String name) {
        return users.get(name).getAddress();
    }

    public float getUserWallet(String name) {
        return users.get(name).getWallet();
    }

    public ArrayList<Product> getShoppingCart(String name) {
        return users.get(name).getShoppingCart();
    }



}
