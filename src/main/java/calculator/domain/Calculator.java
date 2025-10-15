package calculator.domain;

import java.util.List;

public class Calculator {

    private double result;

    public Calculator() {

        this.result = 0;
    }

    public double getResult() {

        return this.result;
    }

    public void calculate(List<String> numbers) {

        if(numbers.isEmpty()) return;

        for(String number : numbers) {
            try {
                this.result += Double.parseDouble(number);
            } catch(NumberFormatException e) {
                throw new IllegalArgumentException("잘못된 값 입력");
            }
        }
    }
}
