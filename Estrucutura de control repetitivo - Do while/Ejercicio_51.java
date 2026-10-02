/*Calcular el término doceavo y la suma de los doce primeros términos de la sucesión: 6, 11, 16, 21.
Respuesta: a12=61, suma=402.*/

public class Ejercicio_51 {
    public static void main(String[] arg){

        int termino=6, suma=0, contador=1;

        do{
            suma=suma+termino;
            termino=termino+5;
            contador++;
        }while(contador<=12);

        termino=termino-5;

        System.out.println("El termino doceavo es: " + termino);
        System.out.println("La suma de los doce primeros terminos es: " + suma);
    }
}