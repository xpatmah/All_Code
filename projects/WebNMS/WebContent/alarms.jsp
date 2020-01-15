<%@page import="java.util.List"%>
<%@page import="com.java.webnms.response.Alarm"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.Map"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Enrolled NE</title>
<link rel="stylesheet" type="text/css" href="webNms.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
<link rel="shortcut icon" type="image/x-icon" href="favicon.ico" />
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css">
<script type="text/javascript" src="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
	var table = $('#myTable').DataTable({
			"fnDrawCallback": function( oSettings ) {
	          //alert("alarm refreshed");
			}
	});
		$('#myTable tbody').on('click', 'tr', function() {
			if ($(this).hasClass('selected')) {
				$(this).removeClass('selected');
			} else {
				table.$('tr.selected').removeClass('selected');
				$(this).addClass('selected');
			}
		});
		
		 $("#alarmdiv").dialog({
				autoOpen : false,
				width : 400,
				modal : true,
				title : 'Error..',
				 buttons: [
				            {
				                id: "OK",
				                text: "OK",
				                click: function () {
				                  $(this).dialog('close');
				                }
				            }
				            ]
			});

		$("#purgedialog").dialog({
			autoOpen : false,
			width : 400,
			title : 'Purge Alarms  ',
			 modal : true,
			 buttons: [
			            {
			                id: "OK",
			                text: "OK",
			                click: function () {
			                    var str = $("#purging").val();
			                  //  alert(str);
			                    if(str != ""){
			                     	$.ajax({
				            			url : 'operation',
				            			type : 'POST',
				            			dataType : 'json',
				            			data : {
				            				OPERATION : "PURGE",
				            				DATE : str
				            			},
				            			success : function(response) {
				            				if(response.RESULT = "PASS"){
				            					 var f = document.getElementById('alarm');
				            					f.submit(); 
				            				}else{
				            					$("#para").text("Operation failed.. Please check the administrator...");
				             				    $("#alarmdiv").dialog('open');
				            				}
				            			}
								 });
				                  $(this).dialog('close');
			                    }else {
			                    	$("#para").text("Please Select the Valid Date..");
	             				    $("#alarmdiv").dialog('open');
			                    }
			                }
			            },
			            {
			                id: "Cancel",
			                text: "Cancel",
			                click: function () {
			                    $(this).dialog('close');
			                }
			            }
			            ]
		});
		$("button").click(function() {
			//console.log("click");
			var id = $(this).attr('id');
			//console.log(id);
			if (id === "refresh") {
				var f = document.getElementById('alarm');
				f.submit();
			}
			if (id === "purge") {
				$("#purgedialog").dialog('open');
			}
		});
	});
</script>
</head>
<body>
	<div>
		<div>
			<img src="images/changedImage1.jpg"
				style="height: 90px; width: 350px">
		</div>
		<div id="div_enrollpage_retriveButton">
			<form method="post" action="reloadServlet">
				<input type="submit" value="Enrolled NE" class="button" align="right">
			</form>
		</div>
	</div>
	<div id="ne_info_table">
		<table id="myTable" class="myTableClass">
			<thead>
				<th>Alarm id</th>
				<th>Ne Name</th>
				<th>Unite</th>
				<th>Location</th>
				<th>Severity</th>
				<th>Time</th>
				<th>Discription</th>
				<th>Document Id</th>
			</thead>
			<tbody>
			<%
				List<Alarm> userInfo = (List<Alarm>) request.getAttribute("alarmList");
				int i = 0;
				for (Alarm alarm : userInfo) {
					out.println("<tr>");
					out.println("<td>" + alarm.getAlarmid() + "</td>");
					out.println("<td>" + alarm.getNename() + "</td>");
					out.println("<td>" + alarm.getUnit() + "</td>");
					out.println("<td>" + alarm.getLocation() + "</td>");
					out.println("<td bgcolor="+handleSeverity(alarm.getSeviourity())+">" + alarm.getSeviourity()+ "</td>");
					out.println("<td>" + alarm.getTime() + "</td>");
					out.println("<td>" + alarm.getDiscription() + "</td>");
					out.println("<td>" + alarm.getDocumentid() + "</td>");
					out.println("</tr>");
				}
			%>
			   <%! 
                 public String handleSeverity(String AlarmType){ 
				     if(AlarmType.equals("Major")){
				    	 return "#FF0000";
				     }else  if(AlarmType.equals("Minor")){
				    	 return "#E9AB17";
				     }else  if(AlarmType.equals("Warning")){
				    	 return "#FFD801";
				     }else  if(AlarmType.equals("Intermediate")){
				    	 return "#1569C7";
				     }else{
				    	 return "#00FF00";
				     }
			   }
                 %>
			</tbody>
		</table>
	</div>
	<div>
		<button id="purge" class="button">Purge</button>
		<button id="refresh" class="button">Refresh</button>
	</div>
	<div id="purgedialog" title="Purge Alarm">
	    <form>
		<table style="width: 99%" align="left">
			<tr style="background-color: gray">
				<td>Date</td>
				<td><input id="purging" type="date" name="Date"></td>
			</tr>
		</table>
		</form>
	</div>
	<div id="alarmdiv">
	<p id="para">Please Select the Valid Date</p>
	</div>
	<form id="alarm" method="post" action="alarms">
	</form>
</body>
</html>