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

public class Ejercicio_60 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        int numFac;
        String nombreCliente;
        double montoFactura;
        int dias;

        double interesMora;
        double montoDescontado;
        double montoCancelar;

        char continuar = 'S';

        while (continuar == 'S' || continuar == 's') {

            System.out.print("Ingrese el número de factura: ");
            numFac = entrada.nextInt();

            entrada.nextLine();

            System.out.print("Ingrese el nombre del cliente: ");
            nombreCliente = entrada.nextLine();

            System.out.print("Ingrese el monto de la factura: ");
            montoFactura = entrada.nextDouble();

            System.out.print("Ingrese los días transcurridos entre compra y pago: ");
            dias = entrada.nextInt();

            interesMora = 0;
            montoDescontado = 0;
            montoCancelar = montoFactura;

            if (dias >= 60) {
                interesMora = montoFactura * 0.08;
                montoCancelar = montoFactura + interesMora;
            } else if (dias >= 31 && dias <= 59) {
                interesMora = montoFactura * 0.06;
                montoCancelar = montoFactura + interesMora;
            } else if (dias < 15) {
                montoDescontado = montoFactura * 0.02;
                montoCancelar = montoFactura - montoDescontado;
            }

            System.out.println("FACTURA");
            System.out.println("Número de factura: " + numFac);
            System.out.println("Cliente: " + nombreCliente);
            System.out.println("Monto de la factura: $" + montoFactura);
            System.out.println("Interés de mora: $" + interesMora);
            System.out.println("Monto descontado: $" + montoDescontado);
            System.out.println("Monto a cancelar: $" + montoCancelar);

            System.out.print("¿Desea procesar otra factura? (S/N): ");
            continuar = entrada.next().charAt(0);
        }
    }
}
