/*Dada la siguiente serie: 1 + 1⁄2 + 1⁄4 + 1/8 + 1/16 + 1/32 + ... Desarrolle un algoritmo o programa que
determine el número de términos necesarios para obtener la suma que más se aproxime al valor de
1.99. Se debe imprimir el número de términos y el valor de la suma cuando cumpla la condición
mencionada antes.*/

public class Ejercicio_64 {

    public static void main(String[] args) {

        int terminos = 0;
        double termino = 1;
        double suma = 0;

        while (suma + termino <= 1.99) {

            suma = suma + termino;
            terminos++;

            termino = termino / 2;
        }

        System.out.println("Número de términos: " + terminos);
        System.out.println("Valor de la suma: " + suma);
    }
}