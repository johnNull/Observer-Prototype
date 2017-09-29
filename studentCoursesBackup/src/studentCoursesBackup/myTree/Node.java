package studentCoursesBackup;
public class Node implements ObserverI, SubjectI, Cloneable{
	private Node b1, b2, left, right;
	private int bnum;
	private char[] courses = new char[11];
	public Node(){
		
	}
	public Node(int b, char course){
		bnum = b;
		courses[0] = course;
		left = null;
		right = null;
	}

	public Object clone(){
		Node n = new Node();
		n.bnum = bnum;
		for(int i = 0; i < 11; i++)
			n.courses[i] = courses[i];
		return n;
	}

	public void update(Node n){
		bnum = n.bnum;
		for(int i = 0; i < 11; i++)
			courses[i] = n.courses[i];
	}

	public void notifyObservers(){
		b1.update(this);
		b2.update(this);
	}

	public void registerObservers(Node n1, Node n2){
		b1 = n1;
		b2 = n2;
	}
}
