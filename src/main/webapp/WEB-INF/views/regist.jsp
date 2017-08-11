<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>

<link href="<%=request.getContextPath()%>/resources/css/home.css"
	rel="stylesheet" />
	<meta name="viewport" content="width=device-width, initial-scale=1">
		<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
		<!--webfonts-->
		<link href='http://fonts.googleapis.com/css?family=Open+Sans:600italic,400,300,600,700' rel='stylesheet' type='text/css'>

	
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Home</title>
</head>
<body>
				<div class="login-form">
					<div class="head">
						<img src="resources/images/logo.PNG" alt=""/>
						
					</div>
  	<form:form method="GET" action="add" modelAttribute="user">
  
       		
       <li>
       
       <form:input path="username" value='Username' onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}"class="text"/>
       
       <a href="#" class=" icon user"></a>
        </li>
        <form:errors path="username" cssClass="error" />
        <li> 
       <form:password  path="password" value='Password'onfocus="this.value = '';"onblur="if (this.value == '') {this.value = 'Password';}" class="text"/>
     
       <a href="#" class=" icon lock"></a>
       </li>
       <form:errors path="password" cssClass="error" />
       
       

			<c:if test="${not empty error}">
				<div class="error" style="text-align:right;">${error}</div>
			</c:if>




 <div class="p-container">
 




        <input type="submit"value="Cancel"  style="" >

		<input type="submit" class="btnLogin" value="Create" style="float:left;"  />
		
		
		<div class="clear"> </div>
		
    </div>

    
     
 	</form:form>
  </div>

<div class="copy-right">
<p>Created by AndriOsta </p>
</div>


</body>
</html>
