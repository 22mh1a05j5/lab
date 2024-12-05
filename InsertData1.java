import java.sql.*;

class DBConn
{
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	int res = 0;

	public DBConn()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(ClassNotFoundException ce) {
			ce.printStackTrace();
		}

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nithin", "root", "");
		} catch(SQLException se) {
			se.printStackTrace();
		}
	}

	

	public int insData(String query)
	{
		try {
			stmt = con.createStatement();
			res = stmt.executeUpdate(query);
			
		} catch(SQLException se) {
			se.printStackTrace();
		}

		return res;
	}

	class InsertData
	{

	public static void main(String[] args) throws SQLException
	{
		DBConn dbc = new DBConn();

		//String sn = args[0];

		//String sp = args[1];

		String query = "insert into studInfo (sname, spass) values (vijay, 67)";

		int res = dbc.insData(query);	

		if(res == 1)
			System.out.println("1 Row Inserted");
		else
			System.out.println("Row NOT Inserted");
	}
}
}