/*Para cada una de las empresas del País se tienen como datos: actividad, localización y número de
trabajadores. La actividad y la localización, se codifican de la siguiente forma:

Actividad Localizacion
1=Agricola 1=norte
2=Industrial 2=sur
3=Mineria 3=este
4=Pesquera 4=oeste
5=Otra

Desarrolle un algoritmo / programa que calcule y muestre:
i. Porcentaje de empresas agrícolas del País.
ii. Porcentaje de empresas mineras del sur respecto al total de empresas que realizan
esa actividad.
iii. Promedio de trabajadores de las empresas de cada tipo de actividad. iv.
Localización con mayor número de empresas industriales.*/

import java.util.Scanner;

public class Ejercicio_62 {
    public static void main(String[] arg){

        Scanner entrada = new Scanner(System.in);

        int actividad, localizacion, trabajadores;

        int totalEmpresas=0;
        int agricolas=0;
        int mineras=0;
        int minerasSur=0;

        int sumaAgricolas=0;
        int sumaIndustriales=0;
        int sumaMineria=0;
        int sumaPesqueras=0;
        int sumaOtras=0;

        int industrialesNorte=0;
        int industrialesSur=0;
        int industrialesEste=0;
        int industrialesOeste=0;

        do{
            System.out.println("Ingrese la actividad de la empresa");
            System.out.println("1=Agricola");
            System.out.println("2=Industrial");
            System.out.println("3=Mineria");
            System.out.println("4=Pesquera");
            System.out.println("5=Otra");
            System.out.println("0=Terminar");

            actividad=entrada.nextInt();

            if(actividad!=0){

                System.out.println("Ingrese la localizacion");
                System.out.println("1=Norte");
                System.out.println("2=Sur");
                System.out.println("3=Este");
                System.out.println("4=Oeste");
                localizacion=entrada.nextInt();

                System.out.println("Ingrese el numero de trabajadores:");
                trabajadores=entrada.nextInt();

                totalEmpresas++;

                if(actividad==1){
                    agricolas++;
                    sumaAgricolas=sumaAgricolas+trabajadores;
                }

                if(actividad==2){
                    sumaIndustriales=sumaIndustriales+trabajadores;

                    if(localizacion==1){
                        industrialesNorte++;
                    }

                    if(localizacion==2){
                        industrialesSur++;
                    }

                    if(localizacion==3){
                        industrialesEste++;
                    }

                    if(localizacion==4){
                        industrialesOeste++;
                    }
                }

                if(actividad==3){
                    mineras++;
                    sumaMineria=sumaMineria+trabajadores;

                    if(localizacion==2){
                        minerasSur++;
                    }
                }

                if(actividad==4){
                    sumaPesqueras=sumaPesqueras+trabajadores;
                }

                if(actividad==5){
                    sumaOtras=sumaOtras+trabajadores;
                }
            }

        }while(actividad!=0);

        System.out.println("RESULTADOS");

        // i. Porcentaje de empresas agricolas
        System.out.println("i. Porcentaje de empresas agricolas: " + (double)agricolas/totalEmpresas*100 + "%");

        // ii. Porcentaje de empresas mineras del sur
        if(mineras>0){
            System.out.println("ii. Porcentaje de empresas mineras del sur: " + (double)minerasSur/mineras*100 + "%");
        }else{
            System.out.println("ii. No existen empresas mineras.");
        }

        // iii. Promedio de trabajadores por actividad
        if(agricolas>0){
            System.out.println("iii. Promedio de trabajadores en empresas agricolas: " + (double)sumaAgricolas/agricolas);
        }

        int industriales=0;
        if(sumaIndustriales>0){
            // Se cuenta posteriormente con las localizaciones
            industriales=industrialesNorte+industrialesSur+
                    industrialesEste+industrialesOeste;

            System.out.println("    Promedio de trabajadores en empresas industriales: " + (double)sumaIndustriales/industriales);
        }

        if(mineras>0){
            System.out.println("    Promedio de trabajadores en empresas mineras: " + (double)sumaMineria/mineras);
        }

        int pesqueras=0;
        // Para conocer la cantidad de pesqueras necesitamos contar las empresas
        // por separado.

        System.out.println("    Promedio de trabajadores en empresas pesqueras: " + "Se requiere el total de empresas pesqueras.");

        // iv. Localizacion con mayor numero de empresas industriales
        if(industrialesNorte>=industrialesSur &&
                industrialesNorte>=industrialesEste &&
                industrialesNorte>=industrialesOeste){

            System.out.println("iv. La localizacion con mayor numero de empresas industriales es: Norte");

        }else if(industrialesSur>=industrialesNorte &&
                industrialesSur>=industrialesEste &&
                industrialesSur>=industrialesOeste){

            System.out.println("iv. La localizacion con mayor numero de empresas industriales es: Sur");

        }else if(industrialesEste>=industrialesNorte &&
                industrialesEste>=industrialesSur &&
                industrialesEste>=industrialesOeste){

            System.out.println("iv. La localizacion con mayor numero de empresas industriales es: Este");

        }else{

            System.out.println("iv. La localizacion con mayor numero de empresas industriales es: Oeste");
        }
    }
}