package shop.service;

import shop.model.Order;
import shop.model.Product;
import shop.model.ProductType;

import java.util.ArrayList;
import java.util.List;

public class OrderService {

    private List<Order> orders = new ArrayList<>();


    //#1
    public Integer createOrderId(){
    Order order = new Order();
    orders.add(order);
    return order.getId();
    }



    //#2
    public Integer addProductToOrder ( Integer orderID, String type, String brand, String model, double price){
        Order order = getOrderById(orderID);
        Product product = new Product(ProductType.valueOf(type), brand, model,price);
        order.addProduct(product);
        return product.getID();
    }



    //#3
    public void printOrder(Integer id){
        Order order = getOrderById(id);
        printProducts(order.getProducts());
    }

    //#4
    public boolean removeProductFromOrder(Integer orderID, Integer productID){
        Order order = getOrderById(orderID);
        return order.removeProductByID(productID);
    }
    //#5
    public boolean giveDiscount(Integer orderID, Integer productID, String discount){
        Order order = getOrderById(orderID);
        return order.giveDiscount(productID, discount);

    }
    //#6
    public Double getOrderValue(Integer orderID){
        Order order = getOrderById(orderID);
        return  order.collectOrderValue();
    }




    //#3 #4
    private Order getOrderById(Integer id) {
        for (Order order : orders) {
            if (order.getId().equals(id)) {
                return order;
            }
        }
        throw new IllegalArgumentException("Unrecognized id " + id);
    }

    //#3
    private void printProducts(List<Product> products){
        for (int i = 0; i<products.size(); i++){
            System.out.println((i+1) + ".- " + products.get(i));
        }
    }








}
