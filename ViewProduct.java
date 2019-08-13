import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Random;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;

public class ViewProduct extends JFrame {

	private JPanel contentPane;
	private JTable table;
        private String pId;//,pName,pDesc,pPrice,pQty;
        static ViewProduct frame;
        
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewProduct frame = new ViewProduct(args);
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
	public ViewProduct(String[] args) {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 550, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		String data[][]=null;
		String column[]=null;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from product",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs=ps.executeQuery();
			
			ResultSetMetaData rsmd=rs.getMetaData();
			int cols=rsmd.getColumnCount();
			column=new String[cols];
			for(int i=1;i<=cols;i++){
				column[i-1]=rsmd.getColumnName(i);
			}
			
			rs.last();
			int rows=rs.getRow();
			rs.beforeFirst();

			data=new String[rows][cols];
			int count=0;
			while(rs.next()){
				for(int i=1;i<=cols;i++){
					data[count][i-1]=rs.getString(i);
				}
				count++;
			}
			con.close();
		}catch(Exception e){System.out.println(e);}
		
		table = new JTable(data,column);
		JScrollPane sp=new JScrollPane(table);
		contentPane.add(sp, BorderLayout.CENTER);
                
                JButton btncall = new JButton("ORDER"); 
                
                
                GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(GroupLayout.Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING, false)
						.addComponent(table,GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(58)
					.addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING, false)
						.addComponent(table, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE))
					.addContainerGap(107, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(151, Short.MAX_VALUE)
					.addGap(144))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(160, Short.MAX_VALUE)
					.addComponent(btncall, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
					.addGap(133))
                                        
		);
                
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(table)
						.addComponent(table, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btncall, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18))
				
		);
		contentPane.setLayout(gl_contentPane);
                
		btncall.addActionListener(new ActionListener() {	
                public void actionPerformed(ActionEvent e) {
                int status=0;
		try{
                        String orderstatus = "ORDERED";
                        //DefaultTableModel model = (DefaultTableModel)table.getModel();
                        int selectedRowIndex = table.getSelectedRow();
                        pId=table.getValueAt(selectedRowIndex, 0).toString();
                        //System.out.println("Product Id"+pId);
                        Random rnd = new Random();
                        int n = 100000 + rnd.nextInt(900000);
                        //String prodid = "select prodid from product where prodid = ";
                        String custid = args[0];
                        System.out.println(custid);
                        //DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                        //Date date = new Date();
                        Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into ordertab (orderid,prodid,custid,orderdate,orderstatus) values(?,?,?,?,?)");
                        ps.setInt(1,n);
			ps.setString(2,pId);
			ps.setString(3,custid);
                        ps.setDate(4,new java.sql.Date(new java.util.Date().getTime()));
                        ps.setString(5,orderstatus);
                        status=ps.executeUpdate();
			con.close();
                            JOptionPane.showMessageDialog(ViewProduct.this,"Order Placed Successfully");
                }
                        catch(Exception ep)
                        {System.out.println(ep);}
                }
                
	});
	}
}
