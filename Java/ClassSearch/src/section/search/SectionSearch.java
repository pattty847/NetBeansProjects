package section.search;

/**
 * @author Patrick McDermott
 * 
 * This program is a short example of the use of Objects. It will load 20 Section classes
 * to an array and give the user the ability to search the array for their class through
 * the CRN. 
 */


public class SectionSearch {

    
    // Main methods on functions are to call the following methods from "SectionList"
    // which are noted in that class file. 
    public static void main(String[] args) {
        SectionList.loadSection();
        
        SectionList.printSections();
        
        SectionList.searchSections();
    }
    
}
