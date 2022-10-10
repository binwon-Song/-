import java.util.LinkedList;
import java.util.Iterator;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.awt.Point;
public class bj_1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Point> queue = new LinkedList<>();
        LinkedList<Point> tempqueue = new LinkedList<>();
        int T=Integer.parseInt(reader.readLine());
        int count=0;
        // 전체 반복 횟수
        for(int i=0;i<T;i++){
            StringTokenizer st = new StringTokenizer(reader.readLine());
            int n=Integer.parseInt(st.nextToken());
            int m=Integer.parseInt(st.nextToken());
            st = new StringTokenizer(reader.readLine());
            boolean flag=true; 
            count=0;
            queue.clear();
            tempqueue.clear();
            ///////////////////////////////////////////////////////
            for(int j=0;j<n;j++){    
                queue.offer(new Point(j,Integer.parseInt(st.nextToken())));
            }
            while(!queue.isEmpty()){
                
                Point same=queue.peek();
                for(int k=0;k<queue.size();k++){  // 리스트에 원소가 모두 같으면 true 
                    flag=true;
                    if(same.y!=queue.get(k).y)
                    {
                        flag=false;  // 한 개라도 다르면 false
                        break;
                    }
                }
                if (flag==false)
                {
                    for(int k=0;k<queue.size()-1;k++){  //첫 번째 원소를 기준으로 비교하면서 맨 앞이 제일 큰 수 올때까지 poll and offer
                        int r=1;
                        Point p=queue.peek();
                        Point temp=queue.get(r);
                        if(p.y <= temp.y){
                            queue.poll();
                            queue.offer(p);
                            r=1;
                        }
                        r++;
                    }
                    tempqueue.offer(queue.poll());   // 제일 큰 수는 새로운 연결리스트에 저장
                }                  
                else{  // 리스트의 원소가 모두 같은경우
                    while(!queue.isEmpty()){
                        tempqueue.offer(queue.poll());  //차례대로 tempqueue에 저장
                    }
                }     
            }
            
            for(Iterator<Point> iter=tempqueue.iterator();iter.hasNext();)  // 결과 출력
            {
                count++;
                if (iter.next().x==m){
                    System.out.println(count);
                }
            }
        }
    }
}