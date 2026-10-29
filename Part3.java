
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
    public boolean twoOccurrences(String stringa, String stringb){
        int firstIndex = stringb.indexOf(stringa);
        if(firstIndex == -1){
            return false;
        }
        
        int secondIndex = stringb.indexOf(stringa, firstIndex+stringa.length());
        if (secondIndex != -1) {
            return true;
        }

        return false;
        }
    
    public void testing(){
        System.out.println(twoOccurrences("by", "A story by Abby Long"));
        System.out.println(twoOccurrences("a", "banana"));
        System.out.println(twoOccurrences("atg", "ctgtatgta"));
        
    }
}
