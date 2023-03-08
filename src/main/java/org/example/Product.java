package org.example;

public class Product {
    protected String nameProduct;
    protected double price;
    protected double rating;

    /**
     * @param nameProduct Наименование товара
     * @param price       Цена товара
     * @param rating      Рейтинг товара
     */
    public Product(String nameProduct, double price, double rating) {
        this.nameProduct = nameProduct;
        this.price = price;
        this.rating = rating;
    }

    public Product() {
        this("no_name", -1.0, 0.0);
    }

    @Override
    public String toString() {
        return String.format("Name Product: %s; Price = %.2f; Rating: %.1f", nameProduct, price, rating);
    }

}


