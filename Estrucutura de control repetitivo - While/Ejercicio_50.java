/*Desarrolle un algoritmo o programa que permita calcular y mostrar la suma de todos los números
pares comprendidos entre 97 y 1003. Respuesta: 249150*/

 class Ejercicio_50 {

    public static void main(String[] args) {

        int numero = 98;
        int suma = 0;

        while (numero <= 1002) {

            suma = suma + numero;

            numero = numero + 2;
        }

        System.out.println("La suma de los números pares entre 97 y 1003 es: " + suma);
    }
}