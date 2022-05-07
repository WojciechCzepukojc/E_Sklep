package shop.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Order {

    private static int counter = 001;

    private Integer id;
    private LocalDate cerateDate;
    private Map<ProductType, List<Product>> productMap;

    public Order() {
        this.id = counter++;
        this.cerateDate = LocalDate.now();
        this.productMap = new HashMap<>();
    }

    public Integer getId() {
        return id;
    }

    public LocalDate getCerateDate() {
        return cerateDate;
    }

public void addProduct(Product product){
        if (productMap.containsKey(product.getProductType())){
            List<Product> products = productMap.get(product.getProductType());
            products.add(product);
        }else {
        List<Product> products = new ArrayList<>();
        products.add(product);
        productMap.put(product.getProductType(), products);
        }
}

public List<Product> getProductsByType(ProductType productType){
        return productMap.get(productType);
}

public List<Product> getProducts(){
        List<Product> result = new ArrayList<>();
        for (List<Product> products : productMap.values()){
            result.addAll(products);
        }
        return result;
}
}
