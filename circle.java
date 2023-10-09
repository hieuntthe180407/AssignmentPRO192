import java.util.*;
import java.lang.*;
import java.text.*;
public class circle {
    
    
        Point center;
        double radius;
        
  public circle (){
      center = new Point ();
      radius = 0.0;
  }
    public void setcenter(Point k){
        center= k;
        
    }
    
    public void setradius (double k){
        radius = k;
    }
    
    public double getPerimeter (){
     
       double result = 2*radius*Math.PI;
       return result;
    }
    public double getArea (){
        double result = radius*radius*Math.PI;
        return result;
    }
    
    public String displayinfo() {
        double p= lamtron (getPerimeter(), "#.#");
        double a = lamtron (getArea (), "#.##");
        String result = "center(" + center.displayinfo() +",radius(" + radius ;
        result += ",Perimeter=" + p +",Area=" + a;
        
        return result;
    }
    
    public double lamtron(double k, String pattern){
        DecimalFormat df = new DecimalFormat(pattern);
        String s=  df.format(k);
        double result= Double.parseDouble(s);
        return result;
        
    }
}
