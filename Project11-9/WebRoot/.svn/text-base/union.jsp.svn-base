<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'union.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script>
		var pro;
		var city;
		var coun;
		window.onload=function(){
			loadPro();
			pro=document.getElementById("pro");
			city=document.getElementById("city");
			coun=document.getElementById("coun");
		}
		
		var ajax=new XMLHttpRequest();
		function loadPro(){
			ajax.open('post','AreaServlet?pid=0');
			ajax.send();
			ajax.onreadystatechange=function(){
				if(ajax.readyState==4&&ajax.status==200){
					var text=ajax.responseText;
					var json=eval(text);
					for(var i=0;i<json.length;i++){
						var op=new Option(json[i].name,json[i].id);
						pro.add(op);
						
					}
				}
			}
		}
		function loadCity(value){
			ajax.open('post','AreaServlet?pid='+value);
			ajax.send();
			ajax.onreadystatechange=function(){
				if(ajax.readyState==4&&ajax.status==200){
					var text=ajax.responseText;
					var json=eval(text);
					city.innerHTML='';
					for(var i=0;i<json.length;i++){
						var op=new Option(json[i].name,json[i].id);
						city.add(op);
						
					}
				}
			}
		}
		function loadCoun(value){
			ajax.open('post','AreaServlet?pid='+value);
			ajax.send();
			ajax.onreadystatechange=function(){
				if(ajax.readyState==4&&ajax.status==200){
					var text=ajax.responseText;
					var json=eval(text);
					coun.innerHTML='';
					for(var i=0;i<json.length;i++){
						var op=new Option(json[i].name,json[i].id);
						coun.add(op);
					}
				}
			}
		}
	</script>
		
  </head>
  
  <body>
    <select id="pro" onchange="loadCity(this.value)"></select>
    <select id="city" onchange="loadCoun(this.value)"></select>
    <select id="coun"></select>
  </body>
</html>
