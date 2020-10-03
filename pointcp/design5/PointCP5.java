
public abstract class PointCP5{
    PointCP3 cp3;
    PointCP2 cp2;
    char type;
    public PointCP5(char type, double xOrRho, double yOrTheta){
        if(type != 'C' && type != 'P'){throw new IllegalArgumentException();}
        this.type = type;
        if(type == 'C'){
            this.cp3 = new PointCP3(type, xOrRho, yOrTheta);
        }else{
            this.cp2 = new PointCP2(type, xOrRho, yOrTheta);
        }
    }


    public double getDistance(PointCP5 pointB){
    // Obtain differences in X and Y, sign is not important as these values
    // will be squared later.
    double deltaX = getX() - pointB.getX();
    double deltaY = getY() - pointB.getY(); 
    
    return Math.sqrt((Math.pow(deltaX, 2) + Math.pow(deltaY, 2)));
    }
    
    public abstract double getY();
    
    public abstract double getX();

    public abstract double getRho();
    
    public abstract double getTheta(); 

<<<<<<< HEAD
    public abstract PointCP5 rotatePoint(double rotation);  

}
=======

    public abstract PointCP5 rotatePoint(double rotation);


  
}
>>>>>>> 259910564bcf26fe9fc816994c4e36c1aecb1386
