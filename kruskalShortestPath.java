/*
FRECKLES- problem from Kattis
In an episode of the Dick Van Dyke show, little Richie connects the freckles on 
his Dad’s back to form a picture of the Liberty Bell. Alas, one of the freckles 
turns out to be a scar, so his Ripley’s engagement falls through.

Consider Dick’s back to be a plane with freckles at various (x,y) locations. 
Your job is to tell Richie how to connect the dots so as to minimize the amount
of ink used. Richie connects the dots by drawing straight lines between pairs, 
possibly lifting the pen between lines. When Richie is done there must be a 
sequence of connected lines from any freckle to any other freckle.

Input
The input begins with a single positive integer on a line by itself indicating 
the number of the cases (at most 20) following, each of them as described below.
This line is followed by a blank line, and there is also a blank line between 
two consecutive inputs.

The first line of test case contains 0<n≤1000, the number of freckles on Dick’s
back. For each freckle, a line follows; each following line contains two real 
numbers indicating the (x,y) coordinates of the freckle. The coordinates will be
at most 100000 in absolute value.

Output
For each test case, your program should print a single real number to two 
decimal places: the minimum total length of ink lines that can connect all the 
freckles. Put a blank line between outputs for consecutive test cases.
*/
package freckles;

import java.util.Scanner;
import java.util.Arrays;

/**
 * @author Nathan Garrett
 */
public class Freckles {
    //This opens up with an uninitialized node for edges and a global variable for vertices
    static int vertices;
    static Edge[]  edges;
    
    public static void main(String [] args) throws  Exception {
        
        Scanner keyboard = new Scanner(System.in);//main input
        
        int tests  = keyboard.nextInt();
        while (tests--  >0){
            
            int elements;
            
            vertices = keyboard.nextInt();
            //next gives a count of the total edges, given that all vertices are interconnected
            edges = new Edge[(vertices *(vertices - 1))/2];
            
            double x[] = new double[vertices];
            double y[] = new double[vertices];
            
            for (int  i = 0 ; i < vertices ; i++){
                //capturing all the input points
                x[i] = keyboard.nextDouble();
                y[i] = keyboard.nextDouble();
            }
            
            elements = 0;
            //creates a graph to work with
            for (int i = 0 ; i <= vertices; i++){
                for (int j = i + 1 ; j < vertices ; j++){
                    edges[elements++] = new Edge(i, j, edgeLength(x[i], y[i], x[j], y[j]));
                }
            }
            //Gets the machine(kruscode) running and delivers the final result
            //in an output with two decimal places.
            System.out.printf("%.2f\n", krusCode());
            
            if (tests > 0){
                System.out.println("");
            }
        }
        System.exit(0);//buh bye
    }
    /*
    One of the cool little things I learned while working on this project the 
    other day was the Comparable command. I spent 4 days pounding my head 
    trying to figure out a way to compare edge lengths (I'm not that bright),
    but I humbled down and did some research and found that if I pulled my Edge
    array out of the krusCode method and put it above the Main method, then
    implemented this method to compare two points, I could capture points p and 
    q, and compare their edge weights to return the shortest paths between each
    other.
    */
    static class Edge implements Comparable<Edge>{
        
        int origin;
        int dest; 
        double weight;

        Edge(int pointP, int pointQ, double w){
            
            origin = pointP; 
            dest = pointQ; 
            weight = w;
        }
        /*
        This method compares weights between a chosen point and its possible 
        destinations.  Picks the shortest path, then moves on to the next vertex
        */
        @Override
        public int compareTo(Edge edge){
            
            if(weight != edge.weight){
                if(weight - edge.weight > 0){
                    return 1;
                }
                else{
                    return -1;
                }
            }
            else if(origin != edge.origin){
                
                return origin - edge.origin;
            }
            else{
                return dest - edge.dest;
            }
        }
    }
    /*
    Simple method that uses the pythagorean theorem to determine the length of
    the edges between vertices(hypotenuse). 
    */
    public static double edgeLength (double x1 , double y1 , double x2 , double y2){
    
        return  Math.hypot((x1 - x2),(y1 - y2));
    
    }

    /*
    Big ole' class I wrote to find the set of an element, then join two sets x
    and y and so on until all the disjoint sets are combined.  I learned about
    path compression over the week and was excited to try it out with this one.
    */
    static class Union{
        
        int setCount;//how many disjointed sets there are left, unless it's 1.
        int[] parent;  
        int[] setSize;
        int[] rank;
        
        public Union(int num){
            
            setCount = num;
            parent = new int[num];
            setSize = new int[num];
            rank = new int[num];
            
            for (int i = 0; i < num; i++){
            
                parent[i] = i; 
                setSize[i] = 1; 
            }
        }

        public int findRecurse(int i){
            
            if (parent[i] == i){ 
                return i;
            }
            else{ 
                return parent[i] = findRecurse(parent[i]);
            }
        }
        /*
        This method combines(or unionizes...unions... er they get attached to each 
        other) each set by rank.  Rank being smaller depth trees get attached to
        the root of the deepest tree.  
        */
        public void setCombine(int i, int j){
            
            if (isSame(i, j))
                return;
            
            int x = findRecurse(i); 
            int y = findRecurse(j);
            setCount--;
            
            if (rank[x] > rank[y]){
                parent[y] = x;
                setSize[x] += setSize[y];
            }
            else{
                if(rank[x] == rank[y]){
                    rank[y]++;
                }
                
                parent[x] = y;
                setSize[y] += setSize[x];  
            }
        }
        
        public int sizeOfSet(int size){
            return setSize[findRecurse(size)];
        }
     
        public Boolean isSame(int i, int j){
            return findRecurse(i) == findRecurse(j);
        }
    }
    /*
    Here's the method to build the Minimum SPanning Tree for the Kruskal
    algorithm.  The minSpan variable will hold the value of the min cost path.
    The Arrays.sort call will arrange all the edges in non decreasing order.
    */
    static double krusCode(){
        
        double minSpan;
        Union build = new Union(vertices);
        Arrays.sort(edges);
        
        minSpan = 0.00;//woops needed to initialize it to work.
        for(int index = 0 ; index < edges.length && build.setCount > 1; index++){
            
            //this holds the min tree
            Edge edge = edges[index];
            //this adds together all the shortest connected paths into one sum.
            if (!build.isSame(edge.origin, edge.dest)){
                
                minSpan += edge.weight;
                build.setCombine(edge.origin, edge.dest);
            }
        }
        //the FINAL answer :)
        return minSpan;
    }
}
