<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>login</title>
</head>

<script language="javascript">

function loadimage(){ 
document.getElementById("randImage").src = "image.jsp?"+Math.random(); 
altet(Math.random());
} 

function check(){
	/* if (frmLogon.code.value ==""){
		alert("用户名不能为空！");
		frmLogon.code.focus();
		return false;
	}
	if (frmLogon.paw.value ==""){
		alert("密码不能为空！");
		frmLogon.paw.focus();
		return false;
	}
	if (frmLogon.paw.value !=""){
	  if (!checkSpace(frmLogon.paw.value)){
		alert("密码不能有空格！");
		frmLogon.paw.focus();
	  return false;
	  }
	}
	if (frmLogon.rand.value ==""){
		alert("验证码不能为空！");
		frmLogon.rand.focus();
		return false;
	} */
	return true;
}
</script>

<body>
<%-- 
<form action="<%=path%>/test/login" method="post"> --%>
<form action="validate.jsp" method="post" onSubmit="return check()"> 
    username:<input type="text" name = "code" ><p> 
    password:<input type="password" name = "paw" ><p>
    <tr>
                            <td height="30"><div align="center"><span class="STYLE3">校验码</span></div></td>
                            <td width="72%" height="30"><input type="text" name="rand" value="" style="height:18px; width:130px; border:solid 1px #cadcb2; font-size:12px;" ></td>
                          </tr>
                            <tr>
                            <td height="30"><div align="center"><span class="STYLE3"><a href="javascript:loadimage();">换一张</a></span></div></td>
                            <td width="72%" height="30"><img alt="code..." name="randImage" id="randImage" src="image.jsp" style="height:18px; width:130px; border:solid 1px #cadcb2; font-size:12px;" ></td>
                            
                          </tr>
    <input type="submit" value="登录"> 
</form>

</body>
</html>