/*La bloquera “El Milagro” es una pequeña empresa dedicada a la fabricación de bloques de cemento
para construcción. Actualmente cuenta con una plantilla de obreros, cada uno de los cuales tiene un
número X de unidades a producir por semana. La secretaria registra, cada día, el número de bloques
que produjo cada obrero, para totalizar el sábado lo producido en la semana. De cada obrero se
conoce: nombre y cantidad de unidades producidas por día. Desarrolle un programa, que calcule y
muestre:
• Por obrero:
o Nombre
o Total, producido en la semana.
o Porcentaje que representa la producción semanal, respecto al límite
establecido.
• En general:
o Porcentaje de obreros que alcanzaron o superaron el número de unidades
producidas establecidas.
o Nombre del obrero que más produjo y cantidad producida.
o Promedio de producción de la bloquera en la semana.*/

import java.util.Scanner;

public class Ejercicio_74 {
    public static void main(String[] arg){

        Scanner entrada = new Scanner(System.in);

        String nombre;
        int limite;
        int produccionDia;
        int produccionSemana;

        int obreros=0;
        int obrerosCumplieron=0;

        int mayorProduccion=0;
        int totalProduccion=0;

        String nombreMayor="";

        System.out.println("Ingrese el limite de unidades a producir por semana:");
        limite=entrada.nextInt();

        do{

            entrada.nextLine();

            System.out.println("Ingrese el nombre del obrero (FIN para terminar):");
            nombre=entrada.nextLine();

            if(!nombre.equalsIgnoreCase("FIN")){

                produccionSemana=0;

                int dia=1;

                do{

                    System.out.println("Ingrese la produccion del dia " + dia + ":");
                    produccionDia=entrada.nextInt();

                    produccionSemana= produccionSemana+produccionDia;

                    dia++;

                }while(dia<=6);

                obreros++;
                totalProduccion= totalProduccion+produccionSemana;

                double porcentaje= (double)produccionSemana/limite*100;

                System.out.println("RESULTADOS DEL OBRERO");
                System.out.println("Nombre: " + nombre);
                System.out.println("Total producido en la semana: " + produccionSemana);
                System.out.println("Porcentaje respecto al limite: " + porcentaje + "%");

                if(produccionSemana>=limite){
                    obrerosCumplieron++;
                }

                if(obreros==1){

                    mayorProduccion=produccionSemana;
                    nombreMayor=nombre;

                }else{

                    if(produccionSemana>mayorProduccion){

                        mayorProduccion=produccionSemana;
                        nombreMayor=nombre;
                    }
                }
            }

        }while(!nombre.equalsIgnoreCase("FIN"));

        System.out.println("RESULTADOS GENERALES");

        if(obreros>0){

            System.out.println("Porcentaje de obreros que alcanzaron " + "o superaron el limite: " + (double)obrerosCumplieron/obreros*100 + "%");

            System.out.println("Obrero que mas produjo: " + nombreMayor);

            System.out.println("Cantidad producida: " + mayorProduccion);

            System.out.println("Promedio de produccion de la bloquera: " + (double)totalProduccion/obreros);
        }
    }
}
