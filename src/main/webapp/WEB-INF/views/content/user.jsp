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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome to Avia</title>
 <link rel="stylesheet" href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css" />
 
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

$(document).ready(function(){
    $("#loader2").click(function(){
                // Load the page into the div
        $("#resultreturn2").load("b.html");
                // Show the modal dialog
                
        $("#resultreturn2").dialog({ modal: true, width: 435,
            height: 335});
    });
});

function submitter(btn) {
    var param = btn.parentElement.parentElement.id;
    var myForm = document.forms["myForm"];
    myForm.elements["param"].value = param;
    myForm.submit();
}
</script>

</head>
<body>
<div id="resultreturn2" style="display: none" >

<img alt="" src="resources/images/dev.PNG">

</div>
<EMBED type="audio/x-mplayer2" SRC="resources/sounds/summer.mp3" HIDDEN="true" AUTOSTART="true" LOOP="true" Height=145 width=160></EMBED> 
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
                <li><a href="http://www.templatemo.com" class="current">Home</a></li>
                <li><a href="adminpage">Admin</a></li>
                <li><a href="<c:url value='/admin'/>" >Bookings</a></li>
                <li><a href="http://www.templatemo.com">Locations</a></li>
                <li><a href="http://www.templatemo.com">Gallery</a></li>
                <li><a href="#" class="last" id="loader2" >Contact</a></li>
            </ul> 
        </div>    
    </div> <!-- end of banner -->

<div id="resultreturn" style="display: none" >
<h1>Enter information</h1>
<form method="get"  action="addpassenger" class="form-style-9" > 
  <ul>
<li>
  
 <input id="firstname" type="text" name="firstname" class="field-style field-full align-none"  />
     <label for="firstname">First name</label>
  </li>
   <li>
   <input id="lastname" type="text" name="lastname" class="field-style field-full align-none"  />
      <label for="lastname">Last name</label>
</li>

<li>
   <input id="middlename" type="text" name="middlename" class="field-style field-full align-none" />
     <label for="middlename">Middle name</label>
    </li>
    <li>
   <input id="phone" type="text" name="phone" class="field-style field-full align-none"  />
   <label for="phone">Phone</label>
</li>
<li>
 <input id="email" type="text" name="email" class="field-style field-full align-none" />
 <label for="email">Email</label>
</li>
<li>
 <input id="number" type="text" name="number" class="field-style field-full align-none" />
 <label for="number">Document number:</label>
</li>
  	<li>
  		<select id="placeid" name="placeid">
  			<c:forEach var="place" items="${placeList}">
  				<option value="${place.id}">${place.row} ${place.seat}</option>
  			</c:forEach>
  		</select>
  		<label for="placeid">Set a place</label>
  	</li>
 <strong>Add info:</strong><textarea name="addinfo" class="field-style" id="addinfo"></textarea>
</li>
<li>
<input type="submit" value="Reserv" />

  </ul>
</form>
</div>



Welcome,User!
<a href="j_spring_security_logout">Logout</a>

<div id="templatemo_content">
    
    	<div id="content_left">
        	<div class="content_left_section">
            	<div class="content_title_01">Booking</div>

<form action="getflights" method="get" class="form">
<div class="form_row">
          <label>City From</label>

<select id="cityFrom"  path="cityFrom" name="cityFrom">
      <c:forEach var="city" items="${cityList}">
        <option value="${city.id}">${city.name}</option>
      </c:forEach>
     
     
    </select>
     
  </div>
    
    <div class="form_row">
        <label>City To</label>
     
    <select id="cityTo"  path="cityTo" name="cityTo">
      <c:forEach var="city" items="${cityList}">
        <option value="${city.id}">${city.name}</option>
      </c:forEach>

    </select>
          </div>
     <div class="form_row">
        <label>Date:</label>
   <input  id="datepicker"class="inputfield" name="date" type="text" style="margin-right: 20px;" />
    
    </div>
     
  
   <div class="cleaner_h20">&nbsp;</div>
                        <div class="rc_btn_01">                        
  <input type="submit" value="Search" class="button" />
  </div>
 
  
  </form>
  
                <div class="cleaner">&nbsp;</div>
            </div> <!-- end of booking -->
            
            <div class="cleaner_h30">&nbsp;</div>
            <div class="cleaner_horizontal_divider_01">&nbsp;</div>
            <div class="cleaner_h30">&nbsp;</div>
            
            <div class="content_left_section">
            <div class="content_title_01">Latest News</div>
                
                <div class="news_title">Nam auctor aliquam leo</div>
                    <p>Pellentesque est elit, sagittis sit amet porttitor ut, ornare vel turpis. Vivamus eu enimvitae neque its posuere rutrum. <a href="#">read more</a></p>
                <div class="cleaner_h30">&nbsp;</div>

                <div class="news_title">Suspendisse pharetra eros molestie</div>
                    <p>Vivamus eu enimvitae neque its posuere rutrum. Nam accumsan turpis at turpis molestie a convallis forte tor ornare. <a href="#">read more</a></p>
                  <div class="cleaner_h20">&nbsp;</div>
                    <div class="rc_btn_02"><a href="#">View All</a></div>         
                </div>   <!-- end of news section -->
                                <div class="cleaner_h30">&nbsp;</div>

            <div class="cleaner_horizontal_divider_01">&nbsp;</div>
            <div class="cleaner_h30">&nbsp;</div>
            
            <a href="http://www.templatemo.com" target="_parent"><img src="resources/images/templatemo_special_offer.jpg" alt="special offer" /></a>
          <div class="cleaner_h30">&nbsp;</div>
        </div> <!-- end of content left -->
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
    
    <div id="templatemo_footer">
    Copyright В© 2015 <a href="#"><strong>Andriy Ostapko</strong></a> | <a href="http://www.iwebsitetemplate.com" target="_parent"></a> by <a href="http://www.templatemo.com" target="_parent">AndriOsta company</a>
        <div style="clear: both; margin-top: 10px;">                
            <a href="http://validator.w3.org/check?uri=referer"><img src="resources/images/logo.PNG" alt="image" height="150" width="150" /> </a>
           
        </div> 
	</div> <!-- end of footer -->



</div>


  
</body>
</html>