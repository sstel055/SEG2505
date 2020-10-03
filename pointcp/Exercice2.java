import java.util.*;

public class Exercice2 {


    
    public static void main (String args[]){
            
        ArrayList<Character> charArrayList = new ArrayList<Character>();
        Random rand = new Random();
        long start = System.nanoTime();

        ///////////Array List
        start = System.nanoTime();    
        for(int i = 0; i<= 1000000;i++){
            charArrayList.add(Character.valueOf((char) (rand.nextInt(26)+'a')));
        }
        long end = System.nanoTime();
        System.out.println("Array List run time: "+ String.valueOf((end-start)/1000000000));
        

        //////////////LinkedList
        LinkedList<Character> linkedChar = new LinkedList<Character>();
        start = System.nanoTime(); 
        for(int i = 0; i<= 1000000;i++){
            linkedChar.add(Character.valueOf((char) (rand.nextInt(26)+'a')));
        }
        end = System.nanoTime();
        System.out.println("Linked List run time: "+String.valueOf((end-start)/1000000000));


        ////////////////Array
        char[] charArray = new char[50000000];
        start = System.nanoTime();
        for(int i = 0; i < 1000000;i++){
            charArray[i] = (char) (rand.nextInt(26)+'a');
        }
        end = System.nanoTime();
        System.out.println("Array run time: "+String.valueOf((end-start)/1000000000));

        //////////////////Addition//////////////////////////////////////////////////////// 
       
        String addition = "";
        start = System.nanoTime();
        for(Character i : charArrayList){
            addition += i;
        }
        end = System.nanoTime();
        System.out.println("Array List addition with advanced for loop run time: "+ String.valueOf((end-start)/1000000000));

        addition = "";
        start = System.nanoTime();
        for(Character i: linkedChar){
            addition+= i;
        }
        end = System.nanoTime();
        System.out.println("LinkedList addition with advanced for loop run time: "+ String.valueOf((end-start)/1000000000));
        
        addition="";
        start = System.nanoTime();
        for(Character i: charArray){

        }
        end = System.nanoTime();
        System.out.println("Array addition with advanced for loop run time: "+ String.valueOf((end-start)/1000000000));


        








    }
}