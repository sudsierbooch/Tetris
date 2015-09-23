import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.geom.Ellipse2D;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class GUI extends JFrame{

	private JFrame frame; 
	private JPanel panel;
	/*private class MKeyListener implements KeyEventDispatcher {
	

		@Override
		public boolean dispatchKeyEvent(KeyEvent e) {
			int keyCode = e.getKeyCode();
			if (e.getID() == KeyEvent.KEY_PRESSED) {
	              if(keyCode == 40 ){
					System.out.println("Down");
	              }
	              if(keyCode == 39 ){
						System.out.println("Right");
		           }
	              if(keyCode == 37 ){
						System.out.println("Left");
		           }
	              if(keyCode == 49 ){
						System.out.println("Space");
	              }
	              if (Character.isSpaceChar(e.getKeyChar())) {
	                  System.out.println("space");
	              }
	           // } else if (e.getID() == KeyEvent.KEY_RELEASED) {
	           //     System.out.println("2test2");
	          //  } else if (e.getID() == KeyEvent.KEY_TYPED) {
	           //     System.out.println("3test3");
	            }
	            return false;
	        }
	}*/

	public GUI() {
		frame =  new JFrame();
		panel = new JPanel();
		panel.setLayout(new GridLayout(20,10));
		
		frame.add(panel);
		frame.setSize(400, 800);
		
		
		
		frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
	
		//frame.addKeyListener(new MKeyListener());
	//	KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
    //    manager.addKeyEventDispatcher(new MKeyListener());
        
	}
	
	public JPanel getPanel(){
		return this.panel;
	}
	
}

