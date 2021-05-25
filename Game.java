package project;
import java.awt.FlowLayout;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Game extends JPanel implements KeyListener, ActionListener,Runnable {
	  private JFrame frame;
	  static JPanel panel;
	  private Icon barIcon,ballIcon;
	static Icon easyBrickIcon;
	static Icon hardBrickIcon;
	static Icon superhardBrickIcon;
	static Icon extrahardBrickIcon;
	static Icon barBuyutme;
	static Icon speedUp;
	static Icon speedDown;
	static Icon death;
	  private JLabel barLabel;
	public static JLabel ballLabel;
	  private int barX=300;
	  private int barY=1090;
	  private int ballX=350;
	  private int ballY=1050;
	  public static JTextField score,life,level;
	  static int scoreInt=0;
	  static int lifeInt=3;
	  static int levelInt;
	  static SuperPower sp = new SuperPower();
	  int xDir=-1;
	  int yDir=-1;
	  int speed=10;
	  static int mainLevel=0;
	  static boolean frameBool=false;
	  boolean play=false;
	  Sound bounce = new Sound("/Users/hakantunc/Desktop/Courses/CSE212/2/Bounce.wav");
	  Sound smash = new Sound("/Users/hakantunc/Desktop/Courses/CSE212/2/Smash.wav");
	  static Icon superPowerIconBar;
	  static int ijtoplam=0;
	static int spPosx;
		static int spPosy;
		static int randomS;
	  
	public void createGUI(int levelInput) throws IOException, UnsupportedAudioFileException, LineUnavailableException{
	      score=new JTextField("Score: " + scoreInt);
	      life=new JTextField("Life: " + lifeInt);
	      level=new JTextField("Level: " + levelInt);
		  frame = new JFrame("Game Play");  
		  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  panel = new JPanel();
		  panel.setLayout(null);
		  barIcon=new ImageIcon(getClass().getResource("bar.png"));
		  ballIcon=new ImageIcon(getClass().getResource("ball.png"));
		  easyBrickIcon=new ImageIcon(getClass().getResource("brick.png"));
		  hardBrickIcon=new ImageIcon(getClass().getResource("hardBrick.png"));
		  superhardBrickIcon=new ImageIcon(getClass().getResource("superHardBrick.png"));
		  extrahardBrickIcon=new ImageIcon(getClass().getResource("extraHardBrick.png"));
		  barBuyutme=new ImageIcon(getClass().getResource("barPowerUp.png"));
		  speedUp=new ImageIcon(getClass().getResource("SpeedUp.png"));
		  speedDown=new ImageIcon(getClass().getResource("SpeedDown.png"));
		  death=new ImageIcon(getClass().getResource("Death.png"));
		  score.setBounds(10,10, 80, 50);
		  score.setEnabled(false);
		  life.setBounds(550,10, 80, 50);
		  life.setEnabled(false);
		  level.setBounds(300,10, 80, 50);
		  level.setEnabled(false);
		  barLabel = new JLabel(barIcon);

		  barLabel.setBounds(barX, barY, 150, 20);
		  ballLabel = new JLabel(ballIcon);
		  ballLabel.setBounds(ballX, ballY, 40, 40); 
		  panel.add(barLabel); 
		  panel.add(ballLabel);
		  panel.add(score);
		  panel.add(life);
		  panel.add(level);
		  frame.add(panel);
		  frame.setSize(650,1155);
		  frame.addKeyListener(this);
		  frame.setVisible(true);
		  frame.setLocationRelativeTo(null);
		  levelInt=levelInput;
		  Bricks.createBricks(levelInput);
			
		  
		  
		  
	}               
	
	  public void moveBox(int newX,int newY)
	  {
		  barLabel.setBounds(newX, newY, 150, 20); 
	  }
	  public void moveBall(int newX,int newY)
	  {
		  ballLabel.setBounds(newX, newY, 40, 40);
	  }
	  
 
	  @Override
	  public void keyPressed(KeyEvent event) {

	  	int key = event.getKeyCode();
	  	if(key == KeyEvent.VK_LEFT)
	  	{
	  		changeLayoutLeft();
	  	}else if(key==KeyEvent.VK_RIGHT){
	  		changeLayoutRight();
	  	}
	  	else if((key==KeyEvent.VK_Q)){
			System.exit(0);
		}
	  	else if((key==KeyEvent.VK_Y)){
			speed--;
		}
	  	else if((key==KeyEvent.VK_U)){
			speed++;
		}
	  	else if((key==KeyEvent.VK_SPACE)){
			if (play) {
				play=false;
			}
			else {
				play=true;
			}
		}
	  }
	  public void changeLayoutLeft()
	  {
	  	if(barX>0) {
			barX-=50;
		  	moveBox(barX,barY);	
	  	}
	  }
	  public void changeLayoutRight()
	  {
		  if(barX<500) {
				barX+=50;	
			  	moveBox(barX,barY);
			  	
		  	}
		  
	  }
	  
	  

	  public void changeBallLayoutUP()
	  {
			ballY+=yDir;
			ballX-=xDir;
		  	moveBall(ballX,ballY);
	  }
	  
	  @Override
	  public void keyReleased(KeyEvent arg0) {
	  	// TODO Auto-generated method stub
	  }
	  @Override
	  public void keyTyped(KeyEvent arg0) {
	  	// TODO Auto-generated method stub
	  }
	  @Override
	  public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub	
	  }

	  @Override
	  public void run() {
	  	while(true) {
	  		if(lifeInt==0) {	
	  			String username= JOptionPane.showInputDialog("Your score is:"
	  					+score.getText()
	  					+ "\nEnter Your name");

					try {
						BufferedWriter wr = new BufferedWriter(new FileWriter("Login.txt", true));
						wr.append(username);
						System.out.println(username);
						wr.newLine();
						wr.newLine();
						wr.append(score.getText());
						System.out.println(score.getText());
						wr.newLine();
						wr.close();
						System.exit(1); 
					}		      
					catch (IOException e) {
						System.out.println("No file");
					}
			  }
	  		if(play) {
	  			changeBallLayoutUP();
	  		}
	  		if(mainLevel==1) {
		  		for(int i = 0; i <4; i++) {
						  for (int j=0;j<4;j++) {
							  if(Bricks.brickLabels[i][j].getBounds().intersects(ballLabel.getBounds())) {
								  spPosx=Bricks.brickLabels[i][j].getX();
								  spPosy=Bricks.brickLabels[i][j].getY();
								  int randomZ =new Random().nextInt(1);
								  randomS=new Random().nextInt(4);
								if(randomZ==0) {
								  	sp.createSuperPower(Bricks.brickLabels[i][j].getX(),Bricks.brickLabels[i][j].getY(),randomS);
								  	Bricks.randomA=new Random().nextInt(3);
						  			Thread t2 = new Thread(sp);
								  	t2.start();
								  }
								  System.out.println(i+j);
								  Bricks.brickLabels[i][j].setBounds(-100000, -100000, 0, 0);
								  smash.play();
								  scoreInt+=5;
								  score.setText("Score: "+scoreInt);
								  yDir*=-1;
								  Bricks.brickCount--;
								  if(Bricks.brickCount==0) {
									  mainLevel++;
								  }
							  }
							  
						  }
						}
							  if(ballLabel.getBounds().intersects(barLabel.getBounds())) {
								  //Bricks.brickLabels[i][j].setVisible(false);
								  //Bricks.brickLabels[i][j].setBounds(-100000, -100000, 0, 0);
								  yDir*=-1;
								  bounce.play();
	
						}
							  if(ballX==0) {
								  xDir*=-1;
								  bounce.play();
							  }
							  if(ballX==600) {
								  xDir*=-1;
								  bounce.play();
							  }
							  if(ballY==0) {
								  yDir*=-1;
								  bounce.play();
							  }
							  if(ballY>1060) {
								 lifeInt--;
								 life.setText("Life: " + lifeInt);
								 yDir*=-1;
								  barX=300;
								  barY=1090;
								  ballX=350;
								  ballY=1050;
								  play=false;
							  }
						  }
	  		if(mainLevel==2) {	 
		  		for(int i = 0; i <8; i++) {
						  for (int j=0;j<4;j++) {
							  if(Bricks.easybrickLabels[i][j].getBounds().intersects(ballLabel.getBounds())) {
								  //Bricks.brickLabels[i][j].setVisible(false);
								  Bricks.easybrickLabels[i][j].setBounds(-100000, -100000, 0, 0);
								  smash.play();
								  scoreInt+=5;
								  score.setText("Score: "+scoreInt);
								  yDir*=-1;
								  Bricks.brickCount--;
								  if(Bricks.brickCount==0) {
									  levelInt++;
								  }
							  }
						  }
						}
		  		for(int k = 0; k<4; k++) {
					  for (int l=0;l<4;l++) {
						  if(Bricks.hardbrickLabels[k][l].getBounds().intersects(ballLabel.getBounds())) {  
							  System.out.println(k+l);
							  Bricks.hardbrickLabels[k][l].setBounds(-100000, -100000, 1, 1);
							  smash.play();
							  scoreInt+=5;
							  score.setText("Score: "+scoreInt);
							  yDir*=-1;
							  Bricks.brickCount--;
							  if(Bricks.brickCount==0) {
								  levelInt++;
							  }
						  }
					  }
					}
							  if(ballLabel.getBounds().intersects(barLabel.getBounds())) {
								  //Bricks.brickLabels[i][j].setVisible(false);
								  //Bricks.brickLabels[i][j].setBounds(-100000, -100000, 0, 0);
								  yDir*=-1;
								  bounce.play();
	
						}
							  if(ballX==0) {
								  xDir*=-1;
								  bounce.play();
							  }
							  if(ballX==600) {
								  xDir*=-1;
								  bounce.play();
							  }
							  if(ballY==0) {
								  yDir*=-1;
								  bounce.play();
							  }
							  if(ballY>1060) {
								 lifeInt--;
								 life.setText("Life: " + lifeInt);
								 yDir*=-1;
								  barX=300;
								  barY=1090;
								  ballX=350;
								  ballY=1050;
								  play=false;
							  }
						  }
	  		if(mainLevel==3) {	 
		  		for(int i = 0; i <8; i++) {
						  for (int j=0;j<4;j++) {
							  if(Bricks.easybrickLabels[i][j].getBounds().intersects(ballLabel.getBounds())) {
								  //Bricks.brickLabels[i][j].setVisible(false);
								  Bricks.easybrickLabels[i][j].setBounds(-100000, -100000, 0, 0);
								  smash.play();
								  scoreInt+=5;
								  score.setText("Score: "+scoreInt);
								  yDir*=-1;
								  Bricks.brickCount--;
								  if(Bricks.brickCount==0) {
									  levelInt++;

								  }
							  }
						  }
						}
		  		for(int k = 0; k<16; k++) {
					  for (int l=0;l<4;l++) {
						  if(Bricks.hardbrickLabels[k][l].getBounds().intersects(ballLabel.getBounds())) {
							  Bricks.hardbrickLabels[k][l].setBounds(-100000, -100000, 1, 1);
							  smash.play();
							  scoreInt+=5;
							  score.setText("Score: "+scoreInt);
							  yDir*=-1;
							  Bricks.brickCount--;
							  if(Bricks.brickCount==0) {
								  levelInt++;
							  }
						  }
					  }
					}
		  		for(int k = 0; k<2; k++) {
					  for (int l=0;l<4;l++) {
						  if(Bricks.superhardbrickLabels[k][l].getBounds().intersects(ballLabel.getBounds())) {
							  Bricks.superhardbrickLabels[k][l].setBounds(-100000, -100000, 1, 1);
							  smash.play();
							  scoreInt+=5;
							  score.setText("Score: "+scoreInt);
							  yDir*=-1;
							  Bricks.brickCount--;
							  if(Bricks.brickCount==0) {
								  levelInt++;
							  }
						  }
					  }
					}
							  if(ballLabel.getBounds().intersects(barLabel.getBounds())) {
								  //Bricks.brickLabels[i][j].setVisible(false);
								  //Bricks.brickLabels[i][j].setBounds(-100000, -100000, 0, 0);
								  yDir*=-1;
								  bounce.play();
	
						}
							  if(ballX==0) {
								  xDir*=-1;
								  bounce.play();
							  }
							  if(ballX==600) {
								  xDir*=-1;
								  bounce.play();
							  }
							  if(ballY==0) {
								  yDir*=-1;
								  bounce.play();
							  }
							  if(ballY>1060) {
								 lifeInt--;
								 life.setText("Life: " + lifeInt);
								 yDir*=-1;
								  barX=300;
								  barY=1090;
								  ballX=350;
								  ballY=1050;
								  play=false;
							  }
						  }
	  		
	  		if(mainLevel==1) {
		  		try {
		  			Thread.sleep(speed-5);
		  		} catch (InterruptedException e) {
		  			// TODO Auto-generated catch block
		  			e.printStackTrace();
		  		}
	  		}
	  		if(mainLevel==2) {
		  		try {
		  			Thread.sleep(speed-2);
		  		} catch (InterruptedException e) {
		  			// TODO Auto-generated catch block
		  			e.printStackTrace();
		  		}
	  		}
	  		if(mainLevel==3) {
		  		try {
		  			Thread.sleep(speed-3);
		  		} catch (InterruptedException e) {
		  			// TODO Auto-generated catch block
		  			e.printStackTrace();
		  		}
	  		}
	  		if(mainLevel==4) {
		  		try {
		  			Thread.sleep(speed-4);
		  		} catch (InterruptedException e) {
		  			// TODO Auto-generated catch block
		  			e.printStackTrace();
		  		}
	  		}
	  		System.out.println("Random A:"+Bricks.randomA);
	  		System.out.println("ijtoplam:"+ijtoplam);
	  	}
	  }

}
	  
