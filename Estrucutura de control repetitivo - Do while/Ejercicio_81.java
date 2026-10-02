/*Una empresa proveedora de equipos de computación desea una aplicación que le permita controlar
las ventas y las comisiones de venta en los diferentes estados y ciudades donde posean canales de
comercialización. Para cada Estado pueden existir varias ciudades donde la empresa está presente;
a su vez cada ciudad puede contener canales de comercialización con vendedores de tienda (locales)
y de calle. Cada ciudad tiene asignada una cantidad de unidades de venta esperada. Cada estado,
ciudad, canal de comercialización y vendedor es identificado por códigos numéricos de 2,3,4 y 5
dígitos respectivamente. Los dos últimos dígitos del código de ciudad deben ser igual al código del
estado y los dos primeros dígitos del código de vendedor indican si el mismo es de tienda (valor 11)
o de calle (valor 12). La empresa paga un porcentaje de comisión del 10% para los vendedores de
tienda y un 15% de comisión para los vendedores de calle en función del monto total vendido por
los mismos, es decir, que la aplicación debe pedir por vendedor el total de unidades vendidas y el
monto total correspondiente a esa cantidad. La empresa le solicita que desarrolle un programa que
cubra lo siguiente:
• Calcular e imprimir por ciudad el código, el nombre, total de unidades vendidas, monto total bruto,
monto de comisión por vendedores de tienda, monto de comisión por vendedores de calle, código
del canal de comercialización con mayor monto neto de veta y el código del vendedor con menor
número de unidades vendidas.
• Calcular e imprimir por Estado el código, nombre, mono neto vendido, el porcentaje de ciudades que
no alcanzaron las cantidades esperadas y la cantidad de ciudades que obtuvieron de un 40% a un
60% por encima de la cantidad esperada.*/

import java.util.Scanner;

