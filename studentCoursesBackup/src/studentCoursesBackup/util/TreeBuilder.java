package studentCoursesBackup;
public class TreeBuilder{
	String input;
	BST orig, b1, b2;
	public TreeBuilder(String input, BST orig, BST b1, BST b2){
		this.input = input;
		this.orig = orig;
		this.b1 = b1;
		this.b2 = b2;
	}

	public void populate(){
		FileProcessor fp = new FileProcessor(input);
		for(String s = fp.readLine(); s != "-1"; s = fp.readLine()){
			Node n = orig.parser(s);		
			orig.insert(n);
			b1.insert(n.b1);
			b2.insert(n.b2);
		}
	}

	//when inserting insert Node n then insert n.b1 and n.b2 into backup trees
}
