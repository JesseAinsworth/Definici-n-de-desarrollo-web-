package edu.utvt.examples;

/**
 * La clase {@code BasicMathOperations} proporciona operaciones matemáticas básicas
 * (suma, resta, multiplicación y división) sobre un número base.
 * 
 * <p>Permite realizar operaciones aritméticas utilizando el número proporcionado
 * en el constructor como operando principal.</p>
 * 
 * <p>Ejemplo de uso:</p>
 * <pre>
 *     BasicMathOperations math = new BasicMathOperations(10);
 *     double suma = math.add(5); // suma = 15
 *     double resta = math.subtract(3); // resta = 7
 *     double multiplicacion = math.multiply(2); // multiplicacion = 20
 *     double division = math.divide(5); // division = 2
 * </pre>
 * 
 * <p>Nota: El método {@code divide} lanza una {@code ArithmeticException} si se intenta dividir por cero.</p>
 * 
 * @author Tu Nombre
 * @version 1.0
 */
public class BasicMathOperations {
    private double number;

    public BasicMathOperations(double number) {
        this.number = number;
    }

    
    /**
     * Suma el valor especificado al número actual.
     *
     * @param value el valor a sumar
     * @return el resultado de sumar el valor especificado al número actual
     */
    public double add(double value) {
        return number + value;
    }

    public double subtract(double value) {
        return number - value;
    }

    public double multiply(double value) {
        return number * value;
    }

    public double divide(double value) {
        if (value == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return number / value;
    }

    public static void main(String[] args) {
        BasicMathOperations math = new BasicMathOperations(10);
        System.out.println("Divide by 0: " + math.divide(0));
    }
}