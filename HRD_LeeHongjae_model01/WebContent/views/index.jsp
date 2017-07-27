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
		</style>
	</head>
	<body>
		<header class="page_head">
			<h2>쇼핑몰 회원관리 ver 1.0</h2>
		</header>
		<menu class="menu_bar">
			<li><a href="insert.jsp">회원등록</a></li>
			<li><a href="list.jsp">회원목록조회/수정</a></li>
			<li><a href="sales.jsp">회원매출조회</a></li>
			<li><a href="index.jsp">홈으로</a></li>
		</menu>
		<section>
			<h3 style="text-align: center">쇼핑몰 회원관리 프로그램</h3>
			<p>쇼핑몰 회원벙보와 회원매출정보 데이터베이스를 구축하고 회원관리 프로그램을 작성하는 프로그램이다.</p>
			<p>프로그램 작성 순서</p>
			<ol>
				<li>회원정보 테이블을 생성한다.</li>
				<li>매출정보 테이블을 생성한다.</li>
				<li>회원정보, 매출정보 테이블에 제시된 문제지의 참조데이터를 추가 생성한다.</li>
				<li>회원정보 입력 화면프로그램을 작성한다.</li>
				<li>회원정보 조회 프로그램을 작성한다.</li>
				<li>회원매출정보 조회 프로그램을 작성한다.</li>
			</ol>
		</section>
		<footer class="page_foot">
			<h6>HRDKOREA Copyrightⓒ2016 All right reserved Human Resources Development Service of Korea</h6>
		</footer>	
	</body>
</html>