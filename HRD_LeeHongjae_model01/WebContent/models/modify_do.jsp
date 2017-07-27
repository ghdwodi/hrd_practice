<%@page import="DBPKG.DAO"%>
<%@page import="DBPKG.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MemberVO mvo = new MemberVO();
	DAO dao = new DAO();
	mvo.setCustno(Integer.parseInt(request.getParameter("custno")));
	mvo.setCustname(request.getParameter("custname"));
	mvo.setPhone(request.getParameter("phone"));
	mvo.setAddress(request.getParameter("address"));
	mvo.setGrade(request.getParameter("grade"));
	mvo.setCity(request.getParameter("city"));
	if(dao.modifyMember(mvo)>0){
		%>
		<script type="text/javascript">
			alert("회원정보수정이 완료되었습니다!");
			location.href="../views/list.jsp";
		</script>
		<%
	}else{
		%>
		<script type="text/javascript">
			alert("회원정보 수정 실패!");
			location.href="../views/list.jsp";
		</script>
		<%
	}
%>
