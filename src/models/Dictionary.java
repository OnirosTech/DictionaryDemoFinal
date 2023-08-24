package models;

public class Dictionary {
	private Word[] wordsESTR;

	public Dictionary() {
	}
	public Word[] getDictionary() {
		return wordsESTR;
	}

	public void setDictionary(Word[] wordsESTR) {
		this.wordsESTR = wordsESTR;
	}
}
