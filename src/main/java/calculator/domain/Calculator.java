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
                if(Double.parseDouble(number) < 0)
                    throw new IllegalArgumentException();

                this.result += Double.parseDouble(number);
            } catch(NumberFormatException e) {
                throw new IllegalArgumentException();
            }
        }
    }
}
