/*Una aerolínea está interesada en diseñar un software que le permita calcular y acumular los montos
a pagar por equipaje para cada uno de sus vuelos. El algoritmo debe procesar todos los vuelos del
día con sus respectivos pasajeros y maletas, las cuales están identificadas por un código. Las tarifas
por kilogramos se muestran en la siguiente tabla:
PESOS TARIFA POR Kgs.
1 a 3 Kgs. 0
3.01 a 6 Kgs 600
6.01 a 9 Kgs 1200
9.01 a 12 Kgs 1500
12.01 a 15 Kgs 2000
más de 15 Kgs. 2500

Se quiere un algoritmo en seudocódigo o diagrama estructurado que permita:

i. Imprimir por pasajero el número de vuelo, el código de abordo, el nombre, el total
de kilogramos del equipaje con su respectivo monto a pagar.
ii. Imprimir por pasajero el número de vuelo, el nombre y el código de la maleta con
mayor peso.
iii. Imprimir para cada vuelo el número de vuelo, el código de abordo, el nombre y el
peso total para el pasajero con mayor y menor peso total del equipaje.
iv. Imprimir para cada vuelo el número de vuelo y el monto total cancelado por
equipaje.
v. Imprimir el porcentaje de pasajeros que no pagaron por equipaje.

NOTA: No se podrán utilizar vectores ni matrices.*/

import java.util.Scanner;

public class Ejercicio_66 {
    public static void main(String[] arg){

        Scanner entrada = new Scanner(System.in);

        int vuelo;
        int abordo;
        int cantidadMaletas;

        String nombre;
        String codigoMaleta;

        double peso;
        double pesoTotal;
        double monto;
        double montoTotalVuelo;

        double mayorPesoMaleta;
        double mayorPesoPasajero;
        double menorPesoPasajero;

        double montoMaleta;

        String codigoMayorMaleta;
        String nombreMayor="";
        String nombreMenor="";

        int totalPasajeros=0;
        int pasajerosSinPago=0;

        do{
            System.out.println("Ingrese el numero de vuelo (0 para terminar):");
            vuelo=entrada.nextInt();

            if(vuelo!=0){

                montoTotalVuelo=0;
                mayorPesoPasajero=0;
                menorPesoPasajero=0;

                boolean primerPasajero=true;

                do{
                    System.out.println("Ingrese el codigo de abordo (0 para terminar el vuelo):");
                    abordo=entrada.nextInt();

                    if(abordo!=0){

                        entrada.nextLine();

                        System.out.println("Ingrese el nombre del pasajero:");
                        nombre=entrada.nextLine();

                        System.out.println("Ingrese la cantidad de maletas:");
                        cantidadMaletas=entrada.nextInt();

                        pesoTotal=0;
                        monto=0;
                        mayorPesoMaleta=0;
                        codigoMayorMaleta="";

                        int maleta=1;

                        do{
                            entrada.nextLine();

                            System.out.println("Ingrese el codigo de la maleta " + maleta + ":");
                            codigoMaleta=entrada.nextLine();

                            System.out.println("Ingrese el peso de la maleta en Kg:");
                            peso=entrada.nextDouble();

                            pesoTotal=pesoTotal+peso;

                            if(peso<=3){
                                montoMaleta=0;
                            }else if(peso<=6){
                                montoMaleta=peso*600;
                            }else if(peso<=9){
                                montoMaleta=peso*1200;
                            }else if(peso<=12){
                                montoMaleta=peso*1500;
                            }else if(peso<=15){
                                montoMaleta=peso*2000;
                            }else{
                                montoMaleta=peso*2500;
                            }

                            monto=monto+montoMaleta;

                            if(peso>mayorPesoMaleta){
                                mayorPesoMaleta=peso;
                                codigoMayorMaleta=codigoMaleta;
                            }

                            maleta++;

                        }while(maleta<=cantidadMaletas);

                        System.out.println("INFORMACION DEL PASAJERO");
                        System.out.println("Numero de vuelo: " + vuelo);
                        System.out.println("Codigo de abordo: " + abordo);
                        System.out.println("Nombre: " + nombre);
                        System.out.println("Total de kilogramos: " + pesoTotal);
                        System.out.println("Monto a pagar: $" + monto);

                        System.out.println("Maleta con mayor peso:");
                        System.out.println("Codigo: " + codigoMayorMaleta);
                        System.out.println("Peso: " + mayorPesoMaleta + " Kg");

                        totalPasajeros++;

                        if(monto==0){
                            pasajerosSinPago++;
                        }

                        if(primerPasajero){

                            mayorPesoPasajero=pesoTotal;
                            menorPesoPasajero=pesoTotal;

                            nombreMayor=nombre;
                            nombreMenor=nombre;

                            primerPasajero=false;

                        }else{

                            if(pesoTotal>mayorPesoPasajero){
                                mayorPesoPasajero=pesoTotal;
                                nombreMayor=nombre;
                            }

                            if(pesoTotal<menorPesoPasajero){
                                menorPesoPasajero=pesoTotal;
                                nombreMenor=nombre;
                            }
                        }

                        montoTotalVuelo=montoTotalVuelo+monto;
                    }

                }while(abordo!=0);

                System.out.println("RESULTADOS DEL VUELO");
                System.out.println("Numero de vuelo: " + vuelo);
                System.out.println("Pasajero con mayor peso: " + nombreMayor);
                System.out.println("Peso mayor: " + mayorPesoPasajero + " Kg");
                System.out.println("Pasajero con menor peso: " + nombreMenor);
                System.out.println("Peso menor: " + menorPesoPasajero + " Kg");
                System.out.println("Monto total cancelado por equipaje: $" + montoTotalVuelo);
            }

        }while(vuelo!=0);

        System.out.println("RESULTADOS GENERALES");
        System.out.println("Total de pasajeros: " + totalPasajeros);

        if(totalPasajeros>0){
            System.out.println("Porcentaje de pasajeros que no pagaron por equipaje: "
                    + (double)pasajerosSinPago/totalPasajeros*100 + "%");
        }
    }
}