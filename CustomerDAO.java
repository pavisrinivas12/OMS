
/**
 *
 * @author Pavithra
 */
import java.sql.*;
public class CustomerDAO {

	
	public static int save(String id,String password,String name,String address,String phonenum,String emailid){
		int status=0;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into customer(id,password,name,address,phonenum,emailid) values(?,?,?,?,?,?)");
			ps.setString(1,id);
			ps.setString(2,password);
			ps.setString(3,name);
			ps.setString(4,address);
			ps.setString(5,phonenum);
			ps.setString(6,emailid);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	public static int delete(String id){
		int status=0;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from customer where id=?");
			ps.setString(1,id);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}

	public static boolean validate(String name,String password){
		boolean status=false;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from customer where id= ? and Password= ? ");
                        ps.setString(1,name);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			status=rs.next();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}

}
