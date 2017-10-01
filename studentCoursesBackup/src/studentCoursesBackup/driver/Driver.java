package studentCoursesBackup.driver;
import studentCoursesBackup.BST;
import studentCoursesBackup.Node;
import studentCoursesBackup.FileProcessor;
import studentCoursesBackup.Results;
import studentCoursesBackup.TreeBuilder;
public class Driver{
	public static void main(String args[]){
		if(args == null || args.length != 2)
			throw new IllegalArgumentException("Two arguments are required, input.txt and output.txt");
		else{
		Results results = new Results(args[1]);
		BST bst = new BST();
		BST backup1 = new BST();
		BST backup2 = new BST();
		TreeBuilder tb = new TreeBuilder(args[0], bst, backup1, backup2);
		tb.populate();
		/*Node n1 = new Node(0001, "A");
		Node n2 = new Node(1234, "B");
		Node n3 = new Node(4567, "B");
		Node n4 = new Node(0000, "C");
		Node n5 = new Node(0000, "D");
		bst.insert("0001:A");
		bst.insert("1234:B");
		bst.insert("8079:B");
		bst.insert("0000:C");
		bst.insert("0000,D");
		bst.inorder();
		bst.delete("0000:D");*/
		//System.out.println(bst.search(n1, 0001));
		bst.delete(new Node(8923, "F"));
		System.out.println();
		bst.inorder();
		System.out.println();
		backup1.inorder();
		System.out.println();
		backup2.inorder();

		}
	}
}
