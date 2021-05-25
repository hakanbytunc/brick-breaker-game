package project;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JComponent;
import javax.swing.JLabel;

public class Bricks {
	static JLabel brickLabels[][] = new JLabel[4][4];
	static JLabel easybrickLabels[][] = new JLabel[8][4];
	static JLabel hardbrickLabels[][] = new JLabel[16][4];
	static JLabel superhardbrickLabels[][] = new JLabel[2][4];
	public static int brickCount=16;
	static int randomA=new Random().nextInt(3);


	
	public static void createBricks(int brickLevel){
			  if(brickLevel==1) {
			  int brickX=25;
			  int brickY=100;
			  int brickCount=16;

			  //JLabel brickLabels[][] = new JLabel[4][4];
			  for(int i = 0; i < 4; i++) {
				  for (int j=0;j<4;j++) {
					  brickLabels[i][j] = new JLabel(Game.easyBrickIcon);
				  }
				}
					 for (int i=0;i<4;i++) {
						 for (int j=0;j<4;j++) {
							 brickLabels[i][j].setBounds(brickX, brickY, 150, 20);
							 brickX+=152;
							 Game.panel.add(brickLabels[i][j]);
						 }
						 brickX=25;
						 brickY+=22;
					 }
			  }
			  if(brickLevel==2) {
				  int brickX=25;
				  int brickY=100;
				  int brickCount=48;
				  //JLabel easyBrickLabels[][] = new JLabel[8][4];
				  for(int i = 0; i <8; i++) {
					  for (int j=0;j<4;j++) {
						  easybrickLabels[i][j] = new JLabel(Game.easyBrickIcon);
					  }
					}
						 for (int i=0;i<8;i++) {
							 for (int j=0;j<4;j++) {
								 easybrickLabels[i][j].setBounds(brickX, brickY, 150, 20);
								 brickX+=152;
								 Game.panel.add(easybrickLabels[i][j]);
							 }
							 brickX=25;
							 brickY+=22;
						 }
					 //JLabel hardBrickLabels[][] = new JLabel[4][4];
					  for(int i = 0; i < 4; i++) {
						  for (int j=0;j<4;j++) {
							  hardbrickLabels[i][j] = new JLabel(Game.hardBrickIcon);
						  	  }
						  }
						 for (int i=0;i<4;i++) {
							 for (int j=0;j<4;j++) {
								 hardbrickLabels[i][j].setBounds(brickX, brickY, 150, 20);
								 brickX+=152;
								 Game.panel.add(hardbrickLabels[i][j]);
							 }
							 brickX=25;
							 brickY+=22;
						 }
				  }
			  if(brickLevel==3) {
				  int brickX=25;
				  int brickY=100;
				  int brickCount=104;
				  //JLabel brickLabels[][] = new JLabel[16][4];
				  for(int i = 0; i<8; i++) {
					  for (int j=0;j<4;j++) {
						  easybrickLabels[i][j] = new JLabel(Game.easyBrickIcon);
					  }
					}
						 for (int i=0;i<8;i++) {
							 for (int j=0;j<4;j++) {
								 easybrickLabels[i][j].setBounds(brickX, brickY, 150, 20);
								 brickX+=152;
								 Game.panel.add(easybrickLabels[i][j]);
							 }
							 brickX=25;
							 brickY+=22;
						 }
					 //JLabel hardBrickLabels[][] = new JLabel[8][4];
					  for(int i = 0; i < 16; i++) {
						  for (int j=0;j<4;j++) {
							  hardbrickLabels[i][j] = new JLabel(Game.hardBrickIcon);
						  }
						}
							 for (int i=0;i<16;i++) {
								 for (int j=0;j<4;j++) {
									 hardbrickLabels[i][j].setBounds(brickX, brickY, 150, 20);
									 brickX+=152;
									 Game.panel.add(hardbrickLabels[i][j]);
								 }
								 brickX=25;
								 brickY+=22;
							 }
					//JLabel superhardBrickLabels[][] = new JLabel[4][4];
					  for(int i = 0; i < 2; i++) {
						  for (int j=0;j<4;j++) {
							  superhardbrickLabels[i][j] = new JLabel(Game.superhardBrickIcon);
						  }
						}
							 for (int i=0;i<2;i++) {
								 for (int j=0;j<4;j++) {
									 superhardbrickLabels[i][j].setBounds(brickX, brickY, 150, 20);
									 brickX+=152;
									 Game.panel.add(superhardbrickLabels[i][j]);
								 }
								 brickX=25;
								 brickY+=22;
							 }
				  }
			  if(brickLevel==4) {
				  int brickX=25;
				  int brickY=100;	
				  int brickCount=108;
				  JLabel brickLabels[][] = new JLabel[16][4];
				  for(int i = 0; i < brickLabels.length; i++) {
					  for (int j=0;j<4;j++) {
						  brickLabels[i][j] = new JLabel(Game.easyBrickIcon);
					  }
					}
						 for (int i=0;i<16;i++) {
							 for (int j=0;j<4;j++) {
								 brickLabels[i][j].setBounds(brickX, brickY, 150, 20);
								 brickX+=152;
								 Game.panel.add(brickLabels[i][j]);
							 }
							 brickX=25;
							 brickY+=22;
						 }
					JLabel hardBrickLabels[][] = new JLabel[8][4];
					  for(int i = 0; i < 8; i++) {
						  for (int j=0;j<4;j++) {
							  hardBrickLabels[i][j] = new JLabel(Game.hardBrickIcon);
						  }
						}
							 for (int i=0;i<8;i++) {
								 for (int j=0;j<4;j++) {
									 hardBrickLabels[i][j].setBounds(brickX, brickY, 150, 20);
									 brickX+=152;
									 Game.panel.add(hardBrickLabels[i][j]);
								 }
								 brickX=25;
								 brickY+=22;
							 }
					 JLabel superhardBrickLabels[][] = new JLabel[4][4];
					  for(int i = 0; i < 4; i++) {
						  for (int j=0;j<4;j++) {
							  superhardBrickLabels[i][j] = new JLabel(Game.superhardBrickIcon);
						  }
						}
							 for (int i=0;i<4;i++) {
								 for (int j=0;j<4;j++) {
									 superhardBrickLabels[i][j].setBounds(brickX, brickY, 150, 20);
									 brickX+=152;
									 Game.panel.add(superhardBrickLabels[i][j]);
								 }
								 brickX=25;
								 brickY+=22;
							 }
						 JLabel extrahardBrickLabels[][] = new JLabel[2][4];
						  for(int i = 0; i < 2; i++) {
							  for (int j=0;j<4;j++) {
								  extrahardBrickLabels[i][j] = new JLabel(Game.extrahardBrickIcon);
							  }
							}
								 for (int i=0;i<2;i++) {
									 for (int j=0;j<4;j++) {
										 extrahardBrickLabels[i][j].setBounds(brickX, brickY, 150, 20);
										 brickX+=152;
										 Game.panel.add(extrahardBrickLabels[i][j]);
									 }
									 brickX=25;
									 brickY+=22;
								 }
				  }
			  

	}


	
}
