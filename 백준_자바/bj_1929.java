import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class bj_1929 {
    public static int prime_number(int num) {
       if (num==1 || num==2) 
            return 0;
        for(int i=2;i*i<=num;i++) {
            if(num%i==0)
                return 0;
        }
        return num;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(reader.readLine());
        ArrayList<Integer> numbers=new ArrayList<>();
        ArrayList<Integer> result=new ArrayList<>();
        for(int i=0; i<2; i++)
        {
            numbers.add(Integer.parseInt(st.nextToken()));
        }
        for(int i=numbers.get(0);i<=numbers.get(1);i++)
        {
            result.add(prime_number(i));
        }
        for(int i=0;i<result.size();i++)
            if(result.get(i)!=0)
                System.out.println(result.get(i));
    }
}
