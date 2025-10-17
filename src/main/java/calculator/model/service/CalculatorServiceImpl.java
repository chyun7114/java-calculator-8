package calculator.model.service;

import calculator.model.domain.Calculator;
import calculator.model.parser.InputParser;
import calculator.model.parser.InputParserFactory;

import java.util.List;

public class CalculatorServiceImpl implements CalculatorService {

    private Calculator calculator = new Calculator();

    @Override
    public double calculate(String userInput) {
        InputParser parser = InputParserFactory.getParser(userInput);
        List<String> numbers = parser.parse(userInput);

        return calculator.calculate(numbers);
    }
}
