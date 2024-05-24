package proj;

public interface Ouvert {

	public abstract  void inserer(Etat e);
	public abstract Etat extraire();
	public abstract boolean vide();
	public abstract boolean chercher(Etat e);
	public abstract void detruire();
}
