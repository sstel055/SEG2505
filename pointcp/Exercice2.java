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

        ///////////Array List
        start = System.nanoTime();    
        for(int i = 0; i<= 220000000;i++){
            charArrayList.add(Character.valueOf((char) (rand.nextInt(26)+'a')));
        }
        long end = System.nanoTime();
        System.out.println("Array List run time: "+ String.valueOf((end-start)/1000000000));
        

        //////////////LinkedList
        LinkedList<Character> linkedChar = new LinkedList<Character>();
        start = System.nanoTime(); 
        for(int i = 0; i<= 220000000;i++){
            linkedChar.add(Character.valueOf((char) (rand.nextInt(26)+'a')));
        }
        end = System.nanoTime();
        System.out.println("Linked List run time: "+String.valueOf((end-start)/1000000000));


        ////////////////Array
        char[] charArray = new char[230000000];
        start = System.nanoTime();
        for(int i = 0; i < 220000000;i++){
            charArray[i] = (char) (rand.nextInt(26)+'a');
        }
        end = System.nanoTime();
        System.out.println("Array run time: "+String.valueOf((end-start)/1000000000));

    }
}