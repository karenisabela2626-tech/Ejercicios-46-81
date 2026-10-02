/*La bloquera “El Milagro” es una pequeña empresa dedicada a la fabricación de bloques de cemento
para construcción. Actualmente cuenta con una plantilla de obreros, cada uno de los cuales tiene un
número X de unidades a producir por semana. La secretaria registra, cada día, el número de bloques
que produjo cada obrero, para totalizar el sábado lo producido en la semana. De cada obrero se
conoce: nombre y cantidad de unidades producidas por día. Desarrolle un programa, que calcule y
muestre:
• Por obrero:
o Nombre
o Total, producido en la semana.
o Porcentaje que representa la producción semanal, respecto al límite
establecido.
• En general:
o Porcentaje de obreros que alcanzaron o superaron el número de unidades
producidas establecidas.
o Nombre del obrero que más produjo y cantidad producida.
o Promedio de producción de la bloquera en la semana.*/

import java.util.Scanner;

public class Ejercicio_74 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        int cantidadObreros;
        int limiteSemanal;

        int obrero = 1;

        int obrerosAlcanzaron = 0;
        int totalProduccion = 0;

        String nombreMayor = "";
        int mayorProduccion = 0;

        System.out.println("       BLOQUERA EL MILAGRO");

        System.out.println("Ingrese la cantidad de obreros:");
        cantidadObreros = entrada.nextInt();

        System.out.println("Ingrese el limite de unidades a producir por semana:");
        limiteSemanal = entrada.nextInt();

        while (obrero <= cantidadObreros) {

            String nombre;
            int dia = 1;
            int produccionSemanal = 0;

            System.out.println("OBRERO " + obrero);

            System.out.println("Ingrese el nombre del obrero:");
            nombre = entrada.nextLine();

            // Registrar producción de los 7 días
            while (dia <= 7) {

                int produccionDia;

                System.out.println("Ingrese los bloques producidos " + "el dia " + dia + ":");

                produccionDia = entrada.nextInt();

                produccionSemanal = produccionSemanal + produccionDia;

                dia++;
            }

            // Porcentaje respecto al limite semanal
            double porcentajeProduccion = (produccionSemanal * 100.0) / limiteSemanal;

            System.out.println("--- RESULTADO DEL OBRERO ---");
            System.out.println("Nombre: " + nombre);
            System.out.println("Total producido en la semana: " + produccionSemanal);
            System.out.println("Porcentaje respecto al limite: " + porcentajeProduccion + "%");

            // Producción total de la bloquera
            totalProduccion = totalProduccion + produccionSemanal;

            // Verificar si alcanzó o superó el límite
            if (produccionSemanal >= limiteSemanal) {
                obrerosAlcanzaron++;
            }

            // Buscar el obrero que más produjo
            if (obrero == 1 || produccionSemanal > mayorProduccion) {

                mayorProduccion = produccionSemanal;
                nombreMayor = nombre;
            }

            obrero++;
        }

        // Porcentaje de obreros que alcanzaron el límite
        double porcentajeObreros;

        if (cantidadObreros > 0) {
            porcentajeObreros = (obrerosAlcanzaron * 100.0) / cantidadObreros;
        } else {
            porcentajeObreros = 0;
        }

        // Promedio de producción
        double promedioProduccion;

        if (cantidadObreros > 0) {
            promedioProduccion = (double) totalProduccion / cantidadObreros;
        } else {
            promedioProduccion = 0;
        }

        // Resultados generales
        System.out.println("RESULTADOS GENERALES");
        System.out.println("Porcentaje de obreros que alcanzaron " + "o superaron el limite: " + porcentajeObreros + "%");
        System.out.println("Obrero que mas produjo: " + nombreMayor);
        System.out.println("Cantidad producida: " + mayorProduccion + " bloques");
        System.out.println("Promedio de produccion de la bloquera: " + promedioProduccion + " bloques");
    }
}
