package Util ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;

public class BuscadorCep {

    static String webService = "http://viacep.com.br/ws/";  //Endere?o viacep
    static String webremnant = "/json";                     //Tipo de retorno
    static int codigoSucesso = 200;                         //C?digo Sucesso conex?o

    public static String[] encontraCep(String cep) {

        // Montagem da URL de chamada
        String urlChamada = webService + cep + webremnant;
        String dados = "";
        String jsonEmString = "";
        String[] endereco = new String[4]; 

        try {
            // Objeto para instanciar uma URL
            URL url = new URL(urlChamada);

            // Realiza a conex?o com o site
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

            // Se a conex?o for bem sucedida, segue o processamento normalmente.
            if (conexao.getResponseCode() != codigoSucesso) {
                throw new RuntimeException("Erro de conex?o!" + conexao.getResponseMessage());
            }

            BufferedReader resposta = new BufferedReader(new InputStreamReader(conexao.getInputStream()));

            // Transformar o arquivo JSON em uma string
            while ((dados = resposta.readLine()) != null) {
                jsonEmString += dados;
            }

            // Transformar o JSON em um objeto JSONObject
            JSONObject obj = new JSONObject(jsonEmString);

            endereco[0] = obj.optString("logradouro", "");  // Rua
            endereco[1] = obj.optString("bairro", "");      // Bairro
            endereco[2] = obj.optString("localidade", "");  // Cidade
            endereco[3] = obj.optString("uf", "");          // Estado

        } catch (Exception e) {
            e.printStackTrace();
        }

        return endereco; 
    }

}