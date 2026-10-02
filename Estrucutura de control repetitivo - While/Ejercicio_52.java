/*Una persona debe realizar un muestreo con 100 personas para determinar el promedio de peso de
los niños, jóvenes, adultos y viejos que existen en su zona habitacional. Para ello, conforme
encuentra a las personas introduce los datos a su computadora, la cual mediante un programa las
clasifica y despliega los cuatro promedios que la persona requiere. Las categorías se trabajan de
acuerdo a la siguiente tabla:

Categoria   Edad
Niños   0-12
Jovenes   13-29
Adultos   30-59
Vielos   60 en adelante*/

import java.util.Scanner;

public class Ejercicio_52 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        int persona = 1;
        int edad;
        double peso;

        double sumaNiños = 0;
        double sumaJovenes = 0;
        double sumaAdultos = 0;
        double sumaViejos = 0;

        int cantidadNiños = 0;
        int cantidadJovenes = 0;
        int cantidadAdultos = 0;
        int cantidadViejos = 0;

        while (persona <= 100) {

            System.out.println("Persona " + persona);

            System.out.print("Ingrese la edad: ");
            edad = entrada.nextInt();

            System.out.print("Ingrese el peso: ");
            peso = entrada.nextDouble();

            if (edad >= 0 && edad <= 12) {
                sumaNiños = sumaNiños + peso;
                cantidadNiños++;
            }

            if (edad >= 13 && edad <= 29) {
                sumaJovenes = sumaJovenes + peso;
                cantidadJovenes++;
            }

            if (edad >= 30 && edad <= 59) {
                sumaAdultos = sumaAdultos + peso;
                cantidadAdultos++;
            }

            if (edad >= 60) {
                sumaViejos = sumaViejos + peso;
                cantidadViejos++;
            }

            persona++;
        }

        System.out.println("PROMEDIOS DE PESO");

        if (cantidadNiños > 0) {
            System.out.println("Niños: " + (sumaNiños / cantidadNiños));
        } else {
            System.out.println("Niños: No hay datos");
        }

        if (cantidadJovenes > 0) {
            System.out.println("Jóvenes: " + (sumaJovenes / cantidadJovenes));
        } else {
            System.out.println("Jóvenes: No hay datos");
        }

        if (cantidadAdultos > 0) {
            System.out.println("Adultos: " + (sumaAdultos / cantidadAdultos));
        } else {
            System.out.println("Adultos: No hay datos");
        }

        if (cantidadViejos > 0) {
            System.out.println("Viejos: " + (sumaViejos / cantidadViejos));
        } else {
            System.out.println("Viejos: No hay datos");
        }
    }
}
