package shop.main;

import shop.service.OrderService;

import java.util.Scanner;

public class ShopMain {

    private static Scanner scanner = new Scanner(System.in);
    private static OrderService orderService = new OrderService();

    public static String discount = null;

    public static void main(String[] args) {

    int choose = 0;


    do {
        System.out.println("Wybierz funkcję: ");
        System.out.println("0 - zakończ");
        System.out.println("1 - utwórz zamówienie");
        System.out.println("2 - dodaj produkt do zamówienia");
        System.out.println("3 - wyświetl zamówienie");
        System.out.println("4 - usuń produkt z zamówienia");
        System.out.println("5 - dodaj kod rabatowy");



        choose = scanner.nextInt();

        switch (choose){

            case 0: System.exit(0);
            case 1: createOrder();              //#1
                break;
            case 2: addProductToOrderr();       //#2
                break;
            case 3: printOrder();               //#3
                break;
            case 4: removeProductFromOrder();   //#4
                break;
            case 5: giveDiscount();             //#5

        }


    }while (true);

    }

    //#1
    private static void createOrder(){
        int orderID = orderService.createOrderId();
        System.out.println("Utworzono zamówienie o id: " + orderID);
    }

    //#2
    private static void addProductToOrderr(){
        System.out.println("Podaj ID zamówienia:");
        int orderID = scanner.nextInt();

        System.out.println("Podaj typ produktu:");
        String type = scanner.next();

        System.out.println("Podaj markę produktu:");
        String brand = scanner.next();

        System.out.println("Podaj model produktu:");
        String model = scanner.next();

        System.out.println("Podaj cenę produktu");
        double price = scanner.nextDouble();

        int productID = orderService.addProductToOrder(orderID, type, brand,model,price);
        System.out.println("Pomyślnie dodano produkt " + productID + " do zamówienia: " + orderID);
    }

    //#3
    public static void printOrder(){
        System.out.println("Podaj ID zamówienia");
        int orderID = scanner.nextInt();

        System.out.println(" Zamówienie składa się z następujących produktów:");
        orderService.printOrder(orderID);
    }

    //#4
    public static void removeProductFromOrder(){

        System.out.println("Podaj ID zamówienia");
        int orderID = scanner.nextInt();

        System.out.println("Podaj ID produktu");
        int productID = scanner.nextInt();

        boolean result = orderService.removeProductFromOrder(orderID, productID);

        if (result) {
            System.out.println("Pomyślnie usunięto produkt o id " + productID + " z zamówienia o id " + orderID);
        } else {
            System.out.println("Nie udało się usunąć produktu o id " + productID + " z zamówienia o id " + orderID);
        }
    }

    //#5
    public static void giveDiscount() {

        if (discount != "rabat") {
            System.out.println("Podaj ID zamówienia");
            int orderID = scanner.nextInt();

            System.out.println("Podaj ID produktu");
            int productID = scanner.nextInt();

            System.out.println("Podaj kod rabatowy");
            discount = scanner.next();



            boolean result = orderService.giveDiscount(orderID, productID, discount);

            if (result) {
                System.out.println("Rabat w wysokości 10% wartości produktu o ID: " + productID + " został udzielony");
                discount = "rabat";
            } else {
                System.out.println("Podano błędny kod rabatowy");
            }
        } else {
            System.out.println("Rabat został już udzielony");
        }
    }



}
