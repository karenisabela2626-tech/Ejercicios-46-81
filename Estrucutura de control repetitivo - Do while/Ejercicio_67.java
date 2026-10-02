/*Una persona adquiere una deuda de Bs. 12775, la cual cancela mediante pagos de montos crecientes
de los cuales el primero es por Bs. 100 y además la diferencia de dos pagos consecutivos es Bs. 125.
Determinar el número de pagos que realiza la persona así como el monto del último pago. Muestre
en pantalla una tabla con el monto de cada pago y el monto pendiente por cancelar. Respuesta:
número pagos = 14, monto del último = 1725.*/

public class Ejercicio_67 {
    public static void main(String[] arg){

        double deuda=12775;
        double pago=100;
        double pendiente=deuda;

        int numeroPago=1;

        System.out.println("PAGO       MONTO PAGADO       MONTO PENDIENTE");

        do{
            pendiente=pendiente-pago;

            System.out.println(numeroPago + "          $" + pago + "              $" + pendiente);

            pago=pago+125;
            numeroPago++;

        }while(pendiente>0);

        System.out.println("Numero de pagos: " + (numeroPago-1));
        System.out.println("Monto del ultimo pago: $" + (pago-125));
    }
}