/*Efectuar la división de dos números enteros, utilizando el método de las restas sucesivas. Observe
el siguiente ejemplo:
a. Dividir 8 entre 2
b. 8 – 2 = 6
c. 6 – 2 = 4
d. 4 – 2 = 2
e. 2 – 2 = 0
número de restas efectuadas es igual al cociente = 4
resto de la división*/

public class Ejercicio_56 {
    public static void main(String[] arg){

        int dividendo, divisor;
        int cociente=0;
        int resto;

        System.out.println("Ingrese el dividendo:");
        dividendo=Integer.parseInt(System.console().readLine());

        System.out.println("Ingrese el divisor:");
        divisor=Integer.parseInt(System.console().readLine());

        resto=dividendo;

        do{
            resto=resto-divisor;
            cociente++;
        }while(resto>=divisor);

        System.out.println("El cociente es: " + cociente);
        System.out.println("El resto es: " + resto);
    }
}