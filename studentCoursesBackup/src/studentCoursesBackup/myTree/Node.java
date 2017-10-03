package studentCoursesBackup;
public class Node implements ObserverI, SubjectI, Cloneable{
	Node b1, b2, left, right;
	int bnum;
	String courses;

	/**
	 * Default Constructor for Node.
	 */
	public Node(){
		
	}

	/**
	 * Constructor for Node, sets bnum and courses and creates
	 * two backups from clones.
	 * @param b      bnumber.
	 * @param course initial course.
	 */
	public Node(int b, String course){
		bnum = b;
		courses = course;
		left = null;
		right = null;
		b1 = (Node)this.clone();
		b2 = (Node)this.clone();
	}

	/**
	 * Creates a deep copy of given Node.
	 * @return Object with identical values of given Node.
	 */
	@Override
	public Object clone(){
		Node n = new Node();
		n.bnum = bnum;
		n.courses = courses;
		return n;
	}

	/**
	 * Sets courses equal to courses of Subject.
	 * @param n Node from which current Node will update from.
	 */
	public void update(Node n){
		courses = n.courses;
	}

	/**
	 * Calls on Observers to update.
	 */	
	public void notifyObservers(){
		b1.update(this);
		b2.update(this);
	}	

	/**
	 * Returns a Node String in format "bnum:courses".
	 * @return String in format "bnum:courses".
	 */
	@Override
	public String toString(){
		return bnum + ":" + courses;
	}
}
