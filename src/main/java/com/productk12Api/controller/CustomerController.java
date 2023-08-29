package com.productk12Api.controller;

import com.productk12Api.model.Customer;
import com.productk12Api.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")
@CrossOrigin("*")  //cho phep tat ca cac port gọi vào

public class CustomerController {
    @Autowired
    CustomerService customerService;

    @RequestMapping("/getAll")
    private ResponseEntity<?> getAll(){
        return customerService.getListCustomer();
    }

    @GetMapping("/getListCustomerPaging")
    private ResponseEntity<?> getListCustomerPaging(@RequestParam int page,
                                                    @RequestParam int size,
                                                    @RequestParam String sort){
        return customerService.getListCustomerPaging(page,size,sort);
    }

    @GetMapping("/search")
    private ResponseEntity<?> search(@RequestParam int key, @RequestParam String search){
        return customerService.search(key,search);
    }

    @PostMapping("/save")
    private ResponseEntity<?> save(@RequestBody Customer customer){
        return customerService.save(customer);
    }

    @GetMapping("/find")
    private ResponseEntity<?> find(@RequestParam int id){
        return customerService.findById(id);
    }
    @GetMapping("/getListPurchased")
    private ResponseEntity<?> getListPurchased(){
        return customerService.getListPurchased();
    }
}
