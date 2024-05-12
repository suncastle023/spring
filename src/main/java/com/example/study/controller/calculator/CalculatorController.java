package com.example.study.controller.calculator;

import com.example.study.dto.calculator.CalculatorAddRequest;
import com.example.study.dto.calculator.CalculatorMultiplyRequest;
import com.example.study.dto.calculator.CalculatorSubtractRequest;
import com.example.study.dto.calculator.CalculatorDivideRequest;
import org.springframework.web.bind.annotation.*;

@RestController
public class CalculatorController {
    // 덧셈
    @GetMapping("/add")
    public int addTwoNumbers(CalculatorAddRequest request) {
        return request.getNumber1() + request.getNumber2();
    }

    // 곱셈
    @PostMapping("/multiply")
    public int multiplyingTwoNumbers(@RequestBody CalculatorMultiplyRequest request) {
        return request.getNumber1() * request.getNumber2();
    }

    // 뺄셈
    @GetMapping("/subtract")
    public int subtractTwoNumbers(@RequestParam int num1, @RequestParam int num2) {
        return num1 - num2;
    }

    // 나눗셈
    @GetMapping("/divide")
    public int divideTwoNumbers(@RequestParam int num1, @RequestParam int num2) {
        // 0으로 나누는 경우 예외 처리
        if (num2 == 0) {
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }
        return num1 / num2;
    }

    @GetMapping("/calc")
    public Object calculateAllOperations(
            @RequestParam int num1,
            @RequestParam int num2) {
        return new Object() {
            public int add = num1 + num2;
            public int minus = num1 - num2;
            public int multiply = num1 * num2;
            public int division = num2 != 0 ? num1 / num2 : 0; // 0으로 나누기 방지
        };
    }
}
