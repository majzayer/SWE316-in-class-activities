import java.util.ArrayList;

public class SnapshotDiagramActivity {
    public static void f(String s, ArrayList<String> list, String[] arr) {
       s = s.concat(" world");  
       arr[0] = s;            
       list.add(arr[0]);       
       arr[0] = "new string";
       arr[1] = "another new string";   
    }
    
    public static void main(String[] args) {
        final ArrayList<String> myList = new ArrayList<>();
        myList.add("hello");
    
        String myString = "hello";
        String[] myArray = new String[2];
        myArray[0] = "initial";
        myArray[1] = "another";
    
        f(myString, myList, myArray);
    
        
        System.out.println(myString);
        System.out.println(myList);   
        System.out.println(myArray[0]); 
        System.out.println(myArray[1]); 
    }
}
