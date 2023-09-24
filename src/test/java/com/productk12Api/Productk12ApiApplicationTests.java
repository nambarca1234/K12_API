package com.productk12Api;

import com.productk12Api.service.Impl.ProductServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class Productk12ApiApplicationTests {

    @Autowired
    ProductServiceImpl service;

    @Test
    void contextLoads() {

    }

    @Test
    void tinhtong() {
        int x = 10;
        int y = 10;
        int expectedRs = 20; //mong muon ket qua
        int actualRs = service.cul(x, y); // ket qua
        assertThat(actualRs).isEqualTo(expectedRs);
    }

}
