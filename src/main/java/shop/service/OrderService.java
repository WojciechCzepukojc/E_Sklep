package shop.service;

import shop.model.Order;
import shop.model.Product;

import java.util.ArrayList;
import java.util.List;

public class OrderService {

    private List<Order> orders = new ArrayList<>();

    public Integer createOrderId(){
    Order order = new Order();
    orders.add(order);
    return order.getId();
    }

    public void printOrder(Integer id){
        Order order = getOrderById(id);
        printProducts(order.getProducts());



    }


    private Order getOrderById(Integer id) {
        for (Order order : orders) {
            if (order.getId().equals(id)) {
                return order;
            }
        }
        throw new IllegalArgumentException("Unrecognized id " + id);
    }

    private void printProducts(List<Product> products){
        for (int i = 0; i<products.size(); i++){
            System.out.println((i+1) + ".- " + products.get(i));
        }
    }






}
