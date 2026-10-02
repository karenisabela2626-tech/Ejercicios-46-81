/*Una empresa comercializadora de productos cerámicos con sucursales y puntos de venta a nivel
nacional está interesada en desarrollar un software que le permita controlar sus ventas. Cada
sucursal posee un monto de venta esperado el cual debe cubrir y tiene asignados varios puntos de
venta, los cuales debe controlar. La sucursal es identificada con un código entero positivo de dos
dígitos y los puntos de venta por un código entero positivo de cuatro dígitos, en el cual los dos
primeros dígitos corresponden al código de la sucursal a la cual reporta. Los productos
comercializados por la empresa son identificados por un código que va del 1 al 3, el PVP de cada uno
es dado como constante y todos los puntos de venta, venden los 3 tipos de productos. El 10% de las
ventas brutas de cada punto de venta es repartido entre los vendedores de la misma en forma
equitativa como comisión de venta. Se requiere que desarrolle un programa que responda a lo
siguiente:
• Imprimir por punto de venta: su código, las unidades vendidas, el monto neto de la venta,
el monto pagado por comisión a los vendedores y el código del producto con menor número
de unidades vendidas.
• Calcular y mostrar por sucursal su código, descripción, el monto total vendido, el porcentaje
de venta alcanzado en función de lo esperado y el código y monto del punto de venta que
más pagó por comisión de venta.
• Calcular y mostrar el porcentaje de las sucursales que alcanzaron el monto de venta
esperado.*/

import java.util.Scanner;

public class Ejercicio_78 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        int cantidadSucursales;
        int cantidadPuntosVenta;
        int cantidadVendedores;

        int sucursal = 1;
        int puntoVenta;

        int codigoSucursal;
        int codigoPuntoVenta;
        int codigoProducto;

        String descripcionSucursal;

        double montoEsperado;
        double pvp1;
        double pvp2;
        double pvp3;

        int unidades1;
        int unidades2;
        int unidades3;

        int unidadesVendidas;
        int menorUnidades;
        int codigoProductoMenor;

        double montoBruto;
        double montoNeto;
        double comision;

        double totalSucursal;
        double porcentajeEsperado;

        double mayorComision;
        int puntoMayorComision;

        int sucursalesAlcanzaron = 0;

        System.out.println("CONTROL DE VENTAS");

        System.out.println("Ingrese la cantidad de sucursales:");
        cantidadSucursales = entrada.nextInt();

        System.out.println("Ingrese la cantidad de puntos de venta por sucursal:");
        cantidadPuntosVenta = entrada.nextInt();

        System.out.println("Ingrese la cantidad de vendedores por punto de venta:");
        cantidadVendedores = entrada.nextInt();

        System.out.println("Ingrese el PVP del producto 1:");
        pvp1 = entrada.nextDouble();

        System.out.println("Ingrese el PVP del producto 2:");
        pvp2 = entrada.nextDouble();

        System.out.println("Ingrese el PVP del producto 3:");
        pvp3 = entrada.nextDouble();

        while (sucursal <= cantidadSucursales) {

            totalSucursal = 0;
            puntoVenta = 1;

            mayorComision = 0;
            puntoMayorComision = 0;

            System.out.println("\nSUCURSAL " + sucursal);

            System.out.println("Ingrese el codigo de la sucursal:");
            codigoSucursal = entrada.nextInt();

            entrada.nextLine();

            System.out.println("Ingrese la descripcion de la sucursal:");
            descripcionSucursal = entrada.nextLine();

            System.out.println("Ingrese el monto de venta esperado:");
            montoEsperado = entrada.nextDouble();

            while (puntoVenta <= cantidadPuntosVenta) {

                System.out.println("\nPUNTO DE VENTA " + puntoVenta);

                System.out.println("Ingrese el codigo del punto de venta:");
                codigoPuntoVenta = entrada.nextInt();

                System.out.println("Ingrese las unidades vendidas " + "del producto 1:");
                unidades1 = entrada.nextInt();

                System.out.println("Ingrese las unidades vendidas " + "del producto 2:");
                unidades2 = entrada.nextInt();

                System.out.println("Ingrese las unidades vendidas " + "del producto 3:");
                unidades3 = entrada.nextInt();

                // Calcular unidades totales
                unidadesVendidas =
                        unidades1 + unidades2 + unidades3;

                // Calcular monto bruto
                montoBruto =
                        (unidades1 * pvp1)
                                + (unidades2 * pvp2)
                                + (unidades3 * pvp3);

                // Calcular comisión del 10%
                comision = montoBruto * 0.10;

                // Calcular monto neto
                montoNeto = montoBruto - comision;

                // Buscar producto con menor cantidad de unidades
                menorUnidades = unidades1;
                codigoProductoMenor = 1;

                if (unidades2 < menorUnidades) {

                    menorUnidades = unidades2;
                    codigoProductoMenor = 2;
                }

                if (unidades3 < menorUnidades) {

                    menorUnidades = unidades3;
                    codigoProductoMenor = 3;
                }

                // Mostrar información del punto de venta
                System.out.println("\nPUNTO DE VENTA: " + codigoPuntoVenta);

                System.out.println("Unidades vendidas: " + unidadesVendidas);

                System.out.println("Monto neto de la venta: Bs. " + montoNeto);

                System.out.println("Monto pagado por comision: Bs. " + comision);

                System.out.println("Producto con menor numero " + "de unidades vendidas: " + codigoProductoMenor);

                // Acumular ventas de la sucursal
                totalSucursal = totalSucursal + montoBruto;

                // Buscar punto de venta con mayor comision
                if (puntoVenta == 1 || comision > mayorComision) {

                    mayorComision = comision;
                    puntoMayorComision = codigoPuntoVenta;
                }

                puntoVenta++;
            }

            // Calcular porcentaje alcanzado
            porcentajeEsperado = (totalSucursal * 100.0) / montoEsperado;

            if (totalSucursal >= montoEsperado) {

                sucursalesAlcanzaron++;
            }

            // Mostrar información de la sucursal
            System.out.println("RESULTADO DE LA SUCURSAL");

            System.out.println("Codigo: " + codigoSucursal);

            System.out.println("Descripcion: " + descripcionSucursal);

            System.out.println("Monto total vendido: Bs. " + totalSucursal);

            System.out.println("Porcentaje de venta alcanzado: " + porcentajeEsperado + "%");

            System.out.println("Punto de venta que mas pago " + "por comision: " + puntoMayorComision);

            System.out.println("Monto de la comision: Bs. " + mayorComision);

            sucursal++;
        }

        // Calcular porcentaje de sucursales que alcanzaron el esperado
        double porcentajeSucursales = (sucursalesAlcanzaron * 100.0) / cantidadSucursales;

        System.out.println("RESULTADO GENERAL");

        System.out.println("Porcentaje de sucursales que alcanzaron " + "el monto de venta esperado: " + porcentajeSucursales + "%");
    }
}