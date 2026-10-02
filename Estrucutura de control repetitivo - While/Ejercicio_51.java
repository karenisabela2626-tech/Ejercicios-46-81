/*Calcular el término doceavo y la suma de los doce primeros términos de la sucesión: 6, 11, 16, 21.
Respuesta: a12=61, suma=402.*/

public class Ejercicio_51 {

    public static void main(String[] args) {

        int termino = 6;
        int diferencia = 5;
        int contador = 1;
        int suma = 0;

        while (contador <= 12) {

            suma = suma + termino;

            if (contador == 12) {
                System.out.println("El término doceavo es: " + termino);
            }

            termino = termino + diferencia;
            contador++;
        }

        System.out.println("La suma de los doce primeros términos es: " + suma);
    }
}