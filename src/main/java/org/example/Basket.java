package org.example;

import java.util.Arrays;

public class Basket {
    protected Product[] purchasedProducts;


    public Basket() {
        purchasedProducts = new Product[]{};
    }

    /**
     * Положить в корзину товар
     * @param category Из какой категории нужный товар
     * @param newProduct Его номер из названия
     */
    public void addProduct(Category category, int newProduct) {
        Product[] result = new Product[this.purchasedProducts.length + 1];
        //Копируем предыдущие покупки
        for (int i = 0; i < this.purchasedProducts.length; i++) {
            result[i] = this.purchasedProducts[i];
        }
        //Добавляем нужный товар в конец
        for (int i = 0; i < category.massiveOfProducts.length; i++) {
            if (category.massiveOfProducts[i].nameProduct.endsWith(String.format("%d", newProduct))) {
                result[result.length - 1] = category.massiveOfProducts[i];
            }
        }
        setPurchasedProducts(result);
        category.removeProduct(newProduct);
    }

    /**
     * Выкладыват из корзины товар обратно в магазин
     * @param category Категория товара
     * @param removeProduct Название товара, который хотим выложить
     */
    public void removeProduct(Category category, String removeProduct) {
        Product[] result = new Product[this.purchasedProducts.length - 1];
        int k = 0;
        for (int i = 0; i < this.purchasedProducts.length; i++) {
            if (!this.purchasedProducts[i].nameProduct.equals(removeProduct)) {
                result[k] = this.purchasedProducts[i];
                k++;
            }
            else
                category.addProduct(this.purchasedProducts[i]);
        }
        setPurchasedProducts(result);
    }

    public void setPurchasedProducts(Product[] purchasedProducts) {
        this.purchasedProducts = purchasedProducts;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (purchasedProducts.length > 0) {
            for (int i = 0; i < purchasedProducts.length; i++) {
                sb.append(purchasedProducts[i].toString() + "\n");
            }
        } else
            sb.append("Basket is empty now");
        return sb.toString();
    }
}
