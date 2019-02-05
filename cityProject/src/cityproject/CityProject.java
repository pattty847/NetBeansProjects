package cityproject;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class CityProject {

    public static void main(String[] args) {

        City[] cities = new City[200]; //array of cities (Vertices) max = 200
        for (int i = 0; i < cities.length; i++) {
            cities[i] = new City();
        }

        Edge[] links = new Edge[2000];// array of links  (Edges)  max = 2000
        for (int i = 0; i < links.length; i++) {
            links[i] = new Edge();
        }

        int cityCount; //    actual number of cities
        int linkCount; //    actual number of links

        // load cities into an array from a datafile
        cityCount = readCities(cities);

        // load links into an array from a datafile
        linkCount = readLinks(links, cities);

        // create the adjacency list for each city based on the link array
        createAdjacencyLists(cityCount, cities, linkCount, links);

        // print adjacency lists for all cities
        PrintAdjacencyLists(cityCount, cities);

    } // end main
    //************************************************************************

    // method to read city data into an array from a data file
    public static int readCities(City[] cities) {

        int count = 0; // number of cities[] elements with data

        String[][] cityData = new String[123][3]; // holds data from the city file
        String delimiter = ",";                   // the delimiter in a csv file
        String line;                              // a String to hold each line from the file
        String fileName = "cities.csv";                          // the file to be opened  

        try {
            // Create a Scanner to read the input from a file
            Scanner infile = new Scanner(new File(fileName));

            /* This while loop reads lines of text into an array. it uses a Scanner class 
             * boolean function hasNextLine() to see if there another line in the file.
             */
            while (infile.hasNextLine()) {
                // read the line 
                line = infile.nextLine();

                // split the line into separate objects and store them in a row in the array
                cityData[count] = line.split(delimiter);
                
                // read data from the 2D array into an array of City objects
                cities[count].setName(cityData[count][0]);
                cities[count].setX(Integer.parseInt(cityData[count][1]));
                cities[count].setY(Integer.parseInt(cityData[count][2]));

                count++;
            }// end while

            infile.close();

        } catch (IOException e) {
            // error message dialog box with custom title and the error icon
            JOptionPane.showMessageDialog(null, "File I/O error:" + fileName, "File Error", JOptionPane.ERROR_MESSAGE);
        }
        return count;

    } // end loadCities()
    //*************************************************************************

    // method to read link data into an array from a data file
    public static int readLinks(Edge[] links, City[] cities) {
        int count = 0; // number of links[] elements with data

        String[][] CityLinkArray = new String[687][3]; // holds data from the link file
        String delimiter = ",";                       // the delimiter in a csv file
        String line;				      // a String to hold each line from the file

        String fileName = "links.csv";                // the file to be opened  

        try {
            // Create a Scanner to read the input from a file
            Scanner infile = new Scanner(new File(fileName));

            /* This while loop reads lines of text into an array. it uses a Scanner class 
             * boolean function hasNextLine() to see if there another line in the file.
             */
            while (infile.hasNextLine()) {
                // read the line 
                line = infile.nextLine();
                

                // split the line into separate objects and store them in a row in the array
                CityLinkArray[count] = line.split(delimiter);

                // read link data from the 2D array into an array of Edge objects
                // set source to vertex with city name in source column
                links[count].setSource(findCity(cities, CityLinkArray[count][0]));
                // set destination to vertex with city name in destination column
                links[count].setDestination(findCity(cities, CityLinkArray[count][1]));
                //set length to integer valuein length column
                links[count].setLength(Integer.parseInt(CityLinkArray[count][2]));

                count++;

            }// end while

        } catch (IOException e) {
            // error message dialog box with custom title and the error icon
            JOptionPane.showMessageDialog(null, "File I/O error:" + fileName, "File Error", JOptionPane.ERROR_MESSAGE);
        }
        return count;
    } // end loadLinks()
    //*************************************************************************

    // emthod to find the City onject with the given city name
    public static City findCity(City[] cities, String n) {
        int index = 0;  // loop counter
        // go through the cities array until the name is found
        // the name will be in the list

        while (cities[index].getName().compareTo(n) != 0) {

            index++;
        }// end while()
        return cities[index];

    } // end  findCity()

// method to create an adjacency lists for each city
    public static void createAdjacencyLists(int cityCount, City[] cities, int linkCount, Edge[] links) {

        AdjacencyNode temp = new AdjacencyNode();

        // iterate city array
        for (int i = 0; i < cityCount; i++) {

            //iterate link array
            for (int j = 0; j < linkCount; j++) {
                // if the currentl link's source is the current city
                if (links[j].getSource() == cities[i]) {

                    /* create a node for the link and inseert it into the adjancency list
                     * as the new head of the list. 
                     */
                    // temporarily store the current value of the list's head
                    temp = cities[i].getAdjacencyListHead();
                    //create a new node
                    AdjacencyNode newNode = new AdjacencyNode();
                    // add city and distance data
                    newNode.setCity(links[j].getDestination());
                    newNode.setDistance(links[j].getLength());
                    // point newNode to the previous list head
                    newNode.setNext(temp);

                    // set the new head of the list to newNode
                    cities[i].setAdjacencyListHead(newNode);

                }  // end if
            } // end for j
        } // end for i

    } // end createAdjacencyLists()

    // method to print adjacency lists
    public static void PrintAdjacencyLists(int cityCount, City[] cities) {

        System.out.println("List of Edges in the Graph of Cities by Source City");
        // iterate array of cities
        for (int i = 0; i < cityCount; i++) {

            // set current to adjacency list for this city    
            AdjacencyNode current = cities[i].getAdjacencyListHead();

            // print city name
            System.out.println("\nFrom " + cities[i].getName());

            // iterate adjacency list and print each node's data
            while (current != null) {
                System.out.println("\t"+ current.toString());
                current = current.getNext();
            } // end while (current != null) 

        }   // end for i 

    } // end PrintAdjacencyLists()

} // end class cityProject
