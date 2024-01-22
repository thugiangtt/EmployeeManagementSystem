package employee.management.system;

import javax.swing.*;
import java.awt.*;

public class Home extends JFrame {

	Home() {

		JLabel heading = new JLabel("Employee Management System");
		heading.setBounds(340, 155, 400, 40);
		heading.setFont(new Font("Raleway", Font.BOLD, 25));
		add(heading);

		setSize(1170, 650);
		setLocation(200, 50);
		setLayout(null);
		setVisible(true);

		try {
			Thread.sleep(5000);
			setVisible(false);
			new Login();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		new Home();
	}
}
