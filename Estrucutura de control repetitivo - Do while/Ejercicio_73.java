/*Un banco está interesado en diseñar un software que le permita calcular y generar ciertos listados
sobre las deudas de sus clientes a créditos. El algoritmo debe procesar para cada estado y sus
agencias los clientes con pagarés pendientes a una fecha (dd/mm/aaaa) dad y generar los recibos
correspondientes para ser enviados a los clientes. Cada estado, agencia y cliente es identificado por
un código. Los pagarés tienen una fecha de vencimiento (dd/mm/aaaa), un monto a pagar y un
número que lo identifica; un cliente debe tener más que un pagaré.
Se quiere un algoritmo o programa que permita:
• Imprimir un recibo para cada cliente cuyo encabezado es su código, nombre, dirección,
código de estado y código de agencia. El detalle del recibo contendrá un número del pagaré,
la fecha de vencimiento y el monto del pagaré. Al final del recibo debe colocar la cantidad
de pagares pendientes y el monto total pendiente.
• Imprimir por agencia su código, estado, la cantidad de clientes con pagares pendientes,
monto total adeudado y el código de cliente con mayor deuda.
• Imprimir por estado su código, el monto total adeudado en el estado y el código de agencia
con menor y mayor monto adeudado.
• Calcular e imprimir el monto promedio adeudado en razón de los montos máximos
adeudados por las agencias a nivel nacional.

NOTA: Los cálculos se deben realizar en función de una fecha dada. No se podrán utilizar vectores
ni matrices.*/

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Ejercicio_73 {
    public static void main(String[] arg){

        Scanner entrada = new Scanner(System.in);

        DateTimeFormatter formato =
                DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String fechaCorteTexto;
        LocalDate fechaCorte;

        int codigoEstado;
        int codigoAgencia;
        int codigoCliente;
        int numeroPagare;

        String estado;
        String nombre;
        String direccion;

        String fechaVencimientoTexto;
        LocalDate fechaVencimiento;

        double montoPagare;
        double montoCliente;
        double montoAgencia;
        double montoEstado;

        double mayorDeudaCliente=0;
        double menorDeudaAgencia=0;
        double mayorDeudaAgencia=0;

        double sumaMaximosAgencias=0;
        double montoTotalNacional=0;

        int cantidadPagares;
        int cantidadClientesAgencia;

        int codigoMayorDeudaCliente=0;
        int codigoMenorAgencia=0;
        int codigoMayorAgencia=0;

        int cantidadAgencias=0;

        System.out.println("Ingrese la fecha de corte (dd/mm/aaaa):");
        fechaCorteTexto=entrada.next();
        fechaCorte=LocalDate.parse(fechaCorteTexto, formato);

        do{

            System.out.println("Ingrese el codigo del estado (0 para terminar):");
            codigoEstado=entrada.nextInt();

            if(codigoEstado!=0){

                entrada.nextLine();

                System.out.println("Ingrese el nombre del estado:");
                estado=entrada.nextLine();

                montoEstado=0;

                boolean primeraAgencia=true;

                do{

                    System.out.println("Ingrese el codigo de la agencia (0 para terminar el estado):");
                    codigoAgencia=entrada.nextInt();

                    if(codigoAgencia!=0){

                        montoAgencia=0;
                        cantidadClientesAgencia=0;

                        boolean primerCliente=true;

                        do{

                            System.out.println("Ingrese el codigo del cliente (0 para terminar la agencia):");
                            codigoCliente=entrada.nextInt();

                            if(codigoCliente!=0){

                                entrada.nextLine();

                                System.out.println("Ingrese el nombre del cliente:");
                                nombre=entrada.nextLine();

                                System.out.println("Ingrese la direccion:");
                                direccion=entrada.nextLine();

                                montoCliente=0;
                                cantidadPagares=0;

                                System.out.println("RECIBO DEL CLIENTE");
                                System.out.println("Codigo: " + codigoCliente);
                                System.out.println("Nombre: " + nombre);
                                System.out.println("Direccion: " + direccion);
                                System.out.println("Codigo de estado: " + codigoEstado);
                                System.out.println("Codigo de agencia: " + codigoAgencia);

                                do{

                                    System.out.println("Ingrese el numero del pagare (0 para terminar):");
                                    numeroPagare=entrada.nextInt();

                                    if(numeroPagare!=0){

                                        System.out.println("Ingrese la fecha de vencimiento (dd/mm/aaaa):");
                                        fechaVencimientoTexto=entrada.next();

                                        fechaVencimiento=LocalDate.parse(
                                                fechaVencimientoTexto,
                                                formato
                                        );

                                        System.out.println("Ingrese el monto del pagare:");
                                        montoPagare=entrada.nextDouble();

                                        if(!fechaVencimiento.isAfter(fechaCorte)){

                                            System.out.println("Pagare: " + numeroPagare);
                                            System.out.println("Fecha de vencimiento: "
                                                    + fechaVencimientoTexto);
                                            System.out.println("Monto: $" + montoPagare);

                                            montoCliente=montoCliente+montoPagare;
                                            cantidadPagares++;
                                        }
                                    }

                                }while(numeroPagare!=0);

                                if(cantidadPagares>0){

                                    System.out.println("Cantidad de pagares pendientes: "
                                            + cantidadPagares);

                                    System.out.println("Monto total pendiente: $"
                                            + montoCliente);

                                    cantidadClientesAgencia++;

                                    montoAgencia=montoAgencia+montoCliente;

                                    if(primerCliente){

                                        mayorDeudaCliente=montoCliente;
                                        codigoMayorDeudaCliente=codigoCliente;

                                        primerCliente=false;

                                    }else{

                                        if(montoCliente>mayorDeudaCliente){

                                            mayorDeudaCliente=montoCliente;
                                            codigoMayorDeudaCliente=codigoCliente;
                                        }
                                    }
                                }
                            }

                        }while(codigoCliente!=0);

                        System.out.println("RESULTADOS DE LA AGENCIA");
                        System.out.println("Codigo de agencia: " + codigoAgencia);
                        System.out.println("Estado: " + estado);
                        System.out.println("Cantidad de clientes con pagares pendientes: "
                                + cantidadClientesAgencia);
                        System.out.println("Monto total adeudado: $" + montoAgencia);

                        if(cantidadClientesAgencia>0){

                            System.out.println("Cliente con mayor deuda: "
                                    + codigoMayorDeudaCliente);

                            if(primeraAgencia){

                                menorDeudaAgencia=montoAgencia;
                                mayorDeudaAgencia=montoAgencia;

                                codigoMenorAgencia=codigoAgencia;
                                codigoMayorAgencia=codigoAgencia;

                                primeraAgencia=false;

                            }else{

                                if(montoAgencia<menorDeudaAgencia){

                                    menorDeudaAgencia=montoAgencia;
                                    codigoMenorAgencia=codigoAgencia;
                                }

                                if(montoAgencia>mayorDeudaAgencia){

                                    mayorDeudaAgencia=montoAgencia;
                                    codigoMayorAgencia=codigoAgencia;
                                }
                            }

                            montoEstado=montoEstado+montoAgencia;

                            sumaMaximosAgencias=
                                    sumaMaximosAgencias+montoAgencia;

                            cantidadAgencias++;
                        }

                    }

                }while(codigoAgencia!=0);

                System.out.println("RESULTADOS DEL ESTADO");
                System.out.println("Codigo del estado: " + codigoEstado);
                System.out.println("Estado: " + estado);
                System.out.println("Monto total adeudado: $" + montoEstado);

                if(!primeraAgencia){

                    System.out.println("Agencia con menor monto adeudado: " + codigoMenorAgencia);

                    System.out.println("Agencia con mayor monto adeudado: " + codigoMayorAgencia);
                }

                montoTotalNacional=
                        montoTotalNacional+montoEstado;
            }

        }while(codigoEstado!=0);

        System.out.println("RESULTADOS NACIONALES");
        System.out.println("Monto total adeudado en el pais: $" + montoTotalNacional);

        if(cantidadAgencias>0){

            System.out.println("Monto promedio adeudado por las agencias: $" + sumaMaximosAgencias/cantidadAgencias);
        }
    }
}
