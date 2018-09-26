/**
 * WordGram objects represent a k-gram of strings/words.
 * 
 * @author Kamyar Yazdani
 *
 */

public class WordGram {
	
	private String[] myWords;   
	private String myToString;  // cached string
	private int myHash;         // cached hash value

	/**
	 * Create WordGram using String array. 
	 * @param source: Array of strings which the WordGram takes words from.
	 * @param start: Index of the passed Array where WordGram starts taking words.
	 * @param size: Length of WordGram (Number of Words stored)
	 */
	public WordGram(String[] source, int start, int size) {
		myWords = new String[size];
		for (int i = 0; i < size; i++) {
			
			myWords[i] = source[i+start];
		}
		myToString = null;
		myHash = 0;
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
	 * Return int of the number of words in this WordGram
	 * @return int of internal array size 
	 */
	public int length(){
		
		return myWords.length;
	}


	@Override
	public boolean equals(Object o) {
		if (! (o instanceof WordGram) || o == null){
			return false;
		}
	    // TODO: complete this method
		else {
			WordGram wg = (WordGram) o;
			if (wg.length() != this.length()) {
				return false;
			}
			else {
				return (this.toString()).equals(o.toString());
			}
		}
	}

	@Override
	public int hashCode(){
		// TODO: complete this method
		if (this.myHash == 0) {
			String a = (this.toString());
			this.myHash = a.hashCode();
			return myHash;
		}
		else {
			return myHash;
		}
	}
	

	/**
	 * Return new WordGram with previous elements shifted left one, and passed String appended to end. 
	 * @param last is last String of returned WordGram
	 * @return WordGram with shifted elements and last added to end
	 */
	public WordGram shiftAdd(String last) { 
		// TODO: Complete this method
		String[] words = new String[this.length()];
		
		for (int i = 0; i < words.length-1 ; i++) {
			words[i] = this.wordAt(i+1); 
					}
		words[words.length-1]=last;
		WordGram wg = new WordGram(words,0,this.myWords.length);
		return wg;
	}

	@Override
	public String toString(){
		
		if (myToString == null) {
		myToString = String.join(" ",myWords);
		}

		return myToString;}
	}
