package com.xunity.xunitycorporate.Controller;

import com.xunity.xunitycorporate.Model.Customer;
import com.xunity.xunitycorporate.Model.Customer;
import com.xunity.xunitycorporate.Service.CustomerService;
import com.xunity.xunitycorporate.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public class CustomerController implements GenericController<Customer, Integer> {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public String getList(Model model) {
        //list
        List<Customer> customers = customerService.findAll();
        model.addAttribute("customers", customers);
        return "customer";
    }

    @PostMapping("/customers/save")
    public String save(Customer customer, Model model) {
        //save
        customerService.create(customer);

        return "redirect:/customers";
    }

    @GetMapping("/customers/add")
    public String add(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer-add";
    }

    @GetMapping("/customers/edit/{customerId}")
    public String getForUpdate(@PathVariable Integer customerId, Model model) {
        Customer currentCustomer = customerService.findById(customerId);
        model.addAttribute("customer", currentCustomer);
        return "customer-edit";
    }

    @PostMapping("/customers/update/{customerId}")
    public String update(@PathVariable Integer customerId, Customer customer, Model model) {
        //Update
        customerService.update(customer);

        return "redirect:/customers";
    }

    @GetMapping("/customers/delete/{customerId}")
    public String delete(@PathVariable Integer customerId, Model model) {
        Customer currentCustomer = customerService.findById(customerId);
        //Delete
        customerService.delete(currentCustomer);
        return "redirect:/customers";
    }
}
