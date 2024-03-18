//****************************** GROUP MEMBERS ******************************
//---------------------------------------------------------------------------
//------ ID ------------ NAME SURNAME ------------------- MAIL --------------
//---------------------------------------------------------------------------
//-- 20761913234 -- Burak Güçlü				-- burak.guclu@tedu.edu.tr
//-- 11782105296 -- Hüseyin Anıl Günay		-- hanil.gunay@tedu.edu.tr
//-- 14699041510 -- Gizem Yüksel			-- gizem.yuksel@tedu.edu.tr
//-- 44905315944 -- Zeynep Bakanoğulları 	-- zeynep.bakanogullari@tedu.edu.tr
//***************************************************************************
// This is the Java class that is used to create connection with database.
//***************************************************************************

import java.sql.*;

public class myConnection {
	static Connection myConn;
	static Statement myStat;

	public myConnection() throws SQLException {
		myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
		myStat = myConn.createStatement();
	}

	static ResultSet showTable(String tablename) {
		try {
			ResultSet myRs = myStat.executeQuery("SELECT * FROM " + tablename);
			return myRs;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	static void add(String sql) {

		try {
			myStat.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	static ResultSet executeCode(String code) {
		try {
			ResultSet myRs = myStat.executeQuery(code);
			return myRs;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	

}
