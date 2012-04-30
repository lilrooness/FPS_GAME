import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

/**
 * Initializes the Window and controls the rendering and the game loop
 * @author Joe Frangoudes
 *
 */
public class Window {
	
	private Sector s;
	private int width;
	private int height;
	Player p1;
	private ArrayList<Block> blocks;
	private JFrame properties;
	private JLabel xLabel;
	private JLabel zLabel;
	private JLabel pxLabel;
	private JLabel pzLabel;
	private float range = 3f;
	
	/**
	 * 
	 * @param width
	 * @param height
	 */
	public Window(int width, int height){
		properties = new JFrame();
		properties.setSize(200, 200);
		properties.setLayout(new FlowLayout());
		properties.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		xLabel = new JLabel("xPos:");
		zLabel = new JLabel("yPos:");
		pxLabel = new JLabel("px:");
		pzLabel = new JLabel("py:");
		properties.add(xLabel);
		properties.add(zLabel);
		properties.add(pxLabel);
		properties.add(pzLabel);
		
		
		properties.setVisible(true);
		this.width = width;
		this.height = height;
		blocks = new ArrayList<Block>();
		try {
			Display.setDisplayMode(new DisplayMode(width, height));
			Display.create();
		} catch (LWJGLException e) {
			JOptionPane.showMessageDialog(null, "Could not create display");
			e.printStackTrace();
		}
		p1 = new Player(10, 1.5f, -90, 0.005f, 0.05f);
		s = new Sector();
	}
	
	/**
	 * Initializes OpenGl and then starts the rendering loop
	 */
	public void render(){
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GLU.gluPerspective(45, width/height, 1, 100);
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glColor3f(1, 1, 1);
		GL11.glViewport(0, 0, width, height);
		GLU.gluLookAt(10, 0, -90, 0, 0, -10, 0, 1, 0);
		initBlocks();
		
		/*
		 * Main game loop
		 */
		while(!Display.isCloseRequested()){
			xLabel.setText("xPos: "+p1.getX());
			zLabel.setText("zPos: "+p1.getZ());
			pxLabel.setText("px: "+p1.getX()+p1.getLx()*range);
			pzLabel.setText("pz: "+p1.getZ()+p1.getLz()*range);
			
			GL11.glLoadIdentity();
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
			p1.move();
			//updates the "Camera's" location to be on the players coordinates
			GLU.gluLookAt(p1.getX(), p1.getY(), p1.getZ(), 
						  p1.getX()+p1.getLx(), p1.getY(), p1.getZ()+p1.getLz(),
						  0, 1, 0);
			renderSurroundings();
			s.render();
			
			GL11.glDisable(GL11.GL_TEXTURE_2D);
			GL11.glBegin(GL11.GL_LINES);
			GL11.glVertex3f(0, 0, 0);
			GL11.glVertex3f(0, 20, 0);
			
			GL11.glVertex3f(0, 0, 0);
			GL11.glVertex3f(20, 0, 0);
			
			GL11.glVertex3f(0, 0, 0);
			GL11.glVertex3f(0, 0, 20);
			GL11.glEnd();
			GL11.glEnable(GL11.GL_TEXTURE_2D);
			handleCollisions();
			pollInput();
			Display.update();
		}
		
		Display.destroy();
	}
	
	/**
	 * gets the keyboard input and changes the players movement flags
	 */
	public void pollInput(){
		p1.setForward(Keyboard.isKeyDown(Keyboard.KEY_W));
		p1.setBackward(Keyboard.isKeyDown(Keyboard.KEY_S));
		p1.setRight(Keyboard.isKeyDown(Keyboard.KEY_D)); 
		p1.setLeft(Keyboard.isKeyDown(Keyboard.KEY_A));
	}
	
	/**
	 * Initializes all of the blocks in the scene
	 */
	public void initBlocks(){
		for(int i=0; i<5; i++){
			for(int j=0; j<5; j++){
				blocks.add(new Block(10 * i, 0,  10 * j, 2));
			}
		}
	}
	
	/**
	 * Calls the render function on all of the
	 * blocks in the scene
	 */
	public void renderSurroundings(){
		for(int i=0; i<blocks.size(); i++){
			blocks.get(i).renderObject();
		}
	}
	
	/**
	 * Checks for collisions and handles them
	 */
	public void handleCollisions(){
		
		//check test block collisions
		for(int i=0; i<blocks.size(); i++){
			if(Collisions.rayBox(p1, blocks.get(i), range)){
				p1.revert();
			}
		}
		
		/*
		//check sector block collisions
		for(int i=0; i<s.getMiddle().size(); i++){
			if(Collisions.rayBox(p1, s.getMiddle().get(i), 3)){
				p1.revert();
			}
		}*/
	}
}
