/*Para calcular la raíz cuadrada de un número N positivo, Herón de Alejandría ideó la siguiente fórmula:
RN = (X + N / X) /2, donde RN es la raíz de N y se calcula hasta cuando la diferencia entre X y RN es
menor que 0.000001; tomando X el valor de RN en cada iteración. Se debe leer el número y asegurar
que es positivo. Se puede iniciar el cálculo dándole a X el valor 0.1.*/

import java.util.Scanner;

public class Ejercicio_57 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        double N;
        double X = 0.1;
        double RN;
        double diferencia;

        do {
            System.out.print("Ingrese un número positivo: ");
            N = entrada.nextDouble();
        } while (N <= 0);

        diferencia = 1;

        while (diferencia >= 0.000001) {

            RN = (X + N / X) / 2;

            diferencia = Math.abs(X - RN);

            X = RN;
        }

        System.out.println("La raíz cuadrada de " + N + " es: " + X);
    }
}