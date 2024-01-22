package employee.management.system;

import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainClass extends JFrame {

	MainClass() {

		JLabel heading = new JLabel("Employee Management System");
		heading.setBounds(340, 155, 400, 40);
		heading.setFont(new Font("Raleway", Font.BOLD, 25));
		add(heading);

		JButton add = new JButton("Add Employee");
		add.setBounds(335, 270, 150, 40);
		add.setForeground(Color.WHITE);
		add.setBackground(Color.black);
		add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new AddEmployee();
				setVisible(false);
			}
		});
		add(add);

		JButton view = new JButton("View Employee");
		view.setBounds(565, 270, 150, 40);
		view.setForeground(Color.WHITE);
		view.setBackground(Color.black);
		view.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ViewEmployee();
				setVisible(false);
			}
		});
		add(view);

		JButton rem = new JButton("Remove Employee");
		rem.setBounds(440, 370, 150, 40);
		rem.setForeground(Color.WHITE);
		rem.setBackground(Color.black);
		rem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new RemoveEmployee();
			}
		});
		add(rem);

		setSize(1120, 630);
		setLocation(250, 100);
		setLayout(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		new MainClass();
	}

}
