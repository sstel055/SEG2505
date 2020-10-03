package design5;

public abstract class PointCP5{

    public double getDistance(PointCP2 pointB){.
         // Obtain differences in X and Y, sign is not important as these values
    // will be squared later.
    double x = getX();
    double deltaX = x - pointB.getX();
    double deltaY = x - pointB.getY();
    
    return Math.sqrt((Math.pow(deltaX, 2) + Math.pow(deltaY, 2)));

    }
    
    public abstract double getY(){

    }

    
    public abstract double getRho(){

    }

    
    public abstract double getTheta(){

    }
    public abstract PointCP rotatePoint(double rotation){

    }



  

}
