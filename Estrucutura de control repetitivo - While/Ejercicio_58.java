/*Muchos bancos y cajas de ahorro calculan los intereses de las cantidades depositadas por los clientes
diariamente con base en las siguientes premisas: un capital de $1000, con una tasa de interés del
6%, renta un interés en un día de 0.06 multiplicado por 1000 y dividido por 365. Esta operación
producirá $0.16 de interés y el capital acumulado será 1000,16. El interés para el segundo día se
calculará multiplicando 0.06 por 1000 y dividiendo el resultado por 365. Diseñar un programa que
reciba tres entradas: el capital a depositar, la tasa de interés y la duración del depósito en semanas
y calcule el capital total acumulado al final del período de tiempo especificado.*/

import java.util.Scanner;

public class Ejercicio_58 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        double capital;
        double tasa;
        int semanas;
        int dias = 0;
        double interes;

        System.out.print("Ingrese el capital a depositar: ");
        capital = entrada.nextDouble();

        System.out.print("Ingrese la tasa de interés (%): ");
        tasa = entrada.nextDouble();

        System.out.print("Ingrese la duración del depósito en semanas: ");
        semanas = entrada.nextInt();

        tasa = tasa / 100;

        dias = semanas * 7;

        while (dias > 0) {

            interes = (tasa * capital) / 365;

            capital = capital + interes;

            dias--;
        }

        System.out.println("El capital acumulado al final del período es: $" + capital);
    }
}
