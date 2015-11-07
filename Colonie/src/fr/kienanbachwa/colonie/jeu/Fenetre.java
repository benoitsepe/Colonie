package fr.kienanbachwa.colonie.jeu;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Fenetre extends BasicGame
{
	public GameContainer gc;
	String texte = "Surprise!";
	Image background;
	Image playerImage;
	private MapLoader mapLoader;
	
	private float y;
	private float x;
	private float delta = 10;
	
	private int mapSizeX;
	private int mapSizeY;
	
	private boolean[] direction = new boolean[4];
	private float zoom = 1;
	
	public Fenetre(String gamename)
	{
		super(gamename);
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		this.gc=gc;
		mapLoader = new MapLoader();
		System.out.println(mapLoader.getMap().getTileId(1,1,0));
		x=gc.getWidth()/2;
		y=gc.getHeight()/2;
		
	    mapSizeY = mapLoader.getMap().getHeight() * mapLoader.getMap().getTileHeight();
	    mapSizeX = mapLoader.getMap().getWidth() * mapLoader.getMap().getTileWidth();

	}

	public void keyReleased(int key, char c){
		if (Input.KEY_ESCAPE==key){
			gc.exit();
		}
		
		 switch (key) {
		 
	        case Input.KEY_UP:    this.direction[0] = false; break;
	        case Input.KEY_LEFT:  this.direction[1] = false; break;
	        case Input.KEY_DOWN:  this.direction[2] = false; break;
	        case Input.KEY_RIGHT: this.direction[3] = false; break;
	    }
	}
	
	public void keyPressed(int key, char c){			
			 switch (key) {
			 
		        case Input.KEY_UP:    this.direction[0] = true; break;
		        case Input.KEY_LEFT:  this.direction[1] = true; break;
		        case Input.KEY_DOWN:  this.direction[2] = true; break;
		        case Input.KEY_RIGHT: this.direction[3] = true; break;
		        
		        case Input.KEY_SUBTRACT: this.zoom-=0.2f; 
		        	System.out.println("zoom:"+zoom); break;
		        case Input.KEY_ADD: this.zoom+=0.2f; 
		        	System.out.println("zoom:"+zoom); break;
		    }
	}
	
	
	@Override
	public void update(GameContainer gc, int i) throws SlickException {
		if(this.direction[0] && (y - gc.getHeight()/2 > 0)){
			this.y -= .1f * delta;
		}
		if(this.direction[1] && (x - gc.getWidth()/2 >0)){
			this.x -= .1f * delta;
		}
		if(this.direction[2] && (y+gc.getHeight()/2 < mapSizeY)){
			this.y += .1f * delta;
		}
		if(this.direction[3] && (x+gc.getWidth()/2 < mapSizeX )){
			this.x += .1f * delta;
		}
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException
	{
		g.scale(zoom, zoom);
	    g.translate(gc.getWidth() / 2 - (int)this.x,  gc.getHeight() / 2 - (int)this.y); 
	    //mapLoader.getMap().render(0, 0);
	}
}