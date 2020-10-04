import java.util.Random;
public class TestEfficiency {
    public static void main(String[] args) {
        PointCP5 point;
        if(args[0].charAt(0) == 'C'){
            point = new PointCP3(args[0].charAt(0), Double.valueOf(args[1]).doubleValue(), Double.valueOf(args[2]).doubleValue());
        }

        int numberOfPoints = 1000000;
        PointCP5[] cp5Array = new PointCP5[numberOfPoints];
        PointCP[] cpArray = new PointCP[numberOfPoints];
        char[] cp = new char[numberOfPoints];
        double[] theta = new double[numberOfPoints];
        double[] rho = new double[numberOfPoints];
        double[] angle = new double[numberOfPoints];
        Random r = new Random();
        String cOrP = "CP";
        
        //Declaring the arrays for cp, rho and theta so that results are consistent  
        for (int i = 0; i<numberOfPoints; i++) {
            cp[i] = (char)cOrP.charAt(r.nextInt(2));
            rho[i] = r.nextInt(1001);
            theta[i]=(double) r.nextInt(361);
            angle[i] = r.nextInt(91);
        }


        /////////////////////////////////////////////////////Declaration Section////////////////////////////////////////////////////
        //Declarartion for PointCP 
        long start = System.nanoTime();
        for(int i = 0; i<numberOfPoints;i++){
            cpArray[i] = new PointCP(cp[i], rho[i], theta[i]);
        }
        long end = System.nanoTime();
        System.out.println("PointCP Declaration time(ms): "+String.valueOf((end-start)/1000000));

        
        //Declaration for PointCP5
        start = System.nanoTime();
        for(int i = 0; i<numberOfPoints;i++){
            if (cp[i] == 'P') {
                cp5Array[i] = new PointCP2(cp[i], rho[i], theta[i]);
            } else {
                cp5Array[i] = new PointCP3(cp[i], rho[i], theta[i]);
            }
        }
        end = System.nanoTime();
        System.out.println("PointCP5 Declaration time(ms): "+String.valueOf((end-start)/1000000));
        

        ////////////////////////////////////////////////////////getX() Section//////////////////////////////////////////////////////////
        //getX() function test for PointCP
        start = System.nanoTime();
        for (int i=0; i<numberOfPoints; i++) {
            cpArray[i].getX();
        }
        end = System.nanoTime();
        System.out.println("PointCP getX time(ms): "+String.valueOf((end-start)/1000000));

        //getx() fuction test for PointCP5
        start = System.nanoTime();
        for (int i=0; i<numberOfPoints; i++) {
            cp5Array[i].getX();
        }
        end = System.nanoTime();
        System.out.println("PointCP5 getX time(ms): "+String.valueOf((end-start)/1000000));


        //////////////////////////////////////////////////////////getY() Section///////////////////////////////////////////
        //getY() function test for PointCP
        start = System.nanoTime();
        for (int i=0; i<numberOfPoints; i++) {
            cpArray[i].getY();
        }
        end = System.nanoTime();
        System.out.println("PointCP getY time(ms): "+ String.valueOf((end-start)/1000000));

        //getY() fuction test for PointCP5
        start = System.nanoTime();
        for (int i=0; i<numberOfPoints; i++) {
            cp5Array[i].getY();
        }
        end = System.nanoTime();
        System.out.println("PointCP5 getY time(ms): "+ String.valueOf((end-start)/1000000));


        //////////////////////////////////////////////////////////getRho() Section///////////////////////////////////////////
        //getRho() function test for PointCP
        start = System.nanoTime();
        for (int i=0; i<numberOfPoints; i++) {
            cpArray[i].getRho();
        }
        end = System.nanoTime();
        System.out.println("PointCP getRho time(ms): "+ String.valueOf((end-start)/1000000));

        //gethrho() fuction test for PointCP5
        start = System.nanoTime();
        for (int i=0; i<numberOfPoints; i++) {
            cp5Array[i].getRho();
        }
        end = System.nanoTime();
        System.out.println("PointCP5 getRho time(ms): "+ String.valueOf((end-start)/1000000));


        //////////////////////////////////////////////////////////getTheta() Section///////////////////////////////////////////
        //gettheta() function test for PointCP
        start = System.nanoTime();
        for (int i=0; i<numberOfPoints; i++) {
            cpArray[i].getTheta();
        }
        end = System.nanoTime();
        System.out.println("PointCP getTheta time(ms): "+String.valueOf((end-start)/1000000));

        //gettheta() fuction test for PointCP5
        start = System.nanoTime();
        for (int i=0; i<numberOfPoints; i++) {
            cp5Array[i].getTheta();
        }
        end = System.nanoTime();
        System.out.println("PointCP5 getTheta time(ms): "+String.valueOf((end-start)/1000000));


        //////////////////////////////////////////////////////////getDistance() Section///////////////////////////////////////////
        //getDistance() function test for PointCP
        start = System.nanoTime();
        for (int i=0; i<numberOfPoints; i++) {
            cpArray[i].getDistance( new PointCP(cp[i],0.0,0.0) );
        }
        end = System.nanoTime();
        System.out.println("PointCP getDistance time(ms): "+String.valueOf((end-start)/1000000));

        //getDistance() fuction test for PointCP5
        start = System.nanoTime();
        for (int i=0; i<numberOfPoints; i++) {
            cp5Array[i].getDistance(new PointCP3(cp[i],0.0,0.0));
        }
        end = System.nanoTime();
        System.out.println("PointCP5 getDistance time(ms): "+String.valueOf((end-start)/1000000));
        
        
        //////////////////////////////////////////////////////////rotatePoint() Section///////////////////////////////////////////
        //rotatePoint() function test for PointCP
        start = System.nanoTime();
        for (int i=0; i<numberOfPoints; i++) {
            cpArray[i].rotatePoint(angle[i]);
        }
        end = System.nanoTime();
        System.out.println("PointCP rotatePoint time(ms): "+String.valueOf((end-start)/1000000));

        //rotatePoint() fuction test for PointCP5
        start = System.nanoTime();
        for (int i=0; i<numberOfPoints; i++) {
            cp5Array[i].rotatePoint(angle[i]);
        }
        end = System.nanoTime();
        System.out.println("PointCP5 rotatePoint time(ms): "+String.valueOf((end-start)/1000000));

         
    }
}

