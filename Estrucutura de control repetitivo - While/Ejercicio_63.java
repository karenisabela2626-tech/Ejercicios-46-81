/*En una encuesta de alumnos se tomaron los siguientes datos: edad, sexo, estado civil, y especialidad
que cursa. La empresa encuestadora, desea generar las siguientes estadísticas:

1
2

a. Promedio de edad de las mujeres.
b. Promedio de edad de los hombres.
c. Cantidad de hombres y de mujeres encuestados.
d. Porcentaje de personas para cada uno de los tipos de estado civil, respecto al total.
e. Cantidad de alumnos por especialidad y porcentaje que representan.
f. Porcentaje de mujeres adultas, tomando en cuenta que los adultos son los que tienen más
de 21 años.
g. Porcentaje de hombres jóvenes, tomando en cuenta que estos son los que tienen menos
de 21 años, pero más de 17.
h. Cantidad de hombres solteros y cantidad de mujeres solteras.*/

import java.util.Scanner;

public class Ejercicio_63 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        int cantidad;
        int alumno = 1;

        int edad;
        char sexo;
        int estadoCivil;
        int especialidad;

        int hombres = 0;
        int mujeres = 0;

        int sumaEdadHombres = 0;
        int sumaEdadMujeres = 0;

        int solteros = 0;
        int casados = 0;
        int divorciados = 0;
        int viudos = 0;

        int esp1 = 0;
        int esp2 = 0;
        int esp3 = 0;
        int esp4 = 0;
        int esp5 = 0;

        int mujeresAdultas = 0;
        int hombresJovenes = 0;

        int hombresSolteros = 0;
        int mujeresSolteras = 0;

        System.out.print("Ingrese la cantidad de alumnos encuestados: ");
        cantidad = entrada.nextInt();

        while (alumno <= cantidad) {

            System.out.println("Alumno " + alumno);

            System.out.print("Ingrese la edad: ");
            edad = entrada.nextInt();

            System.out.print("Ingrese el sexo (M/F): ");
            sexo = entrada.next().charAt(0);

            System.out.println("Estado civil:");
            System.out.println("1. Soltero");
            System.out.println("2. Casado");
            System.out.println("3. Divorciado");
            System.out.println("4. Viudo");
            System.out.print("Seleccione una opción: ");
            estadoCivil = entrada.nextInt();

            System.out.print("Ingrese la especialidad (1-5): ");
            especialidad = entrada.nextInt();

            // Sexo
            if (sexo == 'M' || sexo == 'm') {

                hombres++;
                sumaEdadHombres += edad;

                // Hombres jóvenes: menores de 21 y mayores de 17
                if (edad > 17 && edad < 21) {
                    hombresJovenes++;
                }

                // Hombres solteros
                if (estadoCivil == 1) {
                    hombresSolteros++;
                }
            }

            if (sexo == 'F' || sexo == 'f') {

                mujeres++;
                sumaEdadMujeres += edad;

                // Mujeres adultas: mayores de 21
                if (edad > 21) {
                    mujeresAdultas++;
                }

                // Mujeres solteras
                if (estadoCivil == 1) {
                    mujeresSolteras++;
                }
            }

            // Estado civil
            if (estadoCivil == 1) {
                solteros++;
            }

            if (estadoCivil == 2) {
                casados++;
            }

            if (estadoCivil == 3) {
                divorciados++;
            }

            if (estadoCivil == 4) {
                viudos++;
            }

            // Especialidad
            if (especialidad == 1) {
                esp1++;
            }

            if (especialidad == 2) {
                esp2++;
            }

            if (especialidad == 3) {
                esp3++;
            }

            if (especialidad == 4) {
                esp4++;
            }

            if (especialidad == 5) {
                esp5++;
            }

            alumno++;
        }

        System.out.println("RESULTADOS");

        // a. Promedio de edad de las mujeres
        if (mujeres > 0) {
            System.out.println("a. Promedio de edad de las mujeres: " + (double) sumaEdadMujeres / mujeres);
        }

        // b. Promedio de edad de los hombres
        if (hombres > 0) {
            System.out.println("b. Promedio de edad de los hombres: " + (double) sumaEdadHombres / hombres);
        }

        // c. Cantidad de hombres y mujeres
        System.out.println("c. Cantidad de hombres: " + hombres);
        System.out.println("   Cantidad de mujeres: " + mujeres);

        // d. Porcentaje por estado civil
        System.out.println("d. Porcentaje por estado civil:");

        System.out.println("   Solteros: " + (double) solteros / cantidad * 100 + "%");

        System.out.println("   Casados: " + (double) casados / cantidad * 100 + "%");

        System.out.println("   Divorciados: " + (double) divorciados / cantidad * 100 + "%");

        System.out.println("   Viudos: " + (double) viudos / cantidad * 100 + "%");

        // e. Cantidad y porcentaje por especialidad
        System.out.println("e. Especialidades:");

        System.out.println("   Especialidad 1: " + esp1 + " alumnos - " + (double) esp1 / cantidad * 100 + "%");

        System.out.println("   Especialidad 2: " + esp2 + " alumnos - " + (double) esp2 / cantidad * 100 + "%");

        System.out.println("   Especialidad 3: " + esp3 + " alumnos - " + (double) esp3 / cantidad * 100 + "%");

        System.out.println("   Especialidad 4: " + esp4 + " alumnos - " + (double) esp4 / cantidad * 100 + "%");

        System.out.println("   Especialidad 5: " + esp5 + " alumnos - " + (double) esp5 / cantidad * 100 + "%");

        // f. Porcentaje de mujeres adultas
        if (mujeres > 0) {
            System.out.println("f. Porcentaje de mujeres adultas: " + (double) mujeresAdultas / mujeres * 100 + "%");
        }

        // g. Porcentaje de hombres jóvenes
        if (hombres > 0) {
            System.out.println("g. Porcentaje de hombres jóvenes: " + (double) hombresJovenes / hombres * 100 + "%");
        }

        // h. Hombres y mujeres solteros
        System.out.println("h. Hombres solteros: " + hombresSolteros);
        System.out.println("   Mujeres solteras: " + mujeresSolteras);
    }
}
