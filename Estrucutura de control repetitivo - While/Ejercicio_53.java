/*Una empresa requiere realizar el cálculo de la nómina semanal de un conjunto M de empleados; para
ello dispone que los datos de entrada son: nombre, nacionalidad (V o E), edad, tipo de empleado
(1,2,3) y número de horas trabajadas. Con esta información se desea calcular e imprimir:
a. Sueldo básico o bruto. Considere para ello que el pago por hora depende del tipo de
empleado, según la siguiente distribución:
• Si el tipo empleado es 1 Bs. 5000
• Si el tipo empleado es 2 Bs. 10000
• Si el tipo empleado es 3 Bs. 15000
b. Seguro Social, que corresponde al 3% del Sueldo Básico, si éste último es mayor a 100000.
c. Total, de venezolanos por tipo de empleado.
d. Total, de Extranjeros cuya edad es impar.
e. Promedio de edad de todos los empleados.
f. Total, general a pagar en sueldos.*/

import java.util.Scanner;

public class Ejercicio_53 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        int M;
        int empleado = 1;

        String nombre;
        char nacionalidad;
        int edad;
        int tipo;
        int horas;

        double pagoHora = 0;
        double sueldoBasico;
        double seguroSocial;
        double total;

        int venezolanosTipo1 = 0;
        int venezolanosTipo2 = 0;
        int venezolanosTipo3 = 0;

        int extranjerosEdadImpar = 0;

        int sumaEdades = 0;
        double totalSueldos = 0;

        System.out.print("Ingrese la cantidad de empleados: ");
        M = entrada.nextInt();

        while (empleado <= M) {

            System.out.println("Empleado " + empleado);

            entrada.nextLine();

            System.out.print("Ingrese el nombre: ");
            nombre = entrada.nextLine();

            System.out.print("Ingrese la nacionalidad (V/E): ");
            nacionalidad = entrada.next().charAt(0);

            System.out.print("Ingrese la edad: ");
            edad = entrada.nextInt();

            System.out.print("Ingrese el tipo de empleado (1, 2, 3): ");
            tipo = entrada.nextInt();

            System.out.print("Ingrese el número de horas trabajadas: ");
            horas = entrada.nextInt();

            if (tipo == 1) {
                pagoHora = 5000;
            }

            if (tipo == 2) {
                pagoHora = 10000;
            }

            if (tipo == 3) {
                pagoHora = 15000;
            }

            sueldoBasico = horas * pagoHora;

            if (sueldoBasico > 100000) {
                seguroSocial = sueldoBasico * 0.03;
            } else {
                seguroSocial = 0;
            }

            total = sueldoBasico - seguroSocial;

            System.out.println("Empleado: " + nombre);
            System.out.println("Sueldo básico: Bs. " + sueldoBasico);
            System.out.println("Seguro Social: Bs. " + seguroSocial);
            System.out.println("Total a pagar: Bs. " + total);

            if (nacionalidad == 'V' || nacionalidad == 'v') {

                if (tipo == 1) {
                    venezolanosTipo1++;
                }

                if (tipo == 2) {
                    venezolanosTipo2++;
                }

                if (tipo == 3) {
                    venezolanosTipo3++;
                }
            }

            if ((nacionalidad == 'E' || nacionalidad == 'e') && edad % 2 != 0) {
                extranjerosEdadImpar++;
            }

            sumaEdades = sumaEdades + edad;
            totalSueldos = totalSueldos + total;

            empleado++;
        }

        double promedioEdad = (double) sumaEdades / M;

        System.out.println("RESULTADOS");
        System.out.println("Venezolanos tipo 1: " + venezolanosTipo1);
        System.out.println("Venezolanos tipo 2: " + venezolanosTipo2);
        System.out.println("Venezolanos tipo 3: " + venezolanosTipo3);
        System.out.println("Extranjeros con edad impar: " + extranjerosEdadImpar);
        System.out.println("Promedio de edad: " + promedioEdad);
        System.out.println("Total general a pagar en sueldos: Bs. " + totalSueldos);

    }
}