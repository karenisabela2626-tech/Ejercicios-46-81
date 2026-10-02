/*Una estación climática proporciona un par de temperaturas diarias (máx, min), el rango normal de
temperatura es entre 14 y 30 ° C. La pareja fin de temperaturas es 0,0. Se pide determinar:
g. El número de días cuyas temperaturas se han proporcionado.
h. Las medias máxima y mínima.
i. Número de errores que ingresaron (temperaturas fuera de rango).
j. Porcentaje que representan los errores ingresados.*/

import java.util.Scanner;

public class Ejercicio_70 {
    public static void main(String[] arg){

        Scanner entrada = new Scanner(System.in);

        double maxima;
        double minima;

        double sumaMaxima=0;
        double sumaMinima=0;

        int dias=0;
        int errores=0;

        do{
            System.out.println("Ingrese la temperatura maxima:");
            maxima=entrada.nextDouble();

            System.out.println("Ingrese la temperatura minima:");
            minima=entrada.nextDouble();

            if(maxima!=0 || minima!=0){

                dias++;

                sumaMaxima=sumaMaxima+maxima;
                sumaMinima=sumaMinima+minima;

                if(maxima<14 || maxima>30 ||
                        minima<14 || minima>30){

                    errores++;
                }
            }

        }while(maxima!=0 || minima!=0);

        System.out.println("RESULTADOS");

        System.out.println("g. Numero de dias: " + dias);

        if(dias>0){

            System.out.println("h. Media de temperatura maxima: " + sumaMaxima/dias);

            System.out.println("   Media de temperatura minima: " + sumaMinima/dias);

            System.out.println("i. Numero de errores ingresados: " + errores);

            System.out.println("j. Porcentaje de errores ingresados: " + (double)errores/dias*100 + "%");
        }
    }
}