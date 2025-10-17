package calculator.controller;

import calculator.domain.Calculator;
import calculator.service.CalculatorService;
import calculator.service.CalculatorServiceImpl;
import calculator.view.InputView;
import calculator.view.OutputView;

import java.util.List;

public class CalculatorController {

    private CalculatorService calculatorService = new CalculatorServiceImpl();
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();

    public void start() {
        String userInput = inputView.getUserInput();
        double result = calculatorService.calculate(userInput);
        outputView.getUserOutput(result);
    }
}
