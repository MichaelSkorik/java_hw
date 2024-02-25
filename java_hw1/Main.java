package java_hw1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите действительную часть первого комплексного числа:");
            double real1 = scanner.nextDouble();
            System.out.println("Введите мнимую часть первого комплексного числа:");
            double imaginary1 = scanner.nextDouble();
            ComplexNumber a = new ComplexNumber(real1, imaginary1);

            System.out.println("Введите действительную часть второго комплексного числа:");
            double real2 = scanner.nextDouble();
            System.out.println("Введите мнимую часть второго комплексного числа:");
            double imaginary2 = scanner.nextDouble();
            ComplexNumber b = new ComplexNumber(real2, imaginary2);

            System.out.println("Выберите операцию:");
            System.out.println("1. Сложение");
            System.out.println("2. Вычитание");
            System.out.println("3. Умножение");
            System.out.println("4. Деление");
            int choice = scanner.nextInt();

            Operation operation = null;
            switch (choice) {
                case 1:
                    operation = new Addition();
                    break;
                case 2:
                    operation = new Subtraction();
                    break;
                case 3:
                    operation = new Multiplication();
                    break;
                case 4:
                    operation = new Division();
                    break;
                default:
                    System.out.println("Неверный выбор операции.");
                    System.exit(1);
            }

            Calculator calculator = new Calculator(operation);
            ComplexNumber result = calculator.execute(a, b);

            System.out.println("Результат операции: " + result);
        }
    }
}
