package proj;

import java.util.ArrayList;
import java.util.List;
public class Iferme implements Ferme{
	List<Etat> listeLineaire;
	
	public Iferme() {
		listeLineaire = new ArrayList<>();
	}
	@Override
	public void ajouter(Etat e) {
		listeLineaire.add((Etat_CM)e);
	}

	@Override
	public boolean chercher(Etat e) {
		for (Etat element : listeLineaire) {
		    if (((Etat_CM)element).getNbre_cannibales()==((Etat_CM)e).getNbre_cannibales() && ((Etat_CM)element).getNbre_missionaire()==((Etat_CM)e).getNbre_missionaire() && (((Etat_CM)element).isBateau()==((Etat_CM)e).isBateau())) {
		       return true;
		    }
		}
		return false;
	}

	@Override
	public boolean vide() {
		// TODO Auto-generated method stub
		return  listeLineaire.isEmpty();
	}

	@Override
	public void detruire() {
		// TODO Auto-generated method stub
		listeLineaire.clear();
	}

}
