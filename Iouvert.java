package proj;

import java.util.LinkedList;
import java.util.Queue;

public class Iouvert implements Ouvert {
	  Queue<Etat> file ;
	public Iouvert() {
	   file = new LinkedList<>();   
	}

	@Override
	public void inserer(Etat e) {
		  file.offer((Etat_CM)e);
		
	}

	@Override
	public Etat extraire() {
		// TODO Auto-generated method stub
		return (Etat_CM)file.poll();
	}

	@Override
	public boolean vide() {
		// TODO Auto-generated method stub
		return file.isEmpty();
	}

	@Override
	public boolean chercher(Etat e) {
		for (Etat element : file) {
		    if (((Etat_CM)element).getNbre_cannibales()==((Etat_CM)e).getNbre_cannibales() && ((Etat_CM)element).getNbre_missionaire()==((Etat_CM)e).getNbre_missionaire() && ((Etat_CM)element).isBateau()==((Etat_CM)e).isBateau()) {
		       return true;
		    }
		}
		return false;
	}

	@Override
	public void detruire() {
		// TODO Auto-generated method stub
		file.clear();
	}

}
