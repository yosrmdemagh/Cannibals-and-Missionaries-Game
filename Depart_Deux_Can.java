package proj;

public class Depart_Deux_Can implements Operation{

	@Override
	public Etat Action(Etat e) {
		Etat_CM etat_courant=(Etat_CM) e;
		int varLoc1=3-etat_courant.getNbre_missionaire();
		int varLoc2=(3-etat_courant.getNbre_cannibales())+2;
		if( (etat_courant.isBateau()==true && etat_courant.getNbre_cannibales()>=2)&&(varLoc1==0||varLoc1>=varLoc2)){
			return new Etat_CM(etat_courant.getNbre_missionaire(),etat_courant.getNbre_cannibales()-2,false);
		}
		return null;
	}
	@Override
	public String toString() {
		return "Departure_C_C   ==>  ";
	}
}
