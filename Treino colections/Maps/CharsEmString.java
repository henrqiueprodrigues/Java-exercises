import java.util.HashMap;
import java.util.Map;

public class Main2 {

    public static void main(String[] args) {
        String frase = "O rato roeu a roupa do rei de roma";
        char[] characters = frase.replaceAll("\\s","").toCharArray();
        Map<Character, Integer> mapa = new HashMap<>();

        for (Character chars : characters) {
            mapa.put(chars, characters.frequency(chars))
        }

        for (Map.Entry<Character, Integer> entry : mapa.entrySet()) {
            System.out.println("Letra: " + entry.getKey() + " Frequencia: " + entry.getValue());
        }

    }
}