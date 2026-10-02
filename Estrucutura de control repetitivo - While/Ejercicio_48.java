/*Escriba un algoritmo para producir una tabla de conversión de temperatura para convertir valores
en grados Fahrenheit a su equivalente en grados Celsius, grados Kelvin y grados Rankine.
Las ecuaciones de conversión son:
C = 5(F-32) / 9
R = F + 459.67
K = C + 273.15
Donde F = temperatura en grados Fahrenheit
C = temperatura en grados Celsius
R = temperatura en grados Rankine
K = temperatura en grados Kelvin
Haga que el programa imprima encabezados para cada columna en la tabla.
Datos muestra:
de 28 a 54 oF en intervalos de 1 oF
de 450 a 950 oF en intervalos de 50 oF
de –50 a 250 oF en intervalos de 10 oF */

public class Ejercicio_48 {

    public static void main(String[] args) {

        float F, C, K, R;

        System.out.println("Fahrenheit\tCelsius\t\tKelvin\t\tRankine");

        // De 28 a 54, intervalo de 1
        F = 28;

        while (F <= 54) {

            C = 5 * (F - 32) / 9;
            R = F + 459.67f;
            K = C + 273.15f;

            System.out.printf("%.0f\t\t%.2f\t\t%.2f\t\t%.2f%n",
                    F, C, K, R);

            F = F + 1;
        }

        // De 450 a 950, intervalo de 50
        F = 450;

        while (F <= 950) {

            C = 5 * (F - 32) / 9;
            R = F + 459.67f;
            K = C + 273.15f;

            System.out.printf("%.0f\t\t%.2f\t\t%.2f\t\t%.2f%n",
                    F, C, K, R);

            F = F + 50;
        }

        // De -50 a 250, intervalo de 10
        F = -50;

        while (F <= 250) {

            C = 5 * (F - 32) / 9;
            R = F + 459.67f;
            K = C + 273.15f;

            System.out.printf("%.0f\t\t%.2f\t\t%.2f\t\t%.2f%n",
                    F, C, K, R);

            F = F + 10;
        }
    }
}