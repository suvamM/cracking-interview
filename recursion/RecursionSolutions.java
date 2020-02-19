import java.util.*;

public class RecursionSolutions
{
    private ArrayList<ArrayList<Integer>> getAllSubsets (ArrayList<Integer> set, int index)
    {
        ArrayList<ArrayList<Integer>> allsubsets;

        if (index == set.size())
        {
            // base case, create and add empty set
            allsubsets = new ArrayList<ArrayList<Integer>>();
            ArrayList<Integer> subset = new ArrayList<Integer>();
            allsubsets.add(subset);
        }
        else
        {
            allsubsets = getAllSubsets(set, index + 1);
            int item = set.get(index);

            ArrayList<ArrayList<Integer>> moreSubsets = new ArrayList<ArrayList<Integer>>();
            for (ArrayList<Integer> subset : allsubsets)
            {
                ArrayList<Integer> newsubset = new ArrayList<Integer>();
                newsubset.addAll(subset);
                newsubset.add(item);
                moreSubsets.add(newsubset);
            }
            allsubsets.addAll(moreSubsets);
        }
        return allsubsets;
    }

    // Takes a set of integers, and prints the powerset
    private void PrintAllSubsets ()
    {
        ArrayList<Integer> set = new ArrayList<Integer>();
        
        for(int i=0; i<4; i++)
        {
            set.add(i);
        }

        ArrayList<ArrayList<Integer>> allsubsets = getAllSubsets(set, 0);

        for (ArrayList<Integer> subset : allsubsets)
        {
            System.out.print("{ ");
            for (int x : subset)
            {
                System.out.print(x + ", ");
            }
            System.out.print("}\n");
        }
    }

    public static void main(String[] args)
    {
        // print powerset of set of integers
        RecursionSolutions r = new RecursionSolutions();
        r.PrintAllSubsets();
    }
}

