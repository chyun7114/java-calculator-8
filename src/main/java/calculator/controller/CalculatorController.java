package calculator.controller;

import calculator.domain.Calculator;
import calculator.service.CalculatorService;
import calculator.service.CalculatorServiceImpl;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class CalculatorController {

    private CalculatorService calculatorService = new CalculatorServiceImpl();
    private Calculator calculator = new Calculator();


    public void start() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        List<String> userInput = calculatorService.splitByDelimeters(Console.readLine());
        calculator.calculate(userInput);
        System.out.println("결과 : " + calculator.getResult());
    }
}
