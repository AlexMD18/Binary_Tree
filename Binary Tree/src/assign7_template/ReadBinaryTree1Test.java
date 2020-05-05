/** ReadBinaryTree1Test.java
 *Alexandro Drogo
 * 11/04/2019
 * CIS 2168
 * Description: Reads a file and the program creates a binary tree in post, in, and pre-order. it also finds the size and depth of the tree.
 */
package assign7_template;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 *
 * @author Cindy
 */
public class ReadBinaryTree1Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BinaryTree1<String> binaryTree1 = new BinaryTree1<>();

        try {
            //Create a Scanner for reading from the data file WordBT_InStoredFormat.txt
            Scanner scanner = new Scanner(new File("WordBT_InStoredFormat.txt"));
            //call the static method readBinaryTree1 to 
            //create the binary tree using data read from file: WordBT_InStoredFormat.txt
            binaryTree1 = BinaryTree1.readBinaryTree1(scanner);
            System.out.println("Origional Tree");
            System.out.println(binaryTree1.toString());

            //call each method you implemented and verify the result.
            System.out.println("Depth: ");
            System.out.println((binaryTree1.depth()) + "\n");

            System.out.println("Size: ");
            System.out.println((binaryTree1.size()) + "\n");

            System.out.println("Pre-Ordered Traversal: ");
            System.out.println((binaryTree1.preOrderTraverse()) + "\n");

            System.out.println("In-Ordered Traversal: ");
            System.out.println((binaryTree1.inOrderTraverse()) + "\n");

            System.out.println("Post-Ordered Traversal: ");
            System.out.println((binaryTree1.postOrderTraverse()) + "\n");

            //the code below was given in the lectures.
            //create a Scanner object that is associated with the file Fig_6_12.txt.
            //Scanner input = new Scanner(new File("Fig_06_12.txt"));
            //call the static method readBinaryTree1 to read data in Fig_6_12.txt
            //and construct the corresponding binary tree
            //and assign the reference to this tree to binaryTree1.
            //binaryTree1 = BinaryTree1.readBinaryTree1(input);
            //close the scanner object.
            //input.close();
            scanner.close();
            //print the string, which is the preorder traversal sequence of data stored in binaryTree1.
            //System.out.println(binaryTree1.toString());
        } catch (FileNotFoundException e) { //handle the case when Fig_6_12.txt is not found.
            e.printStackTrace();    //Print the error stack: this exception, and its backtrace for the cause of this exception.
            System.exit(1);         //terminate this program with the status code 1, indicating abnormal termination.
        }
    }

}
