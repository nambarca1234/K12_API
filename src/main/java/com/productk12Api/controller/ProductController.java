package com.productk12Api.controller;

import com.productk12Api.model.Category;
import com.productk12Api.model.MyResponse;
import com.productk12Api.model.Product;
import com.productk12Api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    @Autowired
    ProductService productService;
    private MyResponse myResponse=new MyResponse();


    @GetMapping("/getOne")
    public ResponseEntity<?> getOne(){
        Product product=new Product(1,"nam",1,1,22.f);
        return ResponseEntity.ok(product);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Product product){
        return productService.save(product);
    }
    @GetMapping
    public ResponseEntity<?> getAll(){
        return productService.getListProduct();
    }
    @GetMapping("/getQuantityPurchased")
    private ResponseEntity<?> getQuantityPurchased(){
        return productService.getQuantityPurchased();
    }

    @GetMapping("/getAVGPrice")
    private ResponseEntity<?> getAVGPrice(@RequestParam int cid){
        return productService.getAVGPrice(cid);
    }

    @GetMapping("/getUnsoldProducts")
    private ResponseEntity<?> getUnsoldProducts(){
        return productService.getUnsoldProducts();
    }
}
