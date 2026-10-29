
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
    public String findSimpleGene(String dna){
        String result ="";
        int startCodon = dna.indexOf("ATG");
        if(startCodon == -1){
            return "";
        }
        int stopCodon = dna.indexOf("TAA", startCodon+3);
        if(stopCodon == -1){
            return "";
        }
        if((startCodon-stopCodon-3)%3 != 0){
            return "";
        }
        
        result = dna.substring(startCodon, stopCodon+3);
        return result;
        
    }
    
    public void testSimpleGene(){
        String dna = "ATGATGTACTAAC";
        String gene = findSimpleGene(dna);
        System.out.println("GENE is: "+ gene);
        String dna1 = "CGCGCG";
    
    }
    
}
