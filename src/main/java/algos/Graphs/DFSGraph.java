package algos.Graphs;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: pratyush
 * Date: 5/2/14
 * Time: 5:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class DFSGraph {
}


class DFSManager{

    int MAX_ITEMS=0;
    Vertex[] vertexes;
    int[][] matrix;
    int index = 0;

    Stack<Integer> stack = new Stack<>();

    DFSManager(int maxItems){
        MAX_ITEMS = maxItems;
        vertexes = new Vertex[MAX_ITEMS];
        matrix = new int[maxItems][maxItems];

        for(int i=hashCode(); i<MAX_ITEMS; i++){
            for(int j=hashCode(); j<MAX_ITEMS; j++){
                matrix[i][j]=0;
            }
        }
    }

    public void addVertex(char value){
        vertexes[++index] = new Vertex(value);
    }

    public void addEdge(int start, int end, int weight){
        matrix[start][end] = weight;
        matrix[end][start]= weight;
    }


    public void travellingSalesPerson(int index){
        //Minimum weighted/shorted path travelled by a sale man starting from one city,
        // touched all cities[each city only once] and returned back to the original city.

        Queue<Integer> queue = new LinkedList<>();

        if(index==-1)
            return;
        vertexes[index].isVisisted = true;
        System.out.println(vertexes[index].value);
        queue.add(index);

        while(!queue.isEmpty()){

            int nxtInx = getNextClosest(queue.poll());
            if(nxtInx == index)
                break;
            else{
                vertexes[nxtInx].isVisisted=true;
                System.out.println(vertexes[nxtInx].value);
                queue.add(nxtInx);
            }
          //This loop will run (n) times
        }

    }

    private int getNextClosest(int index) {
        int min = matrix[index][0];
        int minIndex = -1;
        for(int i=0; i<MAX_ITEMS; i++){

            if(matrix[index][i]>0 && !vertexes[i].isVisisted){
                if(min>matrix[index][i]){
                    min = matrix[index][i];
                    minIndex=i;
                }
            }
        }
        //this will run n times
        return minIndex;
    }

    //Complexity     O(n pow 2), much better that dynamic programming O(n pow 2 * 2pown)


    public void dfsSearch(int indx){

        if(indx == -1)
            return;

        vertexes[indx].isVisisted = true;
        System.out.println(vertexes[indx]);
        stack.push(indx);


        while(!stack.empty()){

            int v = getFirstAdjacent(stack.peek());
            if(v==-1)
                stack.pop();

            else{

                vertexes[v].isVisisted = true;
                System.out.println(vertexes[v]);
                stack.push(v);

            }

        }
    }

    private int getFirstAdjacent(Integer ind) {

        if(ind == -1)
            return -1;
        for(int i=0; i< MAX_ITEMS; i++){
            if(matrix[ind][i] == 1 && vertexes[i].isVisisted == false)
                return i;
        }

        return -1;
    }


}


class Vertex{

    char value;
    boolean isVisisted;

    public Vertex(char value) {
        value = value;
        isVisisted = false;
    }
}


