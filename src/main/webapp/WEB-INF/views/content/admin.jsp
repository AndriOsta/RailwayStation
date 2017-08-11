<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=request.getContextPath()%>/resources/css/style_main.css"
	rel="stylesheet" />
	<link href="<%=request.getContextPath()%>/resources/css/style.css"
	rel="stylesheet" />
	 <link rel="stylesheet" href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css" />
 
  <script src="http://code.jquery.com/jquery-1.8.3.js"></script>
  <script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
	<script>
	$(document).ready(function(){
	    $("#loader").click(function(){
	                // Load the page into the div
	        $("#resultreturn").load("b.html");
	                // Show the modal dialog
	                
	        $("#resultreturn").dialog({ modal: true, width: 250,
	            height: 500});
	    });
	});
			
		</script>
<title>Insert title here</title>
</head>
<body>
Admin page!
<a href="j_spring_security_logout">Logout</a>

<div id="resultreturn" style="display: none" >

    <h2>Given name:</h2><h1> ${reserv.passenger.given_name}</h1> 
   <h2> Familly name:</h2><h1> ${reserv.passenger.familly_name}</h1> 
    <h2>Middle name:</h2> <h1>${reserv.passenger.middle_name}</h1> <br/> <br/> 
   
    <h2> Code:</h2><h1> ${reserv.flight.code}</h1> 
    <h2>  Aircraft:</h2> <h1> ${reserv.flight.airCraft.name}</h1>
    <h2> Date depart:</h2><h1>${reserv.flight.getFlight_date().getTime()}</h1>
     <h2> Date come:</h2><h1>${reserv.flight.getFlight_datecome().getTime()}</h1>
     <h2> City from:</h2><h1>${reserv.flight.cityFrom.name}</h1>
     <h2> City to: </h2><h1>${reserv.flight.cityTo.name}</h1>
     <h2> Duration:</h2><h1>${reserv.flight.duration}</h1>
   
    

</div>
<h1>Enter information</h1>
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
                <li> <li><a href="user" >Home</a></li>
                <li><a href="http://www.templatemo.com">Services</a></li>
                <li><a href="http://www.templatemo.com" class="current">Bookings</a></li>
                <li><a href="http://www.templatemo.com">Locations</a></li>
                <li><a href="http://www.templatemo.com">Gallery</a></li>
                <li><a href="http://www.templatemo.com" class="last">Contact</a></li>
            </ul> 
        </div>    
    </div> <!-- end of banner -->
</div>
  	 
		 
		  <h1>This is your unique code:</h1> 
		  <h2>71d0043d-c2bc-4bbe-a281-af04ec7bdd0e</h2>
		  <h1>You can check your reservtion here.</h1>
		  <h1>Please,paste you unique code</h1>
		 
		 
		 
		<form method="get" action="checkcode">
	
			<input type="text"  name="code"/>
			
			
			<input type="submit" class="button" value="check"  >
				<input type="button" value="show"  id="loader" class="button"/> 
		</form>
	                  
                  
              
	</body>

</html>