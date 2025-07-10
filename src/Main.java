//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        PedirTazaDeCambio pedirApi = new PedirTazaDeCambio();
        ManejarJson manejarJson = new ManejarJson();

        String respuesta = pedirApi.extraerTazaDeCambio("COP","USD");
        Cambio taza = manejarJson.selecionarRatioDeConversion(respuesta);
        System.out.println(taza.toString());
    }
}