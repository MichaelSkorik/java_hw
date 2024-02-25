package java_hw1;

public class ComplexNumber {
    private double real;
    private double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public ComplexNumber add(ComplexNumber other) {
        return new ComplexNumber(this.real + other.real, this.imaginary + other.imaginary);
    }

    public ComplexNumber subtract(ComplexNumber other) {
        return new ComplexNumber(this.real - other.real, this.imaginary - other.imaginary);
    }

    public ComplexNumber multiply(ComplexNumber other) {
        double newReal = this.real * other.real - this.imaginary * other.imaginary;
        double newImaginary = this.real * other.imaginary + this.imaginary * other.real;
        return new ComplexNumber(newReal, newImaginary);
    }

    public ComplexNumber divide(ComplexNumber other) {
        double denominator = other.real * other.real + other.imaginary * other.imaginary;
        double newReal = (this.real * other.real + this.imaginary * other.imaginary) / denominator;
        double newImaginary = (this.imaginary * other.real - this.real * other.imaginary) / denominator;
        return new ComplexNumber(newReal, newImaginary);
    }

    @Override
    public String toString() {
        return "(" + real + " + " + imaginary + "i)";
    }
}

interface Operation {
    ComplexNumber calculate(ComplexNumber a, ComplexNumber b);
}

class Addition implements Operation {
    @Override
    public ComplexNumber calculate(ComplexNumber a, ComplexNumber b) {
        return a.add(b);
    }
}

class Subtraction implements Operation {
    @Override
    public ComplexNumber calculate(ComplexNumber a, ComplexNumber b) {
        return a.subtract(b);
    }
}

class Multiplication implements Operation {
    @Override
    public ComplexNumber calculate(ComplexNumber a, ComplexNumber b) {
        return a.multiply(b);
    }
}

class Division implements Operation {
    @Override
    public ComplexNumber calculate(ComplexNumber a, ComplexNumber b) {
        return a.divide(b);
    }
}

class Calculator {
    private Operation operation;

    public Calculator(Operation operation) {
        this.operation = operation;
    }

    public ComplexNumber execute(ComplexNumber a, ComplexNumber b) {
        return operation.calculate(a, b);
    }
}