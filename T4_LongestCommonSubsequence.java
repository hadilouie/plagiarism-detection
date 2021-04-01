import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.Format;

import acm.program.ConsoleProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Agrar: Longest Common Subsequence algorithm
 * 
 * 
 * A simple implementation of Longest Common Subsequence algorithm. All nine c++
 * files compare with each other This class use LongestCommonSubsequence class
 * 
 * @author your M.H.Aghalouyaghmiyouni
 */
public class T4_LongestCommonSubsequence extends ConsoleProgram {
	// Main path is a constant
	private final String MAIN_PATH = "F:/docs/";

	public void run() {

		// enter directory name
		String dirName = readLine("Enter directory to scan (e.g files) : ");
		// final path is created
		String fullPath = MAIN_PATH + "/" + dirName;
		
		File dir = new File(fullPath);
		File[] files = dir.listFiles();

		// first print the top header row
        print("      |");
        for(int i = 0; i<=files.length -1;i++ ) {        	 
        	 print(String.format("%4d", i));
        	 print("  |");        	
        }
        println();
        println("----------------------------------------------------------------------");
        
        for(int i = 0 ;i<=files.length -1 ;i++) {
            // print left most column first
            print(String.format("%4d", i));
            print("  |");
            for(int j=0;j<=files.length -1;j++) {
            	CalculatePercentage(files[i] , files[j]);
            }
            println();
        }
	


	}

	
	/**
	 * This method will calculate the percentage of Longest Common Subsequence
	 * @param file
	 * @param file2
	 */
	private void CalculatePercentage(File file, File file2) {
		LongestCommonSubsequence lcs = new LongestCommonSubsequence();
		print(" ");
        try {
			String contentI = new String(Files.readAllBytes(Paths.get(file.getAbsolutePath())), StandardCharsets.UTF_8);
			String contentJ = new String(Files.readAllBytes(Paths.get(file2.getAbsolutePath())), StandardCharsets.UTF_8);
			

			char[] X = contentI.toCharArray();
			char[] Y = contentJ.toCharArray();
			int m = X.length;
			int n = Y.length;
	
			float maxLength = lcs.max(m, n);
			float lcsResult = lcs.lcs(X, Y, m, n);
	
			float percent = (100 * lcsResult) / maxLength;
		   
			print(String.format("%.0f%%", percent));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        print("  |"); 
		
	}

}
