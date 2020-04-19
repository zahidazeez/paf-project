package main;

import com.sun.corba.se.pept.transport.Connection;

public class ayment
{ //A common method to connect to the DB
private Connection connect()
 {
 Connection con = null;
 try
 {
 Class.forName("com.mysql.jdbc.Driver");

 //Provide the correct details: DBServer/DBName, username, password
 con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "");
 }
 catch (Exception e)
 {e.printStackTrace();}
 return con;
 }
public String insertDoctor(String DoctorID, String DoctorName, String Specialization, String Contact, String Address)
 {
 String output = "";
 try
 {
 Connection con = connect();
 if (con == null)
 {return "Error while connecting to the database for inserting."; }
 // create a prepared statement
 String query = " insert into items
 ('PatientID','ProductrName',,'Contact','Value','Date')"
 + " values (?, ?, ?, ?, ?,?)";
 PreparedStatement preparedStmt = con.prepareStatement(query);
 // binding values
 preparedStmt.setInt(1, 0);
 preparedStmt.setString(2, PID);
 preparedStmt.setString(3, ProductName);
 preparedStmt.setInt(4, Contact);
 preparedStmt.setInt(5, Integer.parseInt(Contact));
 preparedStmt.setInt(6, Date); 

 // execute the statement
 preparedStmt.execute();
 con.close();
 output = "Inserted successfully";
 }
 catch (Exception e)
 {
 output = "Error while inserting the Payment.";
 System.err.println(e.getMessage());
 }
 return output;
 }
public String readPayment()
 {
 String output = "";
 try
 {
 Connection con = connect();
 if (con == null)
 {return "Error while connecting to the database for reading."; }
 // Prepare the html table to be displayed
 output = "<table border=\"1\"><tr>
 <th>PaymentID</th>
 <th>ProductName</th>
 <th>contact</th>
 <th>Value</th>
 <th>Date</th>
 <th>Update</th>
 <th>Remove</th></tr>";
 String query = "select * from Doctor";
 Statement stmt = con.createStatement();
 ResultSet rs = stmt.executeQuery(query);
 // iterate through the rows in the result set
 while (rs.next())
 {
 String PatientID = Integer.toString(rs.getInt("PID"));
 
 String ProductName = rs.getString("ProductrName");
 String Specialization = rs.getString("Specialization");
 String Contact = Integer.toString(rs.getInt("Contact"));
 String Address = rs.getString("Address");
 // Add into the html table
 output += "<tr><td>" + PatientID + "</td>";
 output += "<td>" + ProductName + "</td>";
 output += "<td>" + Value + "</td>";
 output += "<td>" + Contact + "</td>";
 output += "<td>" + Date + "</td>";
 // buttons
 output += "<td><input name=\"btnUpdate\" type=\"button\"
 value=\"Update\" class=\"btn btn-secondary\"></td>"
 + "<td><form method=\"post\" action=\"Doctor.jsp\">"
 + "<input name=\"btnRemove\" type=\"submit\" value=\"Remove\"
 class=\"btn btn-danger\">"
 + "<input name=\"DID\" type=\"hidden\" value=\"" + DID
 + "\">" + "</form></td></tr>";
 }
 con.close();
 // Complete the html table
 output += "</table>";
 }
 catch (Exception e)
 {
 output = "Error while reading the Payment.";
 System.err.println(e.getMessage());
 }
 return output;
 } 

public String updatePayment(String PaymentID, String PaymentName, String Contact,String Value ,Sting Date)
 {
 String output = "";
 try
 {
 Connection con = connect();
 if (con == null)
 {return "Error while connecting to the database for updating."; }
 // create a prepared statement
 String query = "UPDATE Payment SET PaymentID=?,ProductName=?,Value=?,Contact=?,Date=?"
 WHERE PatientID=?";
 PreparedStatement preparedStmt = con.prepareStatement(query);
 // binding values
 preparedStmt.setString(1, PID);
 preparedStmt.setString(2, ProductName);
 preparedStmt.setInt(3, Value);
 preparedStmt.setInt(4, Integer.parseInt(Contact));
 preparedStmt.setInt(5, Date);
 
 // execute the statement
 preparedStmt.execute();
 con.close();
 output = "Updated successfully";
 }
 catch (Exception e)
 {
 output = "Error while updating the Patyment.";
 System.err.println(e.getMessage());
 }
 return output;
 }
public String deleteDoctor(String DID)
 {
 String output = "";
 try
 {
 Connection con = connect();
 if (con == null)
 {return "Error while connecting to the database for deleting."; }
 // create a prepared statement
 String query = "delete from Doctor where DID=?";
 PreparedStatement preparedStmt = con.prepareStatement(query);
 // binding values
 preparedStmt.setInt(1, Integer.parseInt(DID));
 // execute the statement
 preparedStmt.execute();
 con.close();
 output = "Deleted successfully";
 }
 catch (Exception e)
 {
 output = "Error while deleting the Doctor.";
 System.err.println(e.getMessage());
 }
 return output;
 }
} 