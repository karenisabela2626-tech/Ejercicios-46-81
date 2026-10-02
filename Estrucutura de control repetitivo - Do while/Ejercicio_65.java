/*Calcular el sueldo neto de los trabajadores de una compañía sabiendo que este depende de los
siguientes datos:
• sueldo básico mensual 100000 si es obrero
• sueldo básico mensual 165500 si es administrativo
• sueldo básico mensual 250000 si es ejecutivo Las asignaciones y deducciones son:
• aporte por cada hijo hasta 5 hijos 10% del sueldo básico
• aporte por asistencia superior al 95% de los 30 días del mes 5% del sueldo básico.
• Deducción del 10% del sueldo básico para la caja de ahorros.
• Deducción para el seguro social 2% del sueldo básico
Por cada empleado debe salir un registro con el nombre y cédula, sueldo básico, aporte a la Caja de
Ahorros, seguro social y sueldo neto.*/

import java.util.Scanner;

public class Ejercicio_65 {
    public static void main(String[] arg){

        Scanner entrada = new Scanner(System.in);

        String nombre;
        long cedula;
        int tipo;
        int hijos;
        int diasAsistencia;

        double sueldoBasico;
        double aporteHijos;
        double aporteAsistencia;
        double cajaAhorros;
        double seguroSocial;
        double sueldoNeto;

        do{
            System.out.println("Ingrese la cedula del trabajador (0 para terminar):");
            cedula=entrada.nextLong();
            entrada.nextLine();

            if(cedula!=0){

                System.out.println("Ingrese el nombre:");
                nombre=entrada.nextLine();

                System.out.println("Ingrese el tipo de trabajador:");
                System.out.println("1 = Obrero");
                System.out.println("2 = Administrativo");
                System.out.println("3 = Ejecutivo");
                tipo=entrada.nextInt();

                System.out.println("Ingrese el numero de hijos:");
                hijos=entrada.nextInt();

                System.out.println("Ingrese los dias de asistencia:");
                diasAsistencia=entrada.nextInt();

                if(tipo==1){
                    sueldoBasico=100000;
                }else if(tipo==2){
                    sueldoBasico=165500;
                }else{
                    sueldoBasico=250000;
                }

                if(hijos>5){
                    hijos=5;
                }

                aporteHijos=sueldoBasico*0.10*hijos;

                if(diasAsistencia>28.5){
                    aporteAsistencia=sueldoBasico*0.05;
                }else{
                    aporteAsistencia=0;
                }

                cajaAhorros=sueldoBasico*0.10;
                seguroSocial=sueldoBasico*0.02;

                sueldoNeto=sueldoBasico+aporteHijos+aporteAsistencia -cajaAhorros-seguroSocial;

                System.out.println("REGISTRO DEL TRABAJADOR");
                System.out.println("Nombre: " + nombre);
                System.out.println("Cedula: " + cedula);
                System.out.println("Sueldo basico: $" + sueldoBasico);
                System.out.println("Aporte a Caja de Ahorros: $" + cajaAhorros);
                System.out.println("Seguro Social: $" + seguroSocial);
                System.out.println("Sueldo neto: $" + sueldoNeto);
            }

        }while(cedula!=0);
    }
}