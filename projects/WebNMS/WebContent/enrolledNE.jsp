<%@page import="java.util.List"%>
<%@page import="com.java.webnms.response.NE"%>
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
		 var table =	$('#myTable').DataTable();
		 var runningIp ;
		$("#dialog").dialog({
			autoOpen : false,
			width : 400,
			title : 'Enroll Network Element   ',
			 buttons: [
			            {
			                id: "OK",
			                text: "OK",
			                click: function () {
			                	  var ip = $("#ip_enroll").val();
			                	  var port =$("#port_enroll").val();
			                	  console.log("ip="+ip+"&port="+port+"\"");
			                	  $.ajax({
			              			url : 'enrollNE',
			              			type : 'POST',
			              			dataType : 'json',
			              			data : {
			              				ip : $("#ip_enroll").val(),
			              				port : $("#port_enroll").val()
			              			},
			              			success : function(response) {
			              				 console.log(response);
			              				 if(response.Result==='Success'){
			              					 alert(response.Result);
			              					 table.row.add([
													response.Name,
													response.Ip,
													response.Shelf,
													response.Location,
													response.SyncStatus,
													response.SoftwareVersion,
													response.AreaServed,
													response.Status]).draw(true);
			              					$("#dialog").dialog('close'); 
			              				 }else{
			              					 alert(response.Result);
			              					$("#dialog").dialog('close'); 
			              				 }
			              			}
			              		    });
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
		
		$("#deendialog").dialog({
			autoOpen : false,
			width : 400,
			title : 'De Enroll Network Element   ',
			 buttons: [
			            {
			                id: "OK",
			                text: "OK",
			                click: function () {
			                    $(this).dialog('close');
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
			if (id === "open") {
				console.log(id);
				$("#dialog").dialog('open');
			}
			var id2 = $(this).attr('id');
			//console.log(id2);
			if (id2 === "close") {
			//	console.log(id2);
			var table = $('#myTable').DataTable();
			 var ips = $.map(table.rows('.selected').data(), function (item) {
		            return item[1]
		        });
			if(ips.length != 0){
				//alert(ips[0]);
				$.ajax({
		              url : 'deEnroll',
		              type : 'POST',
		              dataType : 'json',
		              data : {
		                ip : ips[0]
		              		},
		              	success : function(response) {
		              	console.log(response);
		              	if(response.Result==='Success'){
		              		table.row('.selected').remove().draw( true );
		              		alert(response.Result);
		              	}else{
		              	  alert(response.Result);
		              	}
		              	}
		            });
			}else{
				alert('No Element is selected');
			}
			}		
			if(id2==="confi"){
				var table = $('#myTable').DataTable();
				 var ips = $.map(table.rows('.selected').data(), function (item) {
			            return item[1]
			        });
				if(ips.length != 0){
					var hidden = document.createElement("input");
					hidden.type = "hidden";
					hidden.name = "Ip";
					hidden.value = ips[0];
					var f = document.getElementById('configure');
					f.appendChild(hidden);
					f.submit();
			     }
			}
			if(id2==="alarm"){
				var table = $('#myTable').DataTable();
				 var ips = $.map(table.rows('.selected').data(), function (item) {
			            return item[1]
			        });
				if(ips.length != 0){
					var hidden = document.createElement("input");
					hidden.type = "hidden";
					hidden.name = "Ip";
					hidden.value = ips[0];
					var f = document.getElementById('alarmss');
					f.appendChild(hidden);
					f.submit();
			     }
			}
			
		});
		
		 $('#myTable tbody').on( 'click', 'tr', function () {
		        if ( $(this).hasClass('selected') ) {
		            $(this).removeClass('selected');
		        }
		        else {
		            table.$('tr.selected').removeClass('selected');
		            $(this).addClass('selected');
		        }
		    } );
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
				<input type="submit" value="Retreive" class="button" align="right">
			</form>
		</div>
	</div>
	<div id="ne_info_table">
		<table id="myTable" class="myTableClass">
			<thead>
				<th>NE Name</th>
				<th>IP Address</th>
				<th>NE Type</th>
				<!--   <th>New Alarm</th>
 			    <th>Outstanding Alarm</th> -->
				<th>Location</th>
				<th>Sync State</th>
				<th>Software version</th>
				<th>Area Served</th>
				<th>Status</th>
			</thead>
			<tbody>
			<%
				List<NE> userInfo = (List<NE>) request.getAttribute("neList");
				int i = 0;
				for (NE ne : userInfo) {
					out.println("<tr>");
					out.println("<td>" + ne.getName() + "</td>");
					out.println("<td>" + ne.getIp() + "</td>");
					out.println("<td>" + ne.getShelf() + "</td>");
					out.println("<td>" + ne.getLocation() + "</td>");
					out.println("<td>" + ne.getSyncstatus() + "</td>");
					out.println("<td>" + ne.getSoftwareversion() + "</td>");
					out.println("<td>" + ne.getAreaServed() + "</td>");
					out.println("<td>" + ne.getStatus() + "</td>");
					out.println("</tr>");
				}
			%>
			</tbody>
		</table>
	</div>
	<%out.println("Login Successfull");
	 %>
	<div>
		<button id="open" class="button">Enroll</button>
		<button id="confi" class="button">Configure</button>
		<button id="close" class="button">De Enroll</button>
		<button id="alarm" class="button">Alarms</button>
	</div>
	<div id="dialog" title="Enroll dialog">
	    <form>
		<table style="width: 99%" align="left">
			<tr style="background-color: gray">
				<td>NE IP</td>
				<td><input id="ip_enroll" type="text" name="ip"></td>
			</tr>
			<tr style="background-color: gray">
				<td>Port</td>
				<td><input id="port_enroll" type="text" name="port"></td>
			</tr>
		</table>
		</form>
	</div>
	
	<form id="configure" method="post" action="configureServlet">
	</form>
	
	<form id="alarmss" method="post" action="alarms">
	</form>
	
</body>
</html>