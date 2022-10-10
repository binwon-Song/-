import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj_1874 {
    protected static void push_pop(Stack<Integer> stl,ArrayList<Integer>al,int n){
        int i=1;
        ArrayList<String> result= new ArrayList<>();
        for(int r=0;r<2*n;r++){
            if(stl.isEmpty()){
                stl.push(i++);
                result.add("+");
            }
            if(!al.get(0).equals(i-1) && stl.lastElement()<al.get(0))
            {
                stl.push(i++);
                result.add("+");
            }
            else{
                while(true){
                    if(stl.isEmpty() && !al.isEmpty()){
                        System.out.println("NO");
                        System.exit(0);
                    }
                    int temp=stl.pop();
                    if (al.get(0).equals(temp)){
                        al.remove(0);
                        result.add("-");
                        break;
                    }
                }
                if(al.isEmpty())break;
            }
        }
        
            for(int j=0;j<result.size();j++)
            {
                System.out.println(result.get(j));
            }

    }
    public static void main(String args[]) throws Exception
    {
        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> al= new ArrayList<>();
        Stack<Integer> stackList= new Stack<>();
        int n=Integer.parseInt(sc.readLine());
        for(int i=0;i<n;i++)
        {
            al.add(Integer.parseInt(sc.readLine()));
        }
        push_pop(stackList, al, n);
    }
}