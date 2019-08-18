// Generate all paths in a grid from source to destination if you can move only left or down, and can only traverse non zero cells. 


// Recursively generate all possible paths

// can optimize by memoizing nodes that have no valid path and skipping them instead of exploring them again and again. 

public class GeneratePaths{
    
    public static void generatePaths(int x1, int y1, int x2, int y2, String path, int[][]array ) {
        
        if (x1 == x2 && y1 == y2) {
            path = path + "," + "(" + x1 + "," + y2 + ")";
            System.out.println(path.substring(1));
        }
        if (x1>=array.length || y1 >= array.length || array[x1][y1] ==0) {
          return;
        }
        
        //use StringBuilder or a list to avoid string copy
        
        generatePaths(x1 + 1, y1, x2, y2, path + "," + "(" + x1 + "," + y1 + ")", array);
        generatePaths(x1, y1 + 1, x2, y2, path + "," + "(" + x1 + "," + y1 + ")", array);
        
        
    }
    

     public static void main(String []args){
         int grid[][] = { {1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
         generatePaths(0,0, 2,2,"", grid);
     }
}
