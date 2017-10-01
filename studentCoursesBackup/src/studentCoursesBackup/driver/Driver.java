package studentCoursesBackup.driver;
import studentCoursesBackup.BST;
import studentCoursesBackup.Node;
public class Driver{
	public static void main(String args[]){
		BST bst = new BST();
		Node n1 = new Node(0001, "A");
		Node n2 = new Node(1234, "B");
		Node n3 = new Node(4567, "B");
		Node n4 = new Node(0000, "C");
		Node n5 = new Node(0000, "D");
		bst.insert("0001:A");
		bst.insert("1234:B");
		bst.insert("4567:B");
		bst.insert("0000:C");
		bst.insert("0000,D");
		bst.inorder();
		bst.delete("0001:A");
		//System.out.println(bst.search(n1, 0001));
		System.out.println();
		bst.inorder();
	}
}
