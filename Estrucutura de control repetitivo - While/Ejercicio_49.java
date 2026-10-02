/*100 personas presentaron una prueba constituida por 3 preguntas. Se requiere desarrollar un
algoritmo o programa que permita determinar la cantidad de personas que respondieron:

9

a. correctamente las tres preguntas.
b. Correctamente solamente la primera y la segunda pregunta.
c. Correctamente solamente la primera y la tercera pregunta.
d. Correctamente solamente la segunda y la tercera pregunta.
e. Correctamente la primera pregunta por lo menos.
f. Correctamente la segunda pregunta por lo menos.
g. Correctamente la tercera pregunta por lo menos.
h. Además, cuántos no respondieron correctamente ninguna pregunta.*/

import java.util.Scanner;

public class Ejercicio_49 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        int persona = 1;
        int p1, p2, p3;

        int tresCorrectas = 0;
        int primeraSegunda = 0;
        int primeraTercera = 0;
        int segundaTercera = 0;
        int primeraPorLoMenos = 0;
        int segundaPorLoMenos = 0;
        int terceraPorLoMenos = 0;
        int ninguna = 0;

        while (persona <= 5) {

            System.out.println("Persona " + persona);

            System.out.println("¿Respondió correctamente la pregunta 1? (1 = Sí, 0 = No)");
            p1 = entrada.nextInt();

            System.out.println("¿Respondió correctamente la pregunta 2? (1 = Sí, 0 = No)");
            p2 = entrada.nextInt();

            System.out.println("¿Respondió correctamente la pregunta 3? (1 = Sí, 0 = No)");
            p3 = entrada.nextInt();

            if (p1 == 1 && p2 == 1 && p3 == 1) {
                tresCorrectas++;
            }

            if (p1 == 1 && p2 == 1 && p3 == 0) {
                primeraSegunda++;
            }

            if (p1 == 1 && p2 == 0 && p3 == 1) {
                primeraTercera++;
            }

            if (p1 == 0 && p2 == 1 && p3 == 1) {
                segundaTercera++;
            }

            if (p1 == 1) {
                primeraPorLoMenos++;
            }

            if (p2 == 1) {
                segundaPorLoMenos++;
            }

            if (p3 == 1) {
                terceraPorLoMenos++;
            }

            if (p1 == 0 && p2 == 0 && p3 == 0) {
                ninguna++;
            }

            persona++;
        }

        System.out.println("RESULTADOS");
        System.out.println("a. Correctamente las tres preguntas: " + tresCorrectas);
        System.out.println("b. Solamente la primera y segunda: " + primeraSegunda);
        System.out.println("c. Solamente la primera y tercera: " + primeraTercera);
        System.out.println("d. Solamente la segunda y tercera: " + segundaTercera);
        System.out.println("e. Primera pregunta por lo menos: " + primeraPorLoMenos);
        System.out.println("f. Segunda pregunta por lo menos: " + segundaPorLoMenos);
        System.out.println("g. Tercera pregunta por lo menos: " + terceraPorLoMenos);
        System.out.println("h. Ninguna pregunta correctamente: " + ninguna);

        entrada.close();
    }
}