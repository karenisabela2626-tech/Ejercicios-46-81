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

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        int cantidadEstados;
        int cantidadCiudades;
        int cantidadCanales;
        int cantidadVendedores;

        int estado = 1;
        int ciudad;
        int canal;
        int vendedor;

        int codigoEstado;
        int codigoCiudad;
        int codigoCanal;
        int codigoVendedor;

        String nombreEstado;
        String nombreCiudad;

        int unidadesEsperadas;
        int unidadesVendidas;

        int totalUnidadesCiudad;
        int totalUnidadesEstado;

        double montoVendido;
        double montoBrutoCiudad;
        double montoNetoCiudad;

        double comisionTienda;
        double comisionCalle;

        double totalComisionTienda;
        double totalComisionCalle;

        double montoNetoCanal;
        double mayorMontoNeto;
        int canalMayorMontoNeto;

        int menorUnidades;
        int vendedorMenorUnidades;

        int ciudadesNoAlcanzaron;
        int ciudadesEntre40y60;

        double porcentajeCiudadesNoAlcanzaron;

        System.out.println("CONTROL DE VENTAS Y COMISIONES");

        System.out.println("Ingrese la cantidad de Estados:");
        cantidadEstados = entrada.nextInt();

        System.out.println("Ingrese la cantidad de ciudades por Estado:");
        cantidadCiudades = entrada.nextInt();

        System.out.println("Ingrese la cantidad de canales por ciudad:");
        cantidadCanales = entrada.nextInt();

        System.out.println("Ingrese la cantidad de vendedores por canal:");
        cantidadVendedores = entrada.nextInt();

        while (estado <= cantidadEstados) {

            ciudad = 1;

            totalUnidadesEstado = 0;
            ciudadesNoAlcanzaron = 0;
            ciudadesEntre40y60 = 0;

            System.out.println("ESTADO " + estado);

            System.out.println("Ingrese el codigo del Estado:");
            codigoEstado = entrada.nextInt();

            entrada.nextLine();

            System.out.println("Ingrese el nombre del Estado:");
            nombreEstado = entrada.nextLine();

            while (ciudad <= cantidadCiudades) {

                canal = 1;

                totalUnidadesCiudad = 0;
                montoBrutoCiudad = 0;
                totalComisionTienda = 0;
                totalComisionCalle = 0;

                mayorMontoNeto = 0;
                canalMayorMontoNeto = 0;

                menorUnidades = 0;
                vendedorMenorUnidades = 0;

                System.out.println("\nCIUDAD " + ciudad);

                System.out.println("Ingrese el codigo de la ciudad:");
                codigoCiudad = entrada.nextInt();

                System.out.println("Ingrese el nombre de la ciudad:");
                nombreCiudad = entrada.nextLine();

                System.out.println("Ingrese las unidades de venta esperadas:");
                unidadesEsperadas = entrada.nextInt();

                while (canal <= cantidadCanales) {

                    vendedor = 1;
                    montoNetoCanal = 0;

                    System.out.println("\nCANAL " + canal);

                    System.out.println("Ingrese el codigo del canal:");
                    codigoCanal = entrada.nextInt();

                    while (vendedor <= cantidadVendedores) {

                        System.out.println("\nVENDEDOR " + vendedor);

                        System.out.println("Ingrese el codigo del vendedor:");
                        codigoVendedor = entrada.nextInt();

                        System.out.println("Ingrese el total de unidades vendidas:");
                        unidadesVendidas = entrada.nextInt();

                        System.out.println("Ingrese el monto total vendido:");
                        montoVendido = entrada.nextDouble();

                        // Acumular unidades y ventas
                        totalUnidadesCiudad = totalUnidadesCiudad + unidadesVendidas;

                        montoBrutoCiudad = montoBrutoCiudad + montoVendido;

                        // Calcular comision segun el tipo de vendedor
                        if (codigoVendedor / 100 == 11) {

                            comisionTienda = montoVendido * 0.10;

                            totalComisionTienda = totalComisionTienda + comisionTienda;

                        } else {

                            comisionCalle = montoVendido * 0.15;

                            totalComisionCalle = totalComisionCalle + comisionCalle;
                        }

                        // Calcular monto neto del canal
                        if (codigoVendedor / 100 == 11) {

                            montoNetoCanal = montoNetoCanal + (montoVendido - (montoVendido * 0.10));

                        } else {

                            montoNetoCanal = montoNetoCanal + (montoVendido - (montoVendido * 0.15));
                        }

                        // Buscar vendedor con menor cantidad de unidades
                        if (vendedor == 1 || unidadesVendidas < menorUnidades) {

                            menorUnidades = unidadesVendidas;
                            vendedorMenorUnidades = codigoVendedor;
                        }

                        vendedor++;
                    }

                    // Buscar canal con mayor monto neto
                    if (canal == 1 || montoNetoCanal > mayorMontoNeto) {

                        mayorMontoNeto = montoNetoCanal;
                        canalMayorMontoNeto = codigoCanal;
                    }

                    canal++;
                }

                // Calcular monto neto de la ciudad
                montoNetoCiudad = montoBrutoCiudad - totalComisionTienda - totalComisionCalle;

                // Verificar si la ciudad no alcanzo lo esperado
                if (totalUnidadesCiudad < unidadesEsperadas) {

                    ciudadesNoAlcanzaron++;
                }

                // Verificar si obtuvo entre 40% y 60% por encima
                // de la cantidad esperada
                if (totalUnidadesCiudad >= unidadesEsperadas * 1.40 && totalUnidadesCiudad <= unidadesEsperadas * 1.60) {

                    ciudadesEntre40y60++;
                }

                totalUnidadesEstado = totalUnidadesEstado + totalUnidadesCiudad;

                System.out.println("RESULTADO DE LA CIUDAD");

                System.out.println("Codigo: " + codigoCiudad);

                System.out.println("Nombre: " + nombreCiudad);

                System.out.println("Total de unidades vendidas: " + totalUnidadesCiudad);

                System.out.println("Monto total bruto: Bs. " + montoBrutoCiudad);

                System.out.println("Comision vendedores de tienda: Bs. " + totalComisionTienda);

                System.out.println("Comision vendedores de calle: Bs. " + totalComisionCalle);

                System.out.println("Canal con mayor monto neto de venta: " + canalMayorMontoNeto);

                System.out.println("Vendedor con menor numero " + "de unidades vendidas: " + vendedorMenorUnidades);

                ciudad++;
            }

            // Calcular porcentaje de ciudades que no alcanzaron
            porcentajeCiudadesNoAlcanzaron = (ciudadesNoAlcanzaron * 100.0) / cantidadCiudades;

            System.out.println("RESULTADO DEL ESTADO");

            System.out.println("Codigo: " + codigoEstado);

            System.out.println("Nombre: " + nombreEstado);

            System.out.println("Monto neto vendido: " + totalUnidadesEstado);

            System.out.println("Porcentaje de ciudades que no alcanzaron " + "las cantidades esperadas: " + porcentajeCiudadesNoAlcanzaron + "%");

            System.out.println("Cantidad de ciudades que obtuvieron " + "entre 40% y 60% por encima de lo esperado: " + ciudadesEntre40y60);

            estado++;
        }
    }
}
