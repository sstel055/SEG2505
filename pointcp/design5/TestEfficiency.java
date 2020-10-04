import java.util.*;
public class TestEfficiency {
    public static void main(String[] args) {

        int numberOfPoints = 500000;
        PointCP5[] cp5Array = new PointCP5[numberOfPoints];
        PointCP[] cpArray = new PointCP[numberOfPoints];
        char[] cp = new char[numberOfPoints];
        double[] yOrTheta = new double[numberOfPoints];
        double[] xOrRho = new double[numberOfPoints];
        double[] angle = new double[numberOfPoints];
        Random r = new Random();
        String cOrP = "CP";

        //Declaring the arrays for cp, xOrRho and yOrTheta so that results are consistent
        for (int i = 0; i<numberOfPoints; i++) {
            cp[i] = (char)cOrP.charAt(r.nextInt(2));
            xOrRho[i] = r.nextInt(1001);
            yOrTheta[i]=(double) r.nextInt(361);
            angle[i] = r.nextInt(91);
        }


        /////////////////////////////////////////////////////Declaration Section////////////////////////////////////////////////////
        //Declarartion for PointCP
        long[] time = new long[9];
        for(int x = 0; x < 9; x++){
            long start = System.nanoTime();
            for(int i = 0; i<numberOfPoints;i++){
                cpArray[i] = new PointCP(cp[i], xOrRho[i], yOrTheta[i]);
            }
            long end = System.nanoTime();
            time[x] = (end-start)/1000000;
            System.out.println("PointCP Declaration time(ms): "+String.valueOf((end-start)/1000000));
        }
        Arrays.sort(time);
        System.out.println("\nMin time: " + time[0] + " Median: " + time[4] + " Max time: " + time[8]  + " Average time: " + Double.toString(average(time)));


        //Declaration for PointCP5
        for(int y = 0; y < 9; y++){
            long start = System.nanoTime();
            for(int i = 0; i<numberOfPoints;i++){
                if (cp[i] == 'P') {
                    cp5Array[i] = new PointCP2(cp[i], xOrRho[i], yOrTheta[i]);
                } else {
                    cp5Array[i] = new PointCP3(cp[i], xOrRho[i], yOrTheta[i]);
                }
            }
            long end = System.nanoTime();
            time[y] = (end-start)/1000000;
            System.out.println("PointCP5 Declaration time(ms): "+String.valueOf((end-start)/1000000));
        }
        Arrays.sort(time);
        System.out.println("\nMin time: " + time[0] + " Median: " + time[4] + " Max time: " + time[8]  + " Average time: " + Double.toString(average(time)));

        ////////////////////////////////////////////////////////getX() Section//////////////////////////////////////////////////////////
        //getX() function test for PointCP
        for(int x = 0; x < 9; x++){
            long start = System.nanoTime();
            for (int i=0; i<numberOfPoints; i++) {
                cpArray[i].getX();
            }
            long end = System.nanoTime();
            time[x] = (end-start)/1000000;
            System.out.println("PointCP getX time(ms): "+String.valueOf((end-start)/1000000));
            
        }
        Arrays.sort(time);
        System.out.println("\nMin time: " + time[0] + " Median: " + time[4] + " Max time: " + time[8]  + " Average time: " + Double.toString(average(time)));
        
        
        //getx() fuction test for PointCP5.
        for(int x = 0; x < 9; x++){
            long start = System.nanoTime();
            for (int i=0; i<numberOfPoints; i++) {
                cp5Array[i].getX();
            }
            long end = System.nanoTime();
            time[x] = (end-start)/1000000;
            System.out.println("PointCP5 getX time(ms): "+String.valueOf((end-start)/1000000));
        }
        Arrays.sort(time);
        System.out.println("\nMin time: " + time[0] + " Median: " + time[4] + " Max time: " + time[8]  + " Average time: " + Double.toString(average(time)));


        //////////////////////////////////////////////////////////getY() Section///////////////////////////////////////////
        //getY() function test for PointCP
        
        for(int x = 0; x < 9; x++){
            long start = System.nanoTime();
            for (int i=0; i<numberOfPoints; i++) {
                cpArray[i].getY();
            }
            long end = System.nanoTime();
            time[x] = (end-start)/1000000;
            System.out.println("PointCP getY time(ms): "+ String.valueOf((end-start)/1000000));
        }
        Arrays.sort(time);
        System.out.println("\nMin time: " + time[0] + " Median: " + time[4] + " Max time: " + time[8]  + " Average time: " + Double.toString(average(time)));


        //getY() fuction test for PointCP5
        for(int x = 0; x < 9; x++){
            long start = System.nanoTime();
            for (int i=0; i<numberOfPoints; i++) {
                cp5Array[i].getY();
            }
            long end = System.nanoTime();
            time[x] = (end-start)/1000000;
            System.out.println("PointCP5 getY time(ms): "+ String.valueOf((end-start)/1000000));

        }
        Arrays.sort(time);
        System.out.println("\nMin time: " + time[0] + " Median: " + time[4] + " Max time: " + time[8]  + " Average time: " + Double.toString(average(time)));

        //////////////////////////////////////////////////////////getRho() Section///////////////////////////////////////////
        //getRho() function test for PointCP
        for(int x = 0; x < 9; x++){
            long start = System.nanoTime();
            for (int i=0; i<numberOfPoints; i++) {
                cpArray[i].getRho();
            }
            long end = System.nanoTime();
            time[x] = (end-start)/1000000;
            System.out.println("PointCP getRho time(ms): "+ String.valueOf((end-start)/1000000));
        }
        Arrays.sort(time);
        System.out.println("\nMin time: " + time[0] + " Median: " + time[4] + " Max time: " + time[8]  + " Average time: " + Double.toString(average(time)));

        //gethrho() fuction test for PointCP5
        for(int x = 0; x < 9; x++){
            long start = System.nanoTime();
            for (int i=0; i<numberOfPoints; i++) {
                cp5Array[i].getRho();
            }
            long end = System.nanoTime();
            time[x] = (end-start)/1000000;
            System.out.println("PointCP5 getRho time(ms): "+ String.valueOf((end-start)/1000000));
        }
        Arrays.sort(time);
        System.out.println("\nMin time: " + time[0] + " Median: " + time[4] + " Max time: " + time[8]  + " Average time: " + Double.toString(average(time)));

        //////////////////////////////////////////////////////////getTheta() Section///////////////////////////////////////////
        //gettheta() function test for PointCP
        for(int x = 0; x < 9; x++){
            long start = System.nanoTime();
            for (int i=0; i<numberOfPoints; i++) {
                cpArray[i].getTheta();
            }
            long end = System.nanoTime();
            time[x] = (end-start)/1000000;
            System.out.println("PointCP getTheta time(ms): "+String.valueOf((end-start)/1000000));
        }
        Arrays.sort(time);
        System.out.println("\nMin time: " + time[0] + " Median: " + time[4] + " Max time: " + time[8]  + " Average time: " + Double.toString(average(time)));

        //gettheta() fuction test for PointCP5
        for(int x = 0; x < 9; x++){
            long start = System.nanoTime();
            for (int i=0; i<numberOfPoints; i++) {
                cp5Array[i].getTheta();
            }
            long end = System.nanoTime();
            time[x] = (end-start)/1000000;
            System.out.println("PointCP5 getTheta time(ms): "+String.valueOf((end-start)/1000000));
        }
        Arrays.sort(time);
        System.out.println("\nMin time: " + time[0] + " Median: " + time[4] + " Max time: " + time[8]  + " Average time: " + Double.toString(average(time)));


        //////////////////////////////////////////////////////////getDistance() Section///////////////////////////////////////////
        //getDistance() function test for PointCP
        for(int x = 0; x < 9; x++){
            long start = System.nanoTime();
            for (int i=0; i<numberOfPoints; i++) {
                cpArray[i].getDistance( new PointCP(cp[i],0.0,0.0) );
            }
            long end = System.nanoTime();
            time[x] = (end-start)/1000000;
            System.out.println("PointCP getDistance time(ms): "+String.valueOf((end-start)/1000000));
        }
        Arrays.sort(time);
        System.out.println("\nMin time: " + time[0] + " Median: " + time[4] + " Max time: " + time[8]  + " Average time: " + Double.toString(average(time)));
        
        //getDistance() fuction test for PointCP5
        for(int x = 0; x < 9; x++){
            long start = System.nanoTime();
            for (int i=0; i<numberOfPoints; i++) {
                cp5Array[i].getDistance(new PointCP3(cp[i],0.0,0.0));
            }
            long end = System.nanoTime();
            time[x] = (end-start)/1000000;
            System.out.println("PointCP5 getDistance time(ms): "+String.valueOf((end-start)/1000000));
        }
        Arrays.sort(time);
        System.out.println("\nMin time: " + time[0] + " Median: " + time[4] + " Max time: " + time[8]  + " Average time: " + Double.toString(average(time)));
        

        //////////////////////////////////////////////////////////rotatePoint() Section///////////////////////////////////////////
        //rotatePoint() function test for PointCP
        for(int x = 0; x < 9; x++){
            long start = System.nanoTime();
            for (int i=0; i<numberOfPoints; i++) {
                cpArray[i].rotatePoint(angle[i]);
            }
            long end = System.nanoTime();
            time[x] = (end-start)/1000000;
            System.out.println("PointCP rotatePoint time(ms): "+String.valueOf((end-start)/1000000));
        }
        Arrays.sort(time);
        System.out.println("\nMin time: " + time[0] + " Median: " + time[4] + " Max time: " + time[8]  + " Average time: " + Double.toString(average(time)));

        //rotatePoint() fuction test for PointCP5
        for(int x = 0; x < 9; x++){
            long start = System.nanoTime();
            for (int i=0; i<numberOfPoints; i++) {
                cp5Array[i].rotatePoint(angle[i]);
            }
            long end = System.nanoTime();
            time[x] = (end-start)/1000000;
            System.out.println("PointCP5 rotatePoint time(ms): "+String.valueOf((end-start)/1000000));
        }
        Arrays.sort(time);
        System.out.println("\nMin time: " + time[0] + " Median: " + time[4] + " Max time: " + time[8]  + " Average time: " + Double.toString(average(time)));

    }
    
    public static double average(long[] times){
        long sum = 0;
        for(int i = 0; i < times.length; i++){
            sum+=times[i];
        }
        return (double)sum/times.length;
    }
}
