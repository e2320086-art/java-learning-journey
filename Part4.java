
/**
 * Write a description of Part4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part4 {
    public String twoOccurance(String word){
        String result = ""; 
        int middleWord = word.indexOf("youtube.com");
        if(middleWord == -1){
            return "";
        }
        int startIndex = word.lastIndexOf("\"", middleWord);
        int stopIndex = word.indexOf("\"", middleWord+10);
        result = word.substring(startIndex+1, stopIndex);
        return result;
    }
    public void testCase(){
        String word = "<a href=\"https://www.youtube.com/watch?v=123\">Watch video</a>";
        
        System.out.println(twoOccurance(word));
    }
}
