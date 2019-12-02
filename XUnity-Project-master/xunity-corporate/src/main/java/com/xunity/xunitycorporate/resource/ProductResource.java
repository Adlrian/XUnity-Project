package com.xunity.xunitycorporate.resource;

import com.xunity.xunitycorporate.Model.Product;
import com.xunity.xunitycorporate.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductResource {

    @Autowired
    private ProductService productService;

    //GET
    @GetMapping("/products")
    public ResponseEntity getAll(){

        List<Product> products = productService.findAll();
        if(products == null){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(products, HttpStatus.OK);
    }

    //GET BY ID
    @GetMapping("/products/{id}")
    public ResponseEntity getById(@PathVariable Integer id){

        Product currentProduct = productService.findById(id);
        if(currentProduct == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(currentProduct, HttpStatus.OK);
    }

    @PostMapping("/products")
    public ResponseEntity create(@RequestBody Product product){
        productService.create(product);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity update(@PathVariable Integer id,
                                 @RequestBody Product product){

        Product currentProduct = productService.findById(id);
        if(currentProduct == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        currentProduct.setProductName(product.getProductName());
        currentProduct.setProductDescription(product.getProductDescription());
        currentProduct.setPrice(product.getPrice());
        currentProduct.setStock(product.getStock());
        currentProduct.setCvPoints(product.getCvPoints());
        currentProduct.setStatus(product.getStatus());
        currentProduct.setImageUrl(product.getImageUrl());

        productService.update(currentProduct);

        return new ResponseEntity(currentProduct, HttpStatus.OK);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        Product currentProduct = productService.findById(id);
        if(currentProduct == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        productService.delete(currentProduct);
        return new ResponseEntity(HttpStatus.OK);
    }
}

