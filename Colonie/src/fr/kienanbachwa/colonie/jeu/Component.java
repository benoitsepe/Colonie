package fr.kienanbachwa.colonie.jeu;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.util.glu.GLU;

import static org.lwjgl.opengl.GL11.*;

public class Component {
	
	public static int scale = 3;
	public static int width = 1024 / scale;
	public static int height = 576 / scale;
	public boolean running = false;
	
	DisplayMode mode = new DisplayMode(width * scale, height * scale);
	int time = 0;
	
	public static boolean tick = false;
	public static boolean render = false;
	
	public static String title = "TEH BEST GAME EVAH";
	
	Game game;
	
	public Component(){
		display();
		game = new Game();
	}
	
	public void display(){
		try {
			Display.setDisplayMode(mode);
			Display.setResizable(true);
			Display.setFullscreen(false);
			Display.setTitle(title);
			Display.create();
			
			view2D(width, height);
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
	}
	private void view2D(int width, int height) {
		glViewport(0, 0, width * scale, height * scale);
		
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		GLU.gluOrtho2D(0, width, height, 0);
		glMatrixMode(GL_MODELVIEW);
		glLoadIdentity();
		
		glEnable(GL_TEXTURE_2D);
		
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
	}
	
	public void start(){
		running=true;
		loop();
	}
	public void tick(){
		time++;
		game.tick();
	}
	
	public void loop(){
		
		game.init();
		
		long timer = System.currentTimeMillis();
		
		long before = System.nanoTime();
		double elapsed = 0;
		double nanoSeconds = 1000000000.0/60.0;
		
		int ticks = 0;
		int frames = 0;
		
		while(running){
			if(Display.isCloseRequested()) stop();
			Display.update();
			
			width = Display.getWidth() / scale;
			height = Display.getHeight() / scale;
			
			tick = false;
			render = false;
			
			long now = System.nanoTime();
			elapsed = now-before;
			
			if(elapsed > nanoSeconds){
				before += nanoSeconds;
				tick = true;
				ticks++;
			}else{
				render = true;
				frames++;
			}
			
			if(tick) tick();
			if(render) render();
			
			if(System.currentTimeMillis() - timer > 1000){
				timer +=1000;
				Display.setTitle("ticks:"+ticks+" FPS:"+frames+" | "+title);
				ticks = 0;
				frames = 0;
			}
		}
		exit();
	}
	
	public void render(){
		view2D(width , height);
		glClear(GL_COLOR_BUFFER_BIT);
		game.render();
	}
	
	public void stop(){
		running=false;
	}
	
	public void exit(){
		Display.destroy();
		System.exit(0);
	}

	
	
}
