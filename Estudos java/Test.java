import java.util.*;
 
public class Test {
 
    private static Map<String, Object> parameters = Map.of(
        "nome", "Fulano",
        "cpf", "12345678900",
        "contas", List.of("123", "456")
    );
 
    public static void main(String[] args) {
        String queryString = "";
    
        System.out.println(parameters.toString());

        System.out.println("?nome=Fulano&cpf=12345678900&contas=123,456".equals(queryString));
    }
 
}
 