package org.example;

public class Category {
    protected String nameCategory;
    protected Product[] massiveOfProducts;


    public Category(String nameCategory, Product[] massiveOfProducts) {
        this.nameCategory = nameCategory;
        this.massiveOfProducts = massiveOfProducts;
    }

    /**
     * @return Возвращает отформатированную строку,
     * состоящую из названия категории и всех ее товаров
     */
    public String printCategory() {
        StringBuilder sb = new StringBuilder();
        sb.append("------------------------------------------------\n");
        sb.append(String.format("Name category: %s\n", nameCategory));
        for (int i = 0; i < massiveOfProducts.length; i++) {
            if (i != massiveOfProducts.length - 1)
                sb.append(massiveOfProducts[i].toString()).append("\n");
            else
                sb.append(massiveOfProducts[i].toString());
        }
        return sb.toString();
    }

    /**
     * Добавляет продукт в категорию магазина
     * @param newProduct Добавляемый товар
     */
    public void addProduct(Product newProduct) {
        Product[] result = new Product[this.massiveOfProducts.length + 1];
        for (int i = 0; i < this.massiveOfProducts.length; i++) {
            result[i] = this.massiveOfProducts[i];
        }
        result[result.length - 1] = newProduct;
        setMassiveOfProducts(result);
    }

    /**
     * Удалени товара из определенной категории магазина
     * @param removeProduct Номер товара, указанный в названии
     */
    public void removeProduct(int removeProduct) {
        Product[] result = new Product[this.massiveOfProducts.length - 1];
        int k = 0;
        for (int i = 0; i < this.massiveOfProducts.length; i++) {
            if (!this.massiveOfProducts[i].nameProduct.endsWith(String.format("%d", removeProduct))) {
                result[k] = this.massiveOfProducts[i];
                k++;
            }
        }
        setMassiveOfProducts(result);
    }


    public void setMassiveOfProducts(Product[] massiveOfProducts) {
        this.massiveOfProducts = massiveOfProducts;
    }
}
