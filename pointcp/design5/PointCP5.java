package design5;

public abstract class PointCP5{

    public double getDistance(PointCP5 pointB){
    // Obtain differences in X and Y, sign is not important as these values
    // will be squared later.
    double deltaX = getX() - pointB.getX();
    double deltaY = getY() - pointB.getY(); 
    
    return Math.sqrt((Math.pow(deltaX, 2) + Math.pow(deltaY, 2)));

    }
    
    public abstract double getY(){

    }
    public abstract double getX(){

    }

    
    public abstract double getRho(){

    }

    
    public abstract double getTheta(){

    }
    public abstract PointCP5 rotatePoint(double rotation){

    }



  

}
