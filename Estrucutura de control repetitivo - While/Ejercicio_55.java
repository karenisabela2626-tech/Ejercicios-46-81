/*Calcule e imprima el número de términos necesarios para que el valor de la siguiente sumatoria se
aproxime los más cercanamente a 1000 sin que lo exceda: ∑((k∧2+1)/k), donde k=1,2,3,4,...*/

public class Ejercicio_55 {

    public static void main(String[] args) {

        int k = 1;
        double suma = 0;
        double termino;

        while (suma + ((k * k + 1.0) / k) <= 1000) {

            termino = (k * k + 1.0) / k;
            suma = suma + termino;

            k++;
        }

        System.out.println("Número de términos necesarios: " + (k - 1));
        System.out.println("Valor de la sumatoria: " + suma);
    }
}