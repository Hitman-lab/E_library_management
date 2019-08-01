package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bean_pages.AddBook;
import com.bean_pages.IssueBook;
import com.bean_pages.User;

public class LibraryDao {

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "web_project", "project123");
		} catch (Exception e) {
			System.out.println("Could not load the class Driver");
			e.printStackTrace();
		}
		return con;
	}

	public static int userFormDate(User u) {

		int status = 0;

		try {
			Connection con = getConnection();
			PreparedStatement ps = con
					.prepareStatement("insert into library_userform(name, email, password, phone_no)values(?,?,?,?)");

			ps.setString(1, u.getName());
			ps.setString(2, u.getEmail());
			ps.setString(3, u.getPassword());
			ps.setString(4, u.getPhoneno());

			status = ps.executeUpdate();
			con.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public static List<User> getAllRecords() {

		List<User> e = new ArrayList<User>();

		try {

			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("select * from library_userform");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				User u = new User();
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				u.setEmail(rs.getString("email"));
				u.setPassword(rs.getString("password"));
				u.setPhoneno(rs.getString("phone_no"));
				e.add(u);
			}

			con.close();
			ps.close();
			rs.close();

		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return e;
	}

	public static int deleteUser(int id) {

		int status = 0;

		try {

			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("delete from library_userform where id=?");
			ps.setInt(1, id);

			status = ps.executeUpdate();
			con.close();
			ps.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public static boolean LibrarianValidate(String username, String pass) {
		boolean status = false;

		try {

			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("select * from library_userform where email=? and password=?");
			ps.setString(1, username);
			ps.setString(2, pass);

			ResultSet rs = ps.executeQuery();
			status = rs.next();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public static int addBook(AddBook a) {

		int status = 0;

		try {

			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("insert into e_book values(?,?,?,?,?,?)");

			ps.setString(1, a.getCellNo());
			ps.setString(2, a.getBookName());
			ps.setString(3, a.getAuthorName());
			ps.setString(4, a.getPublisher());
			ps.setInt(5, a.getQuantity());
			ps.setInt(6, 0);

			status = ps.executeUpdate();

			con.close();
			ps.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public static List<AddBook> viewBook() {

		List<AddBook> a = new ArrayList<AddBook>();
		try {

			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("select * from e_book order by quantity ASC");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				AddBook b = new AddBook();
				b.setCellNo(rs.getString("cellno"));
				b.setBookName(rs.getString("name"));
				b.setAuthorName(rs.getString("author"));
				b.setPublisher(rs.getString("publisher"));
				b.setQuantity(rs.getInt("quantity"));
				b.setIssued(rs.getInt("issued"));
				a.add(b);
			}

			con.close();
			ps.close();
			rs.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}

	public static int issueBook(IssueBook i) {
		String cellNo = i.getCellno();
		boolean checkStatus = checkIssue(cellNo);
		// System.out.println("Check status " + checkStatus);
		if (checkStatus) {
			int status = 0;
			try {

				Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement("insert into e_issuebook values(?,?,?,?,?,?)");
				ps.setString(1, i.getCellno());
				ps.setString(2, i.getStudentid());
				ps.setString(3, i.getStudentname());
				ps.setLong(4, i.getStudentmobile());

				java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());
				ps.setDate(5, currentDate);
				ps.setString(6, "no");

				status = ps.executeUpdate();
				if (status > 0) {
					PreparedStatement ps2 = con.prepareStatement("update e_book set issued=? where cellno=?");
					ps2.setInt(1, getIssued(cellNo) + 1);
					ps2.setString(2, cellNo);
					status = ps2.executeUpdate();
				}
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return status;
		} else {
			return 0;
		}
	}

	private static int getIssued(String cellNo) {
		int issued = 0;
		try {

			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("select * from e_book where cellno=?");
			ps.setString(1, cellNo);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				issued = rs.getInt("issued");
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return issued;
	}

	public static boolean checkIssue(String cellno) {
		boolean status = false;
		try {

			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("select * from e_book where cellno=? and quantity>issued");
			ps.setString(1, cellno);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				status = true;
			}
			con.close();
			ps.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public static List<IssueBook> viewIssuedBook() {

		List<IssueBook> l1 = new ArrayList<IssueBook>();
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("select * from e_issuebook order by callno");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				IssueBook b = new IssueBook();
				b.setCellno(rs.getString("callno"));
				b.setStudentid(rs.getString("studentid"));
				b.setStudentname(rs.getString("studentname"));
				b.setStudentmobile(rs.getLong("studentmobile"));
				b.setIssuedate(rs.getDate("issueddate"));
				b.setReturnstatus(rs.getString("returnstats"));
				l1.add(b);
			}
			con.close();
			ps.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l1;
	}

	public static int returnBook(String cellNo, int id) {

		int status = 0;
		try {

			Connection con = getConnection();
			PreparedStatement ps = con
					.prepareStatement("update e_issuebook set returnstats='yes' where callno=? and studentid=? ");

			ps.setString(1, cellNo);
			ps.setInt(2, id);

			status = ps.executeUpdate();
			if (status > 0) {
				PreparedStatement ps1 = con.prepareStatement("update e_book set issued=? where cellno=?");
				ps1.setInt(1, getIssued(cellNo) - 1);
				ps1.setString(2, cellNo);

				status = ps1.executeUpdate();
			}
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public static int deleteBook(String cellno) {

		int status = 0;
		try {

			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("delete from e_book where cellno=?");
			ps.setString(1, cellno);

			status = ps.executeUpdate();

			if (status > 0) {
				PreparedStatement ps1 = con.prepareStatement("delete from e_issuebook where callno=?");
				ps1.setString(1, cellno);
				status = ps1.executeUpdate();
			}
			con.close();
			ps.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
}
