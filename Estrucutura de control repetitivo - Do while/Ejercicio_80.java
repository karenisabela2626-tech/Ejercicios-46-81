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
    public static void main(String[] arg){

        Scanner entrada = new Scanner(System.in);

        int cantidadEstados;
        int cantidadCiudades= 0;
        int cantidadMunicipios= 0;
        int cantidadPersonas;

        int codigoEstado;
        int codigoCiudad;
        int codigoMunicipio;

        int edad;
        char educacion;
        char situacion;

        int desempleadosSinEducacionMayores25;

        int totalPersonasMunicipio;
        int totalPersonasCiudad;
        int personasCiudadCondicion;

        int profesionalesDesempleadosEstado;
        int profesionalesEstado;

        double porcentajeCiudad;
        double porcentajeProfesionales;

        double mayorPorcentajeProfesionales=0;
        int codigoEstadoMayor=0;

        int estado=1;

        System.out.println("Ingrese la cantidad de estados:");
        cantidadEstados=entrada.nextInt();

        do{

            System.out.println("Ingrese el codigo del estado:");
            codigoEstado=entrada.nextInt();

            profesionalesDesempleadosEstado=0;
            profesionalesEstado=0;

            int ciudad=1;

            do{

                System.out.println("Ingrese el codigo de la ciudad:");
                codigoCiudad=entrada.nextInt();

                totalPersonasCiudad=0;
                personasCiudadCondicion=0;

                int municipio=1;

                do{

                    System.out.println("Ingrese el codigo del municipio:");
                    codigoMunicipio=entrada.nextInt();

                    desempleadosSinEducacionMayores25=0;
                    totalPersonasMunicipio=0;

                    System.out.println("Ingrese la cantidad de personas del municipio:");
                    cantidadPersonas=entrada.nextInt();

                    int persona=1;

                    do{

                        System.out.println("Ingrese la edad:");
                        edad=entrada.nextInt();

                        System.out.println("Ingrese el nivel de educacion:");
                        System.out.println("N = Ninguna");
                        System.out.println("B = Basica");
                        System.out.println("S = Secundaria");
                        System.out.println("P = Profesional");

                        educacion=entrada.next().charAt(0);

                        System.out.println("Ingrese la situacion actual:");
                        System.out.println("D = Desempleado");
                        System.out.println("E = Empleado");

                        situacion=entrada.next().charAt(0);

                        totalPersonasMunicipio++;
                        totalPersonasCiudad++;

                        /*
                         * Personas desempleadas,
                         * sin educacion y mayores de 25 años.
                         */

                        if(edad>25 &&
                                educacion=='N' &&
                                situacion=='D'){

                            desempleadosSinEducacionMayores25++;

                            personasCiudadCondicion++;
                        }

                        /*
                         * Profesionales desempleados
                         */

                        if(educacion=='P'){

                            profesionalesEstado++;

                            if(situacion=='D'){

                                profesionalesDesempleadosEstado++;
                            }
                        }

                        persona++;

                    }while(persona<=cantidadPersonas);

                    System.out.println("RESULTADOS DEL MUNICIPIO");
                    System.out.println("Codigo del municipio: " + codigoMunicipio);

                    System.out.println("Cantidad de personas desempleadas, " + "sin educacion y mayores de 25 años: " + desempleadosSinEducacionMayores25);

                    municipio++;

                }while(municipio<=cantidadMunicipios);

                /*
                 * Porcentaje de la ciudad
                 */

                if(totalPersonasCiudad>0){

                    porcentajeCiudad= (double)personasCiudadCondicion /totalPersonasCiudad*100;

                    if(porcentajeCiudad>50){

                        System.out.println("La ciudad supera el 50%");
                        System.out.println("Codigo de ciudad: " + codigoCiudad);
                        System.out.println("Porcentaje: " + porcentajeCiudad + "%");
                    }
                }

                ciudad++;

            }while(ciudad<=cantidadCiudades);

            /*
             * Porcentaje de profesionales desempleados
             */

            if(profesionalesEstado>0){

                porcentajeProfesionales= (double)profesionalesDesempleadosEstado /profesionalesEstado*100;

                System.out.println("Porcentaje de profesionales " + "desempleados del estado: " + porcentajeProfesionales + "%");

                if(estado==1){

                    mayorPorcentajeProfesionales= porcentajeProfesionales;

                    codigoEstadoMayor= codigoEstado;

                }else{

                    if(porcentajeProfesionales> mayorPorcentajeProfesionales){

                        mayorPorcentajeProfesionales= porcentajeProfesionales;

                        codigoEstadoMayor= codigoEstado;
                    }
                }
            }

            estado++;

        }while(estado<=cantidadEstados);

        System.out.println("RESULTADOS GENERALES");

        System.out.println("Estado con mayor porcentaje de " + "profesionales desempleados: " + codigoEstadoMayor);

        System.out.println("Porcentaje: " + mayorPorcentajeProfesionales + "%");
    }
}
