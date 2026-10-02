/*Un investigador acaba de aplicar 64 cuestionarios de 23 preguntas cada uno; donde cada pregunta
permite escoger entre 1 y 5, a un grupo de personas que constituyen su población. Se desea que
elabore un Programa, para ayudar al Investigador a procesar toda la información recopilada, para
ello tome en cuenta lo siguiente: necesita calcular el promedio de cada instrumento o escala para lo
cual es necesaria la fórmula: PT/NT, donde PT representa el total de puntos de cada cuestionario que
resulta de sumar los valores que el encuestado, encerró entre un círculo y NT es el total de preguntas
del instrumento. Estos valores se deben acumular, para al final calcular y mostrar lo siguiente:
a. La media o promedio de todos los cuestionarios (promedio general).
b. El promedio más alto obtenido y número de instrumento a que corresponde.
c. El promedio más bajo obtenido y número de instrumento a que corresponde.
d. Porcentaje de cuestionarios que obtuvieron un promedio inferior a 3, respecto a los que tuvieron un
promedio superior a 4.
e. Porcentaje de cuestionarios que obtuvieron un promedio entre 4.5 y 5 respecto al total procesado.*/

import java.util.Scanner;

public class Ejercicio_54 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        int cuestionario = 1;
        int pregunta;
        int respuesta;
        int puntosTotales = 0;

        double promedio;
        double sumaPromedios = 0;

        double promedioMayor = 0;
        double promedioMenor = 5;
        int instrumentoMayor = 0;
        int instrumentoMenor = 0;

        int promedioInferior3 = 0;
        int promedioSuperior4 = 0;
        int promedioEntre45y5 = 0;

        while (cuestionario <= 64) {

            puntosTotales = 0;
            pregunta = 1;

            while (pregunta <= 23) {

                System.out.print("Cuestionario " + cuestionario
                        + " - Pregunta " + pregunta + ": ");
                respuesta = entrada.nextInt();

                puntosTotales = puntosTotales + respuesta;

                pregunta++;
            }

            promedio = (double) puntosTotales / 23;

            sumaPromedios = sumaPromedios + promedio;

            if (promedio > promedioMayor) {
                promedioMayor = promedio;
                instrumentoMayor = cuestionario;
            }

            if (promedio < promedioMenor) {
                promedioMenor = promedio;
                instrumentoMenor = cuestionario;
            }

            if (promedio < 3) {
                promedioInferior3++;
            }

            if (promedio > 4) {
                promedioSuperior4++;
            }

            if (promedio >= 4.5 && promedio <= 5) {
                promedioEntre45y5++;
            }

            cuestionario++;
        }

        double promedioGeneral = sumaPromedios / 64;

        double porcentajeInferiorRespectoSuperior =
                (double) promedioInferior3 / promedioSuperior4 * 100;

        double porcentajeEntre45y5 =
                (double) promedioEntre45y5 / 64 * 100;

        System.out.println("RESULTADOS");

        System.out.println("a. Promedio general: " + promedioGeneral);

        System.out.println("b. Promedio más alto: " + promedioMayor);
        System.out.println("   Instrumento: " + instrumentoMayor);

        System.out.println("c. Promedio más bajo: " + promedioMenor);
        System.out.println("   Instrumento: " + instrumentoMenor);

        System.out.println("d. Porcentaje de cuestionarios con promedio inferior a 3 "
                + "respecto a los superiores a 4: "
                + porcentajeInferiorRespectoSuperior + "%");

        System.out.println("e. Porcentaje de cuestionarios con promedio entre 4.5 y 5: "
                + porcentajeEntre45y5 + "%");
    }
}