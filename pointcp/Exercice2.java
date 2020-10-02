import java.util.*;

public class Exercice2 {
//Char[] charArray = new Char[];

    
    public static void main (String args[]){
            
        ArrayList<Character> charArrayList = new ArrayList<Character>();
        Random rand = new Random();
        long start = System.nanoTime();

        // while((System.nanoTime() - start)/1000000000<10){
        //     charArrayList.add(Character.valueOf((char) (rand.nextInt(26)+'a'))); 
        // }//determine the length of the array to fill it for 10 seconds 
        // int x = charArrayList.size();
        // charArrayList.clear();

        start = System.nanoTime();    
        for(int i = 0; i<= 50000000;i++){
            charArrayList.add(Character.valueOf((char) (rand.nextInt(26)+'a')));
        }
        long end = System.nanoTime();
        
        //System.out.println(x);
        System.out.println((end-start)/1000000000);

        // start = System.nanoTime(); 
        // for(int i = 0; i<= 100000000;i++){
        //     charArrayList.add(Character.valueOf((char) (rand.nextInt(26)+'a')));
        // }
        // end = System.nanoTime();
        
        // //System.out.println(x);
        // System.out.println((end-start)/1000000000);

        // start = System.nanoTime(); 
        // for(int i = 0; i <= 100000000;i++){
        //     charArrayList.add(Character.valueOf((char) (rand.nextInt(26)+'a')));
        // }
        // end = System.nanoTime();
        
        // //System.out.println(x);
        // System.out.println((end-start)/1000000000);
    }
}//315409818