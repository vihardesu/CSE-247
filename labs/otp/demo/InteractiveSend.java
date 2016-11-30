package otp.demo;

import javax.swing.JOptionPane;

import otp.utils.Agent;
import otp.utils.DHFactory;
import otp.utils.SendMessage;

public class InteractiveSend {
	
	public static void main(String[] args) {
		DHFactory dhf = new DHFactory(DHFactory.BASE, DHFactory.LARGEPRIME);
		Agent one = new Agent(dhf);
		Agent two = new Agent(dhf);
		SendMessage sm = new SendMessage(one, two);
		String message = JOptionPane.showInputDialog("What message to send?");
		sm.send(message);
	}

}
