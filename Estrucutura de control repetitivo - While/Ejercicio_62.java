/*Para cada una de las empresas del País se tienen como datos: actividad, localización y número de
trabajadores. La actividad y la localización, se codifican de la siguiente forma:

Actividad Localizacion
1=Agricola 1=norte
2=Industrial 2=sur
3=Mineria 3=este
4=Pesquera 4=oeste
5=Otra

Desarrolle un algoritmo / programa que calcule y muestre:
i. Porcentaje de empresas agrícolas del País.
ii. Porcentaje de empresas mineras del sur respecto al total de empresas que realizan
esa actividad.
iii. Promedio de trabajadores de las empresas de cada tipo de actividad. iv.
Localización con mayor número de empresas industriales.*/

import java.util.Scanner;

public class Ejercicio_62 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        int cantidadEmpresas;
        int empresa = 1;

        int actividad;
        int localizacion;
        int trabajadores;

        int totalAgricolas = 0;
        int totalMineras = 0;
        int minerasSur = 0;

        int totalIndustriales = 0;
        int totalMineria = 0;
        int totalPesqueras = 0;
        int totalOtras = 0;

        int trabajadoresAgricolas = 0;
        int trabajadoresIndustriales = 0;
        int trabajadoresMineria = 0;
        int trabajadoresPesqueras = 0;
        int trabajadoresOtras = 0;

        int norteIndustriales = 0;
        int surIndustriales = 0;
        int esteIndustriales = 0;
        int oesteIndustriales = 0;

        System.out.print("Ingrese el número de empresas: ");
        cantidadEmpresas = entrada.nextInt();

        while (empresa <= cantidadEmpresas) {

            System.out.println("Empresa " + empresa);

            System.out.print("Actividad (1=Agrícola, 2=Industrial, 3=Minería, 4=Pesquera, 5=Otra): ");
            actividad = entrada.nextInt();

            System.out.print("Localización (1=Norte, 2=Sur, 3=Este, 4=Oeste): ");
            localizacion = entrada.nextInt();

            System.out.print("Número de trabajadores: ");
            trabajadores = entrada.nextInt();

            if (actividad == 1) {
                totalAgricolas++;
                trabajadoresAgricolas += trabajadores;
            }

            if (actividad == 2) {
                totalIndustriales++;
                trabajadoresIndustriales += trabajadores;

                if (localizacion == 1) {
                    norteIndustriales++;
                }

                if (localizacion == 2) {
                    surIndustriales++;
                }

                if (localizacion == 3) {
                    esteIndustriales++;
                }

                if (localizacion == 4) {
                    oesteIndustriales++;
                }
            }

            if (actividad == 3) {
                totalMineria++;
                trabajadoresMineria += trabajadores;
                totalMineras++;

                if (localizacion == 2) {
                    minerasSur++;
                }
            }

            if (actividad == 4) {
                totalPesqueras++;
                trabajadoresPesqueras += trabajadores;
            }

            if (actividad == 5) {
                totalOtras++;
                trabajadoresOtras += trabajadores;
            }

            empresa++;
        }

        System.out.println("RESULTADOS");

        // i. Porcentaje de empresas agrícolas
        double porcentajeAgricolas =
                (double) totalAgricolas / cantidadEmpresas * 100;

        System.out.println("i. Porcentaje de empresas agrícolas: "
                + porcentajeAgricolas + "%");

        // ii. Porcentaje de empresas mineras del sur
        if (totalMineras > 0) {
            double porcentajeMinerasSur =
                    (double) minerasSur / totalMineras * 100;

            System.out.println("ii. Porcentaje de empresas mineras del sur: "
                    + porcentajeMinerasSur + "%");
        } else {
            System.out.println("ii. No existen empresas mineras.");
        }

        // iii. Promedio de trabajadores por actividad
        if (totalAgricolas > 0) {
            System.out.println("iii. Promedio agrícola: "
                    + (double) trabajadoresAgricolas / totalAgricolas);
        }

        if (totalIndustriales > 0) {
            System.out.println("    Promedio industrial: "
                    + (double) trabajadoresIndustriales / totalIndustriales);
        }

        if (totalMineria > 0) {
            System.out.println("    Promedio minería: "
                    + (double) trabajadoresMineria / totalMineria);
        }

        if (totalPesqueras > 0) {
            System.out.println("    Promedio pesquera: "
                    + (double) trabajadoresPesqueras / totalPesqueras);
        }

        if (totalOtras > 0) {
            System.out.println("    Promedio otras: "
                    + (double) trabajadoresOtras / totalOtras);
        }

        // iv. Localización con mayor número de empresas industriales
        int mayor = norteIndustriales;
        String localizacionMayor = "Norte";

        if (surIndustriales > mayor) {
            mayor = surIndustriales;
            localizacionMayor = "Sur";
        }

        if (esteIndustriales > mayor) {
            mayor = esteIndustriales;
            localizacionMayor = "Este";
        }

        if (oesteIndustriales > mayor) {
            mayor = oesteIndustriales;
            localizacionMayor = "Oeste";
        }

        System.out.println("iv. Localización con mayor número de empresas industriales: "
                + localizacionMayor);
    }
}
