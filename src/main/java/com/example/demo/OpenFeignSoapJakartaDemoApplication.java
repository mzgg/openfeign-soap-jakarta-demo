package com.example.demo;

import com.example.demo.feign.client.CalculatorClient;
import com.example.demo.feign.resource.Add;
import com.example.demo.feign.resource.AddResponse;
import com.example.demo.feign.usecase.CalculatorUserCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class OpenFeignSoapJakartaDemoApplication implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(OpenFeignSoapJakartaDemoApplication.class);

    private final CalculatorUserCase calculatorUserCase;


    public OpenFeignSoapJakartaDemoApplication(CalculatorUserCase calculatorUserCase) {
        this.calculatorUserCase = calculatorUserCase;
    }

    public static void main(String[] args) {
        SpringApplication.run(OpenFeignSoapJakartaDemoApplication.class, args);
    }

    @Override
    public void run(String... args) {
        int addResult = calculatorUserCase.add(5, 6);
        logger.info("addResponse result:{}", addResult);

        int multiplyResult = calculatorUserCase.multiply(5, 6);
        logger.info("multiplyResult result:{}", multiplyResult);

        int subtractResult = calculatorUserCase.subtract(6, 5);
        logger.info("subtractResult result:{}", subtractResult);

        double divideResult = calculatorUserCase.divide(3,3);
        logger.info("divideResult result:{}", divideResult);


    }
}
