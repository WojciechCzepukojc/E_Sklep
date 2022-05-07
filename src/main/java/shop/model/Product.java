package shop.model;

import java.time.LocalDate;

public class Product {

    private static int counterID = 00001;

    private Integer ID;
    private ProductType productType;
    private String brand;
    private String model;
    private double price;
    private LocalDate purchaseDate;
    private LocalDate warrantyDate;

    public Product(ProductType productType, String brand, String model, double price) {
        this.ID = counterID++;
        this.productType = productType;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.purchaseDate = LocalDate.now();
        this.warrantyDate = warrantyDate;
    }


    public Integer getID() {
        return ID;
    }

    public ProductType getProductType() {
        return productType;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public LocalDate getWarrantyDate() {
        return warrantyDate;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "ID=" + ID +
                ", productType=" + productType +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", purchaseDate=" + purchaseDate +
                ", warrantyDate=" + warrantyDate +
                '}';
    }

    private LocalDate calculateWarrantyDate(){
        switch (productType){
            case PHONE:
                return purchaseDate.plusYears(1);
            case SMARTPHONE:
                return purchaseDate.plusYears(2);
            case IPHONE:
                return purchaseDate.plusYears(3);
        }
        return LocalDate.now();
    }
}
