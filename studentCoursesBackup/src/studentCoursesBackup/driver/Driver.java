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
		bst.insert(n1);
		bst.insert(n2);
		bst.insert(n3);
		bst.insert(n4);
		bst.insert(n5);
		bst.inorder();
	}
}
