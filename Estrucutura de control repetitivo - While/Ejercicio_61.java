/*Diseñe un algoritmo o programa que permita calcular la multiplicación de dos números, utilizando el
metodo de la multiplicación Rusa, el cual consiste en multiplicar por dos el multiplicando y dividir entre
dos el multiplicador hasta que el multiplicador tome el valor 1. Durante este proceso, se deben
sumar todos los multiplicandos correspondientes a multiplicadores impares y este resultado es el de
la multiplicación. Ejemplo:
a. 25 x 7 = 175 (multiplicador = 25, multiplicando = 7)
b. 25 7
c. 12 14
d. 6 28 suma= 7 + 56 + 112 = 175
e. 3 56
f. 1 112*/

import java.util.Scanner;

public class Ejercicio_61 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        int multiplicador;
        int multiplicando;
        int suma = 0;

        System.out.print("Ingrese el multiplicador: ");
        multiplicador = entrada.nextInt();

        System.out.print("Ingrese el multiplicando: ");
        multiplicando = entrada.nextInt();

        while (multiplicador >= 1) {

            if (multiplicador % 2 != 0) {
                suma = suma + multiplicando;
            }

            multiplicador = multiplicador / 2;
            multiplicando = multiplicando * 2;
        }

        System.out.println("El resultado de la multiplicación es: " + suma);
    }
}
