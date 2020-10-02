public class Exercice2 {
//Char[] charArray = new Char[];

    
    public static void main (String args[]){
            
        ArrayList<Char> charArrayList = new ArrayList<Char>();
        Random rand = new Random();
        long start = System.nanoTime();
            
        while((System.nanoTime()- start)/1000000000<10){
            charArrayList.push((char) (rand.nextInt(26)+'a'));
        }
    }
}
