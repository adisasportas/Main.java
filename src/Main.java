import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    // creat a function that returns the sum of all integer values of a que
    public static int sumQueue(Queue<Integer> que) {
        if(que == null) return 0;
        int sum = 0;
        Queue<Integer> temp = new LinkedList<>();
        while (!que.isEmpty()){
            sum += que.peek();
            temp.add(que.poll());
        }
        while (!temp.isEmpty())
            que.add(temp.poll());

        return sum;
    }
    //create a function that get a que and a value of int and returns true if the value is in the queue
    public static boolean isInside(Queue<Integer> que, int val) {
        if(que == null) return false;
        Queue<Integer> temp = new LinkedList<>();
        boolean found=false;
        while(!que.isEmpty()){
            if(que.peek()==val)
                found=true;
            temp.add(que.poll());
        }
        while (!temp.isEmpty())
            que.add(temp.poll());
        return found;
    }

    public static Queue<Integer> revers(Queue<Integer> que){
        if(que == null) return null;
        Queue<Integer> res = new LinkedList<>();
        Stack<Integer> temp = new Stack<>();
        while(!que.isEmpty())
            temp.push(que.poll());
        while(!temp.isEmpty()){
            res.add(temp.peek());
            que.add(temp.pop());
        }
        //return the que to the previous order
        while(!que.isEmpty())
            temp.push(que.poll());
        while(!temp.isEmpty())
            que.add(temp.pop());
        return res;
    }
    public static Queue<Integer> reversRec(Queue<Integer> que){
        if(que == null) return null;

        if(!que.isEmpty()) {
            int num = que.poll();
            reversRec(que);
            que.add(num);
        }
        return que;
    }
    public static void firstNegative(Queue<Integer> que ){
        if(que == null) return;
        Queue<Integer> neg= new LinkedList<>();
        Queue<Integer> pos= new LinkedList<>();
        while(!que.isEmpty()){
            if(que.peek()<0)
                neg.add(que.poll());
            else
                pos.add(que.poll());
        }
        while (!neg.isEmpty())
            que.add(neg.poll());
        while (!pos.isEmpty())
            que.add(pos.poll());

    }
    public static void main(String[] args) {

        Queue<Integer> que = new LinkedList<>();
        que.add(4);
        que.add(5);
        que.add(-8);
        que.add(9);
        que.add(-1);
        que.add(-12);

        System.out.println(que);
        firstNegative(que);
        System.out.println(que);


    }
}