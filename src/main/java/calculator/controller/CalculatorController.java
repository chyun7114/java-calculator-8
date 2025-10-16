package calculator.controller;

import calculator.domain.Calculator;
import calculator.service.CalculatorService;
import calculator.service.CalculatorServiceImpl;
import calculator.view.InputView;
import calculator.view.OutputView;

import java.util.List;

public class CalculatorController {

    private CalculatorService calculatorService = new CalculatorServiceImpl();
    private Calculator calculator = new Calculator();
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();

    public void start() {
        String userInput = inputView.getUserInput();
        List<String> splitList = calculatorService.splitByDelimeters(userInput);
        calculator.calculate(splitList);
        outputView.getUserOutput(calculator.getResult());
    }
}
