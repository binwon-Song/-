import java.util.Scanner;
public class bj_1259{
    public static boolean palindrome(String str){{
        StringBuffer sb = new StringBuffer(str);
        if (str.equals(sb.reverse().toString())){
            return true;
        }
        else
        {
            return false;
        }    
    }} 
    public static void main(String[] args) throws Exception {
        Scanner input=new Scanner(System.in);
        String number;
        while(true){
            number=input.next();
            if (number.equals("0"))
                break;
            if (palindrome(number))
                System.out.println("yes");
            else
                System.out.println("no");
        }
    }
}