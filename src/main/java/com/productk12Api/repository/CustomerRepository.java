package com.productk12Api.repository;

import com.productk12Api.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(value = "select c.*, o.oid,o.odate from customer c , orders o where c.cusid = o.cusid", nativeQuery = true)
    List<Map<String, Object>> getListPurchased();

    @Query(value = "select * from customer where cusname like %:cusname%",nativeQuery = true)
    List<Customer> findByCusnameIgnoreCase(String cusname);
//cach 2
//    @Query(value = "select c from Customer c where c.cusname like %?1% ")
//    List<Customer> findByCusnameIgnoreCase(String cusname, Pageable pageable);

    @Query(value = "select c from Customer c where c.phone like %?1% ")
    List<Customer> findByPhoneIgnoreCase(String phone);
    @Query(value = "select c from Customer c where c.aid=?1")
    List<Customer> findByAidIgnoreCase(int aid);
    @Query(value = "select c.*, a.province as address from customer c , address a \n" +
            "where c.cusid = ? and c.aid = a.aid", nativeQuery = true)
    Map<String, Object> findCusById(int id);

}
