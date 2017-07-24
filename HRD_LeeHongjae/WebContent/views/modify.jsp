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
		<script type="text/javascript">
			function modify(f) {
				if(f.custname.value==""){
					alert("회원성명이 입력되지 않았습니다!");
					return;
				}
				if(f.phone.value==""){
					alert("전화번호가 입력되지 않았습니다!");
					return;
				}
				if(f.phone.value.length > 13){
					alert("전화번호는 13자리를 초과할 수 없습니다.");
					return;
				}
				if(f.address.value==""){
					alert("회원주소가 입력되지 않았습니다!");
					return;
				}
				if(f.address.value.length>60){
					alert("주소가 너무 깁니다!");
					return;
				}
				if(!(f.grade.value=="A" || f.grade.value=="B" || f.grade.value=="C")){
					alert("회원등급을 올바르게 입력하십시오!");
					return;
				}
				if(f.city.value==""){
					alert("도시코드가 입력되지 않았습니다!");
					return;
				}
				if(f.city.value.length>2){
					alert("도시코드는 2자리 숫자입니다!");
					return;
				}
				alert("회원정보수정이 완료되었습니다!")
				f.action="../Controller2";
				f.submit();
			}
		</script>
	</head>
	<body>
		
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
			<h3 style="text-align: center">홈쇼핑 회원 등록</h3>
			<form>
				<table>
					<tr>
						<th>회원번호(자동발생)</th>
						<td><input value="${mvo.custno}" disabled="disabled"></td>
					</tr>
					<tr>
						<th>회원성명</th>
						<td><input value="${mvo.custname}" name="custname"></td>
					</tr>
					<tr>
						<th>회원전화</th>
						<td><input value="${mvo.phone}" name="phone"></td>
					</tr>
					<tr>
						<th>회원주소</th>
						<td><input value="${mvo.address}" name="address"></td>
					</tr>
					<tr>
						<th>가입일자</th>
						<td><input value="${mvo.joindate}" disabled="disabled"></td>
					</tr>
					<tr>
						<th>고객등급[A:VIP,B:일반,C:직원]</th>
						<td><input value="${mvo.grade}" name="grade"></td>
					</tr>
					<tr>
						<th>거주도시</th>
						<td><input value="${mvo.city}" name="city"></td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="hidden" value="${mvo.custno}" name="custno">
							<input type="hidden" value="modify" name="cmd">
							<input type="button" value="수정" onclick="modify(this.form)">
							<input type="button" value="조회" onclick="javascript:location.href='../Controller?cmd=list'">
						</td>
					</tr>
				</table>
			</form>
		</section>
		<footer class="page_foot">
			<h6>HRDKOREA Copyrightⓒ2016 All right reserved Human Resources Development Service of Korea</h6>
		</footer>		
	</body>
</html>