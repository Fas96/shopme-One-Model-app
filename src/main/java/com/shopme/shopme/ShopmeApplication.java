package com.shopme.shopme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan({"common"})
public class ShopmeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopmeApplication.class, args);
    }

}
