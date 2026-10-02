/*Una persona debe realizar un muestreo con 100 personas para determinar el promedio de peso de
los niños, jóvenes, adultos y viejos que existen en su zona habitacional. Para ello, conforme
encuentra a las personas introduce los datos a su computadora, la cual mediante un programa las
clasifica y despliega los cuatro promedios que la persona requiere. Las categorías se trabajan de
acuerdo a la siguiente tabla:

Categoria   Edad
Niños   0-12
Jovenes   13-29
Adultos   30-59
Vielos   60 en adelante*/

public class Ejercicio_52 {
    public static void main(String[] arg){

        int persona=1;
        int edad;
        double peso;

        double pesoNinos=0, pesoJovenes=0, pesoAdultos=0, pesoViejos=0;
        int ninos=0, jovenes=0, adultos=0, viejos=0;

        do{
            System.out.println("Persona " + persona);

            System.out.println("Ingrese la edad:");
            edad=Integer.parseInt(System.console().readLine());

            System.out.println("Ingrese el peso:");
            peso=Double.parseDouble(System.console().readLine());

            if(edad>=0 && edad<=12){
                pesoNinos=pesoNinos+peso;
                ninos++;
            }

            if(edad>=13 && edad<=29){
                pesoJovenes=pesoJovenes+peso;
                jovenes++;
            }

            if(edad>=30 && edad<=59){
                pesoAdultos=pesoAdultos+peso;
                adultos++;
            }

            if(edad>=60){
                pesoViejos=pesoViejos+peso;
                viejos++;
            }

            persona++;

        }while(persona<=100);

        System.out.println("PROMEDIOS DE PESO");

        if(ninos>0){
            System.out.println("Promedio de peso de los niños: " + pesoNinos/ninos);
        }

        if(jovenes>0){
            System.out.println("Promedio de peso de los jovenes: " + pesoJovenes/jovenes);
        }

        if(adultos>0){
            System.out.println("Promedio de peso de los adultos: " + pesoAdultos/adultos);
        }

        if(viejos>0){
            System.out.println("Promedio de peso de los viejos: " + pesoViejos/viejos);
        }
    }
}
