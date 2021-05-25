package project;

import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class SuperPower implements Runnable{

	static JLabel superPowerBar = new JLabel();
	static JLabel superPowerSpeedUp = new JLabel();
	static JLabel superPowerSpeedDown = new JLabel();
	static JLabel superPowerDeath = new JLabel();
	
	public static void createSuperPower(int x,int y,int randomS) {
		if(randomS==0) {
			superPowerBar.setIcon(Game.barBuyutme);
			superPowerBar.setBounds(x, y, 40, 43);
			Game.panel.add(superPowerBar);
		}
		if(randomS==1) {
			superPowerSpeedUp.setIcon(Game.speedUp);
			superPowerSpeedUp.setBounds(x, y, 40, 43);
			Game.panel.add(superPowerSpeedUp);
		}
		if(randomS==2) {
			superPowerSpeedDown.setIcon(Game.speedDown);
			superPowerSpeedDown.setBounds(x, y, 40, 43);
			Game.panel.add(superPowerSpeedDown);
		}
		if(randomS==3) {
			superPowerDeath.setIcon(Game.death);
			superPowerDeath.setBounds(x, y, 40, 43);
			Game.panel.add(superPowerDeath);
		}
	}

	@Override
	public void run() {
		while (true) {
			if(Game.randomS==0) {
				superPowerBar.setBounds((Game.spPosx+(Game.spPosx/2)), Game.spPosy++, 40, 43);
			}
			if(Game.randomS==1) {
				superPowerSpeedUp.setBounds((Game.spPosx+(Game.spPosx/2)), Game.spPosy++, 40, 43);
			}
			if(Game.randomS==2) {
				superPowerSpeedDown.setBounds((Game.spPosx+(Game.spPosx/2)), Game.spPosy++, 40, 43);
			}
			if(Game.randomS==3) {
				superPowerDeath.setBounds((Game.spPosx+(Game.spPosx/2)), Game.spPosy++, 40, 43);
			}

			try {
	  			Thread.sleep(15);
				
	  		} catch (InterruptedException e) {
	  			// TODO Auto-generated catch block
	  			e.printStackTrace();
	  		}
		}
		
	}	
}
