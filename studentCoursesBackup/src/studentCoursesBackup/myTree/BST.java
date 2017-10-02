package studentCoursesBackup;
import java.lang.StringBuilder;
public class BST{
	private Node root;
	public BST(){
		root = null;
	}
	
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

	public void insert(Node n){
		//Node n = parser(s);
		root = insert(root, n);
	}

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

	public void delete(Node n){
		//Node n = parser(s);
		Node temp = search(root, n.bnum);
		if(temp != null){
			//System.out.println(temp);
			temp.courses = temp.courses.replace(n.courses, "");
			temp.notifyObservers();
		}
	}


	public Node parser(String n){
		int bnum = Integer.parseInt(n.substring(0, 4));
		String courses = n.substring(5);
		return new Node(bnum, courses);
	}
	
	public String inorder(){
		StringBuilder s = new StringBuilder();
		inorderRec(root, s);
		return s.toString();
	}

	public void inorderRec(Node n, StringBuilder s){
		if(n != null){
			inorderRec(n.left, s);
			s.append(n.toString() + "\n");
			inorderRec(n.right, s);
		}
	}
}
