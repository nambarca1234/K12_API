package com.productk12Api.Security;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
//config function run alaway
public class BatchJob {

//chay dinh ki 3s 1 lan
//    @Scheduled(fixedDelay = 3000)
//    public void test1(){
//        System.out.println("my job");
//    }

//* "0 0 * * * *" = đầu mỗi giờ trong ngày.
//* "*/10 * * * * *" = cứ sau mười giây.
//* "0 0 8-10 * * *" = 8, 9 và 10 giờ hàng ngày.
//* "0 0 8,10 * * *" = 8 và 10 giờ hàng ngày.
//* "0 0/30 8-10 * * *" = 8:00, 8:30, 9:00, 9:30 và 10 giờ mỗi ngày.
//* "0 0 9-17 * * Thứ 2-Thứ 6" = vào giờ từ chín đến năm ngày trong tuần
//* "0 0 0 25 12?" = mỗi ngày Giáng sinh vào lúc nửa đêm
//    @Scheduled(cron = "*/10 * * * * *") //set theo date time ngay 15 10h15p

//    public void test1(){
//        System.out.println("my job");
//    }
}
