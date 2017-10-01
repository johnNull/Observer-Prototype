package studentCoursesBackup;
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
		Node temp = search(root, n.bnum);
		System.out.println(temp);
		temp.courses = temp.courses.replace(n.courses, "");
		temp.notifyObservers();
	}


	/*Node delete(Node root, Node n){
		if(root == null)
			return root;
		if(n.bnum < root.bnum)
			root.left = delete(root.left, n);
		else if(n.bnum > root.bnum)
			root.right = delete(root.right, n);
		else{
			if(root.left == null){
				root.clearObservers();
				return root.right;
			}
			if(root.right == null){
				root.clearObservers();
				return root.left;
			}
			Node temp = minimum(root.right);
			root.bnum = temp.bnum;
			root.courses = temp.courses;
			root.right = delete(root.right, n);
		}
		return root;
	}*/

	Node minimum(Node root){
		int min = root.right.bnum;
		while(root.left != null){
			min = root.left.bnum;
			root = root.left;
		}
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
