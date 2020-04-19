package model;

import java.sql.*;

public class payment {
	public Connection connect()
	{
		Connection con=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/newdb", "root", ""); 
			System.out.print("Successfully connected"); 
			
			
		}
		catch(Exception e)
		{
			System.out.print("error");
			e.printStackTrace(); 
		}
		return con;
	}
	public String addPayment(String invoiceNumber,String amount,String nic,String cardnumber,String cardname,String expdate,String cvv)
	{
	String Output ="";
	
	try {
		//patientDatabase newp = new patientDatabase();
		Connection con = connect();

		if (con == null) {
			//return "Error while connectingto the database for inserting";
		}

		String query = " insert into payment (`invoiceNumber`,`amount`,`payment_nic`, `cardnumber`, `cardname`,`expdate`,`cvv`) "
				+ "values(?, ?, ?, ?, ?, ?, ?)";
//		Date date = Calendar.getInstance().getTime();
//		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
//		String strDate = dateFormat.format(date);
		
		PreparedStatement preparedStmt = con.prepareStatement(query);
		
		preparedStmt.setInt(1, Integer.parseInt(invoiceNumber) );
		preparedStmt.setInt(2, Integer.parseInt(amount) );
		preparedStmt.setString(3, nic);
		preparedStmt.setInt(4, Integer.parseInt(cardnumber) );
		preparedStmt.setString(5,cardname );
		preparedStmt.setString(6,expdate );
		preparedStmt.setString(7,cvv );
		
		
		
		preparedStmt.execute();
		con.close();
		System.out.println("inserted");
		Output = "Inserted successfully"; 
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println(" not inserted");
	}

	return Output;
	}
	public String deletePayment(String cardnumber)
	{
		String output="";
		
		try {
			Connection connection=connect();
			
			if(connection==null)
			{
				return "Error while connecting to the database for deleting.";
			}
			
			String query="delete from payment where cardnumber=?";
			
			PreparedStatement prepareStmt=connection.prepareStatement(query);
			
			prepareStmt.setInt(1, Integer.parseInt(cardnumber));
			prepareStmt.execute();
			connection.close();
			
			output= "deleted successfully";
		}
		catch(Exception e)
		{
			output="error while deleting the patient";
			System.err.println(e.getMessage());
		}
		return output;
	}
}
