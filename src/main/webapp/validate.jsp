<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %> 
<script language="javascript">
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%> 

function login(){
	location.href="test/loginGet/<%=request.getParameter("code")%>/<%=request.getParameter("paw")%>";
}
function login2(){
	location.href="login.do?code=admin&paw=123456";
}
</script>
<% 
String rand = (String)session.getAttribute("rand"); //自动生成的
String input = request.getParameter("rand"); //获取的输出的
String code = request.getParameter("code");//账号
String paw = request.getParameter("paw");//密码
if(rand.equals(input)){ 
out.print("<script>login();</script>"); 
} else{ 
out.print("<script>alert('请输入正确的验证码！');location.href='index.jsp';</script>"); 
}
%> 
