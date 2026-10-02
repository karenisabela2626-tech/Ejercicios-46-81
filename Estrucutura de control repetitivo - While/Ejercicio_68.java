/*Un número se dice que es perfecto si la suma de sus divisores excepto él mismo es igual a dicho
número. Ejemplo: 6 es un número perfecto ya que sus divisores: 1 + 2 + 3 suman seis. Diseñe un
algoritmo o programa que imprima los tres primeros números perfectos.*/

public class Ejercicio_68 {

    public static void main(String[] args) {

        int numero = 1;
        int cantidadPerfectos = 0;

        System.out.println("Los tres primeros numeros perfectos son:");

        while (cantidadPerfectos < 3) {

            int divisor = 1;
            int suma = 0;

            while (divisor < numero) {

                if (numero % divisor == 0) {
                    suma = suma + divisor;
                }

                divisor++;
            }

            if (suma == numero) {
                System.out.println(numero);
                cantidadPerfectos++;
            }

            numero++;
        }
    }
}
