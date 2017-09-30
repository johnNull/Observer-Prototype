package studentCoursesBackup;
public class BST{
	private Node root;
	public BST(){
		root = null;
	}
	
	/*public Node search(int bnumber){
		if(root == null || root.bnum == bnumber)
			return root;
		if(root.bnum > bnumber)
			return search(root.left, bnumber);
		if(root.bnum < bnumber)
			return search(root.right, bnumber);
		else
			return null;
	}*/

	public void insert(Node n){
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
	
	public void inorder(){
		inorderRec(root);
	}

	public void inorderRec(Node n){
		if(n != null){
			inorderRec(n.left);
			System.out.println(n.toString());
			inorderRec(n.right);
		}
	}
}
