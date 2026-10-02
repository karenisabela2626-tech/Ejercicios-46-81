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

public class Ejercicio_73 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        // Fecha de consulta
        int diaConsulta;
        int mesConsulta;
        int anioConsulta;

        System.out.println("       CONSULTA DE PAGARES");

        System.out.println("Ingrese el dia de consulta:");
        diaConsulta = entrada.nextInt();

        System.out.println("Ingrese el mes de consulta:");
        mesConsulta = entrada.nextInt();

        System.out.println("Ingrese el año de consulta:");
        anioConsulta = entrada.nextInt();

        entrada.nextLine();

        // Totales nacionales
        double totalNacional = 0;
        double sumaMaximosAgencias = 0;
        int cantidadAgencias = 0;

        String continuarEstado = "S";

        while (continuarEstado.equalsIgnoreCase("S")) {

            String codigoEstado;

            double totalEstado = 0;

            String codigoAgenciaMayor = "";
            String codigoAgenciaMenor = "";

            double mayorMontoAgencia = 0;
            double menorMontoAgencia = 0;

            boolean primeraAgencia = true;

            System.out.println("ESTADO");

            System.out.println("Ingrese el codigo del estado:");
            codigoEstado = entrada.nextLine();

            String continuarAgencia = "S";

            while (continuarAgencia.equalsIgnoreCase("S")) {

                String codigoAgencia;

                double totalAgencia = 0;
                int clientesConPagares = 0;

                String codigoClienteMayorDeuda = "";
                double mayorDeudaCliente = 0;

                System.out.println("             AGENCIA");

                System.out.println("Ingrese el codigo de la agencia:");
                codigoAgencia = entrada.nextLine();

                String continuarCliente = "S";

                while (continuarCliente.equalsIgnoreCase("S")) {

                    String codigoCliente;
                    String nombre;
                    String direccion;

                    double totalCliente = 0;
                    int cantidadPagaresPendientes = 0;

                    System.out.println("             CLIENTE");

                    System.out.println("Ingrese el codigo del cliente:");
                    codigoCliente = entrada.nextLine();

                    System.out.println("Ingrese el nombre del cliente:");
                    nombre = entrada.nextLine();

                    System.out.println("Ingrese la direccion:");
                    direccion = entrada.nextLine();

                    System.out.println("\nEl cliente debe tener mas de un pagaré.");

                    int cantidadPagares;

                    System.out.println("Ingrese la cantidad de pagares:");
                    cantidadPagares = entrada.nextInt();

                    entrada.nextLine();

                    int pagaré = 1;

                    while (pagaré <= cantidadPagares) {

                        int numeroPagare;
                        int diaVencimiento;
                        int mesVencimiento;
                        int anioVencimiento;
                        double montoPagare;

                        System.out.println("\nPAGARE " + pagaré);

                        System.out.println("Ingrese el numero del pagare:");
                        numeroPagare = entrada.nextInt();

                        System.out.println("Ingrese el dia de vencimiento:");
                        diaVencimiento = entrada.nextInt();

                        System.out.println("Ingrese el mes de vencimiento:");
                        mesVencimiento = entrada.nextInt();

                        System.out.println("Ingrese el año de vencimiento:");
                        anioVencimiento = entrada.nextInt();

                        System.out.println("Ingrese el monto del pagare:");
                        montoPagare = entrada.nextDouble();

                        // Comparar fecha del pagaré con la fecha de consulta
                        boolean pendiente = false;

                        if (anioVencimiento > anioConsulta) {

                            pendiente = true;

                        } else if (anioVencimiento == anioConsulta && mesVencimiento > mesConsulta) {

                            pendiente = true;

                        } else if (anioVencimiento == anioConsulta && mesVencimiento == mesConsulta && diaVencimiento >= diaConsulta) {

                            pendiente = true;
                        }

                        // Si está pendiente, acumularlo
                        if (pendiente) {

                            cantidadPagaresPendientes++;
                            totalCliente = totalCliente + montoPagare;

                            System.out.println("--- PAGARE PENDIENTE ---");
                            System.out.println("Numero: " + numeroPagare);
                            System.out.println("Fecha de vencimiento: "
                                    + diaVencimiento + "/"
                                    + mesVencimiento + "/"
                                    + anioVencimiento);
                            System.out.println("Monto: Bs. " + montoPagare);
                        }

                        pagaré++;
                    }

                    // Imprimir recibo solamente si tiene pagares pendientes
                    if (cantidadPagaresPendientes > 0) {

                        System.out.println("              RECIBO");
                        System.out.println("Codigo cliente: " + codigoCliente);
                        System.out.println("Nombre: " + nombre);
                        System.out.println("Direccion: " + direccion);
                        System.out.println("Codigo estado: " + codigoEstado);
                        System.out.println("Codigo agencia: " + codigoAgencia);
                        System.out.println("Cantidad de pagares pendientes: " + cantidadPagaresPendientes);
                        System.out.println("Monto total pendiente: Bs. " + totalCliente);

                        // Acumular datos de agencia
                        clientesConPagares++;
                        totalAgencia = totalAgencia + totalCliente;

                        // Buscar cliente con mayor deuda
                        if (totalCliente > mayorDeudaCliente) {

                            mayorDeudaCliente = totalCliente;
                            codigoClienteMayorDeuda = codigoCliente;
                        }
                    }

                    System.out.println("\n¿Desea registrar otro cliente? (S/N)");
                    continuarCliente = entrada.nextLine();
                }

                // Mostrar datos de la agencia
                System.out.println("          RESUMEN DE AGENCIA");
                System.out.println("Codigo de agencia: " + codigoAgencia);
                System.out.println("Codigo de estado: " + codigoEstado);
                System.out.println("Clientes con pagares pendientes: " + clientesConPagares);
                System.out.println("Monto total adeudado: Bs. " + totalAgencia);
                System.out.println("Cliente con mayor deuda: " + codigoClienteMayorDeuda);

                // Acumular total del estado
                totalEstado = totalEstado + totalAgencia;

                // Buscar agencia mayor y menor
                if (primeraAgencia) {

                    mayorMontoAgencia = totalAgencia;
                    menorMontoAgencia = totalAgencia;

                    codigoAgenciaMayor = codigoAgencia;
                    codigoAgenciaMenor = codigoAgencia;

                    primeraAgencia = false;

                } else {

                    if (totalAgencia > mayorMontoAgencia) {

                        mayorMontoAgencia = totalAgencia;
                        codigoAgenciaMayor = codigoAgencia;
                    }

                    if (totalAgencia < menorMontoAgencia) {

                        menorMontoAgencia = totalAgencia;
                        codigoAgenciaMenor = codigoAgencia;
                    }
                }

                // Datos nacionales
                totalNacional = totalNacional + totalAgencia;

                sumaMaximosAgencias =
                        sumaMaximosAgencias + mayorMontoAgencia;

                cantidadAgencias++;

                System.out.println("¿Desea registrar otra agencia? (S/N)");
                continuarAgencia = entrada.nextLine();
            }

            // Mostrar datos del estado
            System.out.println("RESUMEN DEL ESTADO");

            System.out.println("Codigo de estado: " + codigoEstado);
            System.out.println("Monto total adeudado: Bs. " + totalEstado);
            System.out.println("Agencia con mayor monto: " + codigoAgenciaMayor);
            System.out.println("Agencia con menor monto: " + codigoAgenciaMenor);

            System.out.println("¿Desea registrar otro estado? (S/N)");
            continuarEstado = entrada.nextLine();
        }

        // Promedio nacional de los máximos de las agencias
        double promedioMaximos = 0;

        if (cantidadAgencias > 0) {

            promedioMaximos =
                    sumaMaximosAgencias / cantidadAgencias;
        }

        // Resultado nacional
        System.out.println("RESULTADO A NIVEL NACIONAL");
        System.out.println("Monto total adeudado nacional: Bs. " + totalNacional);
        System.out.println("Promedio de los montos maximos " + "adeudados por las agencias: Bs. " + promedioMaximos);
    }
}