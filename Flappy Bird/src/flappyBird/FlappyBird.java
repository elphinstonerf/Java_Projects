package flappyBird;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class FlappyBird implements ActionListener, MouseListener, KeyListener{
	
	public Renderer renderer;
	
	// Bird Stuff
	public static Rectangle bird;
	public static int ticks, yMotion, score = 0;
	public static boolean gameOver, started = false;
	
	// WindowSize
	public static final int WIDTH = 800, HEIGHT = 800;
	
	// Moving Columns.
	public static ArrayList<Rectangle> columns;
	public Random rand;
	
	public  FlappyBird() {
	
	JFrame gframe = new JFrame();
	Timer timer = new Timer(20, this);
	
	renderer = new Renderer();
	rand = new Random();
	
	gframe.add(renderer);
	gframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	gframe.setSize(WIDTH, HEIGHT);
	gframe.addMouseListener(this);
	gframe.setTitle("My Flappy Bird!");
	gframe.setResizable(true);
	gframe.setVisible(true);
	
	// Moving Objects
	bird = new Rectangle(WIDTH / 2 - 10, HEIGHT / 2 - 10, 20, 20);
	columns = new ArrayList<Rectangle>();
	
	addColumn(true);
	addColumn(true);
	addColumn(true);
	addColumn(true);
	
	timer.start();
	}

	public void addColumn(boolean start) {
		int space = 300;
		int width = 100;
		int height = 50 + rand.nextInt(300);
		
		if (start) {
			columns.add(new Rectangle(WIDTH + width + columns.size() * 300, HEIGHT - height - 120, width, height));
			columns.add(new Rectangle(WIDTH + width + (columns.size() - 1) * 300, 0, width, HEIGHT - height - space));
		}
		else {
			columns.add(new Rectangle(columns.get(columns.size() - 1).x + 600, HEIGHT - height - 120, width, height));
			columns.add(new Rectangle(columns.get(columns.size() - 1).x, 0, width, HEIGHT - height - space));
		}
	}
	
	public static void paintColumn(Graphics g, Rectangle column) {
		g.setColor(Color.green.darker());
		g.fillRect(column.x, column.y, column.width, column.height);
	}
	
	public void jump() {
		if (gameOver) {
			bird = new Rectangle(WIDTH / 2 - 10, HEIGHT / 2 - 10, 20, 20);
			columns.clear();
			yMotion = 0;
			score = 0;
			
			addColumn(true);
			addColumn(true);
			addColumn(true);
			addColumn(true);
			
		}
		if (!started) {
			started = true;
		}
		else if (!gameOver) {
			if (yMotion > 0) {
				yMotion = 0;
			}
			else {
				yMotion -= 30;
			}
		}
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// More Bird
		int speed = 10;
		ticks ++;
		
		if (started)
		{
			for (int i = 0; i < columns.size(); i++){
				Rectangle column = columns.get(i);
				column.x -= speed;
			}

			if (ticks % 2 == 0 && yMotion < 15){
				yMotion += 2;
			}
			
			for (int i = 0; i < columns.size(); i++){
				Rectangle column = columns.get(i);
				if (column.x + column.width < 0){
					columns.remove(column);
					if (column.y == 0){
					addColumn(false);
					}
				}
				
			}
		
			bird.y += yMotion;
		
			for (Rectangle column : columns) {
				if (column.y == 0 && bird.x + bird.width / 2 > column.x + column.width / 2 - 10 && bird.x + bird.width / 2 < column.x + column.width / 2 + 10) {
					score++;
				}
				if (column.intersects(bird)) {
					gameOver = true;
					
					bird.x = column.x - bird.width;
				}
			}
		
			if(bird.y > HEIGHT - 120 || bird.y < 0) {
				gameOver = true;
			}
			if (gameOver) {
				bird.y = HEIGHT - 120 - bird.height;
			}
		}
		renderer.repaint();
	}
	
	public static void repaint(Graphics g) {
		//Background
		g.setColor(Color.cyan);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		//Ground
		g.setColor(Color.orange);
		g.fillRect(0, HEIGHT - 150, WIDTH, 150);
		
		//Grass
		g.setColor(Color.green);
		g.fillRect(0, HEIGHT - 150, WIDTH, 20);
		
		
		// Bird
		g.setColor(Color.red);
		g.fillRect(bird.x, bird.y, bird.width, bird.height);
		
		for (Rectangle column : columns) {
			paintColumn(g, column);
		}
		
		g.setColor(Color.white);
		g.setFont(new Font("Arial", 1, 100));
		
		if (!gameOver) {
			g.drawString("Click to Play!", 75, HEIGHT / 2 - 50);
		}
		if (gameOver) {
			g.drawString("Game Over", 75, HEIGHT / 2 - 50);
		}
		if (!gameOver &&  started) {
			g.drawString(String.valueOf(score), WIDTH / 2  - 25, 100);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		jump();
		
	}
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			jump();
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	
}
