package org.example;

public class User {
    protected String userLogin;
    protected String userPassword;
    protected Basket userBasket;

    public User(String userLogin, String userPassword, Basket userBasket) {
        this.userLogin = userLogin;
        this.userPassword = userPassword;
        this.userBasket = userBasket;
    }

    public String printBasket() {
        return String.format("-------------------%s-BASKET----------------------\n", this.userLogin) + userBasket.toString();
    }
}
