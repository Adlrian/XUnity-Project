package com.xunity.xunitycorporate.Controller;

import com.xunity.xunitycorporate.Model.Product;
import com.xunity.xunitycorporate.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductController implements GenericController<Product, Integer>{

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public String getList(Model model) {
        //list
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "product";
    }

    @PostMapping("/products/save")
    public String save(Product product, Model model) {
        //save
        productService.create(product);

        return "redirect:/products";
    }

    @GetMapping("/products/add")
    public String add(Model model) {
        model.addAttribute("product", new Product());
        return "product-add";
    }

    @GetMapping("/products/edit/{productId}")
    public String getForUpdate(@PathVariable Integer productId, Model model) {
        Product currentProduct = productService.findById(productId);
        model.addAttribute("product", currentProduct);
        return "product-edit";
    }

    @PostMapping("/products/update/{productId}")
    public String update(@PathVariable Integer productId, Product product, Model model) {
        //Update
        productService.update(product);

        return "redirect:/products";
    }

    @GetMapping("/products/delete/{sku}")
    public String delete(@PathVariable Integer productId, Model model) {
        Product currentProduct = productService.findById(productId);
        //Delete
        productService.delete(currentProduct);
        return "redirect:/products";
    }
}
