import java.io.*;
import java.util.*;

class BSTMain
{
	public static void main(String [] args) throws IOException
	{
		Scanner file=new Scanner(new FileReader("fishfile.txt"));
		int fishcount=file.nextInt();
		
		// line of fish
		//Queue Q=new QueueDonut(100);
		BST Groot=new BST();
		
		// load the fish
		for(int i=0; i<fishcount; i++)
			Groot.insert(new Fish(file));
		
		Groot.print();
		
		Fish lunch=(Fish)Groot.delete(new Fish("","","",4));
		System.out.println("Deleted "+lunch);
		
		System.out.println("Fish with 5 fins: "+
		  Groot.lookup(new Fish("","","",5)));
		
		Groot.print();
		
		System.out.println("****Preorder:****");
		Groot.reset(BST.PREORDER);
		while(Groot.hasNext()) System.out.println(Groot.getNext());
		
		System.out.println("****Inorder:****");
		Groot.reset(BST.INORDER);
		while(Groot.hasNext()) System.out.println(Groot.getNext());
		
		System.out.println("****Postorder:****");
		Groot.reset(BST.POSTORDER);
		while(Groot.hasNext()) System.out.println(Groot.getNext());
		
	}
}
