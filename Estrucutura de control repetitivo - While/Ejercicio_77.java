/*Desarrolle un algoritmo o programa que partiendo de la cantidad de habitantes que tiene cada uno
de los M municipios de los 5 principales Estados del País, calcule y muestre:
a. Estado con mayor población (nombre y cantidad),
b. Estado con menor población (nombre y cantidad),
c. Porcentaje que representan el total de los habitantes de los 5 Estados, respecto al total del
País y
d. Promedio de habitantes por Estado.*/

import java.util.Scanner;

public class Ejercicio_77 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        int cantidadMunicipios;
        int estado = 1;
        int municipio;

        String nombreEstado;
        String estadoMayor = "";
        String estadoMenor = "";

        int habitantes;
        int totalEstado;
        int totalPais;

        int mayorPoblacion = 0;
        int menorPoblacion = 0;
        int totalCincoEstados = 0;

        System.out.println("POBLACION DE LOS 5 PRINCIPALES ESTADOS");

        System.out.println("Ingrese la cantidad de municipios por Estado:");
        cantidadMunicipios = entrada.nextInt();

        System.out.println("Ingrese la cantidad de habitantes del Pais:");
        totalPais = entrada.nextInt();

        while (estado <= 5) {

            totalEstado = 0;
            municipio = 1;

            System.out.println("Ingrese el nombre del Estado " + estado + ":");
            nombreEstado = entrada.nextLine();

            while (municipio <= cantidadMunicipios) {

                System.out.println("Ingrese la cantidad de habitantes "
                        + "del municipio " + municipio + ":");

                habitantes = entrada.nextInt();

                totalEstado = totalEstado + habitantes;

                municipio++;
            }

            System.out.println("Total de habitantes de " + nombreEstado + ": " + totalEstado);

            // Buscar Estado con mayor y menor población
            if (estado == 1) {

                mayorPoblacion = totalEstado;
                menorPoblacion = totalEstado;

                estadoMayor = nombreEstado;
                estadoMenor = nombreEstado;

            } else {

                if (totalEstado > mayorPoblacion) {

                    mayorPoblacion = totalEstado;
                    estadoMayor = nombreEstado;
                }

                if (totalEstado < menorPoblacion) {

                    menorPoblacion = totalEstado;
                    estadoMenor = nombreEstado;
                }
            }

            totalCincoEstados = totalCincoEstados + totalEstado;

            estado++;
        }

        // Porcentaje de los cinco Estados respecto al País
        double porcentajePais = 0;

        if (totalPais > 0) {

            porcentajePais = (totalCincoEstados * 100.0) / totalPais;
        }

        // Promedio de habitantes por Estado
        double promedioEstados = totalCincoEstados / 5.0;

        System.out.println("\nRESULTADOS");

        System.out.println("Estado con mayor poblacion: " + estadoMayor);

        System.out.println("Cantidad de habitantes: " + mayorPoblacion);

        System.out.println("Estado con menor poblacion: " + estadoMenor);

        System.out.println("Cantidad de habitantes: " + menorPoblacion);

        System.out.println("Porcentaje de habitantes de los 5 Estados " + "respecto al Pais: " + porcentajePais + "%");

        System.out.println("Promedio de habitantes por Estado: " + promedioEstados);
    }
}
