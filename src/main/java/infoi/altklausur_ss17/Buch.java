package infoi.altklausur_ss17;

public class Buch extends Medium{
	protected final String author;

	public Buch (String pAuthor, String pTitel, Kategorie pKategorie) {
		super(pTitel, pKategorie);
		author = pAuthor;
	}

	public String getAuthor() {
		return author;
	}
}
