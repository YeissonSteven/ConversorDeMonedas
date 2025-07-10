import com.google.gson.Gson;

public class ManejarJson {
    public Cambio selecionarRatioDeConversion(String respuesta){
        Gson gson = new Gson();
        return gson.fromJson(respuesta,Cambio.class);

    }
}
