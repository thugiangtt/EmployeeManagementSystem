package employee.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddEmployee extends JFrame implements ActionListener {

	Random ran = new Random();
	int number = ran.nextInt(999999);
	JTextField textName, textUsername, textDepartment, textEmail, textAddress, textPhone, textSalary;
	JLabel textEmpID;
	JDateChooser textDob;

	JButton add, back;

	AddEmployee() {
		getContentPane().setBackground(new Color(165, 255, 188));

		JLabel heading = new JLabel("Add Employee Detail");
		heading.setBounds(320, 30, 500, 50);
		heading.setFont(new Font("serif", Font.BOLD, 25));
		add(heading);

		JLabel name = new JLabel("Name");
		name.setBounds(50, 150, 150, 30);
		name.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
		add(name);

		textName = new JTextField();
		textName.setBounds(200, 150, 150, 30);
		textName.setBackground(new Color(177, 252, 197));
		add(textName);

		JLabel fname = new JLabel("User Name");
		fname.setBounds(400, 150, 150, 30);
		fname.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
		add(fname);

		textUsername = new JTextField();
		textUsername.setBounds(600, 150, 150, 30);
		textUsername.setBackground(new Color(177, 252, 197));
		add(textUsername);

		JLabel dob = new JLabel("Date Of Birth");
		dob.setBounds(50, 200, 150, 30);
		dob.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
		add(dob);

		textDob = new JDateChooser();
		textDob.setBounds(200, 200, 150, 30);
		textDob.setBackground(new Color(177, 252, 197));
		add(textDob);

		JLabel salary = new JLabel("Salary");
		salary.setBounds(400, 200, 150, 30);
		salary.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
		add(salary);

		textSalary = new JTextField();
		textSalary.setBounds(600, 200, 150, 30);
		textSalary.setBackground(new Color(177, 252, 197));
		add(textSalary);

		JLabel address = new JLabel("Address");
		address.setBounds(50, 250, 150, 30);
		address.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
		add(address);

		textAddress = new JTextField();
		textAddress.setBounds(200, 250, 150, 30);
		textAddress.setBackground(new Color(177, 252, 197));
		add(textAddress);

		JLabel phone = new JLabel("Phone");
		phone.setBounds(400, 250, 150, 30);
		phone.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
		add(phone);

		textPhone = new JTextField();
		textPhone.setBounds(600, 250, 150, 30);
		textPhone.setBackground(new Color(177, 252, 197));
		add(textPhone);

		JLabel email = new JLabel("Email");
		email.setBounds(50, 300, 150, 30);
		email.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
		add(email);

		textEmail = new JTextField();
		textEmail.setBounds(200, 300, 150, 30);
		textEmail.setBackground(new Color(177, 252, 197));
		add(textEmail);

		JLabel empid = new JLabel("Employee ID");
		empid.setBounds(50, 350, 150, 30);
		empid.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
		add(empid);

		textEmpID = new JLabel("" + number);
		textEmpID.setBounds(200, 350, 150, 30);
		textEmpID.setFont(new Font("SAN_SARIF", Font.BOLD, 20));
		textEmpID.setForeground(Color.RED);
		add(textEmpID);

		JLabel department = new JLabel("Department");
		department.setBounds(400, 300, 150, 30);
		department.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
		add(department);

		textDepartment = new JTextField();
		textDepartment.setBounds(600, 300, 150, 30);
		textDepartment.setBackground(new Color(177, 252, 197));
		add(textDepartment);

		add = new JButton("ADD");
		add.setBounds(450, 550, 150, 40);
		add.setBackground(Color.black);
		add.setForeground(Color.WHITE);
		add.addActionListener(this);
		add(add);

		back = new JButton("BACK");
		back.setBounds(250, 550, 150, 40);
		back.setBackground(Color.black);
		back.setForeground(Color.WHITE);
		back.addActionListener(this);
		add(back);

		setSize(900, 700);
		setLayout(null);
		setLocation(300, 50);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == add) {
			String name = textName.getText();
			String userName = textUsername.getText();
			String dob = ((JTextField) textDob.getDateEditor().getUiComponent()).getText();
			String salary = textSalary.getText();
			String address = textAddress.getText();
			String phone = textPhone.getText();
			String email = textEmail.getText();
			String department = textDepartment.getText();
			String empID = textEmpID.getText();

			try {
				Connect connect = new Connect();
				String query = "insert into employee values('" + empID + "', '" + name + "', '" + userName + "', '"
						+ dob + "','" + address + "', '" + phone + "', '" + email + "', '" + department + "', '"
						+ salary + "')";
				connect.statement.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Details added successfully");
				setVisible(false);
				new MainClass();

			} catch (Exception E) {
				E.printStackTrace();
			}

		} else {
			setVisible(false);
			new MainClass();
		}
	}

	public static void main(String[] args) {
		new AddEmployee();
	}

}
