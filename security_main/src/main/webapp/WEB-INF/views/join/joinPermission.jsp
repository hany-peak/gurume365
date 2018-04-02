<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
function permissionCheck(){
	var check1 = document.getElementById("check1");
	var check2 = document.getElementById("check2");
	
	if(!check1.checked){
		alert("이용약관동의를 체크해주세요");
		return false;
	}
	if(!check2.checked){
		alert("개인정보 수집정보 동의를 체크해주세요");
		return false;
	}
	
	if(check1.checked&&check2.checked){
		location.href = "joinForm";
	}
}
function permissionCancle(){
	location.href = "../"
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>[ joinPermission.jsp ]</title>
</head>
<body>

<div id="joinPermission_main">
	<div id="joinPermission_title">
		gurume365
	</div>
	
	<div id="joinPermission_check1">
		<input type="checkbox" id="check1">이용약관동의
	</div>
	
	<div id="joinPermission_content1">
		<textarea rows="10" cols="40" readonly="readonly">
			content1
		</textarea>
	</div>

	<div id="joinPermission_check2">
		<input type="checkbox" id="check2">개인정보 수집 및 이용약관 동의
	</div>
		
	<div id="joinPermission_content2">
		<textarea rows="10" cols="40" readonly="readonly">
			content2
		</textarea>
	</div>
	
	<div id="joinPermission_button_area">
		<div id="joinPermission_button_agree">
			<input type="button" value="agree" onclick="permissionCheck()">
		</div>
		
		<div id="joinPermission_button_cancle">
			<input type="button" value="cancle" onclick="permissionCancle()">
		</div>
	</div>
</div>




</body>
</html>