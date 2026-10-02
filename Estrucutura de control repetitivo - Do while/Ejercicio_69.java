/*Dos números A y B son amigos, cuando la suma de los divisores menores que A es igual a B, al mismo
tiempo cuando la suma de los divisores menores que B es igual a A. Los dos menores números amigos
son 220 y 284, debido a que:
a. divisores de 220 1+2+4+5+10+11+20+22+44+45+110 = 284
b. divisores de 284 1+2+4+71+142 = 220
c. los siguientes pares de amigos son: 1184 y 1210; 2620 y 2924; 5020 y 5564, etc.*/

public class Ejercicio_69 {
    public static void main(String[] arg){

        int A=1;
        int B;
        int divisor;
        int sumaA;
        int sumaB;
        int pares=0;

        do{
            sumaA=0;
            divisor=1;

            do{
                if(A%divisor==0){
                    sumaA=sumaA+divisor;
                }

                divisor++;

            }while(divisor<A);

            B=sumaA;

            if(B>A){

                sumaB=0;
                divisor=1;

                do{
                    if(B%divisor==0){
                        sumaB=sumaB+divisor;
                    }

                    divisor++;

                }while(divisor<B);

                if(sumaB==A){

                    System.out.println("Par de numeros amigos: " + A + " y " + B);

                    pares++;
                }
            }

            A++;

        }while(pares<4);
    }
}