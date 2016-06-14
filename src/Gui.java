import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Gui extends JFrame {

	JLabel hotelListWithPrices;
	JPanel mainPanel;
	JPanel centerPanel;
	
	public Gui() {
		JFrame guiFrame = new JFrame();
		
		guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		guiFrame.setTitle("DMG Price Checker");
		guiFrame.setSize(700,450);
		guiFrame.setLocationRelativeTo(null);
		
		mainPanel = new JPanel();
		
		centerPanel = new JPanel();
		JPanel centerLeftPanel = new JPanel();
		JPanel centerRightPanel = new JPanel();
		
		centerPanel.add(centerLeftPanel);
		centerPanel.add(centerRightPanel);
		
		guiFrame.setLayout(new BorderLayout());
		guiFrame.add(mainPanel);
		mainPanel.add(centerPanel);
		
		guiFrame.setVisible(true);
	}
}
