package infoi.aufgabe_nr16;

import java.util.List;
import java.util.stream.Stream;

public class ProduktManager {

	public long getAnzahlSchwereProdukte(List<Produkt> products) {
		Stream<Produkt> p = products.parallelStream();
		return p.filter(i->(i.getGewichtInGramm()>=50000)).count();
	}

	public boolean passtAufLKW(LKW lkw, List<Produkt> products) {
		//Streams nur einmal verwendbar!
		Stream<Produkt> p = products.parallelStream();
		Stream<Produkt> q = products.parallelStream();
		int summeDerGewichteInKg = p.map(i->(i.getGewichtInGramm()/1000)).reduce(0, (i,j)->i+j);
		double gesamtVolumenInM3 = q.map(i->(i.getVolumenCM3()/1000000)).reduce(0d, (i,j)->i+j);
		return ((summeDerGewichteInKg <= lkw.getMaxGewichtInKG()) && (gesamtVolumenInM3 <= lkw.getMaxM3Volumen()));
	}
}