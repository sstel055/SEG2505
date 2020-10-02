import java.util.*;

public class Exercice2 {
//Char[] charArray = new Char[];

    
    public static void main (String args[]){
            
        ArrayList<Character> charArrayList = new ArrayList<Character>();
        Random rand = new Random();
        long start = System.nanoTime();
            
        while((System.nanoTime()- start)/1000000000<10){
            charArrayList.add(Character.valueOf((char) (rand.nextInt(26)+'a'))); 
        }

        int x = charArrayList.size();
        System.out.println("Size : " + Integer.toString(x));
        System.out.println(charArrayList.get(1));
    }
}//105136606
//105136606