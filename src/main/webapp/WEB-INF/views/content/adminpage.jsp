<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<link href="<%=request.getContextPath()%>/resources/css/tablestyle.css"
	rel="stylesheet" />
	<link href="<%=request.getContextPath()%>/resources/css/modalform.css"
	rel="stylesheet" />
	<link href="<%=request.getContextPath()%>/resources/css/style.css"
	rel="stylesheet" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <script src="http://code.jquery.com/jquery-1.8.3.js"></script>
  <script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
  <script>
$(function() {
    $( "#datepicker" ).datepicker();
});

$(document).ready(function(){
    $("#loader").click(function(){
                // Load the page into the div
        $("#resultreturn").load("b.html");
                // Show the modal dialog
                
        $("#resultreturn").dialog({ modal: true, width: 700,
            height: 700});
    });
});

function submitter(btn) {
    var param = btn.parentElement.parentElement.id;
    var myForm = document.forms["myForm"];
    myForm.elements["param"].value = param;
    myForm.submit();
}
</script>

<title>Insert title here</title>
</head>
<body>
<div id="templatemo_container">
	<!-- Free Website Template by www.TemplateMo.com -->
    <div id="templatemo_header">
        <div id="website_title">
            <div id="title">
	            Air &amp; Lines
	         
            </div>
            <div id="salgon">
	            The best service at the lowest price</div>
        </div>
    </div> <!-- end of header -->
    
    <div id="templatemo_banner">
    	<div id="templatemo_menu">
            <ul>
                <li><a href="user" >Home</a></li>
                <li><a href="adminpage" class="current">Admin</a></li>
                <li><a href="<c:url value='/admin'/>" >Bookings</a></li>
                <li><a href="http://www.templatemo.com">Locations</a></li>
                <li><a href="http://www.templatemo.com">Gallery</a></li>
                <li><a href="http://www.templatemo.com" class="last">Contact</a></li>
            </ul> 
        </div>    
    </div> <!-- end of banner -->
<input type="button" value="New flight" id="loader"  class="button" /> 
<div id="resultreturn" style="display: none" >

<form method="get"  action="addpassenger" class="form-style-9" > 
  <ul>
<li>
  
 <input id="code" type="text" name="code" class="field-style field-full align-none"  />
     <h2>Code</h2>
  </li>
   <li>
   <input  id="datepicker"class="inputfield" name="date" type="text" style="margin-right: 20px;"  class="field-style field-full align-none"  />
    <h2>Date depart</h2>
</li>

<li>
   <input  id="datepicker"class="inputfield" name="date" type="text" style="margin-right: 20px;"  class="field-style field-full align-none" />
     <h2>Date Come</h2>
    </li>
    <li>
   <input id="aircraft" type="text" name="aircraft" class="field-style field-full align-none"  />
    <h2>Aircraft</h2>
</li>
  	<li>
  		<select id="cityfrom" name="cityfrom">
  			<c:forEach var="city" items="${cityList}">
  				<option value="${city.id}">${city.name}</option>
  			</c:forEach>
  		</select>
  		 <h2>City From</h2>
  	</li>
  	 	<li>
  		<select id="cityto" name="cityto">
  			<c:forEach var="city" items="${cityList}">
  				<option value="${city.id}">${city.name}</option>
  			</c:forEach>
  		</select>
  	 <h2>City To</h2>
  	</li>
</li>

<input type="submit" value="Add" />

  </ul>
</form>
</div>
<div id="content_right">
<form action="getplaces" id="myForm" method="get">
<h1>Race Times</h1>
<input type="hidden" name="param" />
<table id="racetimes">
<tr id="firstrow"><th>Code</th>
<th>Date depart-Date come</th>

<th>Aircraft</th>
<th>City From-City to</th>

<th>Duration</th>
<th>Reserv</th>
</tr>
 <c:forEach  
       items="${flightList}" var="flight">
           <tr id="${flight.id}">
            <td>    <c:out value="${flight.getCode()}"/></td>
           
            <td>  
             <c:out value=" ${flight.getFlight_date().getTime()}"/>
                 <c:out value="${flight.getFlight_datecome().getTime()}"/>
                 </td>
            <td>     <c:out value="${flight.airCraft.name}"/></td>
            <td>    <c:out value="${flight.cityFrom.name}"/>
                <c:out value="${flight.cityTo.name}"/>
               
                </td>
            <td>     <c:out value="${flight.duration}"/></td>
            <td>
             <input type="button" value="reserv" id="loader"  class="button"/> 
            <input type="button" value="places"  onclick="submitter(this)" class="button"/>
            
            </td>
           </tr>
           
        </c:forEach>
</table>
</form>
 <div class="cleaner_h40">&nbsp;</div>
            
            
            <div class="content_right_section">
                <div class="content_title_01">Our aircrafts</div>
                    <div class="gallery_box">
                    	<img src="resources/images/tuv.jpg" alt="image" height="80" width="80"/>
                        <a href="#">TUV</a>
                    </div>
                    <div class="gallery_box">
	                    <img src="resources/images/usa-f.jpg" alt="image" height="80" width="80" />
                        <a href="#">USA-f</a>
                    </div>
                    <div class="gallery_box">
	                    <img src="resources/images/a380.jpg" alt="image" height="80" width="80" />
                        <a href="#">A-280</a>
                    </div>
                    <div class="gallery_box">
                    	<img src="resources/images/n546.jpg" alt="image" height="80" width="80"/>
                        <a href="#">N-548r</a>
                    </div>
                    <div class="gallery_box">
                    	<img src="resources/images/ito.JPG" alt="image" height="80" width="80" />
                        <a href="#">ITO</a>
                    </div>
                    
                    <div class="cleaner_h20">&nbsp;</div>
                    <div class="rc_btn_02"><a href="#">View All</a></div>
                    
                    <div class="cleaner">&nbsp;</div>
			</div>                    
        	<div class="cleaner_h20">&nbsp;</div>
        </div> <!-- end of content right -->
            <div class="cleaner">&nbsp;</div>
    </div>
    







  
</body>
</html>