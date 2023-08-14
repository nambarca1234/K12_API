package com.productk12Api.service.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.productk12Api.model.*;
import com.productk12Api.repository.ProductRepository;
import com.productk12Api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl extends BaseResponse implements ProductService {
    @Autowired
    private ProductRepository productRepo;
    @Override
    public ResponseEntity<?> getListProduct() {
        List<Product> products = productRepo.findAll();
        return getResponseEntity(products);
    }

    @Override
    public ResponseEntity<?> save(Product product) {
        Product product1= productRepo.save(product);
        return getResponseEntity(product1);
    }


    @Override
    public ResponseEntity<?> delete(int id) {
        productRepo.deleteById(id);
        return getResponseEntity("xoa ok");
    }

    @Override
    public ResponseEntity<?> findById(int id) {
        Product product = productRepo.findById(id).get();
        return getResponseEntity(product);
    }

    @Override
    public ResponseEntity<?> getQuantityPurchased() {
        List<Map<String, Object>> maps= productRepo.getQuantityPurchased();
        ObjectMapper objectMapper = new ObjectMapper();
        List<ProductDTO> productDTOS = new ArrayList<>();
        for (Map m:maps) {
            ProductDTO productDTO = objectMapper.convertValue(m,ProductDTO.class);
            productDTOS.add(productDTO);
        }
        return getResponseEntity(productDTOS);
    }

    @Override
    public ResponseEntity<?> getAVGPrice(int cid) {
        List<Map<String,Object>> maps=productRepo.getAVGPrice(cid);
        ObjectMapper objectMapper = new ObjectMapper();
        List<ProductDTO> productDTOList = new ArrayList<>();
        for (Map m: maps) {
            ProductDTO productDTO = objectMapper.convertValue(m,ProductDTO.class);
            productDTOList.add(productDTO);
        }

        return getResponseEntity(productDTOList);
    }

    @Override
    public ResponseEntity<?> getUnsoldProducts() {
        List<Map<String,Object>> mapList=productRepo.getUnsoldProducts();
        ObjectMapper objectMapper=new ObjectMapper();
        List<ProductDTO> productDTOList= new ArrayList<>();
        for (Map m : mapList) {
            ProductDTO productDTO = objectMapper.convertValue(m,ProductDTO.class);
            productDTOList.add(productDTO);
        }
        return getResponseEntity(productDTOList);
    }


}
