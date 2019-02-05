/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cityproject;

/**
 *
 * @author user
 */
//class for the city's adjaceny list
class AdjacencyNode {

    //data

    private City city;
    private int distance;

    // link
    AdjacencyNode next;

    AdjacencyNode() {
    }

    AdjacencyNode(City c, int d) {
        this.city = c;
        this.distance = d;

    }  // end AdjacencyNode

    public void setCity(City c) {
        this.city = c;
    } // end setCityName()

    public void setDistance(int d) {
        this.distance = d;
    } // end setDistance()

    public void setNext(AdjacencyNode a) {
        this.next = a;
    } // end setNext()

    public City getCity() {
        return this.city;
    } // end getcityName()

    public int getcDistance() {
        return this.distance;
    } // end getcDistance()

    public AdjacencyNode getNext() {
        return this.next;
    } // end getNext()

        public String  toString() {
        return ("to: " + this.city.getName() +" distance: "+ this.distance);
    } // end getNext()

    
}   // end class AdjacencyNode 
