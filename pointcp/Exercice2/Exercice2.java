import java.util.*;

public class Exercice2 {



    public static void main (String args[]){

        ArrayList<Character> charArrayList = new ArrayList<Character>();
        Random rand = new Random();
        long start = System.nanoTime();

        ///////////Array List
        start = System.nanoTime();
        for(int i = 0; i<= 100000;i++){
            charArrayList.add(Character.valueOf((char) (rand.nextInt(26)+'a')));
        }
        long end = System.nanoTime();
        System.out.println("Array List run time: "+ String.valueOf((end-start)/1000000000));


        //////////////LinkedList
        LinkedList<Character> linkedChar = new LinkedList<Character>();
        start = System.nanoTime();
        for(int i = 0; i<= 100000;i++){
            linkedChar.add(Character.valueOf((char) (rand.nextInt(26)+'a')));
        }
        end = System.nanoTime();
        System.out.println("Linked List run time: "+String.valueOf((end-start)/1000000000));


        ////////////////Array
        Character[] charArray = new Character[100000];
        start = System.nanoTime();
        for(int i = 0; i < 100000;i++){
            charArray[i] = (char) (rand.nextInt(26)+'a');
        }
        end = System.nanoTime();
        System.out.println("Array run time: "+String.valueOf((end-start)/1000000000));

        //////////////////Addition////////////////////////////////////////////////////////
        @SuppressWarnings("unused")
        String addition = "";
        start = System.nanoTime();
        for(int i = 0; i < charArrayList.size(); i++){
            addition += charArrayList.get(i);
        }
        end = System.nanoTime();
        System.out.println("Array List addition run time: "+ String.valueOf((end-start)/1000000000));

        addition = "";
        start = System.nanoTime();
        for(int i = 0; i< linkedChar.size(); i++){
            addition+= linkedChar.get(i);
        }
        end = System.nanoTime();
        System.out.println("LinkedList addition run time: "+ String.valueOf((end-start)/1000000000));

        addition="";
        start = System.nanoTime();
        for(int i = 0; i < charArray.length; i++){
            addition += charArray[i];
        }
        end = System.nanoTime();
        System.out.println("Array addition run time: "+ String.valueOf((end-start)/1000000000));

    }
}
