/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyramidsdao;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 *
 * @author Esraa
 */
public class PyramidsDao {
     public PyramidsDao()  {
    }
    public List<PyramidsClass> readPyramidsFromCsv (String fileName) throws IOException{
        List<PyramidsClass> pyramids = new ArrayList<>();
        ///open file & read
        FileReader csv1 = new FileReader(fileName);
        BufferedReader Buffer1 = new BufferedReader(csv1);
        String line = Buffer1.readLine() ;
        if (line != null){
            line = Buffer1.readLine();
        }
        while(line != null){
          String[] arr = line.split(",");
          PyramidsClass py=createPyramid(arr);
          pyramids.add(py);
          line = Buffer1.readLine();         
        } 
        csv1.close();
        Buffer1.close();
        return pyramids;
    }
    public PyramidsClass createPyramid(String[] data)
    {
        String pharaoh=data[0];
        String modernName=data[2];
        String site=data[4];
        double height=0;
        if (data[7]!=null&&data[7].length()!=0){
            height=Double.parseDouble(data[7]);   
        }
        PyramidsClass p1= new PyramidsClass(pharaoh,modernName,site,height);
        
     return p1 ;   
    }
    
    public class heightSortingComparator implements Comparator<PyramidsClass>{
        @Override
        public int compare(PyramidsClass obj1,PyramidsClass obj2){
            Double p1 = ((PyramidsClass) obj1).getHeight();
            Double p2 = ((PyramidsClass) obj2).getHeight();
            int heightCompare = p1.compareTo(p2);
        return heightCompare ;
            
        }
        
    }
        
    
    public List<PyramidsClass> sortList(String fileName)  throws IOException{
        List<PyramidsClass> pyramids = new ArrayList<>();
        pyramids= readPyramidsFromCsv (fileName);
        Collections.sort(pyramids,new heightSortingComparator());
        return pyramids;
    } 
   public Map<String,Integer > mapSitesPyramids (String fileName) throws IOException{
       List<PyramidsClass> pyramids1 = new ArrayList<>();
       Map<String,Integer > pyramids2 = new HashMap<>(); 
       pyramids1= readPyramidsFromCsv (fileName);
       List<String> a= new LinkedList<>();
       for (PyramidsClass p :pyramids1){
              a.add(p.getSite()); 
        }
       
       Set<String> distinct = new HashSet<>(a);
		for (String s: distinct) {
                   pyramids2.put(s, Collections.frequency(a, s)) ;
		} 
       
       
       
    return pyramids2;   
       
   }
    
    
}
