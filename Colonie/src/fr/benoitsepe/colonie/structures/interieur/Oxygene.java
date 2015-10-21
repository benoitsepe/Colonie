package fr.benoitsepe.colonie.structures.interieur;

import fr.benoitsepe.colonie.main.IStructure;
import fr.benoitsepe.colonie.main.Ressources;
import fr.benoitsepe.colonie.main.Structure;

public class Oxygene extends Structure implements IStructure{

	public Oxygene() {
		super("Oxyg�ne");
	}

	/* (non-Javadoc)
	 * @see fr.benoitsepe.colonie.main.IStructure#utiliser(fr.benoitsepe.colonie.main.Ressources)
	 * Methode obligatoire � toutes les structures non passives
	 */
	@Override
	public void utiliser(Ressources res) {
		res.setWater(res.getWater() - 1);
		res.setOxygen(res.getOxygen() + 2);
		
	}


}
