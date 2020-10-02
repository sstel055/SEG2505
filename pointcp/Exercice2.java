import java.util.*;

public class Exercice2 {
//Char[] charArray = new Char[];

    
    public static void main (String args[]){
            
        ArrayList<Character> charArrayList = new ArrayList<Character>();
        Random rand = new Random();
        long start = System.nanoTime();

        while((System.nanoTime() - start)/1000000000<10){
            charArrayList.add(Character.valueOf((char) (rand.nextInt(26)+'a'))); 
        }//determine the length of the array to fill it for 10 seconds 
        int x = charArrayList.size();
        charArrayList.clear();

        int i = 0;
        double time = 0.0;
        start = System.nanoTime();    
        while(i <= x){
            charArrayList.add(Character.valueOf((char) (rand.nextInt(26)+'a'))); 
            time = System.nanoTime() - start;
            i++;
        }
        long end = System.nanoTime();
        
        System.out.println(x);
        System.out.println((end-start)/1000000000);
    }
}//315409818