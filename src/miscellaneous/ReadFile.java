package miscellaneous;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map.Entry;
import java.util.Set;

public class ReadFile {

	public static void main(String[] args) throws FileNotFoundException, IOException {

		String line;
		int countWord = 0;
		int sentenceCount = 0;
		int characterCount = 0;
		int paragraphCount = 1;
		int whitespaceCount = 0;

		HashMap<String, Integer> hm = new HashMap<>();

		try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\mohdsuha\\Desktop\\file.txt"))) {
			while ((line = br.readLine()) != null) {

				if (line.equals("")) {
					paragraphCount++;
				}
				if (!line.equals("")) {

					String[] words = line.split("\\s+");

					countWord += words.length;
					whitespaceCount += words.length - 1;
					characterCount += line.length() - (words.length - 1);

					String[] sentenceList = line.split("[!?.:]");
					sentenceCount += sentenceList.length;

					for (int i = 0; i < words.length; i++) {
						if (hm.containsKey(words[i])) {
							hm.put(words[i], hm.get(words[i]) + 1);
						} else {
							hm.put(words[i], 1);
						}
					}

				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("File Missing");
		} catch (IOException ex) {
			System.out.println("IOException");
		}

		System.out.println("Total word count = " + countWord);
		System.out.println("Total number of sentences = " + sentenceCount);
		System.out.println("Total number of characters = " + characterCount);
		System.out.println("Number of paragraphs = " + paragraphCount);
		System.out.println("Total number of whitespaces = " + whitespaceCount);
		System.out.println("\nCount no of occurance of words");

		Comparator<Entry<String, Integer>> comp = new Comparator<Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				Integer val1 = o1.getValue();
				Integer val2 = o2.getValue();
				return val1.compareTo(val2);
			}

		};
		
		Set<Entry<String, Integer>> set = hm.entrySet();
		List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(set);
		
		Collections.sort(list, comp);
		
		ListIterator<Entry<String, Integer>> itr =list.listIterator(list.size());
		
		while (itr.hasPrevious()) {
			System.out.println(itr.previous());
		}
	}

}
