/*Desarrolle un programa que capture las notas del primer parcial de Matemática, Programación
e inglés de un grupo indeterminado de alumnos y calcule e imprima:
a. Nota menor de Programación.
b. Porcentaje de alumnos que no presentaron el examen de inglés, respecto a los que sí
presentaron.
c. Número de alumnos que aprobaron todas las materias.
d. Promedio general en Programación.
e. Porcentaje de alumnos que reprobaron Matemática, respecto al total de alumnos que
presentaron el examen de matemática.*/

import java.util.Scanner;

public class Ejercicio_59 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        double matematica;
        double programacion;
        double ingles;

        double menorProgramacion = 0;
        double sumaProgramacion = 0;

        int alumnos = 0;
        int inglesNoPresentaron = 0;
        int inglesPresentaron = 0;
        int aprobaronTodas = 0;

        int matematicaPresentaron = 0;
        int matematicaReprobaron = 0;

        System.out.print("Ingrese la nota de Matemática (-1 para terminar): ");
        matematica = entrada.nextDouble();

        while (matematica != -1) {

            System.out.print("Ingrese la nota de Programación: ");
            programacion = entrada.nextDouble();

            System.out.print("Ingrese la nota de Inglés (0 si no presentó): ");
            ingles = entrada.nextDouble();

            alumnos++;

            // a. Nota menor de Programación
            if (alumnos == 1) {
                menorProgramacion = programacion;
            }

            if (programacion < menorProgramacion) {
                menorProgramacion = programacion;
            }

            // d. Promedio general en Programación
            sumaProgramacion = sumaProgramacion + programacion;

            // b. Alumnos que presentaron o no Inglés
            if (ingles == 0) {
                inglesNoPresentaron++;
            } else {
                inglesPresentaron++;
            }

            // c. Alumnos que aprobaron todas las materias
            if (matematica >= 3 && programacion >= 3 && ingles >= 3) {
                aprobaronTodas++;
            }

            // e. Alumnos que presentaron y reprobaron Matemática
            matematicaPresentaron++;

            if (matematica < 3) {
                matematicaReprobaron++;
            }

            System.out.print("Ingrese la nota de Matemática (-1 para terminar): ");
            matematica = entrada.nextDouble();
        }

        System.out.println("RESULTADOS");

        System.out.println("a. Nota menor de Programación: "
                + menorProgramacion);

        if (inglesPresentaron > 0) {
            double porcentajeIngles =
                    (double) inglesNoPresentaron / inglesPresentaron * 100;

            System.out.println("b. Porcentaje de alumnos que no presentaron Inglés: "
                    + porcentajeIngles + "%");
        } else {
            System.out.println("b. No hubo alumnos que presentaran Inglés.");
        }

        System.out.println("c. Número de alumnos que aprobaron todas las materias: "
                + aprobaronTodas);

        if (alumnos > 0) {
            double promedioProgramacion =
                    sumaProgramacion / alumnos;

            System.out.println("d. Promedio general en Programación: "
                    + promedioProgramacion);
        }

        if (matematicaPresentaron > 0) {
            double porcentajeMatematica =
                    (double) matematicaReprobaron / matematicaPresentaron * 100;

            System.out.println("e. Porcentaje que reprobaron Matemática: "
                    + porcentajeMatematica + "%");
        }
    }
}