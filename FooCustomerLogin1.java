
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.border.EmptyBorder;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pavithra
 */
public class FooCustomerLogin1 extends JFrame{
  static FooCustomerLogin1 frame;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame= new FooCustomerLogin1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FooCustomerLogin1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblsignup = new JLabel("Foo's Customer Login Page");
		lblsignup.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblsignup.setForeground(Color.GRAY);
		
		JButton btnFooCustomerLogin = new JButton("Customer SignIn");
		btnFooCustomerLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			FooCustomerLogin.main(new String[]{});
			frame.dispose();
			}
		});
		btnFooCustomerLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnFooCustomerLogin1 = new JButton("Foo's Customer SignUp");
		btnFooCustomerLogin1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CustSignup.main(new String[]{});
			}
		});
		btnFooCustomerLogin1.setFont(new Font("Tahoma", Font.PLAIN, 15));
                
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(64)
							.addComponent(lblsignup))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(140)
							.addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
								.addComponent(btnFooCustomerLogin1, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnFooCustomerLogin, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))))
					.addContainerGap(95, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblsignup)
					.addGap(32)
					.addComponent(btnFooCustomerLogin, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
					.addComponent(btnFooCustomerLogin1, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(70, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}