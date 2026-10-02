/*La UNICEF desea obtener información estadística sobre los orfanatorios ubicados dentro de la
República y sobre los niños huérfanos internados en esos orfanatorios. Por cada niño se conoce:
sexo, edad, nombre del orfanatorio y estado de la República al que pertenece el Orfanatorio. Escriba
un Programa para calcular y mostrar lo siguiente:
a. Porcentaje de huérfanos del Estado Táchira y del Distrito Capital respecto al total del País.
b. Número de huérfanos en cada grupo. Los grupos se definen según la Edad:
Grupo 1: menores de 1 año
Grupo 2: edad comprendida entre 1 y 3 años
Grupo 3: edad comprendida entre 4 y 6 años
Grupo 4: mayores de 6 años
c. Cantidad de niños y niñas y porcentaje que representa cada uno.*/

import java.util.Scanner;

public class Ejercicio_71 {
    public static void main(String[] arg){

        Scanner entrada = new Scanner(System.in);

        String sexo;
        String nombreOrfanatorio;
        int edad;
        int estado;

        int totalHuerfanos=0;
        int tachira=0;
        int distritoCapital=0;

        int grupo1=0;
        int grupo2=0;
        int grupo3=0;
        int grupo4=0;

        int ninos=0;
        int ninas=0;

        do{
            System.out.println("Ingrese la edad del niño (0 para terminar):");
            edad=entrada.nextInt();

            if(edad!=0){

                System.out.println("Ingrese el sexo (M=Niño, F=Niña):");
                sexo=entrada.next();

                entrada.nextLine();

                System.out.println("Ingrese el nombre del orfanatorio:");
                nombreOrfanatorio=entrada.nextLine();

                System.out.println("Ingrese el estado:");
                System.out.println("1 = Tachira");
                System.out.println("2 = Distrito Capital");
                System.out.println("3 = Otro estado");
                estado=entrada.nextInt();

                totalHuerfanos++;

                if(estado==1){
                    tachira++;
                }

                if(estado==2){
                    distritoCapital++;
                }

                if(edad<1){
                    grupo1++;
                }else if(edad<=3){
                    grupo2++;
                }else if(edad<=6){
                    grupo3++;
                }else{
                    grupo4++;
                }

                if(sexo.equalsIgnoreCase("M")){
                    ninos++;
                }

                if(sexo.equalsIgnoreCase("F")){
                    ninas++;
                }
            }

        }while(edad!=0);

        System.out.println("RESULTADOS");

        if(totalHuerfanos>0){

            // a. Porcentaje de Tachira y Distrito Capital

            System.out.println("a. Porcentaje de huerfanos de Tachira: " + (double)tachira/totalHuerfanos*100 + "%");
            System.out.println("   Porcentaje de huerfanos del Distrito Capital: " + (double)distritoCapital/totalHuerfanos*100 + "%");

            // b. Cantidad de huerfanos por grupo

            System.out.println("b. Grupo 1 - Menores de 1 año: " + grupo1);
            System.out.println("   Grupo 2 - Entre 1 y 3 años: " + grupo2);
            System.out.println("   Grupo 3 - Entre 4 y 6 años: " + grupo3);
            System.out.println("   Grupo 4 - Mayores de 6 años: " + grupo4);

            // c. Cantidad y porcentaje de niños y niñas

            System.out.println("c. Cantidad de niños: " + ninos);
            System.out.println("   Porcentaje de niños: " + (double)ninos/totalHuerfanos*100 + "%");
            System.out.println("   Cantidad de niñas: " + ninas);
            System.out.println("   Porcentaje de niñas: " + (double)ninas/totalHuerfanos*100 + "%");
        }
    }
}
