package studentCoursesBackup;
public class TreeBuilder{
	String input, deleter;
	BST orig, b1, b2;

	/**
	 * TreeBuilder Constructor.
	 * @param input   String specifying input file.
	 * @param deleter String specifying delete file.
	 * @param orig    The Subject binary search tree.
	 * @param b1      The first backup BST of orig.
	 * @param b2      The second backup BST of orig.
	 */
	public TreeBuilder(String input,String deleter, BST orig, BST b1, BST b2){
		this.input = input;
		this.deleter = deleter;
		this.orig = orig;
		this.b1 = b1;
		this.b2 = b2;
	}

	/**
	 * Creates Nodes from input and inserts them into orig.
	 * Simultaneously inserts Observers into b1 and b2.
	 */
	public void populate(){
		FileProcessor fp = new FileProcessor(input);
		for(String s = fp.readLine(); s != "-1"; s = fp.readLine()){
			Node n = orig.parser(s);		
			orig.insert(n);
			b1.insert(n.b1);
			b2.insert(n.b2);
		}
	}

	/**
	 * Deletes given courses from nodes specified in deleter.
	 */
	public void delete(){
		FileProcessor fp = new FileProcessor(deleter);
		for(String s = fp.readLine(); s != "-1"; s = fp.readLine()){
			Node n = orig.parser(s);		
			orig.delete(n);	
		}
	}
}
