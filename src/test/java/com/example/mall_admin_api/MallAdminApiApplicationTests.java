package com.example.mall_admin_api;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
class MallAdminApiApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void getDateString() {
        Date date = new Date();
        System.out.println(date);
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
        String ds = sdf.format(date);
        System.out.println(ds);
    }
}
