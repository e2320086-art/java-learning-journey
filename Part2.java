
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    public String findSimpleGene(String dna,String startCodon, String stopCodon){
        String result ="";
        String dnaUpper =dna.toUpperCase();
        
        int startIndex = dnaUpper.indexOf(startCodon.toUpperCase());
        if(startIndex == -1){
            return "";  
        }
        int stopIndex = dnaUpper.indexOf(stopCodon.toUpperCase(), startIndex+3);
        if(stopIndex == -1){
            return "";
        }
        if((startIndex-stopIndex-3)%3 != 0){
            return "";
        }
        result = dna.substring(startIndex, stopIndex+3);
                
        return result;
        
    }
    
    
    
    public void testSimpleGene(){
        String dna = "ATGATGTACTAAC";
        String gene = findSimpleGene(dna, "ATG", "TAA");
        System.out.println("GENE is: "+ gene);
        

        String dna1 = "gatgctataat";
        System.out.println(findSimpleGene(dna1, "ATG", "TAA"));
    
    }
}
