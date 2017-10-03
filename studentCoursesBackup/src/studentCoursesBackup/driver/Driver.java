package studentCoursesBackup.driver;
import studentCoursesBackup.BST;
import studentCoursesBackup.Node;
import studentCoursesBackup.FileProcessor;
import studentCoursesBackup.Results;
import studentCoursesBackup.TreeBuilder;
public class Driver{

	/**
	 * Creates tree from the input text and two backups.
	 * Deletes according to delete.txt and outputs to output.txt.
	 * @param args List of txt files: input, delete, output1, output2, output3.
	 */
	public static void main(String args[]){
		if(args == null || args.length != 5)
			throw new IllegalArgumentException("Five arguments are required, input.txt, delete.txt, and 3 output text files");
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
		results.append(bst.printNodes());
		results1.append(backup1.printNodes());
		results2.append(backup2.printNodes());
		results.writeToFile();
		results1.writeToFile();
		results2.writeToFile();
		}
	}
}
