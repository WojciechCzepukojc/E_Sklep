package shop.main;

import shop.service.OrderService;

import java.util.Scanner;

public class ShopMain {

    private static Scanner scanner = new Scanner(System.in);
    private static OrderService orderService = new OrderService();

    public static void main(String[] args) {

    int choose = 0;

    do {
        System.out.println("Wybierz funkcję: ");
        System.out.println("0 - zakończ");
        System.out.println("1 - utwórz zamówienie");



        choose = scanner.nextInt();

        switch (choose){

            case 0: System.exit(0);
            case 1: createOrder();
                break;

        }


    }while (true);

    }
    private static void createOrder(){
        int orderID = orderService.createOrderId();
        System.out.println("Utworzono zamówienie o id: " + orderID);
    }
}
