package com.example.demo.feign.client;


import com.example.demo.feign.config.SoapConfiguration;
import com.example.demo.feign.resource.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "calculator", configuration = {SoapConfiguration.class})
public interface CalculatorClient {

    @PostMapping(consumes = MediaType.TEXT_XML_VALUE, produces = MediaType.TEXT_XML_VALUE)
    AddResponse add(Add add);

    @PostMapping(consumes = MediaType.TEXT_XML_VALUE, produces = MediaType.TEXT_XML_VALUE)
    DivideResponse divide(Divide dive);

    @PostMapping(consumes = MediaType.TEXT_XML_VALUE, produces = MediaType.TEXT_XML_VALUE)
    MultiplyResponse multiply(Multiply multiply);

    @PostMapping(consumes = MediaType.TEXT_XML_VALUE, produces = MediaType.TEXT_XML_VALUE)
    SubtractResponse subtract(Subtract subtract);

}
