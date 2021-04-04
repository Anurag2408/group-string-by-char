import org.locationtech.jts.io.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GroupNamesByChar {
    static final int MAX_CHAR = 26;
    static String getKey(List<String> strList)
    {
        String key = "";
        for(String str: strList) {
            str= str.toLowerCase();
            boolean[] visited = new boolean[MAX_CHAR];
            Arrays.fill(visited, false);

            // store all unique characters of current
            // word in key
            for (int j = 0; j < str.length(); j++)
                visited[str.charAt(j) - 'a'] = true;

            for (int j = 0; j < MAX_CHAR; j++)
                if (visited[j])
                    key = key + (char) ('a' + j);
        }
      return key;
    }

    private static  void  findIndex(List<String> names){
        Map<Character,Set<String>> resultMap= new HashMap<>();
        String keys =getKey(names);
        System.out.println(keys);
        for (String name: names){
            char[] charArr= keys.toCharArray();
            for (final char c : charArr) {
                if (name.indexOf(c)!=-1) {
                    resultMap.computeIfAbsent(c, HashSet::new).add(name);
                }
            }
        }
        resultMap.forEach((key, value) -> System.out.println(key + ":" + value));
    }

    public static void main(String[] args) throws ParseException {
        List<String> list= new ArrayList<String>();
        //test data
        list.add("anurag");
        list.add("rahul");
        list.add("Saurabh");
        findIndex(list);

    }

}
