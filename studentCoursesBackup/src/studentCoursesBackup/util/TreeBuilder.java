package studentCoursesBackup;
public class TreeBuilder{
	String input, deleter;
	BST orig, b1, b2;
	public TreeBuilder(String input,String deleter, BST orig, BST b1, BST b2){
		this.input = input;
		this.deleter = deleter;
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

	public void delete(){
		FileProcessor fp = new FileProcessor(deleter);
		for(String s = fp.readLine(); s != "-1"; s = fp.readLine()){
			Node n = orig.parser(s);		
			orig.delete(n);	
		}
	}
}
