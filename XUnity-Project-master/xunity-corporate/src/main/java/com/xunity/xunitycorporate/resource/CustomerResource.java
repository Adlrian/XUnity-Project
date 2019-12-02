package com.xunity.xunitycorporate.resource;

import com.xunity.xunitycorporate.Model.Customer;
import com.xunity.xunitycorporate.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerResource {

    @Autowired
    private CustomerService customerService;

    //GET
    @GetMapping("/customers")
    public ResponseEntity getAll(){

        List<Customer> customers = customerService.findAll();
        if(customers == null){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(customers, HttpStatus.OK);
    }

    //GET BY ID
    @GetMapping("/customers/{id}")
    public ResponseEntity getById(@PathVariable Integer id){

        Customer currentCustomer = customerService.findById(id);
        if(currentCustomer == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(currentCustomer, HttpStatus.OK);
    }

    @PostMapping("/customers")
    public ResponseEntity create(@RequestBody Customer customer){
        customerService.create(customer);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/customers/{id}")
    public ResponseEntity update(@PathVariable Integer id,
                                 @RequestBody Customer customer){

        Customer currentCustomer = customerService.findById(id);
        if(currentCustomer == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        currentCustomer.setCustomerName(customer.getCustomerName());
        currentCustomer.setCustomerLastName(customer.getCustomerLastName());
        currentCustomer.setUsername(customer.getUsername());
        currentCustomer.setPassword(customer.getPassword());
        currentCustomer.setPhone(customer.getPhone());
        currentCustomer.setDni(customer.getDni());
        currentCustomer.setAddress(customer.getAddress());
        currentCustomer.setEnrollerId(customer.getEnrollerId());
        currentCustomer.setStatus(customer.getStatus());
        currentCustomer.setCustomerType(customer.getCustomerType());
        currentCustomer.setMarketId(customer.getMarketId());

        customerService.update(currentCustomer);

        return new ResponseEntity(currentCustomer, HttpStatus.OK);
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        Customer currentCustomer = customerService.findById(id);
        if(currentCustomer == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        customerService.delete(currentCustomer);
        return new ResponseEntity(HttpStatus.OK);
    }
}
