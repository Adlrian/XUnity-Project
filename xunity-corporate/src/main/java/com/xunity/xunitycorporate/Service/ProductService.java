package com.xunity.xunitycorporate.Service;

import com.xunity.xunitycorporate.Model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService implements GenericService<Product, Integer>{

    List<Product> products = new ArrayList<>(
            Arrays.asList(new Product(1,"AAA", "AAA", 10.2, 20,9,1,"URLTEST"))
    );

    @Override
    public void create(Product product) {
        products.add(product);
    }

    @Override
    public void update(Product product) {
        Product currentProduct = findById(product.getProductId());
        int index = products.indexOf(currentProduct);
        products.set(index, product);
    }

    @Override
    public void delete(Product product) {
        products.remove(product);
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Product findById(Integer productId) {
        Product product = products.stream()
                .filter(p ->productId.equals(p.getProductId()))
                .findFirst()
                .orElse(null);

        return product;
    }
}
