/*Escriba un programa que imprima todos los enteros positivos impares menores que 100
omitiéndose aquellos que sean divisibles por 7. */

public class Ejercicio_47 {
    public static void main(String[] arg) {
        int numero = 1;
        while (numero < 100) {
            if (numero % 2 != 0 && numero % 7 != 0) {
                System.out.println(numero);
            } numero++;
        }
    }
}