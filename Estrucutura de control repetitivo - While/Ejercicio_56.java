/*Efectuar la división de dos números enteros, utilizando el método de las restas sucesivas. Observe
el siguiente ejemplo:
a. Dividir 8 entre 2
b. 8 – 2 = 6
c. 6 – 2 = 4
d. 4 – 2 = 2
e. 2 – 2 = 0
número de restas efectuadas es igual al cociente = 4
resto de la división*/

import java.util.Scanner;

public class Ejercicio_56 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        int dividendo;
        int divisor;
        int resto;
        int cociente = 0;

        System.out.print("Ingrese el dividendo: ");
        dividendo = entrada.nextInt();

        System.out.print("Ingrese el divisor: ");
        divisor = entrada.nextInt();

        resto = dividendo;

        while (resto >= divisor) {

            resto = resto - divisor;
            cociente++;
        }

        System.out.println("Cociente: " + cociente);
        System.out.println("Resto: " + resto);
    }
}