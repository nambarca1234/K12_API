package com.productk12Api.repository;

import com.productk12Api.model.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface EmployeesRepository extends JpaRepository<Employees,Integer> {
    @Query(value = "select e.emid,e.emname, sum(quantity*price)as tongDT  from employees e join orders o on e.emid=o.emid\n" +
            "\t\tjoin orderdetails od on o.oid=od.oid\n" +
            "        join product p on p.id=od.pid\n" +
            "        group by e.emid", nativeQuery = true)
    List<Map<String, Object>> salesByEmployees();
}
