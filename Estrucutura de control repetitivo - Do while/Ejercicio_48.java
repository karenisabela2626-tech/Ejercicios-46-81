/*Escriba un algoritmo para producir una tabla de conversión de temperatura para convertir valores en grados Fahrenheit a su equivalente en grados Celsius, grados Kelvin y grados Rankine. Las ecuaciones de conversión son: C = 5(F-32) / 9 R = F + 459.67 K = C + 273.15 Donde F = temperatura en grados Fahrenheit C = temperatura en grados Celsius R = temperatura en grados Rankine K = temperatura en grados Kelvin Haga que el programa imprima encabezados para cada columna en la tabla. Datos muestra: de 28 a 54 oF en intervalos de 1 oF de 450 a 950 oF en intervalos de 50 oF de –50 a 250 oF en intervalos de 10 oF */

public class Ejercicio_48 {
    public static void main(String[] arg){

        double F=28, C, K, R;

        System.out.println("Fahrenheit\tCelsius\t\tKelvin\t\tRankine");

        do{
            C = 5*(F-32)/9;
            K = C+273.15;
            R = F+459.67;

            System.out.println(F + "\t\t" + C + "\t\t" + K + "\t\t" + R);

            F++;
        }while(F<=54);


        F=450;

        System.out.println("\nFahrenheit\tCelsius\t\tKelvin\t\tRankine");

        do{
            C = 5*(F-32)/9;
            K = C+273.15;
            R = F+459.67;

            System.out.println(F + "\t\t" + C + "\t\t" + K + "\t\t" + R);

            F=F+50;
        }while(F<=950);


        F=-50;

        System.out.println("\nFahrenheit\tCelsius\t\tKelvin\t\tRankine");

        do{
            C = 5*(F-32)/9;
            K = C+273.15;
            R = F+459.67;

            System.out.println(F + "\t\t" + C + "\t\t" + K + "\t\t" + R);

            F=F+10;
        }while(F<=250);
    }
}