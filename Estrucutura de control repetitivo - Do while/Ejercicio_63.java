/*En una encuesta de alumnos se tomaron los siguientes datos: edad, sexo, estado civil, y especialidad
que cursa. La empresa encuestadora, desea generar las siguientes estadísticas:

1
2

a. Promedio de edad de las mujeres.
b. Promedio de edad de los hombres.
c. Cantidad de hombres y de mujeres encuestados.
d. Porcentaje de personas para cada uno de los tipos de estado civil, respecto al total.
e. Cantidad de alumnos por especialidad y porcentaje que representan.
f. Porcentaje de mujeres adultas, tomando en cuenta que los adultos son los que tienen más
de 21 años.
g. Porcentaje de hombres jóvenes, tomando en cuenta que estos son los que tienen menos
de 21 años, pero más de 17.
h. Cantidad de hombres solteros y cantidad de mujeres solteras.*/

import java.util.Scanner;

public class Ejercicio_63 {
    public static void main(String[] arg){

        Scanner entrada = new Scanner(System.in);

        int cantidad, alumno=1;
        int edad, estado, especialidad;
        String sexo;

        int hombres=0, mujeres=0;
        int sumaEdadHombres=0, sumaEdadMujeres=0;

        int solteros=0, casados=0, divorciados=0, viudos=0;

        int sistemas=0, contabilidad=0, administracion=0;

        int mujeresAdultas=0;
        int hombresJovenes=0;

        int hombresSolteros=0;
        int mujeresSolteras=0;

        System.out.println("Ingrese la cantidad de alumnos encuestados:");
        cantidad=entrada.nextInt();

        do{
            System.out.println("Alumno " + alumno);

            System.out.println("Ingrese la edad:");
            edad=entrada.nextInt();

            System.out.println("Ingrese el sexo (M= Mujer, H= Hombre):");
            sexo=entrada.next();

            System.out.println("Ingrese el estado civil:");
            System.out.println("1=Soltero");
            System.out.println("2=Casado");
            System.out.println("3=Divorciado");
            System.out.println("4=Viudo");
            estado=entrada.nextInt();

            System.out.println("Ingrese la especialidad:");
            System.out.println("1=Sistemas");
            System.out.println("2=Contabilidad");
            System.out.println("3=Administracion");
            especialidad=entrada.nextInt();

            if(sexo.equalsIgnoreCase("M")){
                mujeres++;
                sumaEdadMujeres=sumaEdadMujeres+edad;

                if(edad>21){
                    mujeresAdultas++;
                }

                if(estado==1){
                    mujeresSolteras++;
                }
            }

            if(sexo.equalsIgnoreCase("H")){
                hombres++;
                sumaEdadHombres=sumaEdadHombres+edad;

                if(edad>17 && edad<21){
                    hombresJovenes++;
                }

                if(estado==1){
                    hombresSolteros++;
                }
            }

            if(estado==1){
                solteros++;
            }

            if(estado==2){
                casados++;
            }

            if(estado==3){
                divorciados++;
            }

            if(estado==4){
                viudos++;
            }

            if(especialidad==1){
                sistemas++;
            }

            if(especialidad==2){
                contabilidad++;
            }

            if(especialidad==3){
                administracion++;
            }

            alumno++;

        }while(alumno<=cantidad);

        System.out.println("RESULTADOS");

        if(mujeres>0){
            System.out.println("a. Promedio de edad de las mujeres: " + (double)sumaEdadMujeres/mujeres);
        }

        if(hombres>0){
            System.out.println("b. Promedio de edad de los hombres: " + (double)sumaEdadHombres/hombres);
        }

        System.out.println("c. Cantidad de hombres: " + hombres);
        System.out.println("   Cantidad de mujeres: " + mujeres);

        System.out.println("d. Porcentaje de solteros: " + (double)solteros/cantidad*100 + "%");

        System.out.println("   Porcentaje de casados: " + (double)casados/cantidad*100 + "%");

        System.out.println("   Porcentaje de divorciados: " + (double)divorciados/cantidad*100 + "%");

        System.out.println("   Porcentaje de viudos: ");

        System.out.println("e. Sistemas: " + sistemas + " alumnos, " + (double)sistemas/cantidad*100 + "%");

        System.out.println("   Contabilidad: " + contabilidad + " alumnos, " + (double)contabilidad/cantidad*100 + "%");

        System.out.println("   Administracion: " + administracion + " alumnos, " + (double)administracion/cantidad*100 + "%");

        if(mujeres>0){
            System.out.println("f. Porcentaje de mujeres adultas: " + (double)mujeresAdultas/mujeres*100 + "%");
        }

        if(hombres>0){
            System.out.println("g. Porcentaje de hombres jovenes: " + (double)hombresJovenes/hombres*100 + "%");
        }

        System.out.println("h. Hombres solteros: " + hombresSolteros);
        System.out.println("   Mujeres solteras: " + mujeresSolteras);
    }
}
