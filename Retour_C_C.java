package proj;

public class Retour_C_C implements Operation{

	@Override
	public Etat Action(Etat e) {
		Etat_CM etat_courant=(Etat_CM) e;
		int varLoc1=3-etat_courant.getNbre_missionaire();
		int varLoc2=(3-etat_courant.getNbre_cannibales())-2;
		if( (etat_courant.isBateau()==false && varLoc2>=0)&&(varLoc1==0||varLoc1>=varLoc2)&&(etat_courant.getNbre_cannibales()+2<=etat_courant.getNbre_missionaire() || etat_courant.getNbre_missionaire()==0)){
			return new Etat_CM(etat_courant.getNbre_missionaire(),etat_courant.getNbre_cannibales()+2,true);
		}
		return null;
	}

	@Override
	public String toString() {
		return "Return_C_C   ==>  ";
	}

}
