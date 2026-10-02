/*Se desea obtener el promedio de g grupos que están en un mismo año escolar, siendo que cada
grupo puede tener n alumnos que cada alumno puede llevar m materias y que en todas las materias
se promedian tres calificaciones para obtener el promedio de la materia. Lo que se desea es mostrar
el promedio de los grupos, el promedio de cada grupo y el promedio de cada alumno.*/

import java.util.Scanner;

public class Ejercicio_76 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        int cantidadGrupos;
        int cantidadAlumnos;
        int cantidadMaterias;

        int grupo = 1;

        double sumaPromediosGrupos = 0;

        System.out.println("PROMEDIO DEL AÑO ESCOLAR");

        System.out.println("Ingrese la cantidad de grupos:");
        cantidadGrupos = entrada.nextInt();

        System.out.println("Ingrese la cantidad de alumnos por grupo:");
        cantidadAlumnos = entrada.nextInt();

        System.out.println("Ingrese la cantidad de materias por alumno:");
        cantidadMaterias = entrada.nextInt();

        while (grupo <= cantidadGrupos) {

            int alumno = 1;
            double sumaPromediosAlumnos = 0;

            System.out.println("GRUPO " + grupo);

            while (alumno <= cantidadAlumnos) {

                int materia = 1;
                double sumaPromediosMaterias = 0;

                System.out.println("\n--- ALUMNO " + alumno + " ---");

                while (materia <= cantidadMaterias) {

                    int calificacion = 1;
                    double sumaCalificaciones = 0;

                    System.out.println("\nMateria " + materia);

                    while (calificacion <= 3) {

                        double nota;

                        System.out.println("Ingrese la calificacion " + calificacion + ":");

                        nota = entrada.nextDouble();

                        sumaCalificaciones = sumaCalificaciones + nota;

                        calificacion++;
                    }

                    // Promedio de la materia
                    double promedioMateria = sumaCalificaciones / 3;

                    System.out.println("Promedio de la materia: " + promedioMateria);

                    sumaPromediosMaterias = sumaPromediosMaterias + promedioMateria;

                    materia++;
                }

                // Promedio del alumno
                double promedioAlumno = sumaPromediosMaterias / cantidadMaterias;

                System.out.println("Promedio del alumno " + alumno + ": " + promedioAlumno);

                sumaPromediosAlumnos = sumaPromediosAlumnos + promedioAlumno;

                alumno++;
            }

            // Promedio del grupo
            double promedioGrupo = sumaPromediosAlumnos / cantidadAlumnos;

            System.out.println("Promedio del grupo " + grupo + ": " + promedioGrupo);

            sumaPromediosGrupos = sumaPromediosGrupos + promedioGrupo;

            grupo++;
        }

        // Promedio general de todos los grupos
        double promedioGeneral = sumaPromediosGrupos / cantidadGrupos;

        System.out.println("RESULTADO GENERAL");

        System.out.println("Promedio de todos los grupos: " + promedioGeneral);
    }
}
