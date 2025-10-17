package calculator.controller;

import calculator.model.service.CalculatorService;
import calculator.model.service.CalculatorServiceImpl;
import calculator.view.ConsoleView;

public class CalculatorController {

    private final CalculatorService calculatorService = new CalculatorServiceImpl();
    private final ConsoleView consoleView = new ConsoleView();

    public void start() {
        String userInput = consoleView.getUserInput();
        double result = calculatorService.calculate(userInput);
        consoleView.printOutput(result);
    }
}
