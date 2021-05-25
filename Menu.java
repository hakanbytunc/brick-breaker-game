package project;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Menu extends JFrame implements ActionListener {

	public static void main(String[] args){
		
		Sound menuMusic = new Sound("/Users/hakantunc/Desktop/Menu_Music.wav");
		
		JButton newgame = new JButton("New Game");
		JButton options = new JButton("Options");
		JButton highscores = new JButton("High Scores");
		JButton help = new JButton("Help");
		JButton about = new JButton("About");
		JButton exit = new JButton("Exit");
		String username;
		
		Icon menu = new ImageIcon(Menu.class.getResource("menu.jpeg"));
		JLabel background = new JLabel(menu);
			
		JFrame loginFrame = new JFrame("Arkanoid Play Game");
		loginFrame.add(newgame);
		loginFrame.add(options);
		loginFrame.add(highscores);
		loginFrame.add(help);
		loginFrame.add(about);
		loginFrame.add(exit);
		
		loginFrame.setLayout(new FlowLayout());
		
		loginFrame.add(background);
		loginFrame.setVisible(true);
		loginFrame.setSize(650, 1155);
		loginFrame.setResizable(false);
		loginFrame.setLocationRelativeTo(null);
		loginFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		menuMusic.play();
		newgame.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent d){
				  
				JFrame levelFrame = new JFrame("Choose Level");
				  
				  JButton level1 = new JButton("1");
				  JButton level2 = new JButton("2");
				  JButton level3 = new JButton("3");
				  JButton level4 = new JButton("4");				

				  levelFrame.add(level1);
				  levelFrame.add(level2);
				  levelFrame.add(level3);
				  levelFrame.add(level4);
				  levelFrame.setLayout(new FlowLayout());
				  levelFrame.setSize(350, 80);
				  levelFrame.setResizable(false);
				  levelFrame.setLocationRelativeTo(null);
				  levelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				  levelFrame.setVisible(true);
				  levelFrame.setFocusable(true);
				  level1.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent d){
							Game.mainLevel=1;
							Game.frameBool=true;
							levelFrame.setVisible(false);
							Game gameFrame = new Game();
							if(Game.frameBool) {
								try {
									gameFrame.createGUI(Game.mainLevel);
									loginFrame.setVisible(false);
									Thread t = new Thread(gameFrame);
									menuMusic.stop();
									t.start();	
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (UnsupportedAudioFileException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (LineUnavailableException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						}	
					});
				level2.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent d){
							Game.mainLevel=2;
							Game.frameBool=true;
							levelFrame.setVisible(false);
							Game gameFrame = new Game();
							if(Game.frameBool) {
								try {
									gameFrame.createGUI(Game.mainLevel);
									loginFrame.setVisible(false);
									Thread t = new Thread(gameFrame);
									menuMusic.stop();
									t.start();	
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (UnsupportedAudioFileException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (LineUnavailableException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						}	
					});
				  level3.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent d){
							Game.mainLevel=3;
							Game.frameBool=true;
							levelFrame.setVisible(false);
							Game gameFrame = new Game();
							if(Game.frameBool) {
								try {
									gameFrame.createGUI(Game.mainLevel);
									loginFrame.setVisible(false);
									Thread t = new Thread(gameFrame);
									menuMusic.stop();
									t.start();	
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (UnsupportedAudioFileException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (LineUnavailableException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						}	
					});
				  level4.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent d){
							Game.mainLevel=4;
							Game.frameBool=true;
							levelFrame.setVisible(false);
							Game gameFrame = new Game();
							if(Game.frameBool) {
								try {
									gameFrame.createGUI(Game.mainLevel);
									loginFrame.setVisible(false);
									Thread t = new Thread(gameFrame);
									menuMusic.stop();
									t.start();	
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (UnsupportedAudioFileException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (LineUnavailableException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						}	
					});
				
			}	
		});
	
		options.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent d){
				String[] options = new String[] {"Mouse", "Keyboard"};
			    int response = JOptionPane.showOptionDialog(null, "Choose your control type", "Options",
			        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
			        null, options, null);
			  if(response==0) {
				  JOptionPane.showInputDialog("This option is only available for only Premium Users(9.999€/day)\nPlease enter your credit card number");

			  }
			
			}	
		});
		
		help.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent d){
				Icon help = new ImageIcon(Menu.class.getResource("help.gif"));
				JOptionPane.showMessageDialog(null," There are two types of bricks: one that is solid and cannot be broken, second that can be broken with one hit of a ball and third that can be broken with two hits.\n" + 
						" Power Up: Increases the length of the paddle.\n" + 
						" Power Up: Decreases the length of the paddle.\n" + 
						" Power Up: Increase the speed of the ball by 25%\n" + 
						" Power Up: Decrease the speed of the ball by 25%\n" + 
						" Power Up: Transform all balls on the field to fireballs. Fireballs break through every brick (except unbreakable)\n" + 
						" Power Up: The ball will lose its energy for 12 seconds. During that time it cannot break bricks.\n" + 
						" Power Up: Grants an extra life\n" + 
						" Power Up: Loses a life\n" + 
						" Power Up: Grants the paddle the ability to catch the ball and release it when necessary.\n" + 
						" Power Up: Creates a shield in line with the paddle for 15 seconds. The shield prevents ball falling down.\n" + 
						" Power Up: The paddle shoots lasers for 8 seconds. These laser beams destroy all bricks except the unbreakable ones","HELP ME", JOptionPane.INFORMATION_MESSAGE, help);
			}	
		});
		
		about.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent d){
				JOptionPane.showMessageDialog(null, "Copyright © 2019 by Hakan Tunç\n" + 
						"\n" + 
						"All rights reserved. No part of this publication may be reproduced, distributed, or transmitted in any form or by any means,\n"
						+ "including photocopying, recording, or other electronic or mechanical methods, without the prior written permission of the publisher,\n"
						+ "except in the case of brief quotations embodied in critical reviews and certain other noncommercial uses permitted by copyright law.\n"
						+ "For permission requests, write to the publisher, addressed “Attention: Permissions Coordinator,” at the address below.\n" + 
						"\n" + 
						"Imaginary Press\n" + 
						"1233 Pennsylvania Avenue\n" + 
						"San Francisco, CA 94909\n" + 
						"www.hakantunc.com\n" + 
						"\n" + 
						"Ordering Information:\n" + 
						"Quantity sales. Special discounts are available on quantity purchases by corporations, associations, and others. For details, contact the publisher at the address above.\n" + 
						"Orders by U.S. trade bookstores and wholesalers. Please contact Big Distribution: Tel: (800) 800-8000; Fax: (800) 800-8001 or visit www.bigbooks.com.\n" + 
						"\n" + 
						"Printed in the United States of America\n"
						+ "Please contact hakan.tunc1@std.yeditepe.edu.tr");
			}	
		});
		
		
		exit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent d){
				System.exit(0);
			}	
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}