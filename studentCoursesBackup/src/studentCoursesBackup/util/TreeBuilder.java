package studentCoursesBackup;
public class TreeBuilder{
	private Node head, b1, b2;
	public TreeBuilder(Node n){
		head = n;
		b1 = (Node)n.clone();
		b2 = (Node)n.clone();
	}
}
