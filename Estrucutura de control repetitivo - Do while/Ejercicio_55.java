/*Calcule e imprima el número de términos necesarios para que el valor de la siguiente sumatoria se
aproxime los más cercanamente a 1000 sin que lo exceda: ∑((k∧2+1)/k), donde k=1,2,3,4,...*/

public class Ejercicio_55 {
    public static void main(String[] arg){

        int k=1;
        double suma=0;
        double termino;

        do{
            termino=(k*k+1)/(double)k;

            if(suma+termino<=1000){
                suma=suma+termino;
                k++;
            }

        }while(suma<1000);

        System.out.println("Numero de terminos necesarios: " + (k-1));
        System.out.println("Valor de la sumatoria: " + suma);
    }
}
