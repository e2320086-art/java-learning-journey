import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        int count=0;

        for(Point p: s.getPoints()){
            count++;
        }

        return count;
    }

    public double getAverageLength(Shape s) {
        double perimeter = getPerimeter(s);
        int nPoints = getNumPoints(s);

        double average = perimeter / nPoints;

        return average;
    }

    public double getLargestSide(Shape s) {
        double largest = 0.0;
        Point prePt = s.getLastPoint();
        
        for(Point currPt: s.getPoints()){
            double currDist = prePt.distance(currPt);
            
            if(currDist > largest){
                largest = currDist;
                
            }
            prePt = currPt;
            
        }
        return largest;
    }

    public double getLargestX(Shape s) {
        double maxV = 0.0;
        
        for(Point P : s.getPoints()){
            if( P.getX() > maxV){
                maxV = P.getX();
            }        }
        return maxV;
    }

    public double getLargestPerimeterMultipleFiles() {
        DirectoryResource dr = new DirectoryResource();
        double largePerimeter = 0.0;
        for(File f: dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double perimeter = getPerimeter(s);
            
            if(perimeter > largePerimeter){
                largePerimeter = perimeter;
            }
            
        }
        return largePerimeter;
    }

    public String getFileWithLargestPerimeter() {
        DirectoryResource dr = new DirectoryResource();
        double largPerimeter = 0.0;
        File temp = null;
        
        for(File f: dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double perimeter = getPerimeter(s);
            
            if (perimeter > largPerimeter){
                largPerimeter = perimeter;
                temp = f;
            }
        }
        
        
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        int points = getNumPoints(s);
        System.out.println("Number of points:" + points);
        double avg = getAverageLength(s);
        System.out.println("Average length:" + avg);
        double largestS = getLargestSide(s);
        System.out.println("Largest side:" + largestS);
        double largestX = getLargestX(s);
        System.out.println("Largest X:" + largestX);

    }
    
    public void testPerimeterMultipleFiles() {
        double larPerim = getLargestPerimeterMultipleFiles();
        System.out.println("Larget Perimeter:" + larPerim);
    }

    public void testFileWithLargestPerimeter() {
        String lrgPerimeterfile = getFileWithLargestPerimeter();
        System.out.println("Largest perimeter file:" + lrgPerimeterfile);
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
        pr.testPerimeterMultipleFiles();
        pr.testFileWithLargestPerimeter();
    }
}
