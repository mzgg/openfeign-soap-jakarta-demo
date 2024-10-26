package com.example.demo.feign.usecase;

import com.example.demo.feign.client.CalculatorClient;
import com.example.demo.feign.resource.*;
import feign.FeignException;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

@Component
public class CalculatorUserCase {

    private final CalculatorClient calculatorClient;

    public CalculatorUserCase(CalculatorClient calculatorClient) {
        this.calculatorClient = calculatorClient;
    }

    public int add(int input1, int input2) {
        Add add = new Add();
        add.setIntA(input1);
        add.setIntB(input2);
        AddResponse response = calculatorClient.add(add);
        return response.getAddResult();

    }

    public int multiply(int input1, int input2) {
        Multiply multiply = new Multiply();
        multiply.setIntA(input1);
        multiply.setIntB(input2);
        MultiplyResponse response = calculatorClient.multiply(multiply);
        return response.getMultiplyResult();
    }

    public double divide(int input1, int input2) {
        Divide divide = new Divide();
        divide.setIntA(input1);
        divide.setIntB(input2);
        DivideResponse response = calculatorClient.divide(divide);
        return response.getDivideResult();
    }

    public int subtract(int input1, int input2) {
        Subtract subtract = new Subtract();
        subtract.setIntA(input1);
        subtract.setIntB(input2);
        SubtractResponse response = calculatorClient.subtract(subtract);
        return response.getSubtractResult();
    }
}
