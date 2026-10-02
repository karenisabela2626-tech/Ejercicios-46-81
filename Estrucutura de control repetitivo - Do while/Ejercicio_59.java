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
    public static void main(String[] arg){

        Scanner entrada = new Scanner(System.in);

        double matematica, programacion, ingles;
        double menorProgramacion=10;
        double sumaProgramacion=0;

        int alumnos=0;
        int inglesNoPresentaron=0;
        int inglesPresentaron=0;
        int aprobaronTodas=0;
        int matematicaPresentaron=0;
        int matematicaReprobaron=0;

        do{
            System.out.println("Ingrese las notas del alumno " + (alumnos+1));
            System.out.println("Ingrese -1 en Matematica para terminar:");

            matematica=entrada.nextDouble();

            if(matematica!=-1){

                System.out.println("Ingrese la nota de Programacion:");
                programacion=entrada.nextDouble();

                System.out.println("Ingrese la nota de Ingles (-1 si no presento):");
                ingles=entrada.nextDouble();

                alumnos++;

                // a. Nota menor de Programacion
                if(programacion<menorProgramacion){
                    menorProgramacion=programacion;
                }

                // d. Promedio general de Programacion
                sumaProgramacion=sumaProgramacion+programacion;

                // b. Alumnos que presentaron o no Ingles
                if(ingles==-1){
                    inglesNoPresentaron++;
                }else{
                    inglesPresentaron++;
                }

                // c. Aprobaron todas las materias
                if(matematica>=3 && programacion>=3 && ingles>=3){
                    aprobaronTodas++;
                }

                // e. Matematica
                matematicaPresentaron++;

                if(matematica<3){
                    matematicaReprobaron++;
                }
            }

        }while(matematica!=-1);

        System.out.println("RESULTADOS");

        System.out.println("a. Nota menor de Programacion: " + menorProgramacion);

        if(inglesPresentaron>0){
            System.out.println("b. Porcentaje de alumnos que no presentaron Ingles: " + (double)inglesNoPresentaron/inglesPresentaron*100 + "%");
        }else{
            System.out.println("b. No hubo alumnos que presentaran Ingles.");
        }

        System.out.println("c. Alumnos que aprobaron todas las materias: " + aprobaronTodas);

        System.out.println("d. Promedio general en Programacion: " + sumaProgramacion/alumnos);

        if(matematicaPresentaron>0){
            System.out.println("e. Porcentaje de alumnos que reprobaron Matematica: " + (double)matematicaReprobaron/matematicaPresentaron*100 + "%");
        }
    }
}
