package fr.benoitsepe.colonie.main;

import org.lwjgl.Sys;
import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;
 
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.*;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		// Je t'ai mis un exemple de cr�ation d'une �olienne, lance le programme pour voir
		
		Gestion moteur = new Gestion(); // Init moteur
		
		
		moteur.creerStruct(TypeStructures.EOLIENNE); // Tu peux en cr�er plusieurs si tu veux, j'ai pas encore impl�ment� les autres structures
        
        System.out.println("Hello LWJGL " + Sys.getVersion() + "!");	
        }
}
