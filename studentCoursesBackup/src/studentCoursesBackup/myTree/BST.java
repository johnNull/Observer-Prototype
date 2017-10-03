package studentCoursesBackup;
import java.lang.StringBuilder;
public class BST{
	private Node root;
	
	/**
	 * Default constructor for binary search tree.
	 */
	public BST(){
		root = null;
	}
	
	/**
	 * Searches and returns node with matching bnumber.
	 * @param root    Top level Node in tree/subtree.
	 * @param bnumber Key to be searched for.
	 * @return Node   with matching bnumber.
	 */	
	public Node search(Node root, int bnumber){
		if(root == null || root.bnum == bnumber)
			return root;
		if(root.bnum > bnumber)
			return search(root.left, bnumber);
		if(root.bnum < bnumber)
			return search(root.right, bnumber);
		else
			return null;
	}

	/**
	 * Calls recursive insert to insert node into proper location.
	 * @param n Node to be inserted.
	 */
	public void insert(Node n){
		root = insert(root, n);
	}

	/**
	 * Recursively searches for spot to insert node based on bnumber.
	 * http://www.geeksforgeeks.org/binary-search-tree-set-1-search-and
	 * -insertion/.
	 * @param root Top level Node in tree/subtree.
	 * @param n    Node to be inserted.
	 * @return     Next Node in the path from root to the insert Node.
	 */
	Node insert(Node root, Node n){
		if(root == null)
			root = n;
		if(root.bnum > n.bnum)
			root.left = insert(root.left, n);
		if(root.bnum < n.bnum)
			root.right = insert(root.right, n);
		else if(!root.courses.contains(n.courses) && root.bnum == n.bnum)
			root.courses+=n.courses;
		return root;
	}

	/**
	 * Finds node, then deletes specified course if it exists.
	 * @param n Node to be deleted.
	 */
	public void delete(Node n){
		Node temp = search(root, n.bnum);
		if(temp != null){
			temp.courses = temp.courses.replace(n.courses, "");
			temp.notifyObservers();
		}
	}


	/**
	 * Takes in a String with Node parameters and returns
	 * corresponding node.
	 * @param n String to be parsed into Node.
	 * @return Node created from String.
	 */
	public Node parser(String n){
		int bnum = Integer.parseInt(n.substring(0, 4));
		String courses = n.substring(5);
		return new Node(bnum, courses);
	}
	
	/**
	 * Creates mutable StringBuilder to be passed into inorderRec.
	 * @return String listing all nodes in order by bnumber.
	 */
	public String printNodes(){
		StringBuilder s = new StringBuilder();
		inorderRec(root, s);
		return s.toString();
	}

	/**
	 * Recursively traverse the BST, adding nodes in order by bnum.
	 * http://www.geeksforgeeks.org/binary-search-tree-set-2-delete/.
	 */
	public void inorderRec(Node n, StringBuilder s){
		if(n != null){
			inorderRec(n.left, s);
			s.append(n.toString() + "\n");
			inorderRec(n.right, s);
		}
	}
}
