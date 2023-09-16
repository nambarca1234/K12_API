package com.productk12Api.service.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.productk12Api.model.BaseResponse;
import com.productk12Api.model.Customer;
import com.productk12Api.model.CustomerDTO;
import com.productk12Api.repository.CustomerRepository;
import com.productk12Api.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CustomerServiceImpl extends BaseResponse implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public ResponseEntity<?> getListCustomer() {
        List<Customer> customers = customerRepository.findAll();
        return getResponseEntity(customers);
    }

    @Override
    public ResponseEntity<?> getListCustomerPaging(int page, int size, String propSortName) {
        //phan trang lay domain
        Pageable pageable = PageRequest.of(page, size,
                Sort.by(Sort.Direction.ASC, propSortName));
        Page<Customer> pageCus = customerRepository.findAll(pageable);
        return getResponseEntity(pageCus);
    }

    @Override
    public ResponseEntity<?> save(Customer customer) {
        Customer customer1 = customerRepository.save(customer);
        return getResponseEntity(customer1);
    }

    @Override
    public ResponseEntity<?> delete(int id) {
        customerRepository.deleteById(id);
        return getResponseEntity("xoa ok");
    }

    @Override
    public ResponseEntity<?> findById(int id) {
        Customer customer = customerRepository.findById(id).get();
        return getResponseEntity(customer);
    }

    @Override
    public ResponseEntity<?> search(int key, String value) {
//        Pageable pageable =PageRequest.of(0,4);
        switch (key) {
            case 1:
                return getResponseEntity(customerRepository.findByCusnameIgnoreCase(value));
            case 2:
                return getResponseEntity(customerRepository.findByPhoneIgnoreCase(value));
            case 3:
                return getResponseEntity(customerRepository.findByAidIgnoreCase(Integer.parseInt(value)));
        }
        return null;
    }

    @Override
    public ResponseEntity<?> getListPurchased() {
        List<Map<String, Object>> maps = customerRepository.getListPurchased();
        ObjectMapper objectMapper = new ObjectMapper();
        List<CustomerDTO> customerDTOS = new ArrayList<>();
        for (Map m : maps) {
            CustomerDTO customerDTO = objectMapper.convertValue(m, CustomerDTO.class);
            customerDTOS.add(customerDTO);
        }
        return getResponseEntity(customerDTOS);
    }

    @Override
    public ResponseEntity<?> findCusById(int id) {
        return getResponseEntity(customerRepository.findCusById(id));
    }
}
