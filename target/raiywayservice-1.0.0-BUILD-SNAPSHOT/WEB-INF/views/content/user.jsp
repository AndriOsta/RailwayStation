<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<%=request.getContextPath()%>/resources/css/style_main.css"
	rel="stylesheet" />
	<link href="<%=request.getContextPath()%>/resources/css/tablestyle.css"
	rel="stylesheet" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome to Avia</title>
 <link rel="stylesheet" href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css" />
 
  <script src="http://code.jquery.com/jquery-1.8.3.js"></script>
  <script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
  <script>
$(function() {
    $( "#datepicker" ).datepicker();
});
$('#cityFrom').fancySelect();
</script>
</head>
<body>
User page!
<a href="j_spring_security_logout">Logout</a>

<form:form action="getflights" method="get" class="form" modelAttribute="flightParams">

<form:select id="cityFrom"  path="cityFrom" name="cityFrom">
      <c:forEach var="city" items="${cityList}">
        <form:option value="${city.id}">${city.name}</form:option>
      </c:forEach>
     
    </form:select>
     <label for="cityFrom">City From</label>
  
    
    <p class="email">
    <form:select id="cityTo"  path="cityTo" name="cityTo">
      <c:forEach var="city" items="${cityList}">
        <form:option value="${city.id}">${city.name}</form:option>
      </c:forEach>

    </form:select>
          <label for="cityTo">City To</label>
    </p>
    <p class="web">
    <form:input type="text" id="datepicker"  path="date" name="date" />
      <label for="date">Please,select a date</label>
  </p>
  <p class=submit>
  <input type="submit" value="Search" />
 
  </p>
  
<h1>Race Times</h1>

<table id="racetimes">
<tr id="firstrow"><th>Code</th><th>Date depart</th><th>Date come</th><th>Aircraft</th><th>City From</th><th>City To</th><th>Duration</th><th>Free places</th></tr>
<c:forEach items="${flightList}" var="flight" varStatus="loop">
            <c:if test="${not loop.first and loop.index % 3 == 0}">
                </tr><tr>
            </c:if>
            <td>     ${flight.code}</td>
            
            <td>     ${flight.airCraft.name}</td>
            <td>     ${flight.cityFrom.name}</td>
            <td>     ${flight.cityTo.name}</td>
            <td>     ${flight.duration}</td>
           
        </c:forEach>
</table>
  </form:form>
</body>
</html>