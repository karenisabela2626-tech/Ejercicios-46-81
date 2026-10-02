/*Una estación climática proporciona un par de temperaturas diarias (máx, min), el rango normal de
temperatura es entre 14 y 30 ° C. La pareja fin de temperaturas es 0,0. Se pide determinar:
g. El número de días cuyas temperaturas se han proporcionado.
h. Las medias máxima y mínima.
i. Número de errores que ingresaron (temperaturas fuera de rango).
j. Porcentaje que representan los errores ingresados.*/

import java.util.Scanner;

public class Ejercicio_70 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        double maxima;
        double minima;

        int dias = 0;
        int errores = 0;

        double sumaMaximas = 0;
        double sumaMinimas = 0;

        System.out.println("Ingrese las temperaturas.");
        System.out.println("Para finalizar ingrese 0,0.");

        System.out.println("Temperatura maxima:");
        maxima = entrada.nextDouble();

        System.out.println("Temperatura minima:");
        minima = entrada.nextDouble();

        while (maxima != 0 || minima != 0) {

            dias++;

            // Acumular temperaturas
            sumaMaximas = sumaMaximas + maxima;
            sumaMinimas = sumaMinimas + minima;

            // Verificar temperatura maxima
            if (maxima < 14 || maxima > 30) {
                errores++;
            }

            // Verificar temperatura minima
            if (minima < 14 || minima > 30) {
                errores++;
            }

            System.out.println();

            System.out.println("Temperatura maxima:");
            maxima = entrada.nextDouble();

            System.out.println("Temperatura minima:");
            minima = entrada.nextDouble();
        }

        double mediaMaxima = 0;
        double mediaMinima = 0;
        double porcentajeErrores = 0;

        if (dias > 0) {

            mediaMaxima = sumaMaximas / dias;
            mediaMinima = sumaMinimas / dias;

            porcentajeErrores = (errores * 100.0) / (dias * 2);
        }

        System.out.println("RESULTADOS");

        System.out.println("Numero de dias: " + dias);
        System.out.println("Media maxima: " + mediaMaxima + " °C");
        System.out.println("Media minima: " + mediaMinima + " °C");
        System.out.println("Numero de errores: " + errores);
        System.out.println("Porcentaje de errores: " + porcentajeErrores + "%");

        entrada.close();
    }
}