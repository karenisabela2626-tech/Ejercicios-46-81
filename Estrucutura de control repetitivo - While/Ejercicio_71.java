/*La UNICEF desea obtener información estadística sobre los orfanatorios ubicados dentro de la
República y sobre los niños huérfanos internados en esos orfanatorios. Por cada niño se conoce:
sexo, edad, nombre del orfanatorio y estado de la República al que pertenece el Orfanatorio. Escriba
un Programa para calcular y mostrar lo siguiente:
a. Porcentaje de huérfanos del Estado Táchira y del Distrito Capital respecto al total del País.
b. Número de huérfanos en cada grupo. Los grupos se definen según la Edad:
Grupo 1: menores de 1 año
Grupo 2: edad comprendida entre 1 y 3 años
Grupo 3: edad comprendida entre 4 y 6 años
Grupo 4: mayores de 6 años
c. Cantidad de niños y niñas y porcentaje que representa cada uno.*/

import java.util.Scanner;

public class Ejercicio_71 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        String sexo;
        String estado;
        String orfanatorio;
        int edad;

        String continuar = "S";

        int totalHuerfanos = 0;

        // Estados Táchira y Distrito Capital
        int huerfanosTachira = 0;
        int huerfanosDistritoCapital = 0;

        // Grupos por edad
        int grupo1 = 0;
        int grupo2 = 0;
        int grupo3 = 0;
        int grupo4 = 0;

        // Cantidad por sexo
        int ninos = 0;
        int ninas = 0;

        while (continuar.equalsIgnoreCase("S")) {

            System.out.println("REGISTRO DEL HUERFANO");

            System.out.println("Ingrese el sexo (M/F):");
            sexo = entrada.nextLine();

            System.out.println("Ingrese la edad:");
            edad = entrada.nextInt();

            System.out.println("Ingrese el nombre del orfanatorio:");
            orfanatorio = entrada.nextLine();

            System.out.println("Ingrese el estado:");
            estado = entrada.nextLine();

            // Contar total de huérfanos
            totalHuerfanos++;

            // a. Contar huérfanos de Táchira
            if (estado.equalsIgnoreCase("Tachira")) {
                huerfanosTachira++;
            }

            // a. Contar huérfanos del Distrito Capital
            if (estado.equalsIgnoreCase("Distrito Capital")) {
                huerfanosDistritoCapital++;
            }

            // b. Clasificar según la edad
            if (edad < 1) {

                grupo1++;

            } else if (edad >= 1 && edad <= 3) {

                grupo2++;

            } else if (edad >= 4 && edad <= 6) {

                grupo3++;

            } else if (edad > 6) {

                grupo4++;
            }

            // c. Contar niños y niñas
            if (sexo.equalsIgnoreCase("M")) {

                ninos++;

            } else if (sexo.equalsIgnoreCase("F")) {

                ninas++;
            }

            System.out.println("¿Desea registrar otro huérfano? (S/N)");
            continuar = entrada.nextLine();
        }

        // Calcular porcentajes
        double porcentajeTachira = 0;
        double porcentajeDistritoCapital = 0;
        double porcentajeNinos = 0;
        double porcentajeNinas = 0;

        if (totalHuerfanos > 0) {

            porcentajeTachira = (huerfanosTachira * 100.0) / totalHuerfanos;

            porcentajeDistritoCapital = (huerfanosDistritoCapital * 100.0) / totalHuerfanos;

            porcentajeNinos = (ninos * 100.0) / totalHuerfanos;

            porcentajeNinas = (ninas * 100.0) / totalHuerfanos;
        }

        // Mostrar resultados
        System.out.println("RESULTADOS");

        System.out.println("--- A. POR ESTADO ---");

        System.out.println("Huérfanos de Táchira: " + huerfanosTachira);

        System.out.println("Porcentaje de Táchira: " + porcentajeTachira + "%");

        System.out.println("Huérfanos del Distrito Capital: " + huerfanosDistritoCapital);

        System.out.println("Porcentaje del Distrito Capital: " + porcentajeDistritoCapital + "%");

        System.out.println("--- B. GRUPOS POR EDAD ---");

        System.out.println("Grupo 1 (menores de 1 año): " + grupo1);

        System.out.println("Grupo 2 (1 a 3 años): " + grupo2);

        System.out.println("Grupo 3 (4 a 6 años): " + grupo3);

        System.out.println("Grupo 4 (mayores de 6 años): " + grupo4);

        System.out.println("--- C. POR SEXO ---");

        System.out.println("Cantidad de niños: " + ninos);
        System.out.println("Porcentaje de niños: " + porcentajeNinos + "%");

        System.out.println("Cantidad de niñas: " + ninas);
        System.out.println("Porcentaje de niñas: " + porcentajeNinas + "%");

        System.out.println("Total de huérfanos: " + totalHuerfanos);
    }
}
