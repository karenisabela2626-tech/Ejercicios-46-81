/*Cinco miembros de un club contra la obesidad desean saber cuánto han bajado o subido de peso
desde la última vez que se reunieron. Para esto se debe realizar un ritual de pesaje en donde cada
uno se pesa en diez básculas distintas para así tener el promedio más exacto de su peso. Si existe
diferencia positiva entre este promedio de peso y el peso de la última vez que se reunieron, significa
que subieron de peso. Pero si la diferencia es negativa, significa que bajaron. Lo que el problema
requiere es que por cada persona se imprima un mensaje que diga SUBIO ó BAJO y la cantidad de
kilos que subió o bajó de peso.*/

import java.util.Scanner;

public class Ejercicio_75 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        int persona = 1;

        while (persona <= 5) {

            double pesoAnterior;
            double peso;
            double sumaPesos = 0;
            double promedio;
            double diferencia;

            System.out.println("PERSONA " + persona);

            System.out.println("Ingrese el peso de la ultima reunion:");
            pesoAnterior = entrada.nextDouble();

            int bascula = 1;

            while (bascula <= 10) {

                System.out.println("Ingrese el peso de la bascula " + bascula + ":");

                peso = entrada.nextDouble();

                sumaPesos = sumaPesos + peso;

                bascula++;
            }

            // Calcular promedio de las 10 basculas
            promedio = sumaPesos / 10;

            // Diferencia entre el peso actual y el anterior
            diferencia = promedio - pesoAnterior;

            System.out.println("--- RESULTADO ---");

            if (diferencia > 0) {

                System.out.println("SUBIO");
                System.out.println("Cantidad de kilos: " + diferencia + " Kg.");

            } else if (diferencia < 0) {

                System.out.println("BAJO");
                System.out.println("Cantidad de kilos: " + (-diferencia) + " Kg.");

            } else {

                System.out.println("MANTUVO SU PESO");
                System.out.println("No subio ni bajo de peso.");
            }

            persona++;
        }
    }
}
