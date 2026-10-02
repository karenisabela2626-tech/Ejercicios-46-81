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
    public static void main(String[] arg){

        Scanner entrada = new Scanner(System.in);

        String apellido;
        String apellidoMayor="";

        int codigoLibro;
        int genero;
        int paginas;

        int totalLibrosAutor;
        int totalPaginasAutor;

        int mayorPaginas;
        int codigoMayorLibro;

        int totalLibros=0;
        int cienciaFiccion=0;
        int romance=0;

        int mayorCantidadLibros=0;

        int autores=0;

        do{

            entrada.nextLine();

            System.out.println("Ingrese el apellido del autor (FIN para terminar):");
            apellido=entrada.nextLine();

            if(!apellido.equalsIgnoreCase("FIN")){

                autores++;

                totalLibrosAutor=0;
                totalPaginasAutor=0;
                mayorPaginas=0;
                codigoMayorLibro=0;

                do{

                    System.out.println("Ingrese el codigo del libro (0 para terminar):");
                    codigoLibro=entrada.nextInt();

                    if(codigoLibro!=0){

                        System.out.println("Ingrese el genero del libro:");
                        System.out.println("1 = Ciencia ficcion");
                        System.out.println("2 = Romance");
                        System.out.println("3 = Accion");
                        System.out.println("4 = Terror");
                        System.out.println("5 = Novela");
                        System.out.println("6 = Autoayuda");
                        System.out.println("7 = Academico");

                        genero=entrada.nextInt();

                        System.out.println("Ingrese el numero de paginas:");
                        paginas=entrada.nextInt();

                        totalLibrosAutor++;
                        totalLibros++;

                        totalPaginasAutor= totalPaginasAutor+paginas;

                        if(genero==1){
                            cienciaFiccion++;
                        }

                        if(genero==2){
                            romance++;
                        }

                        if(totalLibrosAutor==1){

                            mayorPaginas=paginas;
                            codigoMayorLibro=codigoLibro;

                        }else{

                            if(paginas>mayorPaginas){

                                mayorPaginas=paginas;
                                codigoMayorLibro=codigoLibro;
                            }
                        }
                    }

                }while(codigoLibro!=0);

                System.out.println("RESULTADOS DEL AUTOR");
                System.out.println("Apellido: " + apellido);
                System.out.println("Total de paginas escritas: " + totalPaginasAutor);

                System.out.println("Codigo del libro con mayor numero de paginas: " + codigoMayorLibro);

                System.out.println("Cantidad de paginas: " + mayorPaginas);

                /*
                 * Autor con mayor cantidad de libros
                 */

                if(autores==1){

                    mayorCantidadLibros=totalLibrosAutor;
                    apellidoMayor=apellido;

                }else{

                    if(totalLibrosAutor>mayorCantidadLibros){

                        mayorCantidadLibros=totalLibrosAutor;
                        apellidoMayor=apellido;
                    }
                }
            }

        }while(!apellido.equalsIgnoreCase("FIN"));

        System.out.println("RESULTADOS GENERALES");

        if(totalLibros>0){

            /*
             * Porcentaje de libros de ciencia ficcion
             */

            System.out.println("Porcentaje de libros de ciencia ficcion: " + (double)cienciaFiccion/totalLibros*100 + "%");

            /*
             * Cantidad de libros de ciencia ficcion y romance
             */

            System.out.println("Cantidad de libros de ciencia ficcion: " + cienciaFiccion);

            System.out.println("Cantidad de libros de romance: " + romance);

            /*
             * Autor con mayor cantidad de libros
             */

            System.out.println("Autor con mayor cantidad de libros escritos: " + apellidoMayor);

            System.out.println("Cantidad de libros escritos: " + mayorCantidadLibros);
        }
    }
}
