package proj;

public class Depart_C_M implements Operation{

	@Override 
	public Etat Action(Etat e) {
		Etat_CM etat_courant=(Etat_CM) e;
		int varLoc1=3-etat_courant.getNbre_missionaire()+1;
		int varLoc2=(3-etat_courant.getNbre_cannibales())+1;
		if( (etat_courant.isBateau()==true && etat_courant.getNbre_cannibales()>=1 && etat_courant.getNbre_missionaire()>=1)&&(varLoc1>=varLoc2)&& etat_courant.getNbre_cannibales()-1<=etat_courant.getNbre_missionaire()-1 ){
			return new Etat_CM(etat_courant.getNbre_missionaire()-1,etat_courant.getNbre_cannibales()-1,false);
		}
		return null;
	}
	@Override
	public String toString() {
		return "Departure_C_M   ==>   ";
	}
}
