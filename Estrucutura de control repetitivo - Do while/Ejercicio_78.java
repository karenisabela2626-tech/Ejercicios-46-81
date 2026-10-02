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
    public static void main(String[] arg){

        Scanner entrada = new Scanner(System.in);

        int cantidadSucursales;
        int cantidadPuntos;

        int codigoSucursal;
        int codigoPunto;
        int codigoProducto;

        String descripcionSucursal;

        int unidades;
        int unidades1;
        int unidades2;
        int unidades3;

        double pvp1;
        double pvp2;
        double pvp3;

        double venta1;
        double venta2;
        double venta3;

        double ventaBruta;
        double ventaNeta;
        double comision;

        double montoEsperado;
        double montoSucursal;

        double mayorComision;
        int codigoMayorComision;

        int sucursal=1;
        int punto;

        int sucursalesCumplieron=0;

        System.out.println("Ingrese la cantidad de sucursales:");
        cantidadSucursales=entrada.nextInt();

        System.out.println("Ingrese la cantidad de puntos de venta por sucursal:");
        cantidadPuntos=entrada.nextInt();

        System.out.println("Ingrese el PVP del producto 1:");
        pvp1=entrada.nextDouble();

        System.out.println("Ingrese el PVP del producto 2:");
        pvp2=entrada.nextDouble();

        System.out.println("Ingrese el PVP del producto 3:");
        pvp3=entrada.nextDouble();

        do{

            System.out.println("SUCURSAL " + sucursal);

            System.out.println("Ingrese el codigo de la sucursal:");
            codigoSucursal=entrada.nextInt();

            entrada.nextLine();

            System.out.println("Ingrese la descripcion de la sucursal:");
            descripcionSucursal=entrada.nextLine();

            System.out.println("Ingrese el monto de venta esperado:");
            montoEsperado=entrada.nextDouble();

            montoSucursal=0;
            mayorComision=0;
            codigoMayorComision=0;

            punto=1;

            do{

                System.out.println("PUNTO DE VENTA " + punto);

                System.out.println("Ingrese el codigo del punto de venta:");
                codigoPunto=entrada.nextInt();

                System.out.println("Ingrese unidades vendidas del producto 1:");
                unidades1=entrada.nextInt();

                System.out.println("Ingrese unidades vendidas del producto 2:");
                unidades2=entrada.nextInt();

                System.out.println("Ingrese unidades vendidas del producto 3:");
                unidades3=entrada.nextInt();

                venta1=unidades1*pvp1;
                venta2=unidades2*pvp2;
                venta3=unidades3*pvp3;

                ventaBruta=venta1+venta2+venta3;

                comision=ventaBruta*0.10;

                ventaNeta=ventaBruta-comision;

                montoSucursal=montoSucursal+ventaNeta;

                /*
                 * Determinar el producto con menor cantidad
                 * de unidades vendidas.
                 */

                if(unidades1<=unidades2 && unidades1<=unidades3){

                    codigoProducto=1;

                }else if(unidades2<=unidades1 && unidades2<=unidades3){

                    codigoProducto=2;

                }else{

                    codigoProducto=3;
                }

                unidades=unidades1+unidades2+unidades3;

                System.out.println("RESULTADOS DEL PUNTO DE VENTA");
                System.out.println("Codigo: " + codigoPunto);
                System.out.println("Unidades vendidas: " + unidades);
                System.out.println("Monto neto de la venta: $" + ventaNeta);
                System.out.println("Monto pagado por comision: $" + comision);
                System.out.println("Producto con menor cantidad de unidades: " + codigoProducto);

                /*
                 * Buscar el punto de venta que mas pago
                 * por comision.
                 */

                if(punto==1){

                    mayorComision=comision;
                    codigoMayorComision=codigoPunto;

                }else{

                    if(comision>mayorComision){

                        mayorComision=comision;
                        codigoMayorComision=codigoPunto;
                    }
                }

                punto++;

            }while(punto<=cantidadPuntos);

            /*
             * Resultados de la sucursal
             */

            double porcentajeVenta= (montoSucursal/montoEsperado)*100;

            System.out.println("RESULTADOS DE LA SUCURSAL");
            System.out.println("Codigo: " + codigoSucursal);
            System.out.println("Descripcion: " + descripcionSucursal);
            System.out.println("Monto total vendido: $" + montoSucursal);
            System.out.println("Porcentaje de venta alcanzado: " + porcentajeVenta + "%");
            System.out.println("Punto de venta que mas pago por comision: " + codigoMayorComision);
            System.out.println("Monto de comision: $" + mayorComision);

            if(montoSucursal>=montoEsperado){

                sucursalesCumplieron++;
            }

            sucursal++;

        }while(sucursal<=cantidadSucursales);

        /*
         * Porcentaje de sucursales que cumplieron
         */

        System.out.println("RESULTADOS GENERALES");

        System.out.println("Porcentaje de sucursales que alcanzaron " + "el monto esperado: " + (double)sucursalesCumplieron/cantidadSucursales*100 + "%");
    }
}
