import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        PedirTazaDeCambio pedirApi = new PedirTazaDeCambio();
        Scanner input = new Scanner(System.in);
        Conversion convertir = new Conversion();

        String monedaInicial = "";
        String monedaACambiar = "";
        try {
            while (true) {
                System.out.println("""
                        *******************************************
                        Bienvenido al conversor de monedas
                        *******************************************
                        seleccione la opcion deseada:
                        1) Dolar estados unidos ==> Peso colombiano
                        2) Peso colombiano ==> Dolar estados unidos
                        3) Dolar estados unidos ==> Peso chileno
                        4) Peso chileno ==> Dolar estados unidos
                        5) Dolar estados unidos ==> Peso argentino
                        6) Peso argentino ==> dolar estados unidos
                        7) dolar estados unidos ==> Real Brazileño
                        8) Real Brazileño ==> Dolar estados unidos
                        0) Salir
                        *******************************************
                        Digite su opcion a continuacion:
                        *******************************************""");

                int opcion = Integer.parseInt(input.nextLine());

                switch (opcion) {
                    case 1:
                        monedaInicial = "USD";
                        monedaACambiar = "COP";
                        break;
                    case 2:
                        monedaInicial = "COP";
                        monedaACambiar = "USD";
                        break;
                    case 3:
                        monedaInicial = "USD";
                        monedaACambiar = "CLP";
                        break;
                    case 4:
                        monedaInicial = "CLP";
                        monedaACambiar = "USD";
                        break;
                    case 5:
                        monedaInicial = "USD";
                        monedaACambiar = "ARS";
                        break;
                    case 6:
                        monedaInicial = "ARS";
                        monedaACambiar = "USD";
                        break;
                    case 7:
                        monedaInicial = "USD";
                        monedaACambiar = "BRL";
                        break;
                    case 8:
                        monedaInicial = "BRL";
                        monedaACambiar = "USD";
                        break;
                }
                if (opcion == 0) {
                    break;
                } else if (opcion < 0 || opcion > 8) {
                    System.out.println("por favor digite una opcion valida (0-8)");
                    break;
                }

                System.out.println("por favor digite el valor a convertir");

                try {
                    double valor = Double.parseDouble(input.nextLine());
                    Cambio respuesta = pedirApi.extraerTazaDeCambio(monedaInicial, monedaACambiar);
                    convertir.convertir(valor, respuesta.conversion_rate(), monedaInicial, monedaACambiar);
                }catch (NumberFormatException e){
                    System.out.println("""
                            
                            $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
                            Por favor digite de forma correcta el valor a convertir
                            $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
                            """);

                }
            }
        } catch (NumberFormatException e) {
            System.out.println("por favor digite una opcion valida (0-8)");
        }
    }
}