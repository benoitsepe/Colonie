package fr.benoitsepe.colonie.main;

import java.awt.image.BufferedImage;

import javax.imageio.IIOException;

import org.newdawn.slick.Image;

import fr.kienanbachwa.colonie.jeu.SpriteLoader;

/**
 * @author Beno�t
 * 
 * Classe m�re de toutes les structures int�rieurs ou ext�rieurs
 * Contient les variables membres indispensables � chaque structure
 * 
 * @precaution mettre les variables membres en protected et g�nerer les getter/setter
 *
 */
public class Structure implements IStructure {
	protected Etat etat; // RUNNING ou STOP
	protected int maintenance; // 0 = cass�, 100=neuf
	protected String nom; // nom de la structure
	protected int sizeX; //Taille horizontale de la structure
	protected int sizeY; //Taille verticale de la structure
	public Image[][] sprites;
	protected SpriteLoader spriteLoader = new SpriteLoader();
	
	/**
	 * @param nom
	 * Le constructeur doit �tre appel� depuis la classe fille avec comme param�tre le nom du la structure
	 * Constructeur sans image: une image par d�faut est charg�e pour l'affichage
	 */
	public Structure(String nom) {
		this.nom = nom;
		etat = Etat.RUNNING;
		maintenance = 100;
		sprites = spriteLoader.loadStructureSprites(nom);
		sizeX=1;	//Si la taille de la structure n'est pas modifi�e dans la classe fille, elle est �gale � 1
		sizeY=1;
	}


	public Image[][] getSprites() {
		return sprites;
	}
	
	public int getSizeX() {
		return sizeX;
	}


	public int getSizeY() {
		return sizeY;
	}


	public Etat getEtat() {
		return etat;
	}


	public void setEtat(Etat etat) {
		this.etat = etat;
	}


	public int getMaintenance() {
		return maintenance;
	}


	public void setMaintenance(int maintenance) {
		this.maintenance = maintenance;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	@Override
	public void utiliser(Ressources res) {
		System.out.println("Je ne suis pas impl�ment� ! " + nom);
	}
	
	

}
