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

public class Ejercicio_65 {

    public static void main(String[] args) {

        String continuar = "S";

        while (continuar.equalsIgnoreCase("S")) {

            String nombre;
            String cedula;
            int tipo;
            int hijos;
            int diasAsistencia;

            double sueldoBasico = 0;
            double aporteHijos = 0;
            double aporteAsistencia = 0;
            double cajaAhorros;
            double seguroSocial;
            double sueldoNeto;

            System.out.println("Ingrese el nombre del trabajador:");
            nombre = System.console().readLine();

            System.out.println("Ingrese la cedula:");
            cedula = System.console().readLine();

            System.out.println("Seleccione el tipo de trabajador:");
            System.out.println("1. Obrero");
            System.out.println("2. Administrativo");
            System.out.println("3. Ejecutivo");
            tipo = Integer.parseInt(System.console().readLine());

            if (tipo == 1) {
                sueldoBasico = 100000;
            } else if (tipo == 2) {
                sueldoBasico = 165500;
            } else if (tipo == 3) {
                sueldoBasico = 250000;
            } else {
                System.out.println("Tipo de trabajador no valido.");
                continue;
            }

            System.out.println("Ingrese la cantidad de hijos:");
            hijos = Integer.parseInt(System.console().readLine());

            // Maximo 5 hijos
            if (hijos > 5) {
                hijos = 5;
            }

            aporteHijos = hijos * (sueldoBasico * 0.10);

            System.out.println("Ingrese los dias de asistencia del mes:");
            diasAsistencia = Integer.parseInt(System.console().readLine());

            // 95% de 30 dias = 28.5 dias
            if (diasAsistencia > 28.5) {
                aporteAsistencia = sueldoBasico * 0.05;
            }

            // Deducciones
            cajaAhorros = sueldoBasico * 0.10;
            seguroSocial = sueldoBasico * 0.02;

            // Calculo del sueldo neto
            sueldoNeto = sueldoBasico + aporteHijos + aporteAsistencia
                    - cajaAhorros - seguroSocial;

            System.out.println("REGISTRO DEL TRABAJADOR");
            System.out.println("Nombre: " + nombre);
            System.out.println("Cedula: " + cedula);
            System.out.println("Sueldo basico: " + sueldoBasico);
            System.out.println("Aporte Caja de Ahorros: " + cajaAhorros);
            System.out.println("Seguro Social: " + seguroSocial);
            System.out.println("Sueldo neto: " + sueldoNeto);

            System.out.println("¿Desea ingresar otro trabajador? (S/N)");
            continuar = System.console().readLine();
        }
    }
}
