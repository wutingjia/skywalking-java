package org.apache.skywalking.apm.testcase.tomcatclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        try {
            SpringApplication.run(Application.class, args);
            System.out.println("success");
        } catch (Exception e) {
            // Never do this
        }
    }
}
