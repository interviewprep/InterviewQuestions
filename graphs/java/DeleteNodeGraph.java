package graphs.java;

import java.util.*;

/*
* Find if there is a node such that deleting it will make the destination unreachable from source. We call such a node key node.
  TODO: Add a cache to decrease time complexity
*/

public class DeleteNodeGraph{
    
    public static int dfs(int array[][], int node, int dest, int []visited ) {
        visited[node] = 1;
        // node is directly connected to destination, then from that node to the destintion it is a key node. 
        if (array[node][dest] == 1) {
          return node;    
        }
        
        int result = -1;
        Set<Integer> resultSet = new HashSet<Integer>();
        
        for(int i =0; i<array[node].length; i++) {
            if (array[node][i] == 1 && visited[i] == 0) {
               int temp =   dfs(array, i, dest, visited);
               if (temp == -1) continue;
               resultSet.add(temp);
            }
            
        }
        // if there is more than one key node from different edges, none of them are key nodes. 
        // set current nodes as key node . 
        if (resultSet.size()>1) result = node;
        // else propage the key node. 
        else if (resultSet.size()==1) result = resultSet.iterator().next();
            
        visited[node] = 0;
        return result;
    }
     public static void main(String []args){
       
       
/*              3 -- 1 -- 4
 *            /   \     /
 *          0        2
 */
         
        int array2[][] = {{0, 0, 0, 1, 0},
                          {0, 0, 0, 1, 1},
                          {0, 0, 0, 1, 1},
                          {1, 1, 1, 0, 0},
                          {0, 1, 1, 0, 0}};
        
        int visited[] = new int[array2.length]; 
        int source = 0;
        int dest = 4;
        int result = dfs(array2, source, dest, visited);
        // check if there is a key node other than source. 
        if (result == source) {
            System.out.println("-1");
        } else {
          System.out.println("Deleting node " + result + "will disconnect dest");
        }

     }
}
