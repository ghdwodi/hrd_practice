<%@page import="java.util.ArrayList"%>
<%@page import="DBPKG.DAO"%>
<%@page import="DBPKG.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<style type="text/css">
			.page_head{
				text-align: center;
				background-color: black;
				color: white;
				padding: 5px;
			}
			.page_foot{
				text-align: center;
				background-color: black;
				color: white;
				padding: 2px;
			}
			.menu_bar{
				list-style-type: none;
				background-color: gray;
				overflow: hidden;
			}
			.menu_bar li{
				float: left;
			}
			.menu_bar li a{
				display: block;
				padding: 5px;
				text-align: center;
			}
			.menu_bar li a hover{
				color: white;
			}
			section{
				float: none;
			}
			table tr th,td {
				border: 1px solid black;
			}
		</style>
	</head>
	<body>
		<%
			DAO dao = new DAO();
			ArrayList<MemberVO> mvoList = dao.getAllMember();
		%>
		<header class="page_head">
			<h2>쇼핑몰 회원관리 ver 1.0</h2>
		</header>
		<menu class="menu_bar">
			<li><a href="../Controller?cmd=insert">회원등록</a></li>
			<li><a href="../Controller?cmd=list">회원목록조회/수정</a></li>
			<li><a href="../Controller?cmd=sales">회원매출조회</a></li>
			<li><a href="../Controller?cmd=index">홈으로</a></li>
		</menu>
		<section>
			<h3 style="text-align: center">회원목록조회/수정</h3>
			<table>
				<tr>
					<th>회원번호</th>
					<th>회원성명</th>
					<th>전화번호</th>
					<th>주소</th>
					<th>가입일자</th>
					<th>고객등급</th>
					<th>거주지역</th>
				</tr>
			<%
				for(MemberVO k : mvoList){
					String grade = "직원";
					if(k.getGrade().equals("A")){
						grade = "VIP";
					}else if(k.getGrade().endsWith("B")){
						grade = "일반";
					}
					%>
					<tr>
						<td><a href="../Controller?cmd=modify&custno=<%=k.getCustno()%>"><%=k.getCustno()%></a></td>
						<td><%=k.getCustname()%></td>
						<td><%=k.getPhone()%></td>
						<td><%=k.getAddress()%></td>
						<td><%=k.getJoindate()%></td>
						<td><%=grade%></td>
						<td><%=k.getCity()%></td>
					</tr>
					<%
				}
			%>
			</table>
		</section>
		<footer class="page_foot">
			<h6>HRDKOREA Copyrightⓒ2016 All right reserved Human Resources Development Service of Korea</h6>
		</footer>		
	</body>
</html>