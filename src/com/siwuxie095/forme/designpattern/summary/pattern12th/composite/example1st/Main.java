package com.siwuxie095.forme.designpattern.summary.pattern12th.composite.example1st;

/**
 * @author Jiajing Li
 * @date 2019-11-06 22:05:44
 */
public class Main {

    public static void main(String[] args) {
        MenuComponent breakfastMenu = new Menu("Breakfast Menu", "Good");
        MenuComponent lunchMenu = new Menu("Lunch Menu", "Fine");
        MenuComponent dinnerMenu = new Menu("Dinner Menu", "OK");

        MenuComponent dessertMenu = new Menu("Dessert Menu", "Fantastic");

        MenuComponent allMenus = new Menu("All Menus", "Combined");

        allMenus.add(breakfastMenu);
        allMenus.add(lunchMenu);
        allMenus.add(dinnerMenu);

        MenuComponent breakfastA = new MenuItem("早餐 A", "早餐 A：...", true, 3.99);
        MenuComponent breakfastB = new MenuItem("早餐 B", "早餐 B：...", false, 4.99);
        MenuComponent breakfastC = new MenuItem("早餐 C", "早餐 C：...", true, 5.99);
        breakfastMenu.add(breakfastA);
        breakfastMenu.add(breakfastB);
        breakfastMenu.add(breakfastC);

        MenuComponent lunchA = new MenuItem("午餐 A", "午餐 A：...", true, 15.99);
        MenuComponent lunchB = new MenuItem("午餐 B", "午餐 B：...", false, 16.99);
        MenuComponent lunchC = new MenuItem("午餐 C", "午餐 C：...", true, 17.99);
        lunchMenu.add(lunchA);
        lunchMenu.add(lunchB);
        lunchMenu.add(lunchC);
        lunchMenu.add(dessertMenu);

        MenuComponent dinnerA = new MenuItem("晚餐 A", "晚餐 A：...", true, 23.99);
        MenuComponent dinnerB = new MenuItem("晚餐 B", "晚餐 B：...", false, 24.99);
        MenuComponent dinnerC = new MenuItem("晚餐 C", "晚餐 C：...", true, 25.99);
        dinnerMenu.add(dinnerA);
        dinnerMenu.add(dinnerB);
        dinnerMenu.add(dinnerC);

        MenuComponent dessertA = new MenuItem("午后甜点 A", "午后甜点 A：...", true, 0.99);
        MenuComponent dessertB = new MenuItem("午后甜点 B", "午后甜点 B：...", false, 0.99);
        MenuComponent dessertC = new MenuItem("午后甜点 C", "午后甜点 C：...", true, 0.99);
        dessertMenu.add(dessertA);
        dessertMenu.add(dessertB);
        dessertMenu.add(dessertC);

        //{
        //    Waitress waitress = new Waitress(dessertA);
        //    waitress.printMenu();
        //}

        //{
        //    Waitress waitress = new Waitress(dessertMenu);
        //    waitress.printMenu();
        //}

        //{
        //    Waitress waitress = new Waitress(lunchMenu);
        //    waitress.printMenu();
        //}

        {
            Waitress waitress = new Waitress(allMenus);
            waitress.printMenu();
        }
    }

}
