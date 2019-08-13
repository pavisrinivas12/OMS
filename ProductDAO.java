import java.sql.*;
public class ProductDAO {
    
	public static int save(String name,String prodid,String description,int price,int quantity){
		int status=0;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into product(prodid,name,description,price,quantity) values(?,?,?,?,?)");
			ps.setString(1,prodid);
			ps.setString(2,name);
			ps.setString(3,description);
			ps.setInt(4,price);
			ps.setInt(5,quantity);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
        
	public static int delete(String prodid){
		int status=0;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from product where prodid=?");
			ps.setString(1,prodid);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}

	public static boolean validate(String name,String password){
		boolean status=false;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from product where name=? and password=?");
			ps.setString(1,name);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			status=rs.next();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}

}
