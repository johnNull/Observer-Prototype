package studentCoursesBackup;
public class Node implements ObserverI, SubjectI, Cloneable{
	Node b1, b2, left, right;
	int bnum;
	String courses;
	public Node(){
		
	}
	public Node(int b, String course){
		bnum = b;
		courses = course;
		left = null;
		right = null;
		b1 = (Node)this.clone();
		b2 = (Node)this.clone();
	}

	public Object clone(){
		Node n = new Node();
		n.bnum = bnum;
		n.courses = courses;
		return n;
	}

	public void update(Node n){
		bnum = n.bnum;
		courses = n.courses;
	}

	public void notifyObservers(){
		b1.update(this);
		b2.update(this);
	}

	public void clearObservers(){
		b1 = null;
		b2 = null;
	}
	
	public Node getB1(){
		return b1;
	}

	public Node getB2(){
		return b2;
	}

	@Override
	public String toString(){
		return bnum + ":" + courses;
	}

	/*public int getBnum(){
		return bnum;
	}
	
	public char[] getCourses(){
		return courses;
	}*/
}
