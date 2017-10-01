package studentCoursesBackup;
public class TreeBuilder{
	private Node head, b1, b2;
	public TreeBuilder(Node n){
		head = n;
		b1 = n.getB1();
		b2 = n.getB2();
	}

	//when inserting insert Node n then insert n.b1 and n.b2 into backup trees
}
