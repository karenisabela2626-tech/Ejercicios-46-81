/*Una aerolínea está interesada en diseñar un software que le permita calcular y acumular los montos
a pagar por equipaje para cada uno de sus vuelos. El algoritmo debe procesar todos los vuelos del
día con sus respectivos pasajeros y maletas, las cuales están identificadas por un código. Las tarifas
por kilogramos se muestran en la siguiente tabla:
PESOS TARIFA POR Kgs.
1 a 3 Kgs. 0
3.01 a 6 Kgs 600
6.01 a 9 Kgs 1200
9.01 a 12 Kgs 1500
12.01 a 15 Kgs 2000
más de 15 Kgs. 2500

Se quiere un algoritmo en seudocódigo o diagrama estructurado que permita:

i. Imprimir por pasajero el número de vuelo, el código de abordo, el nombre, el total
de kilogramos del equipaje con su respectivo monto a pagar.
ii. Imprimir por pasajero el número de vuelo, el nombre y el código de la maleta con
mayor peso.
iii. Imprimir para cada vuelo el número de vuelo, el código de abordo, el nombre y el
peso total para el pasajero con mayor y menor peso total del equipaje.
iv. Imprimir para cada vuelo el número de vuelo y el monto total cancelado por
equipaje.
v. Imprimir el porcentaje de pasajeros que no pagaron por equipaje.

NOTA: No se podrán utilizar vectores ni matrices.*/

public class Ejercicio_66 {

