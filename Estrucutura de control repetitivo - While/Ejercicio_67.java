/*Una persona adquiere una deuda de Bs. 12775, la cual cancela mediante pagos de montos crecientes
de los cuales el primero es por Bs. 100 y además la diferencia de dos pagos consecutivos es Bs. 125.
Determinar el número de pagos que realiza la persona así como el monto del último pago. Muestre
en pantalla una tabla con el monto de cada pago y el monto pendiente por cancelar. Respuesta:
número pagos = 14, monto del último = 1725.*/

public class Ejercicio_67 {

    public static void main(String[] args) {

        double deuda = 12775;
        double pago = 100;
        double diferencia = 125;

        double pendiente = deuda;
        int numeroPago = 0;

        System.out.println("TABLA DE PAGOS DE LA DEUDA");
        System.out.println("Pago\tMonto\t\tPendiente");

        while (pendiente > 0) {

            numeroPago++;

            // Si el pago es mayor que la deuda pendiente,
            // solo se paga lo que falta.
            if (pago > pendiente) {
                pago = pendiente;
            }

            pendiente = pendiente - pago;

            System.out.println(numeroPago + "\tBs. " + pago
                    + "\t\tBs. " + pendiente);

            // Aumentar el siguiente pago en Bs. 125
            pago = pago + diferencia;
        }
        System.out.println("Numero de pagos: " + numeroPago);
        System.out.println("Monto del ultimo pago: Bs. " + (pago - diferencia));
    }
}
