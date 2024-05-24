package proj;

public class Etat_CM extends Etat{
private int nbre_missionaire;
private int nbre_cannibales;
private boolean bateau;

public Etat_CM(int miss, int can, boolean b) {
	nbre_missionaire=miss;
	nbre_cannibales=can;
	bateau=b;
}

public int getNbre_missionaire() {
	return nbre_missionaire;
}

public void setNbre_missionaire(int nbre_missionaire) {
	this.nbre_missionaire = nbre_missionaire;
}

public int getNbre_cannibales() {
	return nbre_cannibales;
}

public void setNbre_cannibales(int nbre_cannibales) {
	this.nbre_cannibales = nbre_cannibales;
}

public boolean isBateau() {
	return bateau;
}

public void setBateau(boolean bateau) {
	this.bateau = bateau;
}

	@Override
public String toString() {
	return " (m=" + nbre_missionaire + ", c=" + nbre_cannibales + ", b="
			+ bateau + ")";
}

	@Override
	public boolean testBut() {
		// TODO Auto-generated method stub
		return  (nbre_cannibales ==0 && nbre_missionaire==0 && bateau== false);
	}

}
