package org.example;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        //Инициализируем наборы товаров для магазина.
        Random rand = new Random();
        Product[] soda = new Product[5];
        Product[] fruit = new Product[5];
        Product[] vegetable = new Product[5];
        Product[] tea = new Product[5];
        //Заполняем магазин товарами.
        for (int i = 0; i < soda.length; i++) {
            soda[i] = new Product(String.format("Soda #%d", i + 1),
                    rand.nextDouble(10.0, 100.0),
                    rand.nextDouble(1.0, 5.0));
            fruit[i] = new Product(String.format("Fruit #%d", i + 1),
                    rand.nextDouble(1.0, 10.0),
                    rand.nextDouble(1.0, 5.0));
            vegetable[i] = new Product(String.format("Vegetable #%d", i + 1),
                    rand.nextDouble(1.0, 10.0),
                    rand.nextDouble(1.0, 5.0));
            tea[i] = new Product(String.format("Tea #%d", i + 1),
                    rand.nextDouble(10.0, 20.0),
                    rand.nextDouble(1.0, 5.0));
        }
        Category carbonatedDrinks = new Category("Sodas", soda);
        Category fruits = new Category("Fruits", fruit);
        Category vegetables = new Category("Vegetables", vegetable);
        Category teaDrinks = new Category("Tea", tea);
        Category[] store = {carbonatedDrinks, fruits, vegetables, teaDrinks};
        //Магазин наполнен товарами, можем начинать с ними работать.
        //Покажем все доступные товары в магазине.
        for (int i = 0; i < store.length; i++) {
            System.out.println(store[i].printCategory());
        }
        //Инициализируем пользователей
        User user1 = new User("user1","12345",new Basket());
        User user2 = new User("user2","12345",new Basket());
        User user3 = new User("user2","12345",new Basket());
        //Добавим первому пользователю товары
        user1.userBasket.addProduct(fruits, 1);
        user1.userBasket.addProduct(fruits, 2);
        user1.userBasket.addProduct(fruits, 3);
        user1.userBasket.addProduct(carbonatedDrinks, 3);
        //Добавим второму пользователю товары
        user2.userBasket.addProduct(vegetables, 1);
        user2.userBasket.addProduct(vegetables, 2);
        user2.userBasket.addProduct(vegetables, 3);
        user2.userBasket.addProduct(teaDrinks, 1);
        //Добавим третьему пользователю товары
        user3.userBasket.addProduct(teaDrinks, 5);
        user3.userBasket.addProduct(fruits, 5);
        //Выведем его корзину на экран
        System.out.println(user1.printBasket());
        //Выведем все доступные товары в магазине(должно пропасть то, что ушло в корзину)
        for (int i = 0; i < store.length; i++) {
            System.out.println(store[i].printCategory());
        }
        //Удалим из корзины первого пользователя товар и покажем его корзину
        user1.userBasket.removeProduct(fruits,"Fruit #2");
        System.out.println(user1.printBasket());
        //Проверим выложился ли он в магазин
        for (int i = 0; i < store.length; i++) {
            System.out.println(store[i].printCategory());
        }
    }
}