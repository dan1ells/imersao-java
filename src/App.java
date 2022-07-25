import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {

        String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
        URI endereco = URI.create(url);
        HttpClient newHttpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = newHttpClient.send(request, BodyHandlers.ofString());
        String body = response.body();

        JsonParser parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);

        for (Map<String,String> filme : listaDeFilmes) {
            System.out.println("\u001b[1m Titulo: \u001b[0m" + filme.get("title"));
            System.out.println("\u001b[1m Poster: \u001b[0m" + filme.get("image"));
            System.out.println("\u001b[44m \u001b[32m \u001b[1m Avaliação: " + filme.get("imDbRating") + " \u001b[0m" );
            System.out.println();
        }
        
    }
}
