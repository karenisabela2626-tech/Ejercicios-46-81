/*Una empresa está interesada en automatizar el proceso anual de cálculo de intereses de mora y de
descuentos en el cobro de las facturas de los clientes a crédito. Para ello la empresa utiliza los
siguientes criterios:
a. Si la factura se paga se paga 60 días después de haber realizado la compra se cobra un
interés de mora del 8% sobre el monto de la factura.
b. Si la factura se paga entre 31 y 59 días después de haber realizado la compra se cobra un
interés de mora del 6% sobre el monto de la factura.
c. Si la factura se paga antes de los 15 días de haber realizado la compra se hace un descuento
del 2% sobre el monto de la factura.

Realice un algoritmo que lea los datos de las facturas por pantalla e imprima para cada factura el
número, nombre del cliente, el monto a cancelar, el monto a pagar por interés de mora y monto
descontado por pronto pago.
Los datos de cada factura son: Número de factura (num-fac), nombre del cliente (num-cli), monto de
la factura (mon-fac), fecha de compra (fec-com) y fecha de pago (fec-pag).*/

import java.util.Scanner;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Ejercicio_60 {
    public static void main(String[] arg){

        Scanner entrada = new Scanner(System.in);

        int numFac;
        String nombre;
        double monto;
        double interes;
        double descuento;
        double montoPagar;

        String fechaCompra;
        String fechaPago;

        long dias;

        do{
            System.out.println("Ingrese el numero de factura (0 para terminar):");
            numFac=entrada.nextInt();
            entrada.nextLine();

            if(numFac!=0){

                System.out.println("Ingrese el nombre del cliente:");
                nombre=entrada.nextLine();

                System.out.println("Ingrese el monto de la factura:");
                monto=entrada.nextDouble();
                entrada.nextLine();

                System.out.println("Ingrese la fecha de compra (AAAA-MM-DD):");
                fechaCompra=entrada.nextLine();

                System.out.println("Ingrese la fecha de pago (AAAA-MM-DD):");
                fechaPago=entrada.nextLine();

                LocalDate compra=LocalDate.parse(fechaCompra);
                LocalDate pago=LocalDate.parse(fechaPago);

                dias=ChronoUnit.DAYS.between(compra,pago);

                interes=0;
                descuento=0;
                montoPagar=monto;

                if(dias>=60){
                    interes=monto*0.08;
                    montoPagar=monto+interes;
                }else if(dias>=31 && dias<=59){
                    interes=monto*0.06;
                    montoPagar=monto+interes;
                }else if(dias<15){
                    descuento=monto*0.02;
                    montoPagar=monto-descuento;
                }

                System.out.println("FACTURA");
                System.out.println("Numero: " + numFac);
                System.out.println("Cliente: " + nombre);
                System.out.println("Monto de la factura: $" + monto);
                System.out.println("Dias transcurridos: " + dias);
                System.out.println("Interes de mora: $" + interes);
                System.out.println("Descuento por pronto pago: $" + descuento);
                System.out.println("Monto a cancelar: $" + montoPagar);
            }

        }while(numFac!=0);
    }
}