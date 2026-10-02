/*100 personas presentaron una prueba constituida por 3 preguntas. Se requiere desarrollar un
algoritmo o programa que permita determinar la cantidad de personas que respondieron:
a. correctamente las tres preguntas.
b. Correctamente solamente la primera y la segunda pregunta.
c. Correctamente solamente la primera y la tercera pregunta.
d. Correctamente solamente la segunda y la tercera pregunta.
e. Correctamente la primera pregunta por lo menos.
f. Correctamente la segunda pregunta por lo menos.
g. Correctamente la tercera pregunta por lo menos.
h. Además, cuántos no respondieron correctamente ninguna pregunta.*/

public class Ejercicio_49 {
    public static void main(String[] arg){

        int persona=1;
        int P1, P2, P3;

        int tres=0;
        int primeraSegunda=0;
        int primeraTercera=0;
        int segundaTercera=0;
        int primera=0;
        int segunda=0;
        int tercera=0;
        int ninguna=0;

        do{
            System.out.println("Persona " + persona);

            System.out.println("¿Respondio correctamente la primera pregunta? (1=Si, 0=No)");
            P1=Integer.parseInt(System.console().readLine());

            System.out.println("¿Respondio correctamente la segunda pregunta? (1=Si, 0=No)");
            P2=Integer.parseInt(System.console().readLine());

            System.out.println("¿Respondio correctamente la tercera pregunta? (1=Si, 0=No)");
            P3=Integer.parseInt(System.console().readLine());

            if(P1==1 && P2==1 && P3==1){
                tres++;
            }

            if(P1==1 && P2==1 && P3==0){
                primeraSegunda++;
            }

            if(P1==1 && P2==0 && P3==1){
                primeraTercera++;
            }

            if(P1==0 && P2==1 && P3==1){
                segundaTercera++;
            }

            if(P1==1){
                primera++;
            }

            if(P2==1){
                segunda++;
            }

            if(P3==1){
                tercera++;
            }

            if(P1==0 && P2==0 && P3==0){
                ninguna++;
            }

            persona++;

        }while(persona<=100);

        System.out.println("RESULTADOS");
        System.out.println("a. Respondieron correctamente las tres: " + tres);
        System.out.println("b. Correctamente solamente la primera y segunda: " + primeraSegunda);
        System.out.println("c. Correctamente solamente la primera y tercera: " + primeraTercera);
        System.out.println("d. Correctamente solamente la segunda y tercera: " + segundaTercera);
        System.out.println("e. Correctamente la primera por lo menos: " + primera);
        System.out.println("f. Correctamente la segunda por lo menos: " + segunda);
        System.out.println("g. Correctamente la tercera por lo menos: " + tercera);
        System.out.println("h. No respondieron correctamente ninguna: " + ninguna);
    }
}
