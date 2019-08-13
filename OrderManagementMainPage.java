/**
 *
 * @author Pavithra
 */

//Importing Libraries
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//Main Page Class
public class OrderManagementMainPage extends JFrame {
	static OrderManagementMainPage frame;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame= new OrderManagementMainPage();
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
	public OrderManagementMainPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                //Setting Bounds for the Frame (x,y,width,height)
		setBounds(50, 50, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5 ,5,5,5));
		setContentPane(contentPane);
		
                //Title
		JLabel lblOrderManagement = new JLabel(" Order Management System ");
                //Setting Font and Forground
		lblOrderManagement.setFont(new Font("Sans Serif", Font.BOLD, 22));
		lblOrderManagement.setForeground(Color.GRAY);
		
                
               //Supplier(Admin) Login
		JButton btnAdminLogin = new JButton("Supplier Login");
		btnAdminLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			AdminLogin.main(new String[]{});  //Calling Admin Login Class 
			frame.dispose();
			}
		});
		btnAdminLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
                //Foo's Customer Login
		JButton btnFooCustomerLogin1 = new JButton("Foo's Customer Login");
		btnFooCustomerLogin1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FooCustomerLogin1.main(new String[]{});  //Calling Foo customer Login Class 
			}
		});
		btnFooCustomerLogin1.setFont(new Font("Tahoma", Font.PLAIN, 15));
                
                
                //Creating Layout 
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(64)
							.addComponent(lblOrderManagement))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(140)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnFooCustomerLogin1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnAdminLogin, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))))
					.addContainerGap(95, Short.MAX_VALUE))
		);
                
                
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblOrderManagement)
					.addGap(32)
					.addComponent(btnAdminLogin, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnFooCustomerLogin1, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(70, Short.MAX_VALUE))
		);
                
		contentPane.setLayout(gl_contentPane);
	}
}


