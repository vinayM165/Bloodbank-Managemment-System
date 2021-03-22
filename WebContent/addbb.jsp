<%@page import="java.util.*" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
      <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>RCPIT BLOOD BANK</title>
	<!-- BOOTSTRAP STYLES-->
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
     <!-- FONTAWESOME STYLES-->
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
        <!-- CUSTOM STYLES-->
    <link href="assets/css/custom.css" rel="stylesheet" />
     <!-- GOOGLE FONTS-->
   <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
    <script type="text/javascript">
   	function access(){
		<% Object s1 = request.getSession().getAttribute("msg");
		 if(s1!=null){ %>
		alert('<%=s1.toString()%>');
		<% request.getSession().setAttribute("msg",null);
		}	%>
	}
   	</script>
</head>
<body onload="access()">
<%
//AbstractDao abstractDao=new AbstractDao();
%>

    <div id="wrapper">
        <nav class="navbar navbar-default navbar-cls-top " role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" style="font-size:19px" href="#">RCPIT BLOOD BANK</a> 
            </div>
  <div style="color: white;
padding: 15px 50px 5px 50px;
float: right;
font-size: 16px;"> &nbsp; <a href="index.jsp" class="btn btn-danger square-btn-adjust">Logout</a> </div>
            </nav>   
            <!-- /. NAV TOP  -->
            <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
             <ul class="nav" id="main-menu">
				<li class="text-center">
            <img src="assets/img/find_user.png" class="user-image img-responsive" style="height: 100px;"/>
				</li>
				  <li>
                        <a  href="addbb.jsp"><i class="fa fa-edit fa-3x"></i>Add Blood Donation Camp </a>
                    </li>
                    <li>
                        <a  href="viewbb.jsp"><i class="fa fa-edit fa-3x"></i>View Blood Donation Camp </a>
                    </li>
                    <li>
                        <a  href="upd.jsp"><i class="fa fa-edit fa-3x"></i>Update Stock </a>
                    </li>
                    <li>
                        <a  href="bbdetails.jsp"><i class="fa fa-edit fa-3x"></i>Blood Bank Details </a>
                    </li>
                    <li>
                        <a  href="viewbbtips.jsp"><i class="fa fa-edit fa-3x"></i>View Health Tips</a>
                    </li>
                    <li>
                        <a  href="viewreq.jsp"><i class="fa fa-edit fa-3x"></i>View Requests </a>
                    </li>                    
                     <li>
                        <a  href="adreq.jsp"><i class="fa fa-edit fa-3x"></i>Approved/DisApproved Requests </a>
                    </li>                    

	                </ul>
               
            </div>
            
        </nav>  
        <!-- /. NAV SIDE  -->
        
      <div id="page-wrapper" >
            <div id="page-inner">
                <div class="row">
         		<h2>&nbsp&nbspAdd New Blood Donation Camp</h2>
         		 <div class="col-md-12">
          <div class="card">
        <form action="AddBB" method="post">
                
                <div class="form-group row">
                <input type="hidden" name="action" value="add"/>
    			<label for="inputEmail3" class="col-sm-3 form-control-label">Blood Donation Camp ID :</label>
                  <div class="col-sm-9">
                    <textarea cols="7" rows="1" class="form-control" name="bdid" placeholder="Enter Blood Donation Camp" onkeypress="return isNumberKey(event)" minlength="4" maxlength="12" required></textarea>
                  </div>
                </div>
                
                <div class="form-group row">
                <input type="hidden" name="action" value="add"/>
    			<label for="inputEmail3" class="col-sm-3 form-control-label">Blood Donation Camp Name</label>
                  <div class="col-sm-9">
                    <textarea cols="7" rows="1" class="form-control" name="bdname" placeholder="Enter Blood Donation Camp Name" required></textarea>
                  </div>
                </div>
                
                <div class="form-group row">
                <input type="hidden" name="action" value="add"/>
    			<label for="inputEmail3" class="col-sm-3 form-control-label">Blood Donation Camp Date</label>
                  <div class="col-sm-9">
                    <textarea cols="7" rows="1" class="form-control" name="bddate" placeholder="Enter Blood Donation Camp Date" onkeypress="return isNumberKey(event)" minlength="10" maxlength="10" required></textarea>
                  </div>
                </div>
                
                <div class="form-group row">
                <input type="hidden" name="action" value="add"/>
    			<label for="inputEmail3" class="col-sm-3 form-control-label">Blood Donation Camp Time</label>
                  <div class="col-sm-9">
                    <textarea cols="7" rows="1" class="form-control" name="bdtime" placeholder="Enter Blood Donation Camp Time" required></textarea>
                  </div>
                </div>
                                
                <div class="form-group row">
                <input type="hidden" name="action" value="add"/>
    			<label for="inputEmail3" class="col-sm-3 form-control-label">Blood Donation Camp Address</label>
                  <div class="col-sm-9">
                    <textarea cols="7" rows="3" class="form-control" name="bdadd" placeholder="Enter Blood Donation Camp Address" required></textarea>
                  </div>
                </div>
                
                <div class="form-group row m-b-0">
                  <div class="col-sm-offset-3 col-sm-9">
                    <button type="submit" class="btn btn-primary">Add Blood Donation Camp</button>
                  </div>
                </div>
                
              </form>
            </div>
        </div>
         		</div>
                   
                </div>
                                       
	 </div>
					                    </div>                                           
                                         
                    </div>
               
           
             <!-- /. PAGE INNER  -->
            </div>
         <!-- /. PAGE WRAPPER  -->
        </div>
     <!-- /. WRAPPER  -->
    <!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
    <!-- JQUERY SCRIPTS -->
    <script src="assets/js/jquery-1.10.2.js"></script>
      <!-- BOOTSTRAP SCRIPTS -->
    <script src="assets/js/bootstrap.min.js"></script>
    <!-- METISMENU SCRIPTS -->
    <script src="assets/js/jquery.metisMenu.js"></script>
      <!-- CUSTOM SCRIPTS -->
    <script src="assets/js/custom.js"></script>
    <SCRIPT language=Javascript>
     function isNumberKey(evt)
{
var charCode = (evt.which) ? evt.which : event.keyCode;

if (charCode > 31 && (charCode<48 || charCode>57))
	return false;
	
return true;
}
       
</SCRIPT>
   
</body>
</html>
