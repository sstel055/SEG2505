import java.util.Random;
public class TestEfficiency {
    public static void main(String[] args) {
        int numberOfPoints = 1000;
        PointCP[] cpArray = new PointCP[numberOfPoints];
        PointCP2[] cpArray2 = new PointCP2[numberOfPoints];
        PointCP3[] cpArray3 = new PointCP3[numberOfPoints];
        Random r = new Random();
        String cOrP = "CP";


        //Declarartion for PointCP 
        long start = System.nanoTime();
        for(int i = 0; i<numberOfPoints;i++){
            cpArray[i] = new PointCP((char)cOrP.charAt(r.nextInt(2)) , r.nextInt(1001), (double) r.nextInt(361));
        }
        long end = System.nanoTime();
        System.out.println("Average PointCP Declaration time(runtime/numberOfPoints): "+String.valueOf(((end-start)/1000000000)/numberOfPoints));

        //Declaration for PointCP2 
        start = System.nanoTime();
        for(int i = 0; i<numberOfPoints;i++){
            cpArray2[i] = new PointCP2((char)cOrP.charAt(r.nextInt(2)) , r.nextInt(1001), (double) r.nextInt(361));
        }
        end = System.nanoTime();
        System.out.println("Average PointCP2 Declaration time(runtime/numberOfPoints): "+String.valueOf(((end-start)/1000000000)/numberOfPoints));


        //Declaration for PointCP3 
        for(int i = 0; i<numberOfPoints;i++){
            cpArray3[i] = new PointCP3((char)cOrP.charAt(r.nextInt(2)) , r.nextInt(1001), (double) r.nextInt(361));
        }
        System.out.println("Average PointCP3 Declaration time(runtime/numberOfPoints): "+String.valueOf(((end-start)/1000000000)/numberOfPoints));

        


    }
}
