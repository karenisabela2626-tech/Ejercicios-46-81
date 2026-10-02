/*Una pequeña Librería de la Ciudad desea controlar los datos de los diferentes autores cuyos libros
están a la venta. Cada autor ha escrito diversos libros, pudiendo estos ser clasificados de acuerdo al
género: ciencia ficción, romance, acción, terror, novela, autoayuda y académico. Para cada texto se
conoce: código, género y número de páginas. Escriba un programa, que permita calcular y mostrar:
• Por autor:
 Apellido
 Total, de páginas escritas o Código del libro con mayor número de páginas y
cantidad de páginas.

• En General:
 Porcentaje de libros de ciencia ficción, respecto al total de libros.
 Cantidad de libros de ciencia ficción y romance que hay en existencia.
 Apellido del autor con mayor cantidad de libros escritos y cantidad de libros
escritos.*/

import java.util.Scanner;

public class Ejercicio_79 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        int cantidadAutores;
        int cantidadLibros;

        int autor = 1;
        int libro;

        String apellido;
        String codigoLibro;
        String genero;

        int paginas;
        int totalPaginasAutor;
        int mayorPaginas;
        String codigoMayorLibro;

        int totalLibros = 0;
        int librosCienciaFiccion = 0;
        int librosRomance = 0;

        int mayorCantidadLibros = 0;
        String autorMayorCantidad = "";

        System.out.println("CONTROL DE LIBROS");

        System.out.println("Ingrese la cantidad de autores:");
        cantidadAutores = entrada.nextInt();

        while (autor <= cantidadAutores) {

            libro = 1;
            totalPaginasAutor = 0;
            mayorPaginas = 0;
            codigoMayorLibro = "";

            System.out.println("\nAUTOR " + autor);

            entrada.nextLine();

            System.out.println("Ingrese el apellido del autor:");
            apellido = entrada.nextLine();

            System.out.println("Ingrese la cantidad de libros escritos:");
            cantidadLibros = entrada.nextInt();

            while (libro <= cantidadLibros) {

                entrada.nextLine();

                System.out.println("\nLIBRO " + libro);

                System.out.println("Ingrese el codigo del libro:");
                codigoLibro = entrada.nextLine();

                System.out.println("Ingrese el genero del libro:");
                genero = entrada.nextLine();

                System.out.println("Ingrese el numero de paginas:");
                paginas = entrada.nextInt();

                // Acumular paginas del autor
                totalPaginasAutor = totalPaginasAutor + paginas;

                // Buscar libro con mayor cantidad de paginas
                if (libro == 1 || paginas > mayorPaginas) {

                    mayorPaginas = paginas;
                    codigoMayorLibro = codigoLibro;
                }

                // Contar libros
                totalLibros++;

                // Contar libros de ciencia ficcion
                if (genero.equalsIgnoreCase("ciencia ficcion")) {

                    librosCienciaFiccion++;
                }

                // Contar libros de romance
                if (genero.equalsIgnoreCase("romance")) {

                    librosRomance++;
                }

                libro++;
            }

            // Mostrar informacion del autor
            System.out.println("\nRESULTADO DEL AUTOR");

            System.out.println("Apellido: " + apellido);

            System.out.println("Total de paginas escritas: " + totalPaginasAutor);

            System.out.println("Codigo del libro con mayor numero " + "de paginas: " + codigoMayorLibro);

            System.out.println("Cantidad de paginas: " + mayorPaginas);

            // Buscar autor con mayor cantidad de libros
            if (cantidadLibros > mayorCantidadLibros) {

                mayorCantidadLibros = cantidadLibros;
                autorMayorCantidad = apellido;
            }

            autor++;
        }

        // Calcular porcentaje de libros de ciencia ficcion
        double porcentajeCienciaFiccion = 0;

        if (totalLibros > 0) {

            porcentajeCienciaFiccion = (librosCienciaFiccion * 100.0) / totalLibros;
        }

        System.out.println("RESULTADOS GENERALES");

        System.out.println("Porcentaje de libros de ciencia ficcion: " + porcentajeCienciaFiccion + "%");

        System.out.println("Cantidad de libros de ciencia ficcion: " + librosCienciaFiccion);

        System.out.println("Cantidad de libros de romance: " + librosRomance);

        System.out.println("Autor con mayor cantidad de libros: " + autorMayorCantidad);

        System.out.println("Cantidad de libros escritos: " + mayorCantidadLibros);
    }
}
