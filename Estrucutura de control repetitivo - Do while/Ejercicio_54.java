/*Un investigador acaba de aplicar 64 cuestionarios de 23 preguntas cada uno; donde cada pregunta
permite escoger entre 1 y 5, a un grupo de personas que constituyen su población. Se desea que
elabore un Programa, para ayudar al Investigador a procesar toda la información recopilada, para
ello tome en cuenta lo siguiente: necesita calcular el promedio de cada instrumento o escala para lo
cual es necesaria la fórmula: PT/NT, donde PT representa el total de puntos de cada cuestionario que
resulta de sumar los valores que el encuestado, encerró entre un círculo y NT es el total de preguntas
del instrumento. Estos valores se deben acumular, para al final calcular y mostrar lo siguiente:
a. La media o promedio de todos los cuestionarios (promedio general).
b. El promedio más alto obtenido y número de instrumento a que corresponde.
c. El promedio más bajo obtenido y número de instrumento a que corresponde.
d. Porcentaje de cuestionarios que obtuvieron un promedio inferior a 3, respecto a los que tuvieron un
promedio superior a 4.
e. Porcentaje de cuestionarios que obtuvieron un promedio entre 4.5 y 5 respecto al total procesado.*/

public class Ejercicio_54 {
    public static void main(String[] arg){

        int cuestionario=1;
        int pregunta;
        int respuesta;
        int totalPuntos=0;

        double promedio;
        double sumaPromedios=0;
        double promedioMayor=0;
        double promedioMenor=5;

        int instrumentoMayor=0;
        int instrumentoMenor=0;
        int menor3=0;
        int mayor4=0;
        int entre45y5=0;

        do{
            pregunta=1;
            totalPuntos=0;

            System.out.println("Cuestionario " + cuestionario);

            do{
                System.out.println("Ingrese la respuesta de la pregunta " + pregunta + " (1 a 5):");
                respuesta=Integer.parseInt(System.console().readLine());

                totalPuntos=totalPuntos+respuesta;
                pregunta++;

            }while(pregunta<=23);

            promedio=(double)totalPuntos/23;

            System.out.println("Promedio del cuestionario: " + promedio);

            sumaPromedios=sumaPromedios+promedio;

            if(promedio>promedioMayor){
                promedioMayor=promedio;
                instrumentoMayor=cuestionario;
            }

            if(promedio<promedioMenor){
                promedioMenor=promedio;
                instrumentoMenor=cuestionario;
            }

            if(promedio<3){
                menor3++;
            }

            if(promedio>4){
                mayor4++;
            }

            if(promedio>=4.5 && promedio<=5){
                entre45y5++;
            }

            cuestionario++;

        }while(cuestionario<=64);

        System.out.println("RESULTADOS");

        System.out.println("a. Promedio general: " + sumaPromedios/64);

        System.out.println("b. Promedio mas alto: " + promedioMayor);
        System.out.println("   Instrumento: " + instrumentoMayor);

        System.out.println("c. Promedio mas bajo: " + promedioMenor);
        System.out.println("   Instrumento: " + instrumentoMenor);

        if(mayor4>0){
            System.out.println("d. Porcentaje de cuestionarios con promedio inferior a 3 respecto a los superiores a 4: " + (double)menor3/mayor4*100 + "%");
        }else{
            System.out.println("d. No hubo cuestionarios con promedio superior a 4.");
        }

        System.out.println("e. Porcentaje de cuestionarios entre 4.5 y 5: " + (double)entre45y5/64*100 + "%");
    }
}
