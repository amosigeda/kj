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
String rand = (String)session.getAttribute("rand"); //�Զ����ɵ�
String input = request.getParameter("rand"); //��ȡ�������
String code = request.getParameter("code");//�˺�
String paw = request.getParameter("paw");//����
if(rand.equals(input)){ 
out.print("<script>login();</script>"); 
} else{ 
out.print("<script>alert('��������ȷ����֤�룡');location.href='index.jsp';</script>"); 
}
%> 
