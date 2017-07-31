package DBPKG;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAO {
	PreparedStatement prst = null;
	ResultSet rs = null;
	public static Connection getConnection() throws Exception{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection
				("jdbc:oracle:thin:@//10.10.10.133:1521/xe","system","1234");
		return con;
	}
	
	public ArrayList<MemberVO> getAllMember(){
		ArrayList<MemberVO> mvoList = new ArrayList<>();
		try {
			prst = getConnection().prepareStatement("select * from member_tbl_02");
			rs = prst.executeQuery();
			while(rs.next()){
				MemberVO mvo = new MemberVO();
				mvo.setCustno(rs.getInt(1));
				mvo.setCustname(rs.getString(2));
				mvo.setPhone(rs.getString(3));
				mvo.setAddress(rs.getString(4));
				mvo.setJoindate(rs.getString(5).substring(0,10));
				mvo.setGrade(rs.getString(6));
				mvo.setCity(rs.getString(7));
				mvoList.add(mvo);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		System.out.println(mvoList.size());
		return mvoList;
	}
	public MemberVO getOneMember(int custno){
		MemberVO mvo = new MemberVO();
		try{
			prst = getConnection().prepareStatement("select * from member_tbl_02 where custno="+custno);
			rs = prst.executeQuery();
			while(rs.next()){
				mvo.setCustno(rs.getInt(1));
				mvo.setCustname(rs.getString(2));
				mvo.setPhone(rs.getString(3));
				mvo.setAddress(rs.getString(4));
				mvo.setJoindate(rs.getString(5).substring(0,10));
				mvo.setGrade(rs.getString(6));
				mvo.setCity(rs.getString(7));
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return mvo;
	}
	public int getNextCustno(){
		int res = 0;
		try {
			prst = getConnection().prepareStatement("select max(custno) from member_tbl_02");
			rs = prst.executeQuery();
			while(rs.next()){
				res = rs.getInt(1);				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res+1;
	}
	
	public int insertMember(MemberVO mvo){
		int res = 0;
		try {
			prst = getConnection().prepareStatement("insert into member_tbl_02 values(mem_seq.nextval,?,?,?,sysdate,?,?)");
			prst.setString(1, mvo.getCustname());
			prst.setString(2, mvo.getPhone());
			prst.setString(3, mvo.getAddress());
			prst.setString(4, mvo.getGrade());
			prst.setString(5, mvo.getCity());
			res = prst.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return res;
	}
	public int modifyMember(MemberVO mvo){
		int res = 0;
		try {
			prst = getConnection().prepareStatement("update member_tbl_02 set custname=?,phone=?,address=?,grade=?,city=? where custno=?");
			prst.setString(1, mvo.getCustname());
			prst.setString(2, mvo.getPhone());
			prst.setString(3, mvo.getAddress());
			prst.setString(4, mvo.getGrade());
			prst.setString(5, mvo.getCity());
			prst.setInt(6, mvo.getCustno());
			res = prst.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return res;
	}
	public ArrayList<SalesVO> getSalesList(){
		ArrayList<SalesVO> salesList = new ArrayList<>();
		try {
			prst = getConnection().prepareStatement("select mem.custno,mem.custname,mem.grade, sum(mon.price) total from member_tbl_02 mem, money_tbl_02 mon where mem.custno=mon.custno group by mem.custno,mem.custname,mem.grade");
			rs = prst.executeQuery();
			while(rs.next()){
				SalesVO svo = new SalesVO();
				svo.setCustno(rs.getString(1));
				svo.setCustname(rs.getString(2));
				svo.setGrade(rs.getString(3));
				svo.setTotal(rs.getString(4));
				salesList.add(svo);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return salesList;
	}
}
