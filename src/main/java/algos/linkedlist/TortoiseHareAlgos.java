package algos.linkedlist;

/**
 * Created by pratyush on 20/5/16.
 */
public class TortoiseHareAlgos {

    public static void main(String[] args) {

        ILinkedList unknownLL = getLinkedList(new int[]{10,20,30,40,50});
        isCircular(unknownLL);


    }

    private static boolean isCircular(ILinkedList unknownLL) {

        Node tortoise = unknownLL.start;
        Node hare = tortoise.nptr.nptr;

        while(true){

            if(hare==null || hare.nptr ==null)
                return false;
            if(hare == tortoise)
                return true;
            else {
                tortoise = tortoise.nptr;
                hare = hare.nptr.nptr;
            }

        }

    }

    private static ILinkedList getLinkedList(int[] ints) {

        if(ints ==null || ints.length<1)
            return null;

        ILinkedList ll = new ILinkedList();

        for(int val: ints){
              ll.add(val);
        }

        return ll;
    }

}


/*
* Support
* 1. Addition at END and index based.
* 2. Deletion at END and index based
* * */
class ILinkedList{
    Node start;
    Node end;
    int length = -1;

    public void add(int val){
        if(start == null){
            start = new Node(val);
            end = start;
        }else{
            Node newNode = new Node(val);
            end.nptr = newNode;
            end = newNode;
        }
        length = length+1;
    }

    public void addIndex(int indx, int value){
        if(start == null || length-1<indx)
            throw new ArrayIndexOutOfBoundsException("");

        Node temp = start;
        for(int i=0;i<indx;i++){
            temp = temp.nptr;
        }

        temp.value = value;
    }

    public int remove() throws Exception {
        if(end==null)
            throw new IllegalAccessException("No element in linked list");
        Node deleteNode = end;
        end = end.nptr;
        int value = deleteNode.value;
        deleteNode.nptr = null;
        deleteNode = null;
        return value;
    }

    public int removeIndex(int indx) throws Exception {

        Node temp = start;
        if(start == null)
            throw new IllegalAccessException("No element in linked list");
        if(indx == 0) {
            start = start.nptr;
            temp.nptr = null;
            temp =null;
        }

        for(int i=0; i<indx-1; i++){
            temp = temp.nptr;
        }

        int value = temp.nptr.value;
        Node deleted = temp.nptr;
        temp.nptr = temp.nptr.nptr;
        temp.nptr = null;
        temp = null;
        return value;
    }

}

class Node{

    Node nptr;
    int value;

    public Node(int val) {
        value = val;
        nptr = null;
    }
}