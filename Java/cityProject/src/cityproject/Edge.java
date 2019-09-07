
package cityproject;

//Array of edges sorted by source 
public class Edge {

    City  source;		// the name of the source vertex;
    City  destination;	// the name of the destination vertex;
    int length;			// the length of the edge;

    Edge() {
    }

    Edge(City s, City d, int l) {
        this.source = s;
        this.destination = d;
        this.length = l;
    } // end Edge(...)

    public void setSource(City s) {
        this.source = s;
    }  // end setSource

    public void setDestination(City d) {
        this.destination = d;
    } // end setDestination

    public void setLength(int l) {
        this.length = l;
    } // end setLength

    public City getSource() {
        return this.source;
    }  // end getSource

    public City getDestination() {
        return this.destination;
    } // end getDestination

    public int getLength() {
        return this.length;
    } // end getLength

    public String toString() {
        return this.source + " to " + this.destination + ": " + this.length;
    }

}  //end class edge
