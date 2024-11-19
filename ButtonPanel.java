import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ButtonPanel extends JFrame implements ActionListener {

	
	//Özellikleri tanımlama
	private JButton yellowButton;
	private JButton blueButton, redButton;
	private Container contentPane;
	
	//Constructor
	public ButtonPanel () {
		//container'ı ayarlama aşaması
		contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		//componentlerin yaratılması ve ilgili sıra ile eklenmesi
		yellowButton = new JButton("Yellow");
		blueButton = new JButton("Blue");
		redButton = new JButton("Red");
		
		contentPane.add(yellowButton);
		contentPane.add(blueButton);
		contentPane.add(redButton);
		
		//componentleri dinleme listesi
		yellowButton.addActionListener(this);
		blueButton.addActionListener(this);
		redButton.addActionListener(this);
	}
	
	
	public static void main(String[] args) {
		ButtonPanel frame = new ButtonPanel();
		frame.setSize(300,200);
		frame.setTitle("ButtonTest");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// bir event olduğunda çalışacak metot
		Color color = getBackground();
		if(e.getSource() == yellowButton)
			color = color.yellow;
		else if(e.getSource() == blueButton)
			color = color.blue;
		else if(e.getSource() == redButton)
			color = color.red;
		
		contentPane.setBackground(color);
		repaint();
	}
}