    public static void main(String[] args) {

        int cantidadVuelos;
        int vuelo = 1;

        int totalPasajeros = 0;
        int pasajerosNoPagaron = 0;

        System.out.println("Ingrese la cantidad de vuelos del dia:");
        cantidadVuelos = Integer.parseInt(System.console().readLine());

        while (vuelo <= cantidadVuelos) {

            int cantidadPasajeros;
            int pasajero = 1;

            double totalVuelo = 0;

            // Datos del pasajero con mayor y menor equipaje
            double mayorPesoVuelo = -1;
            double menorPesoVuelo = -1;

            String nombreMayor = "";
            String codigoMayor = "";

            String nombreMenor = "";
            String codigoMenor = "";

            System.out.println("VUELO " + vuelo);

            System.out.println("Ingrese la cantidad de pasajeros:");
            cantidadPasajeros = Integer.parseInt(System.console().readLine());

            while (pasajero <= cantidadPasajeros) {

                String nombre;
                String codigoAbordo;

                int cantidadMaletas;
                int maleta = 1;

                double pesoTotalPasajero = 0;
                double montoTotalPasajero = 0;

                // Datos de la maleta con mayor peso
                double mayorPesoMaleta = -1;
                String codigoMaletaMayor = "";

                System.out.println("\n--- PASAJERO " + pasajero + " ---");

                System.out.println("Ingrese el nombre:");
                nombre = System.console().readLine();

                System.out.println("Ingrese el codigo de abordo:");
                codigoAbordo = System.console().readLine();

                System.out.println("Ingrese la cantidad de maletas:");
                cantidadMaletas = Integer.parseInt(System.console().readLine());

                while (maleta <= cantidadMaletas) {

                    String codigoMaleta;
                    double peso;
                    double tarifa;
                    double monto;

                    System.out.println("\nMaleta " + maleta);

                    System.out.println("Ingrese el codigo de la maleta:");
                    codigoMaleta = System.console().readLine();

                    System.out.println("Ingrese el peso de la maleta en Kgs:");
                    peso = Double.parseDouble(System.console().readLine());

                    // Determinar tarifa
                    if (peso >= 1 && peso <= 3) {
                        tarifa = 0;
                    } else if (peso > 3 && peso <= 6) {
                        tarifa = 600;
                    } else if (peso > 6 && peso <= 9) {
                        tarifa = 1200;
                    } else if (peso > 9 && peso <= 12) {
                        tarifa = 1500;
                    } else if (peso > 12 && peso <= 15) {
                        tarifa = 2000;
                    } else if (peso > 15) {
                        tarifa = 2500;
                    } else {
                        tarifa = 0;
                    }

                    // Calcular monto de la maleta
                    monto = peso * tarifa;

                    pesoTotalPasajero = pesoTotalPasajero + peso;
                    montoTotalPasajero = montoTotalPasajero + monto;

                    // Buscar la maleta de mayor peso
                    if (peso > mayorPesoMaleta) {
                        mayorPesoMaleta = peso;
                        codigoMaletaMayor = codigoMaleta;
                    }

                    maleta++;
                }

                // i. Información del pasajero
                System.out.println("INFORMACION DEL PASAJERO");
                System.out.println("Numero de vuelo: " + vuelo);
                System.out.println("Codigo de abordo: " + codigoAbordo);
                System.out.println("Nombre: " + nombre);
                System.out.println("Total de kilogramos: " + pesoTotalPasajero);
                System.out.println("Monto a pagar: $" + montoTotalPasajero);

                // ii. Maleta con mayor peso
                System.out.println("Maleta con mayor peso:");
                System.out.println("Codigo de maleta: " + codigoMaletaMayor);
                System.out.println("Peso: " + mayorPesoMaleta + " Kgs.");

                // Acumular monto del vuelo
                totalVuelo = totalVuelo + montoTotalPasajero;

                // Contar pasajeros
                totalPasajeros++;

                // v. Pasajeros que no pagaron
                if (montoTotalPasajero == 0) {
                    pasajerosNoPagaron++;
                }

                // iii. Buscar pasajero con mayor peso del vuelo
                if (mayorPesoVuelo == -1 || pesoTotalPasajero > mayorPesoVuelo) {

                    mayorPesoVuelo = pesoTotalPasajero;
                    nombreMayor = nombre;
                    codigoMayor = codigoAbordo;
                }

                // iii. Buscar pasajero con menor peso del vuelo
                if (menorPesoVuelo == -1 || pesoTotalPasajero < menorPesoVuelo) {

                    menorPesoVuelo = pesoTotalPasajero;
                    nombreMenor = nombre;
                    codigoMenor = codigoAbordo;
                }

                pasajero++;
            }

            // iii. Pasajeros con mayor y menor peso
            System.out.println("MAYOR Y MENOR PESO DEL VUELO " + vuelo);

            System.out.println("\nPasajero con MAYOR peso:");
            System.out.println("Numero de vuelo: " + vuelo);
            System.out.println("Codigo de abordo: " + codigoMayor);
            System.out.println("Nombre: " + nombreMayor);
            System.out.println("Peso total: " + mayorPesoVuelo + " Kgs.");

            System.out.println("Pasajero con MENOR peso:");
            System.out.println("Numero de vuelo: " + vuelo);
            System.out.println("Codigo de abordo: " + codigoMenor);
            System.out.println("Nombre: " + nombreMenor);
            System.out.println("Peso total: " + menorPesoVuelo + " Kgs.");

            // iv. Total cancelado por el vuelo
            System.out.println("TOTAL DEL VUELO " + vuelo);
            System.out.println("Monto total cancelado por equipaje: $" + totalVuelo);

            vuelo++;
        }

        // v. Porcentaje de pasajeros que no pagaron
        double porcentajeNoPagaron;

        if (totalPasajeros > 0) {
            porcentajeNoPagaron =
                    (pasajerosNoPagaron * 100.0) / totalPasajeros;
        } else {
            porcentajeNoPagaron = 0;
        }

        System.out.println("RESULTADO GENERAL DEL DIA");
        System.out.println("Total de pasajeros: " + totalPasajeros);
        System.out.println("Pasajeros que no pagaron: " + pasajerosNoPagaron);
        System.out.println("Porcentaje de pasajeros que no pagaron: " + porcentajeNoPagaron + "%");
    }
}