public class Ejercicio_81 {
    public static void main(String[] arg){

        Scanner entrada = new Scanner(System.in);

        int cantidadEstados;
        int cantidadCiudades;
        int cantidadCanales;
        int cantidadVendedores;

        int codigoEstado;
        int codigoCiudad;
        int codigoCanal;
        int codigoVendedor;

        String nombreEstado;
        String nombreCiudad;

        int unidades;
        int totalUnidadesCiudad;

        double monto;
        double montoBrutoCiudad;
        double montoComisionTienda;
        double montoComisionCalle;
        double montoComision;
        double montoNeto;

        double mayorMontoNeto;
        int codigoCanalMayor;

        int menorUnidades;
        int codigoVendedorMenor;

        double montoNetoEstado;

        int ciudadesNoAlcanzaron;
        int ciudadesEntre40y60;

        double unidadesEsperadas;
        double porcentajeCiudadesNoAlcanzaron;

        int estado=1;

        System.out.println("Ingrese la cantidad de estados:");
        cantidadEstados=entrada.nextInt();

        System.out.println("Ingrese la cantidad de ciudades por estado:");
        cantidadCiudades=entrada.nextInt();

        System.out.println("Ingrese la cantidad de canales por ciudad:");
        cantidadCanales=entrada.nextInt();

        System.out.println("Ingrese la cantidad de vendedores por canal:");
        cantidadVendedores=entrada.nextInt();

        do{

            System.out.println("ESTADO " + estado);

            System.out.println("Ingrese el codigo del estado (2 digitos):");
            codigoEstado=entrada.nextInt();

            entrada.nextLine();

            System.out.println("Ingrese el nombre del estado:");
            nombreEstado=entrada.nextLine();

            montoNetoEstado=0;
            ciudadesNoAlcanzaron=0;
            ciudadesEntre40y60=0;

            int ciudad=1;

            do{

                System.out.println("CIUDAD " + ciudad);

                System.out.println("Ingrese el codigo de la ciudad (3 digitos):");
                codigoCiudad=entrada.nextInt();

                /*
                 * Verificar que los dos ultimos digitos
                 * correspondan al codigo del estado.
                 */

                int ultimosDigitos=codigoCiudad%100;

                if(ultimosDigitos!=codigoEstado){

                    System.out.println("ERROR: Los dos ultimos digitos " + "del codigo de ciudad deben coincidir " + "con el codigo del estado.");

                }else{

                    entrada.nextLine();

                    System.out.println("Ingrese el nombre de la ciudad:");
                    nombreCiudad=entrada.nextLine();

                    System.out.println("Ingrese las unidades de venta esperadas:");
                    unidadesEsperadas=entrada.nextDouble();

                    totalUnidadesCiudad=0;
                    montoBrutoCiudad=0;
                    montoComisionTienda=0;
                    montoComisionCalle=0;

                    mayorMontoNeto=0;
                    codigoCanalMayor=0;

                    menorUnidades=0;
                    codigoVendedorMenor=0;

                    int canal=1;

                    do{

                        System.out.println("CANAL DE COMERCIALIZACION " + canal);

                        System.out.println("Ingrese el codigo del canal:");
                        codigoCanal=entrada.nextInt();

                        double montoNetoCanal=0;

                        int vendedor=1;

                        do{

                            System.out.println("VENDEDOR " + vendedor);

                            System.out.println("Ingrese el codigo del vendedor:");
                            codigoVendedor=entrada.nextInt();

                            /*
                             * Obtener los dos primeros digitos
                             * del codigo del vendedor.
                             */

                            int tipoVendedor= codigoVendedor/1000;

                            System.out.println("Ingrese el total de unidades vendidas:");
                            unidades=entrada.nextInt();

                            System.out.println("Ingrese el monto total vendido:");
                            monto=entrada.nextDouble();

                            /*
                             * Calculo de la comision
                             */

                            if(tipoVendedor==11){

                                montoComision=monto*0.10;

                                montoComisionTienda= montoComisionTienda+montoComision;

                            }else if(tipoVendedor==12){

                                montoComision=monto*0.15;

                                montoComisionCalle= montoComisionCalle+montoComision;

                            }else{

                                montoComision=0;

                                System.out.println("Codigo de vendedor " + "no valido.");
                            }

                            montoNeto=monto-montoComision;

                            totalUnidadesCiudad= totalUnidadesCiudad+unidades;

                            montoBrutoCiudad= montoBrutoCiudad+monto;

                            montoNetoCanal= montoNetoCanal+montoNeto;

                            /*
                             * Vendedor con menor cantidad
                             * de unidades vendidas.
                             */

                            if(vendedor==1){

                                menorUnidades=unidades;
                                codigoVendedorMenor=codigoVendedor;

                            }else{

                                if(unidades<menorUnidades){

                                    menorUnidades=unidades;
                                    codigoVendedorMenor=codigoVendedor;
                                }
                            }

                            vendedor++;

                        }while(vendedor<=cantidadVendedores);

                        /*
                         * Canal con mayor monto neto
                         */

                        if(canal==1){

                            mayorMontoNeto=montoNetoCanal;
                            codigoCanalMayor=codigoCanal;

                        }else{

                            if(montoNetoCanal>mayorMontoNeto){

                                mayorMontoNeto=montoNetoCanal;
                                codigoCanalMayor=codigoCanal;
                            }
                        }

                        canal++;

                    }while(canal<=cantidadCanales);

                    /*
                     * Calculo del monto neto de la ciudad
                     */

                    montoNeto= montoBrutoCiudad -montoComisionTienda -montoComisionCalle;

                    montoNetoEstado= montoNetoEstado+montoNeto;

                    /*
                     * Resultados de la ciudad
                     */

                    System.out.println("RESULTADOS DE LA CIUDAD");
                    System.out.println("Codigo: " + codigoCiudad);
                    System.out.println("Nombre: " + nombreCiudad);
                    System.out.println("Total de unidades vendidas: " + totalUnidadesCiudad);
                    System.out.println("Monto total bruto: $" + montoBrutoCiudad);
                    System.out.println("Comision vendedores de tienda: $" + montoComisionTienda);
                    System.out.println("Comision vendedores de calle: $" + montoComisionCalle);
                    System.out.println("Canal con mayor monto neto de venta: " + codigoCanalMayor);
                    System.out.println("Vendedor con menor numero " + "de unidades vendidas: " + codigoVendedorMenor);

                    /*
                     * Ciudades que no alcanzaron
                     * las unidades esperadas.
                     */

                    if(totalUnidadesCiudad<unidadesEsperadas){

                        ciudadesNoAlcanzaron++;
                    }

                    /*
                     * Ciudades entre 40% y 60%
                     * por encima de lo esperado.
                     */

                    if(totalUnidadesCiudad>=unidadesEsperadas*1.40 && totalUnidadesCiudad<=unidadesEsperadas*1.60){

                        ciudadesEntre40y60++;
                    }
                }

                ciudad++;

            }while(ciudad<=cantidadCiudades);

            /*
             * Porcentaje de ciudades que no alcanzaron
             * las cantidades esperadas.
             */

            porcentajeCiudadesNoAlcanzaron= (double)ciudadesNoAlcanzaron /cantidadCiudades*100;

            /*
             * Resultados del estado
             */

            System.out.println("RESULTADOS DEL ESTADO");
            System.out.println("Codigo: " + codigoEstado);
            System.out.println("Nombre: " + nombreEstado);
            System.out.println("Monto neto vendido: $" + montoNetoEstado);
            System.out.println("Porcentaje de ciudades que no alcanzaron " + "las cantidades esperadas: " + porcentajeCiudadesNoAlcanzaron + "%");
            System.out.println("Cantidad de ciudades que obtuvieron " + "entre 40% y 60% por encima de lo esperado: " + ciudadesEntre40y60);

            estado++;

        }while(estado<=cantidadEstados);
    }
}