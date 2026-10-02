/*Cinco miembros de un club contra la obesidad desean saber cuánto han bajado o subido de peso
desde la última vez que se reunieron. Para esto se debe realizar un ritual de pesaje en donde cada
uno se pesa en diez básculas distintas para así tener el promedio más exacto de su peso. Si existe
diferencia positiva entre este promedio de peso y el peso de la última vez que se reunieron, significa
que subieron de peso. Pero si la diferencia es negativa, significa que bajaron. Lo que el problema
requiere es que por cada persona se imprima un mensaje que diga SUBIO ó BAJO y la cantidad de
kilos que subió o bajó de peso.*/

import java.util.Scanner;

public class Ejercicio_75 {
    public static void main(String[] arg){

        Scanner entrada = new Scanner(System.in);

        double pesoAnterior;
        double peso;
        double sumaPesos;
        double promedio;
        double diferencia;

        int persona=1;
        int bascula;

        do{

            System.out.println("PERSONA " + persona);

            System.out.println("Ingrese el peso de la ultima reunion:");
            pesoAnterior=entrada.nextDouble();

            sumaPesos=0;
            bascula=1;

            do{

                System.out.println("Ingrese el peso de la bascula " + bascula + ":");
                peso=entrada.nextDouble();

                sumaPesos=sumaPesos+peso;

                bascula++;

            }while(bascula<=10);

            promedio=sumaPesos/10;

            diferencia=promedio-pesoAnterior;

            System.out.println("Peso promedio actual: " + promedio);

            if(diferencia>0){

                System.out.println("SUBIO");
                System.out.println("Cantidad de kilos que subio: " + diferencia);

            }else if(diferencia<0){

                System.out.println("BAJO");
                System.out.println("Cantidad de kilos que bajo: " + (-diferencia));

            }else{

                System.out.println("MANTUVO SU PESO");
                System.out.println("No subio ni bajo de peso.");
            }

            persona++;

        }while(persona<=5);
    }
}