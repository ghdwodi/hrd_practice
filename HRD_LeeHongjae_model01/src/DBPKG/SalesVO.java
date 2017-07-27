package DBPKG;

public class SalesVO {
	String custno,custname,grade,total;
	public SalesVO() {}
	public SalesVO(String custno, String custname, String grade, String total) {
		super();
		this.custno = custno;
		this.custname = custname;
		this.grade = grade;
		this.total = total;
	}
	public String getCustno() {
		return custno;
	}
	public void setCustno(String custno) {
		this.custno = custno;
	}
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
}
