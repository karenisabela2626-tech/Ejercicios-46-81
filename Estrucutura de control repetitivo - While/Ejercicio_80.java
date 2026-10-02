/*La Oficina Central de Estadística e Informática (OCEI) desea conocer cierta información sobre la
situación actual del país en cuanto a los niveles actuales de desempleo, analfabetismo y del potencial
de profesionales existentes en Venezuela. Los Estados son identificados por un código entero
positivo de dos (02) dígitos significativos. Las ciudades mediante un código de cuatro (04) dígitos
significativos, de los cuales los dos últimos dígitos corresponden al Estado al cual pertenecen. Los
municipios se identifican con un código de cuatro (06) dígitos significativos, de los cuales los primeros
dígitos corresponden al código de Estado y los dos siguientes dígitos a los dos primeros dígitos del
código de la ciudad en la cual están ubicados. Los datos fueron tomados de personas mayores de 18
años y los mismos son los siguientes: edad; nivel de educación (N: ninguna, B: básica, S: secundaria,
P: profesional); situación actual (D: desempleado, E: empleado). Se requiere que desarrolle un
programa que cumpla con lo siguiente:
• Determinar e imprimir por municipio el código y la cantidad de personas con las siguientes
características: desempleado, sin ningún nivel de educación y mayores de 25 años.
• Calcular e imprimir el código de las ciudades cuyas personas establecidas en la parte anterior sean
más del 50%.
• Calcular e imprimir el código del Estado con mayor porcentaje de profesionales desempleados.*/

import java.util.Scanner;

public class Ejercicio_80 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        int cantidadEstados;
        int cantidadCiudades;
        int cantidadMunicipios;
        int cantidadPersonas;

        int estado = 1;
        int ciudad;
        int municipio;
        int persona;

        int codigoEstado;
        int codigoCiudad;
        int codigoMunicipio;

        int edad;
        String educacion;
        String situacion;

        int desempleadosSinEducacion;
        int totalPersonasMunicipio;

        int totalPersonasCiudad;
        int totalPersonasEspecialesCiudad;

        int totalProfesionalesEstado;
        int totalProfesionalesDesempleadosEstado;

        double porcentajeEspeciales;
        double porcentajeProfesionalesDesempleados;

        double mayorPorcentajeProfesionales = 0;
        int estadoMayorProfesionales = 0;

        System.out.println("INFORMACION ESTADISTICA");

        System.out.println("Ingrese la cantidad de Estados:");
        cantidadEstados = entrada.nextInt();

        System.out.println("Ingrese la cantidad de ciudades por Estado:");
        cantidadCiudades = entrada.nextInt();

        System.out.println("Ingrese la cantidad de municipios por ciudad:");
        cantidadMunicipios = entrada.nextInt();

        System.out.println("Ingrese la cantidad de personas por municipio:");
        cantidadPersonas = entrada.nextInt();

        while (estado <= cantidadEstados) {

            ciudad = 1;

            totalProfesionalesEstado = 0;
            totalProfesionalesDesempleadosEstado = 0;

            System.out.println("ESTADO " + estado);

            System.out.println("Ingrese el codigo del Estado:");
            codigoEstado = entrada.nextInt();

            while (ciudad <= cantidadCiudades) {

                municipio = 1;

                totalPersonasCiudad = 0;
                totalPersonasEspecialesCiudad = 0;

                System.out.println("CIUDAD " + ciudad);

                System.out.println("Ingrese el codigo de la ciudad:");
                codigoCiudad = entrada.nextInt();

                while (municipio <= cantidadMunicipios) {

                    persona = 1;

                    desempleadosSinEducacion = 0;
                    totalPersonasMunicipio = 0;

                    System.out.println("\nMUNICIPIO " + municipio);

                    System.out.println("Ingrese el codigo del municipio:");
                    codigoMunicipio = entrada.nextInt();

                    while (persona <= cantidadPersonas) {

                        System.out.println("\nPERSONA " + persona);

                        System.out.println("Ingrese la edad:");
                        edad = entrada.nextInt();

                        System.out.println("Ingrese el nivel de educacion:");
                        System.out.println("N: Ninguna");
                        System.out.println("B: Basica");
                        System.out.println("S: Secundaria");
                        System.out.println("P: Profesional");
                        educacion = entrada.next();

                        System.out.println("Ingrese la situacion actual:");
                        System.out.println("D: Desempleado");
                        System.out.println("E: Empleado");
                        situacion = entrada.next();

                        totalPersonasMunicipio++;
                        totalPersonasCiudad++;

                        // Personas desempleadas, sin educacion y mayores de 25 años
                        if (edad > 25 && educacion.equalsIgnoreCase("N") && situacion.equalsIgnoreCase("D")) {
                            desempleadosSinEducacion++;
                            totalPersonasEspecialesCiudad++;
                        }

                        // Contar profesionales
                        if (educacion.equalsIgnoreCase("P")) {

                            totalProfesionalesEstado++;

                            // Contar profesionales desempleados
                            if (situacion.equalsIgnoreCase("D")) {

                                totalProfesionalesDesempleadosEstado++;
                            }
                        }

                        persona++;
                    }

                    System.out.println("RESULTADO DEL MUNICIPIO");

                    System.out.println("Codigo del municipio: " + codigoMunicipio);

                    System.out.println("Cantidad de desempleados, sin educacion " + "y mayores de 25 años: " + desempleadosSinEducacion);

                    municipio++;
                }

                // Calcular porcentaje de personas especiales de la ciudad
                porcentajeEspeciales = 0;

                if (totalPersonasCiudad > 0) {

                    porcentajeEspeciales = (totalPersonasEspecialesCiudad * 100.0) / totalPersonasCiudad;
                }

                // Verificar si supera el 50%
                if (porcentajeEspeciales > 50) {

                    System.out.println("\nCIUDAD CON MAS DEL 50%");

                    System.out.println("Codigo de la ciudad: " + codigoCiudad);

                    System.out.println("Porcentaje: " + porcentajeEspeciales + "%");
                }

                ciudad++;
            }

            // Calcular porcentaje de profesionales desempleados
            porcentajeProfesionalesDesempleados = 0;

            if (totalProfesionalesEstado > 0) {

                porcentajeProfesionalesDesempleados = (totalProfesionalesDesempleadosEstado * 100.0) / totalProfesionalesEstado;
            }

            // Buscar Estado con mayor porcentaje
            if (estado == 1 || porcentajeProfesionalesDesempleados > mayorPorcentajeProfesionales) {

                mayorPorcentajeProfesionales = porcentajeProfesionalesDesempleados;

                estadoMayorProfesionales = codigoEstado;
            }

            System.out.println("RESULTADO DEL ESTADO");

            System.out.println("Codigo del Estado: " + codigoEstado);

            System.out.println("Porcentaje de profesionales desempleados: " + porcentajeProfesionalesDesempleados + "%");

            estado++;
        }

        System.out.println("RESULTADO GENERAL");

        System.out.println("Estado con mayor porcentaje " + "de profesionales desempleados: " + estadoMayorProfesionales);

        System.out.println("Porcentaje: " + mayorPorcentajeProfesionales + "%");
    }
}