import java.util.ArrayList;
import java.util.List;

public class Swapper {
    public void swapRow(int row1, int row2, List<List<String>> s){
       List<String> temp = new ArrayList<>();
       for(String st : s.get(row1))
       {
           temp.add(st);
       }
       s.set(row1,s.get(row2));
       s.set(row2, temp);
    }
    public void swapWord(int row1, int word1, int row2, int word2, List<List<String>> s){
       String temp = s.get(row1).get(word1);
        s.get(row1).set(word1,s.get(row2).get(word2));
        s.get(row2).set(word2,temp);
    }
}
