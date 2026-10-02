/*Desarrolle un algoritmo o programa que permita calcular y mostrar la suma de todos los números
pares comprendidos entre 97 y 1003. Respuesta: 249150*/

public class Ejercicio_50 {
    public static void main(String[] arg){

        int numero=98, suma=0;

        do{
            suma=suma+numero;
            numero=numero+2;
        }while(numero<=1002);

        System.out.println("La suma de los numeros pares entre 97 y 1003 es: " + suma);
    }
}