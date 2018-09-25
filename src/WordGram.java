/**
 * WordGram objects represent a k-gram of strings/words.
 * 
 * @author Kamyar Yazdani
 *
 */

public class WordGram {
	
	private static String[] myWords;   
	private String myToString;  // cached string
	private int myHash;         // cached hash value

	/**
	 * Create WordGram (add comments)
	 * @param source
	 * @param start
	 * @param size
	 */
	public WordGram(String[] source, int start, int size) {
		myWords = new String[size];
		myToString = myWords.toString();
		myHash = myWords.hashCode();
		// TODO: initialize myWords and ...
	}

	/**
	 * Return string at specific index in this WordGram
	 * @param index in range [0..length() ) for string 
	 * @return string at index
	 */
	public String wordAt(int index) {
		if (index < 0 || index >= myWords.length) {
			throw new IndexOutOfBoundsException("bad index in wordAt "+index);
		}
		return myWords[index];
	}

	/**
	 * Complete this comment
	 * @return
	 */
	public int length(){
		
		return myWords.length;
	}


	@Override
	public boolean equals(Object o) {

		if (o instanceof WordGram) {
			return true;
		}
		return false;
	}

	@Override
	public int hashCode(){
		// TODO: complete this method
		myHash = myWords.toString().hashCode();
		return myHash;
	}
	

	/**
	 * Create and complete this comment
	 * @param last is last String of returned WordGram
	 * @return
	 */
	public WordGram shiftAdd(String last) {
		myWords[myWords.length-1] = last;
		WordGram wg = new WordGram(myWords,0,myWords.length);
		
		return wg;
	}

	@Override
	public String toString(){
		// TODO: Complete this method	
		myToString = String.join(" ",myWords);
		return myToString;
	}
}
