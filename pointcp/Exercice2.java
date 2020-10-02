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
            
        start = System.nanoTime();    
        for(int i = 0; i<=charArrayList.size(); i++){
            charArrayList.add(Character.valueOf((char) (rand.nextInt(26)+'a'))); 
        }
        long end = System.nanoTime();
        System.out.println(charArrayList.size());
        System.out.println(start-end/1000000000);
    }
}//105136606
//105136606

//Size :202252881 m
//Stef: 157704908, 105136606, 109185481, 119490523