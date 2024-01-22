package employee.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewEmployee extends JFrame implements ActionListener {
	JTable table;
	Choice choiceEmp;
	JButton searchBtn, printBtn, updateBtn, backBtn;

	ViewEmployee() {

		getContentPane().setBackground(new Color(255, 131, 122));

		JLabel search = new JLabel("Search by employee id");
		search.setBounds(20, 20, 150, 20);
		add(search);

		choiceEmp = new Choice();
		choiceEmp.setBounds(180, 20, 150, 20);
		add(choiceEmp);

		try {
			Connect connect = new Connect();
			ResultSet resultSet = connect.statement.executeQuery("select * from employee");
			while (resultSet.next()) {
				choiceEmp.add(resultSet.getString("empID"));
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		table = new JTable();
		try {
			Connect connect = new Connect();
			ResultSet resultSet = connect.statement.executeQuery("select * from employee");
			table.setModel(DbUtils.resultSetToTableModel(resultSet));
		} catch (Exception e) {
			e.printStackTrace();
		}

		JScrollPane jp = new JScrollPane(table);
		jp.setBounds(0, 100, 900, 600);
		add(jp);

		searchBtn = new JButton("Search");
		searchBtn.setBounds(20, 70, 80, 20);
		searchBtn.addActionListener(this);
		add(searchBtn);

		printBtn = new JButton("Print");
		printBtn.setBounds(120, 70, 80, 20);
		printBtn.addActionListener(this);
		add(printBtn);

		updateBtn = new JButton("Update");
		updateBtn.setBounds(220, 70, 80, 20);
		updateBtn.addActionListener(this);
		add(updateBtn);

		backBtn = new JButton("back");
		backBtn.setBounds(320, 70, 80, 20);
		backBtn.addActionListener(this);
		add(backBtn);

		setSize(900, 700);
		setLayout(null);
		setLocation(300, 100);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == searchBtn) {
			System.out.println("search");
			String query = "select * from employee where empID = '" + choiceEmp.getSelectedItem() + "'";
			try {
				System.out.println("search");
				Connect connect = new Connect();
				ResultSet resultSet = connect.statement.executeQuery(query);
				table.setModel(DbUtils.resultSetToTableModel(resultSet));
			} catch (Exception E) {

				E.printStackTrace();
			}
		} else if (e.getSource() == printBtn) {
			try {
				table.print();
			} catch (Exception E) {
				E.printStackTrace();
			}
		} else if (e.getSource() == updateBtn) {
			setVisible(false);
			new UpdateEmployee(choiceEmp.getSelectedItem());
		} else {
			setVisible(false);
			new MainClass();
		}
	}

	public static void main(String[] args) {
		new ViewEmployee();
	}

}
