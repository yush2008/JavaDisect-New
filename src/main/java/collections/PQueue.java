package collections;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * User: pratyush
 * Date: 27/10/13
 * Time: 11:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class PQueue {

    int x=20;

    public int hashCode(){
        return x/5;
    }


    public static void main(String[] args) {

        PriorityQueue<String> pqueueO = new PriorityQueue<String>();
        pqueueO.offer("banana");
        pqueueO.offer("pear");
        pqueueO.offer("apple");
      //  System.out.println(pqueueO.poll() + " " + pqueueO.peek());


        PriorityQueue<String> pqueue = new PriorityQueue<String>();
        pqueue.add("banana");
        pqueue.add("pear");
        pqueue.add("apple");

        pqueue.offer("banana");
        pqueue.offer("pear");
        pqueue.offer("apple");

        System.out.println(pqueue.poll() + " " + pqueue.peek());



        Queue<String> pq = new PriorityQueue<String>();
        pq.add("2");
        pq.add("4");
        System.out.print(pq.peek() + " ");
        pq.offer("1");
        pq.add("3");
        pq.offer("5");
        pq.offer("7");
        pq.remove("1");
        System.out.print(pq.poll() + " ");
        if(pq.remove("2")) System.out.print(pq.poll() + " ");
        System.out.println(pq.poll() + " " + pq.peek());

    }
}
