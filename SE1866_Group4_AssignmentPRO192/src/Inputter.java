
import java.util.*;
import java.lang.*;
public class Inputter {

    public static Scanner sc =new Scanner (System.in);
    
    public static String normalize(String S){
        StringTokenizer stk = new StringTokenizer(S, " ");
        String result = stk.nextToken();
        while (stk.hasMoreElements()) result += " " + stk.nextToken();
        return result;
    }
    
    public static String getNonBlankStr ( String msg) {
        String result;
        do{
            System.out.println(msg);
            result = normalize(sc.nextLine());
        }
        while (result.length()==0);
        return result;
    }
    
    public static  String getPatternStr (String msg, String regEx){
        String result;
        do{
            System.out.println(msg);
            result  = normalize(sc.nextLine());
        }
        while (!result.matches(regEx));
        return result;
    }
    
    public static int getIntGreater(String msg, int min){
        int result;
        do{
            System.out.println(msg);
            result =Integer.parseInt(sc.nextLine());
        }
        while (result<= min);
        return result;
    }
}

