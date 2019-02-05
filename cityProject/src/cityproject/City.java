package cityproject;

class City extends Vertex {

    // added properties
    private boolean visited = false;
    private int bestDistance = Integer.MAX_VALUE;   //maximum value and integer can have
    private City immediatePredecessor;
    private AdjacencyNode adjacencyListHead;  // link to first node in adjacency list

    
    // city constructor
    City() {}
    
    
//added methods
    public void setVisited(boolean v) {
        this.visited = v;
    } // end setVisited()

    public void setBestDistance(int b) {
        this.bestDistance = b;
    } // end setBestDistance()

    public void setImmediatePredecessor(City c) {
        this.immediatePredecessor = c;
    } // end setImmediatePredecessor()

    public void setAdjacencyListHead(AdjacencyNode a) {
        this.adjacencyListHead = a;
    } // end setAdjacencyListHead()
    
    public boolean getVisited() {
        return this.visited;
    } // end getVisited()

    public int getBestDistance() {
        return this.bestDistance;
    } // end getBestDistance()

    public City getImmediatePredecessor() {
        return this.immediatePredecessor;
    } // end getImmediatePredecessor()

    public AdjacencyNode getAdjacencyListHead()  {
        return this.adjacencyListHead;
    } // end getAdjacencyListHead()
    
    
} // end class MyCity
