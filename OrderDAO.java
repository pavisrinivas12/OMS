import java.sql.*;
public class OrderDAO {

	
	public static int save(String prodid,String orderid,String custid,Date orderdate,String orderstatus){
		int status=0;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into ordertab(prodid,orderid,custid,orderdate,orderstatus) values(?,?,?,?,?)");
			ps.setString(1,prodid);
			ps.setString(2,orderid);
			ps.setString(3,custid);
			ps.setDate(4,orderdate);
			ps.setString(5,orderstatus);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	public static int delete(int id){
		int status=0;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from ordertab where orderid=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}

	public static boolean validate(String name,String password){
		boolean status=false;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from customer where name=? and password=?");
			ps.setString(1,name);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			status=rs.next();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}

}
