/*Un número se dice que es perfecto si la suma de sus divisores excepto él mismo es igual a dicho
número. Ejemplo: 6 es un número perfecto ya que sus divisores: 1 + 2 + 3 suman seis. Diseñe un
algoritmo o programa que imprima los tres primeros números perfectos.*/

public class Ejercicio_68 {
    public static void main(String[] arg){

        int numero=1;
        int cantidadPerfectos=0;
        int divisor;
        int suma;

        do{
            divisor=1;
            suma=0;

            do{
                if(numero%divisor==0){
                    suma=suma+divisor;
                }

                divisor++;

            }while(divisor<numero);

            if(suma==numero){
                System.out.println("Numero perfecto: " + numero);
                cantidadPerfectos++;
            }

            numero++;

        }while(cantidadPerfectos<3);
    }
}