package fr.kienanbachwa.colonie.graphics;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Mouse;

import fr.benoitsepe.colonie.elements.TypeElements;
import fr.benoitsepe.colonie.main.Gestion;
import fr.benoitsepe.colonie.ressources.TypeRessources;
import fr.kienanbachwa.colonie.graphics.things.ElemButton;
import fr.kienanbachwa.colonie.jeu.Component;
import fr.kienanbachwa.colonie.jeu.Game;

public class Hud {
	
	List<ElemButton> buttons = new ArrayList<ElemButton>();
	List<TypeRessources> ressources = new ArrayList<TypeRessources>();
	
	private Font font;
	public static boolean mouseOnHud;
	public static TypeElements elementClicked = TypeElements.BATIMENT;
	
	int x,y,w,h;
	Panneau panElem;
	Panneau panStructures;
	Panneau panRessources;
	Panneau panOnglets;
	int page =1;
	
	public Hud(){
		try {
			font = new Font("res/minecraft_font.ttf", 6);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		w=Component.width;
		h=(Component.height/16)*4;
		panElem = new Panneau(x,y-10,w,h,1);
		panStructures = new Panneau(x,y-10,w,h,1);
		panRessources = new Panneau(x+panElem.w,y,16,16,2);
	}
	
	public void init(){
		for(TypeElements e : TypeElements.values()){
			buttons.add(new ElemButton(e));				//Boutons d'�lements
		}
		
		for(TypeRessources res : TypeRessources.values()){
			ressources.add(res);
		}
		
		try {												//THIS WAS TAKING MEMORY
			font = new Font("res/stan0753.ttf", 8);
		} catch (Exception e) {
			System.err.println("Police non trouv�e");
			e.printStackTrace();
		}
		
		for(ElemButton eb : buttons){
			panElem.add(eb);
		}
		

	}
	
	public void update(){
		//Position en haut � gauche du hud
		h=(Component.height/16)*4;
		x = 0;		
		y =(int)(Component.height-h);	
		w=Component.width;

		
		if(Mouse.getX() > x*Component.scale && Mouse.getX()<(x+w)*Component.scale && Mouse.getY() < (Component.height-y)*Component.scale && Mouse.getY()> (Component.height-y-h)*Component.scale){
			mouseOnHud=true;
		}else{
			mouseOnHud=false;
		}		
		
		panElem.update(x,y+10,(w/4)*3,h-10);
		panElem.update(x,y+10,(w/4)*3,h-10);
		panRessources.update(x+panElem.w, y, w-panElem.w, h);
	}
	
	public void render(){
		Renderer.renderQuad(x, y, w, h, new float[]{0,0,1,0.6f});
		if(page==1)
			panElem.render();
		if(page==2)
			panStructures.render();
		
		panRessources.render();

	}
		

}