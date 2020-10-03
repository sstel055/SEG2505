import java.util.Random;
public class TestEfficiency {
    public static void main(String[] args) {
        int numberOfPoints = 1000000;
        PointCP5[] cp5Array = new PointCP5[numberOfPoints];
        PointCP[] cpArray = new PointCP[numberOfPoints];
        char[] cp = new char[numberOfPoints];
        double theta[] = new double[numberOfPoints];
        double rho[] = new double[numberOfPoints];
        Random r = new Random();
        String cOrP = "CP";
        
        //Declaring the arrays for cp, rho and theta so that results are consistent  
        for (int i = 0; i<numberOfPoints; i++) {
            cp[i] = (char)cOrP.charAt(r.nextInt(2));
            rho[i] = r.nextInt(1001);
            theta[i]=(double) r.nextInt(361);
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
        System.out.println("PointCP5 Declaration time(runtime/numberOfPoints): "+String.valueOf((end-start)/1000000));
        

        ////////////////////////////////////////////////////////getX() Section//////////////////////////////////////////////////////////
        //getX() function test for PointCP
        start = System.nanoTime();
        for (int i=0; i<numberOfPoints; i++) {
            cpArray[i].getX();
        }
        end = System.nanoTime();
        System.out.println("PointCP getx time(ms): "+String.valueOf((end-start)/1000000));

        //getx() fuction test for PointCP5
        start = System.nanoTime();
        for (int i=0; i<numberOfPoints; i++) {
            cp5Array[i].getX();
        }
        end = System.nanoTime();
        System.out.println("PointCP5 getx time(ms): "+String.valueOf((end-start)/1000000));

        //////////////////////////////////////////////////////////getY() Section///////////////////////////////////////////





    }
}
