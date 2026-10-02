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

public class Ejercicio_53 {
    public static void main(String[] arg){

        int M, empleado=1;
        String nombre, nacionalidad;
        int edad, tipo, horas;
        double sueldo, seguro, total;

        int venezolanos1=0, venezolanos2=0, venezolanos3=0;
        int extranjerosImpar=0;
        int sumaEdad=0;
        double totalSueldos=0;

        System.out.println("Ingrese la cantidad de empleados:");
        M=Integer.parseInt(System.console().readLine());

        do{
            System.out.println("\nEmpleado " + empleado);

            System.out.println("Ingrese el nombre:");
            nombre=System.console().readLine();

            System.out.println("Ingrese la nacionalidad (V o E):");
            nacionalidad=System.console().readLine();

            System.out.println("Ingrese la edad:");
            edad=Integer.parseInt(System.console().readLine());

            System.out.println("Ingrese el tipo de empleado (1, 2 o 3):");
            tipo=Integer.parseInt(System.console().readLine());

            System.out.println("Ingrese el numero de horas trabajadas:");
            horas=Integer.parseInt(System.console().readLine());

            if(tipo==1){
                sueldo=horas*5000;
            }else if(tipo==2){
                sueldo=horas*10000;
            }else{
                sueldo=horas*15000;
            }

            if(sueldo>100000){
                seguro=sueldo*0.03;
            }else{
                seguro=0;
            }

            total=sueldo-seguro;

            System.out.println("Nombre: " + nombre);
            System.out.println("Sueldo basico: " + sueldo);
            System.out.println("Seguro Social: " + seguro);
            System.out.println("Total a pagar: " + total);

            if(nacionalidad.equalsIgnoreCase("V")){
                if(tipo==1){
                    venezolanos1++;
                }

                if(tipo==2){
                    venezolanos2++;
                }

                if(tipo==3){
                    venezolanos3++;
                }
            }

            if(nacionalidad.equalsIgnoreCase("E") && edad%2!=0){
                extranjerosImpar++;
            }

            sumaEdad=sumaEdad+edad;
            totalSueldos=totalSueldos+total;

            empleado++;

        }while(empleado<=M);

        System.out.println("RESULTADOS GENERALES");

        System.out.println("c. Venezolanos tipo 1: " + venezolanos1);
        System.out.println("   Venezolanos tipo 2: " + venezolanos2);
        System.out.println("   Venezolanos tipo 3: " + venezolanos3);

        System.out.println("d. Extranjeros con edad impar: " + extranjerosImpar);

        System.out.println("e. Promedio de edad: " + (double)sumaEdad/M);

        System.out.println("f. Total general a pagar en sueldos: " + totalSueldos);
    }
}
