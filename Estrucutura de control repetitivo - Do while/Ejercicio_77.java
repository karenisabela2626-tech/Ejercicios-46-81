/*Desarrolle un algoritmo o programa que partiendo de la cantidad de habitantes que tiene cada uno
de los M municipios de los 5 principales Estados del País, calcule y muestre:
a. Estado con mayor población (nombre y cantidad),
b. Estado con menor población (nombre y cantidad),
c. Porcentaje que representan el total de los habitantes de los 5 Estados, respecto al total del
País y
d. Promedio de habitantes por Estado.*/

import java.util.Scanner;

public class Ejercicio_77 {
    public static void main(String[] arg){

        Scanner entrada = new Scanner(System.in);

        String nombreEstado;
        String estadoMayor="";
        String estadoMenor="";

        int municipios;
        int municipio;

        double habitantes;
        double poblacionEstado;

        double mayorPoblacion=0;
        double menorPoblacion=0;

        double sumaEstados=0;
        double totalPais;

        int estado=1;

        System.out.println("Ingrese el total de habitantes del pais:");
        totalPais=entrada.nextDouble();

        do{

            entrada.nextLine();

            System.out.println("Ingrese el nombre del estado " + estado + ":");
            nombreEstado=entrada.nextLine();

            System.out.println("Ingrese la cantidad de municipios del estado:");
            municipios=entrada.nextInt();

            poblacionEstado=0;
            municipio=1;

            do{

                System.out.println("Ingrese la cantidad de habitantes "
                        + "del municipio " + municipio + ":");

                habitantes=entrada.nextDouble();

                poblacionEstado= poblacionEstado+habitantes;

                municipio++;

            }while(municipio<=municipios);

            System.out.println("Poblacion del estado " + nombreEstado + ": " + poblacionEstado);

            sumaEstados= sumaEstados+poblacionEstado;

            if(estado==1){

                mayorPoblacion=poblacionEstado;
                menorPoblacion=poblacionEstado;

                estadoMayor=nombreEstado;
                estadoMenor=nombreEstado;

            }else{

                if(poblacionEstado>mayorPoblacion){

                    mayorPoblacion=poblacionEstado;
                    estadoMayor=nombreEstado;
                }

                if(poblacionEstado<menorPoblacion){

                    menorPoblacion=poblacionEstado;
                    estadoMenor=nombreEstado;
                }
            }

            estado++;

        }while(estado<=5);

        System.out.println("RESULTADOS");

        // a. Estado con mayor poblacion

        System.out.println("a. Estado con mayor poblacion: " + estadoMayor);

        System.out.println("   Cantidad de habitantes: " + mayorPoblacion);

        // b. Estado con menor poblacion

        System.out.println("b. Estado con menor poblacion: " + estadoMenor);

        System.out.println("   Cantidad de habitantes: " + menorPoblacion);

        // c. Porcentaje respecto al total del pais

        System.out.println("c. Porcentaje de habitantes de los 5 estados: " + (sumaEstados/totalPais)*100 + "%");

        // d. Promedio de habitantes por estado

        System.out.println("d. Promedio de habitantes por estado: " + sumaEstados/5);
    }
}