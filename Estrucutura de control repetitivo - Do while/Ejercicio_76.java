/*Se desea obtener el promedio de g grupos que están en un mismo año escolar, siendo que cada
grupo puede tener n alumnos que cada alumno puede llevar m materias y que en todas las materias
se promedian tres calificaciones para obtener el promedio de la materia. Lo que se desea es mostrar
el promedio de los grupos, el promedio de cada grupo y el promedio de cada alumno.*/

import java.util.Scanner;

public class Ejercicio_76 {
    public static void main(String[] arg){

        Scanner entrada = new Scanner(System.in);

        int grupos;
        int alumnos;
        int materias;

        int grupo=1;
        int alumno;
        int materia;
        int calificacion;

        double nota;
        double sumaCalificaciones;
        double promedioMateria;

        double sumaAlumno;
        double promedioAlumno;

        double sumaGrupo;
        double promedioGrupo;

        double sumaGrupos=0;
        double promedioGeneral;

        System.out.println("Ingrese la cantidad de grupos:");
        grupos=entrada.nextInt();

        System.out.println("Ingrese la cantidad de alumnos por grupo:");
        alumnos=entrada.nextInt();

        System.out.println("Ingrese la cantidad de materias por alumno:");
        materias=entrada.nextInt();

        do{

            sumaGrupo=0;

            alumno=1;

            do{

                sumaAlumno=0;

                materia=1;

                do{

                    sumaCalificaciones=0;
                    calificacion=1;

                    do{

                        System.out.println("Grupo " + grupo);
                        System.out.println("Alumno " + alumno);
                        System.out.println("Materia " + materia);
                        System.out.println("Ingrese la calificacion " + calificacion + ":");

                        nota=entrada.nextDouble();

                        sumaCalificaciones= sumaCalificaciones+nota;

                        calificacion++;

                    }while(calificacion<=3);

                    promedioMateria= sumaCalificaciones/3;

                    sumaAlumno= sumaAlumno+promedioMateria;

                    materia++;

                }while(materia<=materias);

                promedioAlumno= sumaAlumno/materias;

                System.out.println("PROMEDIO DEL ALUMNO");
                System.out.println("Grupo: " + grupo);
                System.out.println("Alumno: " + alumno);
                System.out.println("Promedio: " + promedioAlumno);

                sumaGrupo= sumaGrupo+promedioAlumno;

                alumno++;

            }while(alumno<=alumnos);

            promedioGrupo= sumaGrupo/alumnos;

            System.out.println("PROMEDIO DEL GRUPO");
            System.out.println("Grupo: " + grupo);
            System.out.println("Promedio: " + promedioGrupo);

            sumaGrupos= sumaGrupos+promedioGrupo;

            grupo++;

        }while(grupo<=grupos);

        promedioGeneral= sumaGrupos/grupos;

        System.out.println("PROMEDIO GENERAL DE LOS GRUPOS");
        System.out.println("Promedio: " + promedioGeneral);
    }
}
