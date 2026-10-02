/*72.Conociendo la masa y distancia de dos cuerpos se puede determinar la Fuerza de atracción que se
ejerce entre ambos. Se desea determinar las fuerzas de atracción ejercida entre la tierra y diversos
satélites ubicados a distintas alturas. Para lo cual la NASA le ha solicitado a usted construir un
programa que responda a los siguientes requerimientos:
a) Cuál es la mayor y menor fuerza de atracción ejercida por los satélites en estudio
b) La fuerza de atracción promedio ejercida por los satélites en estudio
c) La mayor masa de todos los satélites estudiados
d) La masa promedio de los satélites
e) La menor y mayor altura de los satélites
La fórmula para determinar la Fuerza de atracción es:

F = G m M / r^2

donde:
m: masa satélite;
M: Masa tierra (5,97 * 10 24 Kg);
r: distancia de los cuerpos;
G: Constante Gravitatoria (6,67259 * 10-11 N*m^2
/kg^2)

Considere la siguiente muestra para realizar la prueba del Programa:
Satélite País Masa Altura
Kg. Mts
Canada 1 Canadá 8.300 31.200.000
Alfa 1 Chile 5.500 36.000.000
Boby 4 EE.UU. 12.000 33.450.000
Che 3 Argentina 3.350 34.200.000*/

import java.util.Scanner;

public class Ejercicio_72 {
    public static void main(String[] arg){

        Scanner entrada = new Scanner(System.in);

        String nombre;
        double masa;
        double altura;
        double fuerza;

        double mayorFuerza=0;
        double menorFuerza=0;
        double sumaFuerzas=0;

        double mayorMasa=0;
        double sumaMasas=0;

        double mayorAltura=0;
        double menorAltura=0;

        int satelites=0;

        final double G=6.67259E-11;
        final double M=5.97E24;

        do{
            System.out.println("Ingrese el nombre del satelite (escriba 0 en la masa para terminar):");
            nombre=entrada.next();

            System.out.println("Ingrese la masa del satelite en Kg:");
            masa=entrada.nextDouble();

            if(masa!=0){

                System.out.println("Ingrese la altura del satelite en metros:");
                altura=entrada.nextDouble();

                fuerza=(G*masa*M)/(altura*altura);

                satelites++;

                sumaFuerzas=sumaFuerzas+fuerza;
                sumaMasas=sumaMasas+masa;

                if(satelites==1){
                    mayorFuerza=fuerza;
                    menorFuerza=fuerza;

                    mayorMasa=masa;

                    mayorAltura=altura;
                    menorAltura=altura;
                }else{

                    if(fuerza>mayorFuerza){
                        mayorFuerza=fuerza;
                    }

                    if(fuerza<menorFuerza){
                        menorFuerza=fuerza;
                    }

                    if(masa>mayorMasa){
                        mayorMasa=masa;
                    }

                    if(altura>mayorAltura){
                        mayorAltura=altura;
                    }

                    if(altura<menorAltura){
                        menorAltura=altura;
                    }
                }

                System.out.println("Satélite: " + nombre);
                System.out.println("Fuerza de atraccion: " + fuerza + " N");
            }

        }while(masa!=0);

        System.out.println("RESULTADOS");

        if(satelites>0){

            System.out.println("a. Mayor fuerza de atraccion: " + mayorFuerza + " N");

            System.out.println("   Menor fuerza de atraccion: " + menorFuerza + " N");

            System.out.println("b. Fuerza de atraccion promedio: " + sumaFuerzas/satelites + " N");

            System.out.println("c. Mayor masa de los satelites: " + mayorMasa + " Kg");

            System.out.println("d. Masa promedio de los satelites: " + sumaMasas/satelites + " Kg");

            System.out.println("e. Menor altura de los satelites: " + menorAltura + " m");

            System.out.println("   Mayor altura de los satelites: " + mayorAltura + " m");
        }
    }
}