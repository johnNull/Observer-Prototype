package studentCoursesBackup.driver;
import studentCoursesBackup.BST;
import studentCoursesBackup.Node;
import studentCoursesBackup.FileProcessor;
import studentCoursesBackup.Results;
import studentCoursesBackup.TreeBuilder;
public class Driver{
	public static void main(String args[]){
		if(args == null || args.length != 5)
			throw new IllegalArgumentException("Two arguments are required, input.txt and output.txt");
		else{
		Results results = new Results(args[2]);
		Results results1 = new Results(args[3]);
		Results results2 = new Results(args[4]);
		BST bst = new BST();
		BST backup1 = new BST();
		BST backup2 = new BST();
		TreeBuilder tb = new TreeBuilder(args[0],args[1], bst, backup1, backup2);
		tb.populate();
		tb.delete();
		results.append(bst.inorder());
		results1.append(backup1.inorder());
		results2.append(backup2.inorder());
		results.writeToFile();
		results1.writeToFile();
		results2.writeToFile();
		}
	}
}
