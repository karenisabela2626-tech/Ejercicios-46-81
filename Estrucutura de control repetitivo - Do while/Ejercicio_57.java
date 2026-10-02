/*Para calcular la raíz cuadrada de un número N positivo, Herón de Alejandría ideó la siguiente fórmula:
RN = (X + N / X) /2, donde RN es la raíz de N y se calcula hasta cuando la diferencia entre X y RN es
menor que 0.000001; tomando X el valor de RN en cada iteración. Se debe leer el número y asegurar
que es positivo. Se puede iniciar el cálculo dándole a X el valor 0.1.*/

import java.util.Scanner;

public class Ejercicio_57 {
    public static void main(String[] arg){

        Scanner entrada = new Scanner(System.in);

        double N, X=0.1, RN;
        double diferencia;

        do{
            System.out.println("Ingrese un numero positivo:");
            N=entrada.nextDouble();

            if(N<=0){
                System.out.println("El numero debe ser positivo.");
            }

        }while(N<=0);

        do{
            RN=(X+N/X)/2;
            diferencia=Math.abs(X-RN);
            X=RN;

        }while(diferencia>=0.000001);

        System.out.println("La raiz cuadrada de " + N + " es: " + RN);
    }
}
