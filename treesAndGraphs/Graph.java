import java.io.*;
import java.util.*;

class Graph
{
    private int NumNodes;
    private LinkedList<Integer> adjList[];

    public Graph (int numNodes)
    {
        this.NumNodes = numNodes;
        adjList = new LinkedList[numNodes];

        for(int i=0; i<this.NumNodes; i++)
        {
            adjList[i] = new LinkedList();
        }
    }

    public void addEdge (int u, int v)
    {
        adjList[u].add(v);
    }

    private void topologicalSortHelper (Stack s, int u, boolean[] visited)
    {
        visited[u] = true;
        Integer i;

        Iterator<Integer> it = this.adjList[u].iterator();

        while(it.hasNext())
        {
            i = it.next();
            if (!visited[i])
            {
                topologicalSortHelper(s, i, visited);
            }
        }    
        
        s.push(new Integer(u));   
    }

    public void topologicalSort ()
    {
        Stack s = new Stack();
        boolean[] visited = new boolean[this.NumNodes];

        for(int i=0; i<visited.length; i++)
        {
            visited[i] = false;
        }

        // perform topological sort
        for(int i=0; i<this.NumNodes; i++)
        {
            if (visited[i] == false)
            {
                topologicalSortHelper(s, i, visited);
            }
        }

        while(! s.empty())
        {
            System.out.print(s.pop() + ", ");
        }
    }

}