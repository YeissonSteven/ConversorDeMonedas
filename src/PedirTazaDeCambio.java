import javax.swing.*;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PedirTazaDeCambio {
    public String extraerTazaDeCambio(String monedaInicial, String monedaACambiar) {
        String direccion = "https://v6.exchangerate-api.com/v6/f00457fafc980a11125d03ee/pair/"+ monedaInicial + "/" +  monedaACambiar;

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(direccion)).build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return  response.body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
