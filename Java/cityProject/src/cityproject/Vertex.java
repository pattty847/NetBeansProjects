
package cityproject;


    
public class Vertex {

    private String name; 	// name of the city
    private int x;  		// city's x-coordinate for drawing
    private int y;  		// city's y-coordinate for drawing

    Vertex() {
    }  // end Vertex()

    Vertex(String n, String s, int x, int y) {
        this.name = n;
        this.x = x;
        this.y = y;
    }  // end Vertex(...)

    public void setName(String n) {
        this.name = n;
    } // end setName()

    public void setX(int x) {
        this.x = x;
    } // end setX()

    public void setY(int y) {
        this.y = y;
    } // end setY()

    public String getName() {
        return this.name;
    } // end getName()

    public int getX() {
        return this.x;
    } // end getX()

    public int getY() {
        return this.y;
    } // end getY()

    public String toString() {
        return (this.name + " " + " " + this.x + " " + this.y);
    } // end toString()

} // end class Vertex


