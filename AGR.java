package proj;

public class AGR {
private Etat_CM etat_initial;
private Iferme ferme;
private Iouvert ouvert;
private Operation[] operations;
public AGR(Etat_CM etat_initial, Iferme ferme, Iouvert ouvert, Operation[] operations) {
	this.etat_initial = etat_initial;
	this.ferme = ferme;
	this.ouvert = ouvert;
	this.operations = operations;
}

public Etat_CM explorer() {
	ouvert.inserer(etat_initial);
	while(!ouvert.vide())
	{
		Etat_CM etat_courant=(Etat_CM) ouvert.extraire();
		if(etat_courant.testBut()) {
			ouvert.detruire();
			return etat_courant;
		}
		else {
			
			ferme.ajouter(etat_courant);
			//System.out.println(operations);
			
			for (Operation op:operations) {
				Etat_CM successeur=(Etat_CM) op.Action(etat_courant);
				if(successeur!=null && !(ouvert.chercher(successeur))&& !(ferme.chercher(successeur))) {
					successeur.op=op;
					successeur.pere=etat_courant;
					ouvert.inserer((Etat_CM)successeur);
				}
			}
		}
	}
	ouvert.detruire();
	return null;
}
public String chemin(Etat etat) {
	Pile<Etat_CM> pile=new Pile();
	String chemin="";
	Etat_CM etatCourant=(Etat_CM)etat;
	while(etatCourant!=null) {
		pile.inserer(etatCourant);
		etatCourant=(Etat_CM) etatCourant.pere;
	}
	chemin="Initial state ";
	chemin+=(pile.extraire()).toString()+"/";
	while(!pile.vide()) {
		etatCourant=pile.extraire();
		chemin+=(etatCourant.op).toString()+etatCourant.toString()+"/";
	}
	return chemin;
}
}

