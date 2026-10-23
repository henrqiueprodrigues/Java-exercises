import java.util.*;
import java.util.regex.Pattern;
 
public class Test {
 
    private static Map<String, Object> parameters = Map.of(
        "nome", "Fulano",
        "cpf", "12345678900",
        "contas", List.of("123", "456")
    );
 
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("?");

        //parameters.forEach((t, u) -> sb.append(t + "=" + u + "&"));

        //String result = sb.toString().substring(0, sb.length() - 1).replaceAll("[ \\[\\] ]", "");

        for (String key : parameters.keySet()) {
            
            sb.append(key + "=");

            Object value = parameters.get(key);
            
            if (value instanceof List<?> list) {
                for (int i = 0; i < list.size(); i++) {
                    sb.append(list.get(i));

                    if (i < list.size() - 1) {
                        sb.append(",");
                    }
                }

            } else {
                sb.append(value + "&");
            };
        };

        System.out.println(sb.toString());

        System.out.println("?nome=Fulano&cpf=12345678900&contas=123,456".equals(sb.toString()));

        Map<String, Object> finalMap = new HashMap<String, Object>();

        String initialString = "?nome=Fulano&cpf=12345678900&contas=123,456,789";
        String[] split = initialString.split("&");
        
        for (String string : split) {
            String[] secondSplit = string.split("=");
            Object mapObject = (Object) secondSplit[1];
            List<String> list = new ArrayList<>();

            if (secondSplit[1].contains(",")) {
                String[] listString = secondSplit[1].split(",");
                for (String listValues : listString) {
                    list.add(listValues);
                };

                mapObject= list;
            }

            finalMap.put(secondSplit[0], mapObject);
        }

        for (String key : finalMap.keySet()) {
            System.out.println("KEY: " + key);
            System.out.println("Object: " + finalMap.get(key));
        }
    };
}
 