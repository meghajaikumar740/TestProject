// Program to count the number of every word in a text file
//
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class WordCount {

	public static void main(String[] args) throws IOException, FileNotFoundException {
		// TODO Auto-generated method stub
		File file = new File ("C:\\Users\\Megha Jaikumar\\Documents\\JAVA_STUDY\\TEST_DOCUMENTS\\test.txt");
		FileInputStream fis = new FileInputStream(file); 
		InputStreamReader input = new InputStreamReader(fis); 
		BufferedReader reader = new BufferedReader(input); 
		
		HashMap<String,ArrayList> hm = new HashMap<String,ArrayList>();
		
		String line;
		String word;
		int lineCount = 0;
		int paraCount = 1;
		int sentenceCount = 0;
		
		while((line = reader.readLine()) != null) {
			String [] words = line.split("\\s+");
			lineCount++;
			
			for (int i=0; i<words.length; i++) {
				if (hm.containsKey(word = words[i])) {
					ArrayList list = hm.get(word);
					list.add(lineCount);
				}
				else {
					ArrayList<Integer> lineNumber = new ArrayList<Integer>();
					lineNumber.add(lineCount);
					hm.put(word, lineNumber);
				}
				
			}
		}
		for(Entry<String,ArrayList> e : hm.entrySet()) {
			ArrayList list = e.getValue();
			Iterator itr = list.iterator();
			int wordCount = 0;
			System.out.print(e.getKey() + " -- ");
			System.out.print("Line numbers: ");
			while (itr.hasNext()) {
				System.out.print(itr.next() + ", ");
				wordCount ++;
			}
			System.out.print("| Count: "+wordCount);
			System.out.println();
			
		}
		
	}

}
