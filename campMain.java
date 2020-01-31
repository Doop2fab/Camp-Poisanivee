import java.io.*;
import java.util.*;
/**@author Andrew Spores */
class campMain 
{
    /**prints out commands for help */
    public static void getHelp() {
        System.out.println("H   Help: print a list of commands");
        System.out.println("E name age sex  Enroll a new camper (insert)");
        System.out.println("W name	Withdraw a camper (delete)");
        System.out.println("D name	Display the age and gender of a camper");
        System.out.println("A	Print the average age of the campers");
        System.out.println("L	List all campers names in alphabetical order");
        System.out.println("S	Print the number of boy and girl campers");
        System.out.println("P	List all campers names in preorder");
        System.out.println("Q	Quit\n");
    }

    /**
     * @param fin open scanner w/ file
     * @return number of lines in file
     */
    public static int getNumLines(Scanner fin) {
        int numLines = 0;
        while (fin.hasNextLine()) {
            numLines++;
            fin.nextLine();
        }
        return numLines;
    }
    public static void main(String[] args) throws IOException 
    {
        System.out.println("Welcome to Camp Posanivee!!\n");
        String command;
        String name;
        String sex;
        int age;
        Scanner fin = new Scanner(new FileReader("camp.txt"));
        int numlines = getNumLines(fin);
        fin = new Scanner(new FileReader("camp.txt"));

        BST binaryTree = new BST();

        for (int i = 0; i < numlines; i++) {
            command = fin.next();
            command = command.toUpperCase(); //makes it so commands are not case sensitive
            if (command.equals("H")) { //displays all commands
                System.out.println("Command: " + command);
                getHelp();
                fin.nextLine();
            }
            if (command.equals("E")) { //adds camper into tree
                name = fin.next();
                age = fin.nextInt();
                sex = fin.next();
                System.out.println("Command: " + command + " " + name + " " + age + " " + sex);
                System.out.println("New camper added.\n");
                binaryTree.insert(new Camper(name, age, sex));
                fin.nextLine();
            }
            if (command.equals("W")) { //withdraws camper from tree
                name = fin.next();
                System.out.println("Command: " + command + " " + name);
                System.out.println("Camper withdrawn.\n");
                binaryTree.delete(binaryTree.lookup(new Camper(name, 0, "")));
                fin.nextLine();
            }
            if (command.equals("D")) { //displays specific camper info
                name = fin.next();
                System.out.println("Command: " + command + " " + name);
                Camper inFront = (Camper) binaryTree.lookup(new Camper(name, 0, ""));
                System.out.println("  Name: " + inFront.getName() + "\n  Age: " + inFront.getAge() + "\n  Sex: "
                        + inFront.getSex() + "\n");
                fin.nextLine();
            }
            if (command.equals("A")) { //displays average age of all campers
                System.out.println("Command: " + command);
                if (!binaryTree.isEmpty()) {
                    double totalAge = 0;
                    double count = binaryTree.size();
                    binaryTree.reset(BST.INORDER);
                    while (binaryTree.hasNext()) {
                        Camper inFront = (Camper) binaryTree.getNext();
                        totalAge = totalAge + inFront.getAge();
                    }
                    System.out.println("Average Age = " + totalAge / count + "\n");
                } else {
                    System.out.println("There are no campers!\n");
                }
                fin.nextLine();
            }
            if (command.equals("L")) { //lists campers alphabetically
                System.out.println("Command: " + command);
                System.out.println("Alphabetical list of campers:");
                binaryTree.reset(BST.INORDER);
                while (binaryTree.hasNext()) {
                    Camper inFront = (Camper) binaryTree.getNext();
                    System.out.println(inFront.getName());
                }
                System.out.println("");
                fin.nextLine();
            }
            if (command.equals("S")) { //displays number of male and female campers
                System.out.println("Command: " + command);
                int boys = 0;
                int girls = 0;
                binaryTree.reset(BST.INORDER);
                while (binaryTree.hasNext()) {
                    Camper inFront = (Camper) binaryTree.getNext();
                    if (inFront.getSex().equals("M")) {
                        boys++;
                    } else {
                        girls++;
                    }
                }
                System.out.println("Camper count by gender:\n" + "  boys: " + boys + "\n  girls: " + girls + "\n");
            }
            if (command.equals("P")) { //displays campers in preorder traversal
                System.out.println("Command: " + command);
                binaryTree.reset(BST.PREORDER);
                System.out.println("Preorder Traversal:");
                while (binaryTree.hasNext()) {
                    Camper inFront = (Camper) binaryTree.getNext();
                    System.out.println(inFront.getName());
                }
                System.out.println("");
                fin.nextLine();
            }
            if (command.equals("Q")) { //quits program
                System.out.println("Command: " + command + "\nEnd of program.\nBring plenty of calomine!");
                System.exit(0);
            }
        }
    }
}