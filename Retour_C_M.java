package proj;

public class Retour_C_M implements Operation{

	@Override 
	public Etat Action(Etat e) {
		Etat_CM etat_courant=(Etat_CM) e;
		int varLoc1=3-etat_courant.getNbre_missionaire()-1;
		int varLoc2=(3-etat_courant.getNbre_cannibales())-1;
		if( (etat_courant.isBateau()==false && varLoc1>=0 && varLoc2>=0)&&(varLoc1>=varLoc2|| varLoc1==0)&& etat_courant.getNbre_cannibales()+1<=etat_courant.getNbre_missionaire()+1 ){
			return new Etat_CM(etat_courant.getNbre_missionaire()+1,etat_courant.getNbre_cannibales()+1,true);
		}
		return null;
	}
	@Override
	public String toString() {
		return "Return_C_M   ==>  ";
	}
}
