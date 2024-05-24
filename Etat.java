package proj;

public abstract class Etat {
	@Override
	public String toString() {
		return "Etat [pere=" + pere + "]";
	}
	Etat pere;
	Operation op;
	public abstract boolean testBut();

}
