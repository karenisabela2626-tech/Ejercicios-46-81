/*Dos números A y B son amigos, cuando la suma de los divisores menores que A es igual a B, al mismo
tiempo cuando la suma de los divisores menores que B es igual a A. Los dos menores números amigos
son 220 y 284, debido a que:
a. divisores de 220 1+2+4+5+10+11+20+22+44+45+110 = 284
b. divisores de 284 1+2+4+71+142 = 220
c. los siguientes pares de amigos son: 1184 y 1210; 2620 y 2924; 5020 y 5564, etc.*/

public class Ejercicio_69 {

    public static void main(String[] args) {

        int numero = 2;
        int cantidadPares = 0;

        System.out.println("Pares de numeros amigos:");

        while (cantidadPares < 5) {

            int sumaA = 0;
            int divisor = 1;

            // Sumar divisores de A
            while (divisor < numero) {

                if (numero % divisor == 0) {
                    sumaA = sumaA + divisor;
                }

                divisor++;
            }

            // B es la suma de los divisores de A
            int B = sumaA;

            // Evitar comparar un numero consigo mismo
            if (B > numero) {

                int sumaB = 0;
                divisor = 1;

                // Sumar divisores de B
                while (divisor < B) {

                    if (B % divisor == 0) {
                        sumaB = sumaB + divisor;
                    }

                    divisor++;
                }

                // Verificar si son numeros amigos
                if (sumaB == numero) {

                    System.out.println(numero + " y " + B);

                    cantidadPares++;
                }
            }

            numero++;
        }
    }
}