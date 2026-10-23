import java.util.Map;
import java.util.HashMap;

public class MapExercices {

    public static void main (String[] args){
        Map<String, Integer> testMap= new HashMap<String, Integer>();
        StringBuilder builder= new StringBuilder("INIT");

        testMap.put("A",1);
        testMap.put("B",2);
        testMap.put("C",3);
        testMap.put("D",4);

        System.out.println("MAP: "+ testMap);

        System.out.println(builder +"\n");

        for(String letter: testMap.keySet()){
            builder.append(letter +"\n");
        }

        for(Integer number: testMap.values()){
            builder.append(number.toString() +"\n");
        }

        for(Map.Entry<String, Integer> entr: testMap.entrySet()){
            builder.append(entr.toString() +"\n");
        }
        builder.delete(0,4);
        System.out.println("RESULTADO:\n" + builder);
    }
}