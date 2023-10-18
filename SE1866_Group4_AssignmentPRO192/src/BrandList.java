

import java.util.*;
import java.lang.*;
public class BrandList{
    List<Brand> brands= new ArrayList();
    public BrandList(){
        
    }
public boolean loadFromFile(String){
    
}
public boolean saveToFile(String){
    
}
public int searchID (String ID){
    int N = this.size();
    for (int i = 0; i < N; i++) {
    if (this.get(i).getBrandID().equals(bID)) {
        return i;
        }
    }
    return -1;
}
public Brand getUserChoice(){
    
}
public void addBrand(){
    
}
public void updateBrand(){
    
}
public void listBrands(){
    for ( int i=0; i<brands.size(); i++)
        System.out.println(this.brands.get(i));
    
}
}
