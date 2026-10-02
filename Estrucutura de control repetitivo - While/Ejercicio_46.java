/*Sea N y K dos enteros positivos, con K < N. Se desea escribir un programa que escriba el valor de
N,N-1,N-2,..., y así sucesivamente hasta llegar al valor de K. */

public class Ejercicio_46 {
    public static void main(String[] args){
        int N=10, K=2;
        System.out.println("El valor de N es: " + N);
        while(K<N){
            N--;
            System.out.println("El valor de N es: " + N);
        }
    }
}
