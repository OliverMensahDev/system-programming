public class UniGraph{
   private int NUM_VERTICES;
   private int NUM_EDGES;
   private Set<Integer>[] adjecencySet
     
   public UniGraph(Scanner in){
     this.NUM_VERTICES = in.nextInt();
     adjacencySet = (Set<Integer>[]) new HashSet[NUM_VERTICES];
     
     for(int vertex = 0; vertex < NUM_VERTICES; vertex++){
       adjacencySet[vertex] = new new HashSet<Integer>();
     }
     
     int numEdges = in.nextInt();
     for(int i = 0; i< numEdges; i++){
       int vertex = in.nextInt();
       int nextVertex = in.nextInt();
       addEdgeToGraph(vertex, nextVertex);
     }
   }
   
   public int numVertices(){return NUM_VERTICES;}
   
   public int numEdges(){ return NUM_EDGES;}
   
   public void addEdgeToGraph(int vertex, int nextVertex){
     NUM_EDGES++;
     adjecencySet[vertex].add(nextVertex);
     adjecencySet[nextVertex].add(vertex);
     
   }
   
   public Iterable<Integer> findAdjacentNodes(int vertex){
     return adjacencySet[vertex]
   }
   
   
     
     