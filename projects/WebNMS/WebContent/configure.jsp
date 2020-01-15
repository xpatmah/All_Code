<%@page import="java.util.List"%>
<%@page import="com.java.webnms.response.NE"%>
<%@page import="com.java.webnms.response.Card"%>
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
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css">
<script type="text/javascript" src="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		var data;
		var facData;
		var emptySlots;
		var allCards = "PKTOTN,100GOCLD,100GMUX,EMOTR";
		var pktotnpec = "NTK760MK,NTK760MA,NTK761AA,NTK769AL";
		var emotrpec = "NTK428BB,NTK429BA,NTK427BK,NTK424BL";
		var muxpec = "NTK539AA,NTK537AA,NTK538AB,NTK536AJ";
		var ocldPec = "NTK675AA,NTK675AB,NTK675AJ,NTK675GT";
		var pktotnfac = "PTP,ODUTTP,ODUCTP,TCMTTP";
		var emotrfac = "ODU3,STM4,STM16,STM64";
		var muxfac = "OTM2,OTM4,OTM6,OTM10";
		var ocldfac = "OC12,OC48,OC192,ODU1";
		 var table =$('#myTable').DataTable({
			 "lengthMenu": [[4, 25, 50, -1], [4, 25, 50, "All"]],    
			  rowId: 'cardid',
			 "fnDrawCallback": function( oSettings ) {
		        }
		    } );
		 var table2 =	$('#myTable2').DataTable({
		        "lengthMenu": [[4, 25, 50, -1], [4, 25, 50, "All"]],
		         "fnDrawCallback": function( oSettings ) {
		        	 //var connt  =table2.data().count();
	        }
		    } );

		 $( "#card" ).change(function() {
			 var str ="" ;
			 $( "#card option:selected" ).each(function() {
			      str = $( this ).text();
			      //alert( "Handler for .change() called."+ str);
			      var selectData=""
			      if(str == "PKTOTN"){
			    	  selectData = pktotnpec.split(",");
			      }else if(str == "EMOTR"){
			    	  selectData = emotrpec.split(",");
			      }else if(str == "100GOCLD"){
			    	  selectData = ocldPec.split(",");
			      }else if(str == "100GMUX"){
			    	  selectData = muxpec.split(",");
			      }
			      $('#myPec').empty();
					$.each(selectData, function (i, item) {
					    $('#myPec').append($('<option>', { 
					        value: item,
					        text : item 
					    }));
					});
			    });
			});
		 
		 $( "#editcard" ).change(function() {
			 var str ="" ;
			 $( "#editcard option:selected" ).each(function() {
			      str = $( this ).text();
			      //alert( "Handler for .change() called."+ str);
			      var selectData=""
			      if(str == "PKTOTN"){
			    	  selectData = pktotnpec.split(",");
			      }else if(str == "EMOTR"){
			    	  selectData = emotrpec.split(",");
			      }else if(str == "100GOCLD"){
			    	  selectData = ocldPec.split(",");
			      }else if(str == "100GMUX"){
			    	  selectData = muxpec.split(",");
			      }
			      $('#editmyPec').empty();
					$.each(selectData, function (i, item) {
					    $('#editmyPec').append($('<option>', { 
					        value: item,
					        text : item 
					    }));
					});
			    });
			});
		 
		 $("#deleteDialog").dialog({
				autoOpen : false,
				width : 400,
				modal : true,
				title : 'Delete Warning...',
				 buttons: [
				            {
				                id: "OK",
				                text: "OK",
				                click: function () {
				                	var row = table.rows('.selected').data()[0];
				                	//alert(row[1]);
				                 	$.ajax({
				            			url : 'operation',
				            			type : 'POST',
				            			dataType : 'json',
				            			data : {
				            				OPERATION : "DLT-CARD",
				            				CARDID : row[1],
				            				CARD : row[0]
				            			},
				            			success : function(response) {
				            				if(response.RESULT = "PASS"){
				            					table.rows('.selected').remove().draw(true);
				            					$("#para").text("Card Deleted Successfully...");
				             				    $("#warn").dialog('open');
				            				}else{
				            					$("#para").text("Card Add Operation failed.. Please check the administrator...");
				             				    $("#warn").dialog('open');
				            				}
				            			}
								 }); 
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
		 
		 $("#deleteFacDialog").dialog({
				autoOpen : false,
				width : 500,
				modal : true,
				title : 'Delete Warning...',
				 buttons: [
				            {
				                id: "OK",
				                text: "OK",
				                click: function () {
				                	var row = table2.rows('.selected').data()[0];
				                	//alert(row[1]);
				                 	$.ajax({
				            			url : 'operation',
				            			type : 'POST',
				            			dataType : 'json',
				            			data : {
				            				OPERATION : "DLT-FACILITY",
				            				FACILITYID : row[0],
				            				FACILITY : row[1]
				            			},
				            			success : function(response) {
				            				if(response.RESULT = "PASS"){
				            					table2.rows('.selected').remove().draw(true);;
				            					$("#para").text("Facility Deleted Successfully...");
				             				    $("#warn").dialog('open');
				            				}else{
				            					$("#para").text("Card Add Operation failed.. Please check the administrator...");
				             				    $("#warn").dialog('open');
				            				}
				            			}
								 }); 
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
		 $("#adddialog").dialog({
				autoOpen : false,
				width : 400,
				title : 'Add Dialog',
				modal : true,
				buttons: [
				            {
				                id: "OK",
				                text: "OK",
				                click: function () {
				                	var slot = $("#mySelect option:selected").text();
				                	var card = $("#card option:selected").text();
				                	var primaryStateadd = $("#primaryStateadd option:selected").text();
				                	var pec = $("#myPec option:selected").text();
				                	var mode = $("#addMod option:selected").text();
				                	var profile = $("#addProfile option:selected").text();
				                	var trafic = $("#addtraficStatus option:selected").text();
				                	//alert(slot+" "+card+"  "+ primaryStateadd+" "+pec +" "+ mode+ " " + profile+" "+ trafic);
				                	$.ajax({
				            			url : 'operation',
				            			type : 'POST',
				            			dataType : 'json',
				            			data : {
				            				OPERATION : "ENT-CARD",
				            				SLOT : slot,
				            				CARD : card,
				            				PEC : pec,
				            				PRIMARYSTATE : primaryStateadd,
				            				MODE : mode,
				            				PROFILE : profile,
				            				TRAFIC : trafic
				            			},
				            			success : function(response) {
				            				if(response.RESULT = "PASS"){
				            					 table.row.add([
			        											card,
			        											response.ID,
			        											primaryStateadd,
			        											pec,
			        											mode,
			        											profile,
			        											trafic,
			        											response.SN]).draw(true);
				            					$("#para").text("Card Added Successfully...");
				             				    $("#warn").dialog('open');
				            				}else{
				            					$("#para").text("Card Add Operation failed.. Please check the administrator...");
				             				    $("#warn").dialog('open');
				            				}
				            			}
								 });
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
				            ],
				 open: function( event, ui ) {
						var data = emptySlots;
        				var selectData = data.split(",")
						$('#mySelect').empty();
						$.each(selectData, function (i, item) {
						    $('#mySelect').append($('<option>', { 
						        value: item,
						        text : item 
						    }));
						});
				 }
			});
		 
		 $("#editdialog").dialog({
				autoOpen : false,
				width : 400,
				title : 'Edit Dialog',
				modal : true,
				buttons: [
				            {
				                id: "OK",
				                text: "OK",
				                click: function () {
				                    var cardrow = table.rows('.selected').data()[0];
				                	var slot = cardrow[1].split("-")[1];
				                	var card = $("#editcard option:selected").text();
				                	var primaryStateadd = $("#editprimarystate option:selected").text();
				                	var pec = $("#editmyPec option:selected").text();
				                	var mode = $("#editmod option:selected").text();
				                	var profile = $("#editprofile option:selected").text();
				                	var trafic = $("#edittrafficstatus option:selected").text();
				                //	alert(slot+" "+card+"  "+ primaryStateadd+" "+pec +" "+ mode+ " " + profile+" "+ trafic);
				                	$.ajax({
				            			url : 'operation',
				            			type : 'POST',
				            			dataType : 'json',
				            			data : {
				            				OPERATION : "ED-CARD",
				            				SLOT : slot,
				            				CARD : card,
				            				PEC : pec,
				            				PRIMARYSTATE : primaryStateadd,
				            				MODE : mode,
				            				PROFILE : profile,
				            				TRAFIC : trafic
				            			},
				            			success : function(response) {
				            				if(response.RESULT = "PASS"){
				            					 var _trEdit = table.row('.selected').node();
				            					 var rowdata = table.row('.selected').data();
				            					 rowdata[0]=card;
				            					 rowdata[1]=response.ID;
				            					 rowdata[2]=primaryStateadd;
				            					 rowdata[3]=pec;
				            					 rowdata[4]=mode;
				            					 rowdata[5]=profile;
				            					 rowdata[6]=trafic;
				            					 rowdata[7]=response.SN;
				            					 table.row('.selected').data(rowdata);
				            					 $(_trEdit).find('td:eq(0)').text(card);
				            					 $(_trEdit).find('td:eq(1)').text(response.ID);
				            				     $(_trEdit).find('td:eq(2)').text(primaryStateadd);
				            					 $(_trEdit).find('td:eq(3)').text(pec);
				            					 $(_trEdit).find('td:eq(4)').text(mode);
				            					 $(_trEdit).find('td:eq(5)').text(profile);
				            					 $(_trEdit).find('td:eq(6)').text(trafic);
				            					 $(_trEdit).find('td:eq(7)').text(response.SN);
				            					$("#para").text("Card Edited Successfully...");
				             				    $("#warn").dialog('open');
				            				}else{
				            					$("#para").text("Operation failed.. Please check the administrator...");
				             				    $("#warn").dialog('open');
				            				}
				            			}
								 });
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
		 $("#warn").dialog({
				autoOpen : false,
				width : 300,
				title : 'Message...',
				modal : true,
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
		 $("#addfacdialog").dialog({
				autoOpen : false,
				width : 480,
				title : 'Add Dialog',
				modal : true,
				buttons: [
				            {
				                id: "OK",
				                text: "OK",
				                click: function () {
				                	var row = table.rows('.selected').data()[0];
				                	var port = $("#myFacSelect option:selected").text();
				                	var facility = $("#addFac option:selected").text();
				                	var serviceType = $("#addServicetype option:selected").text();
				                	var frequency = $("#addFrequency option:selected").text();
				                	var wavelength = $("#addWavelength option:selected").text();
				                	var diffrentialEncoding = $("#addDiffrentialEncoding option:selected").text();
				                	var cdfi = $("#cdfi").val();
				                	//alert(port+" "+facility+"  "+ serviceType+" "+frequency +" "+ wavelength+ " " + diffrentialEncoding+" "+ cdfi);
				                	$.ajax({
				            			url : 'operation',
				            			type : 'POST',
				            			dataType : 'json',
				            			data : {
				            				OPERATION : "ENT-FACILITY",
				            				PORT : port,
				            				SLOT : row[1].split("-")[1],
				            				FACILITY : facility,
				            				SERVICETYPE : serviceType,
				            				FREQUENCY : frequency,
				            				WAVELENGTH : wavelength,
				            				DIFFRENTIALENCODING : diffrentialEncoding,
				            				CDFI : cdfi
				            			},
				            			success : function(response) {
				            				if(response.RESULT = "PASS"){
				            					 table2.row.add([
			        											response.ID,
			        											facility,
			        											serviceType,
			        											frequency,
			        											wavelength,
			        											diffrentialEncoding,
			        											cdfi]).draw(true);
				            					 
				            					$("#para").text("Facility Added Successfully...");
				             				    $("#warn").dialog('open');
				            				}else{
				            					$("#para").text("Facility Add Operation failed.. Please check the administrator...");
				             				    $("#warn").dialog('open');
				            				}
				            			}
								 }); 
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
				            ],
				  open: function( event, ui ) {
					  var row = table.rows('.selected').data()[0];
					  $.ajax({
	            			url : 'getdata',
	            			type : 'POST',
	            			dataType : 'json',
	            			data : {
	            				INFO : "PORTS",
	            				CARDID : row[1]
	            			},
	            			success : function(response) {
	            				//alert(response.EMPTYSLOTS);
	            				var data = response.EMPTYPORTS;
	            				var selectData = data.split(",");
	            				$('#myFacSelect').empty();
	    						$.each(selectData, function (i, item) {
	    						    $('#myFacSelect').append($('<option>', { 
	    						        value: item,
	    						        text : item 
	    						    }));
	    						});
    					      if(row[0] == "PKTOTN"){
    					    	  selectData = pktotnfac.split(",");
    					      }else if(row[0] == "EMOTR"){
    					    	  selectData = emotrfac.split(",");
    					      }else if(row[0] == "100GOCLD"){
    					    	  selectData = ocldfac.split(",");
    					      }else if(row[0] == "100GMUX"){
    					    	  selectData = muxfac.split(",");
    					      }
    					      $('#addFac').empty();
    							$.each(selectData, function (i, item) {
    							    $('#addFac').append($('<option>', { 
    							        value: item,
    							        text : item 
    							    }));
    							});
	            			}
	         		    });
				  }
			});
		 $("#editfacdialog").dialog({
				autoOpen : false,
				width : 480,
				title : 'Edit Dialog',
				modal : true,
				buttons: [
				            {
				                id: "OK",
				                text: "OK",
				                click: function () {
				                    var cardrow = table.rows('.selected').data()[0];
				                	var slot = cardrow[1].split("-")[1];
				                	var port = $("#myEditFacSelect option:selected").text();
				                	var facility = $("#editFac option:selected").text();
				                	var serviceType = $("#editServicetype option:selected").text();
				                	var frequency = $("#editFrequency option:selected").text();
				                	var wavelength = $("#editwavelength option:selected").text();
				                	var diffrentialEncoding = $("#editdiffrentialencoding option:selected").text();
				                	var cdfi = $("#editcdfi").val();
				                    //alert(slot +" "+port+" "+facility+"  "+ serviceType+" "+frequency +" "+ wavelength+ " " + diffrentialEncoding+" "+ cdfi);
				                	$.ajax({
				            			url : 'operation',
				            			type : 'POST',
				            			dataType : 'json',
				            			data : {
				            				OPERATION : "ED-FACILITY",
				            				SLOT : slot,
				            				PORT : port,
				            				FACILITY : facility,
				            				SERVICETYPE : serviceType,
				            				FREQUENCY : frequency,
				            				WAVELENGTH : wavelength,
				            				DIFFRENTIALENCODING : diffrentialEncoding,
				            				CDFI : cdfi,
				            			},
				            			success : function(response) {
				            				if(response.RESULT = "PASS"){
				            					 var _trEdit = table2.row('.selected').node();
				            					 var rowdata = table2.row('.selected').data();
				            					 rowdata[0]=response.ID;
				            					 rowdata[1]=facility;
				            					 rowdata[2]=serviceType;
				            					 rowdata[3]=frequency;
				            					 rowdata[4]=wavelength;
				            					 rowdata[5]=diffrentialEncoding;
				            					 rowdata[6]=cdfi;
				            					 table2.row('.selected').data(rowdata);
				            					 $(_trEdit).find('td:eq(0)').text(response.ID);
				            					 $(_trEdit).find('td:eq(1)').text(facility);
				            				     $(_trEdit).find('td:eq(2)').text(serviceType);
				            					 $(_trEdit).find('td:eq(3)').text(frequency);
				            					 $(_trEdit).find('td:eq(4)').text(wavelength);
				            					 $(_trEdit).find('td:eq(5)').text(diffrentialEncoding);
				            					 $(_trEdit).find('td:eq(6)').text(cdfi);
				            					$("#para").text("Facility Edited Successfully...");
				             				    $("#warn").dialog('open');
				            				}else{
				            					$("#para").text("Operation failed.. Please check the administrator...");
				             				    $("#warn").dialog('open');
				            				}
				            			}
								 }); 
				                  $(this).dialog('close');}
				            },
				            {
				                id: "Cancel",
				                text: "Cancel",
				                click: function () {
				                    $(this).dialog('close');
				                }
				            }
				            ],
				            open: function( event, ui ) {
								  var row = table2.rows('.selected').data()[0];
								  var cardrow = table.rows('.selected').data()[0];
								  var port  = row[0].split("-")[2];
								  $('#myEditFacSelect').empty();
								  $('#myEditFacSelect').append($('<option>', { 
	    						        value: port,
	    						        text : port 
	    						    }));
								  
								    if(cardrow[0] == "PKTOTN"){
		    					    	  selectData = pktotnfac.split(",");
		    					      }else if(cardrow[0] == "EMOTR"){
		    					    	  selectData = emotrfac.split(",");
		    					      }else if(cardrow[0] == "100GOCLD"){
		    					    	  selectData = ocldfac.split(",");
		    					      }else if(cardrow[0] == "100GMUX"){
		    					    	  selectData = muxfac.split(",");
		    					      }
		    					      $('#editFac').empty();
		    							$.each(selectData, function (i, item) {
		    							    $('#editFac').append($('<option>', { 
		    							        value: item,
		    							        text : item 
		    							    }));
		    							});
		    						  $('#editFac').val(row[1]);
		    						  $("#editServicetype").val(row[2]);
	    							  $("#editFrequency").val(row[3]);
	    							  $("#editwavelength").val(row[4]);
	    							  $("#editdiffrentialencoding").val(row[5]);
	    							  $("#editcdfi").val(row[6]);
							  }           
			});
		 
		 $("button").click(function() {
				//console.log("click");
				var id = $(this).attr('id');
				//console.log(id);
				if (id === "addCard") {
					console.log(id);
					$.ajax({
            			url : 'getdata',
            			type : 'POST',
            			dataType : 'json',
            			data : {
            				INFO : "SLOTS"
            			},
            			success : function(response) {
            				//alert(response.EMPTYSLOTS);
            			   emptySlots = response.EMPTYSLOTS;
            			   if(emptySlots != "XXXX"){
            				   $("#adddialog").dialog('open');  
            			   }else {
            				   $("#para").text("Slot is not empty");
            				   $("#warn").dialog('open');
            			   }
        				 
            			}
         		    });
				}
				if (id === "editCard") {
					console.log(id);
					var rows = table.$('tr.selected');
					if(rows.length > 0){
						var row = table.rows('.selected').data()[0];
						$('#editcard').empty();
						if(facData.length > 0){
							 $('#editcard').append($('<option>', { 
							        value: row[0],
							        text : row[0] 
							  }));
							 $("#editprimarystate").val(row[2]);
							  var selectData="";
						      if(row[0] == "PKTOTN"){
						    	  selectData = pktotnpec.split(",");
						      }else if(row[0] == "EMOTR"){
						    	  selectData = emotrpec.split(",");
						      }else if(row[0] == "100GOCLD"){
						    	  selectData = ocldPec.split(",");
						      }else if(row[0] == "100GMUX"){
						    	  selectData = muxpec.split(",");
						      }
						      $('#editmyPec').empty();
							  $.each(selectData, function (i, item) {
								    $('#editmyPec').append($('<option>', { 
								        value: item,
								        text : item 
								    }));
							});
							  $("#editmyPec").val(row[3]);
							  $("#editmod").val(row[4]);
							  $("#editprofile").val(row[5]);
							  $("#edittrafficstatus").val(row[6]);
					}else{
						 var selectData = allCards.split(",")
							 $('#editcard').empty();
							 $.each(selectData, function (i, item) {
							    $('#editcard').append($('<option>', { 
							        value: item,
							        text : item 
							    }));
							  });
							  $('#editcard').val(row[0]);
							  $("#editprimarystate").val(row[2]);
							  var selectData="";
						      if(row[0] == "PKTOTN"){
						    	  selectData = pktotnpec.split(",");
						      }else if(row[0] == "EMOTR"){
						    	  selectData = emotrpec.split(",");
						      }else if(row[0] == "100GOCLD"){
						    	  selectData = ocldPec.split(",");
						      }else if(row[0] == "100GMUX"){
						    	  selectData = muxpec.split(",");
						      }
						      $('#editmyPec').empty();
							  $.each(selectData, function (i, item) {
								    $('#editmyPec').append($('<option>', { 
								        value: item,
								        text : item 
								    }));
							  });
							  $("#editmyPec").val(row[3]);
							  $("#editmod").val(row[4]);
							  $("#editprofile").val(row[5]);
							  $("#edittrafficstatus").val(row[6]);
					}
				    $("#editdialog").dialog('open');
					}
					else {
						$("#para").text("Select the card...");
						$("#warn").dialog('open');
					}
				}
				if (id === "deleteCard") {
					console.log(id);
					var rows = table.$('tr.selected');
					if(rows.length > 0){
						$("#deleteDialog").dialog('open');				
					}else{
						$("#para").text("Select the card...");
     				    $("#warn").dialog('open');
					}
				}
				if(id === "refreshCard"){ 
					 $.ajax({
	            			url : 'refreshCard',
	            			type : 'POST',
	            			dataType : 'json',
	            			data : {
	            				DUMMY : "",
	            			},
	            			success : function(response) {
	            			//	alert("Response can be received");
	            			  var cardData = response.ALLCARD;
	            				table.clear();
	            				 for (var i = 0, len = cardData.length; i < len; i++) {
	            				        console.log(cardData[i]);
	            				        table.row.add([
	        											cardData[i].Name,
	        											cardData[i].Id,
	        											cardData[i].PrimaryState,
	        											cardData[i].ProvisionPec,
	        											cardData[i].Mode,
	        											cardData[i].Profile,
	        											cardData[i].TraficStatus,
	        											cardData[i].SerialNo]).draw(true);
	            				    }
	            			}
					 });
					 table2.clear();
					 table2.draw(true); 
					 $("#deleteCard").attr("disabled", false);
    				 $("#deleteCard").css("background-color","gray");
					 $("#para").text("Card Refreshed....");
  				     $("#warn").dialog('open');
				}
				if (id === "addFacility") {
					console.log(id);
					var rows = table.$('tr.selected');
					if(rows.length > 0){
						$("#addfacdialog").dialog('open');				
					}else{
						$("#para").text("Select the card...");
     				    $("#warn").dialog('open');
					}
				}
				if (id === "editFacility") {
					console.log(id);
					var rows = table2.$('tr.selected');
					if(rows.length > 0){
						$("#editfacdialog").dialog('open');				
					}else{
						$("#para").text("Select the Facility...");
     				    $("#warn").dialog('open');
					}
				}
				if (id === "deleteFacility") {
					console.log(id);
					var rows = table2.$('tr.selected');
					if(rows.length > 0){
						$("#deleteFacDialog").dialog('open');				
					}else{
						$("#para").text("Select the Facility...");
     				    $("#warn").dialog('open');
					}
				}
				if(id === "refreshFacility"){
					var rows = table.$('tr.selected');
					if(rows.length > 0){
						var row = table.rows('.selected').data()[0];
						  $.ajax({
		            			url : 'getdata',
		            			type : 'POST',
		            			dataType : 'json',
		            			data : {
		            				INFO : "FACILITY",
		            				CARDID : row[1]
		            			},
		            			success : function(response) {
		            				//alert(response.EMPTYSLOTS);
		            				var data = response.ALLFAC;
		            				table2.clear();
		            				 for (var i = 0, len = data.length; i < len; i++) {
		            				        console.log(data[i]);
		            				        table2.row.add([
		        											data[i].Id,
		        											data[i].Facility,
		        											data[i].ServiceType,
		        											data[i].Frequency,
		        											data[i].WaveLength,
		        											data[i].DiffrentialEncoding,
		        											data[i].Cdfi]).draw(true);
		            				 }
		            				if(data.length > 0){
		            					$("#para").text("Facility Refreshed...");
			         				    $("#warn").dialog('open');
		            				}
		            				else {
		            					$("#para").text("No Services Available...");
			         				    $("#warn").dialog('open');
		            				}
		            			}
		         		    });
					}else{
					$("#para").text("Select the card...");
 				    $("#warn").dialog('open');
				     }
				}
		 });
		 
		 $('#myTable tbody').on( 'click', 'tr', function () {
		        if ( $(this).hasClass('selected') ) {
		            $(this).removeClass('selected');
		            table2.clear();
		            table2.draw(true);
		        	$("#deleteCard").attr("disabled", false);
    				$("#deleteCard").css("background-color","gray");
		        }
		        else {
		            table.$('tr.selected').removeClass('selected');
		            $(this).addClass('selected');
		            var row = table.rows('.selected').data()[0];
		         //   alert(row[1]);
		            $.ajax({
            			url : 'facilityServlet',
            			type : 'POST',
            			dataType : 'json',
            			data : {
            				CARDID : row[1],
            			},
            			success : function(response) {
            			//	alert("Response can be received");
            			    facData = response.ALLFAC;
            				table2.clear();
            				table2.draw(true);
            				 for (var i = 0, len = facData.length; i < len; i++) {
            				        console.log(facData[i]);
            				        table2.row.add([
        											facData[i].Id,
        											facData[i].Facility,
        											facData[i].ServiceType,
        											facData[i].Frequency,
        											facData[i].WaveLength,
        											facData[i].DiffrentialEncoding,
        											facData[i].Cdfi]).draw(true);
            				    }
            				 if(facData.length > 0){
            					$("#deleteCard").attr("disabled", true);
                				$("#deleteCard").css("background-color","black");
            				 }else{
            					$("#deleteCard").attr("disabled", false);
                				$("#deleteCard").css("background-color","gray");
            				 }
            			  }
            		    });
		        }
		    } );
		 
		 $('#myTable2 tbody').on( 'click', 'tr', function () {
		        if ( $(this).hasClass('selected') ) {
		            $(this).removeClass('selected');
		            $("#deleteFacility").attr("disabled", true);
    				 $("#deleteFacility").css("background-color","black");
    				 $("#editFacility").attr("disabled", true);
      				 $("#editFacility").css("background-color","black");
		        }
		        else {
		            table2.$('tr.selected').removeClass('selected');
		            $(this).addClass('selected');
		            $("#deleteFacility").attr("disabled", false);
    				 $("#deleteFacility").css("background-color","gray");
    				 $("#editFacility").attr("disabled", false);
      				 $("#editFacility").css("background-color","gray");
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
	</div>
	<div id="ne_info_table">
		<table id="myTable" class="myTableClass">
			<thead>
				<th>Card Name</th>
				<th id="cardid">Card Id</th>
				<th>Primary State</th>
				<th>Provision Pec</th>
				<th>Mode</th>
				<th>Profile</th>
				<th>Trafic Status</th>
				<th>Serial No</th>
			</thead>
			<tbody>
			<%
				List<Card> userInfo = (List<Card>) request.getAttribute("cardList");
				for (Card card : userInfo) {
					out.println("<tr>");
					out.println("<td>" + card.getCardName() + "</td>");
					out.println("<td>" + card.getId() + "</td>");
					out.println("<td>" + card.getPrimaryState() + "</td>");
					out.println("<td>" + card.getProvisionPec()+ "</td>");
					out.println("<td>" + card.getMod()+ "</td>");
					out.println("<td>" + card.getProfile() + "</td>");
					out.println("<td>" + card.getTraficStatus() + "</td>");
					out.println("<td>" + card.getSerialNo()+ "</td>");
					out.println("</tr>");
				}
			%>
			</tbody>
		</table>
	</div>
	<div>
		<button id="addCard" class="button" >Add</button>
		<button id="editCard" class="button">Edit</button>
		<button id="deleteCard" class="button">Delete</button>
		<button id="refreshCard" class="button">Refresh</button>
	</div>
	
	<form id="configure" method="post" action="configureServlet">
	</form>
	<div id="ne_info_table">
		<table id="myTable2" class="myTableClass">
			<thead>
				<th>Facility Id.</th>
				<th>Name</th>
				<th>Service Type</th>
				<th>Frequency</th>
				<th>Wavelength</th>
				<th>Differential Encoding</th>
				<th>Customer Defined Identifier</th>
			</thead>
			<tbody>
			</tbody>
		</table>
	</div>
	<div>
		<button id="addFacility" class="button">Add</button>
		<button id="editFacility" class="button">Edit</button>
		<button id="deleteFacility" class="button">Delete</button>
		<button id="refreshFacility" class="button">Refresh</button>
	</div>
	<div id="adddialog" title="Add dialog">
	    <form>
		<table style="width: 99%" align="left">
			<tr style="background-color: gray">
				<td>Slot</td>
				<td>
				<select id="mySelect">
				</select>
				</td>
			</tr>
			<tr>
				<td>Card</td>
				<td>
				<select id="card">
					<option value="PKTOTN">PKTOTN</option>
  					<option value="100GMUX">100GMUX</option>
  					<option value="100GOCLD">100GOCLD</option>
  					<option value="EMOTR">EMOTR</option>
				</select>
				</td>
			</tr>
			<tr style="background-color: gray">
				<td>Primary State</td>
				<td>
				<select id="primaryStateadd">
					<option value="IS">IS</option>
  					<option value="OSS">OSS</option>
  					<option value="OSS-MA">OSS-MA</option>
				</select>
				</td>
			</tr>
			<tr>
				<td>Provision PEC</td>
				<td>
				<select id=myPec>
					<option value="NTK760MK">NTK760MK</option>
  					<option value="NTK760MA">NTK760MA</option>
  					<option value="NTK761AA">NTK761AA</option>
  					<option value="NTK769AL">NTK769AL</option>
				</select>
				</td>
			</tr>
				<tr style="background-color: gray">
				<td>MOD</td>
				<td>
				<select id="addMod">
					<option value="QPSK">QPSK</option>
  					<option value="BPSK">BPSK</option>
  					<option value="100QPSK">100QPSK</option>
  					<option value="40BPSK">40BPSK</option>
				</select>
				</td>
			</tr>
			<tr>
				<td>Profile</td>
				<td>
				<select id="addProfile">
					<option value="10G">10G</option>
  					<option value="40GUNNI">40GUNNI</option>
  					<option value="4X10G">4X10G</option>
  					<option value="10GUII">10GUII</option>
				</select>
				</td>
			</tr>
			<tr  style="background-color: gray">
				<td>Traffic Status</td>
				<td>
				<select id="addtraficStatus">
					<option value="YES">YES</option>
  					<option value="NO">NO</option>
				</select>
				</td>
			</tr>
		</table>
		</form>
	</div>
	<div id="editdialog" title="Edit dialog">
	    <form>
		<table style="width: 99%" align="left">
			<tr style="background-color: gray">
				<td>Card</td>
				<td>
				<select id="editcard">
				</select>
				</td>
			</tr>
			<tr>
				<td>Primary State</td>
				<td>
				<select id="editprimarystate">
					<option value="IS">IS</option>
  					<option value="OSS">OSS</option>
  					<option value="OSS-MA">OSS-MA</option>
				</select>
				</td>
			</tr>
			<tr style="background-color: gray">
				<td>Provision PEC</td>
				<td>
				<select id=editmyPec>
					<option value="NTK760MK">NTK760MK</option>
  					<option value="NTK760MA">NTK760MA</option>
  					<option value="NTK761AA">NTK761AA</option>
  					<option value="NTK769AL">NTK769AL</option>
				</select>
				</td>
			</tr>
				<tr>
				<td>MOD</td>
				<td>
				<select id="editmod">
					<option value="QPSK">QPSK</option>
  					<option value="BPSK">BPSK</option>
  					<option value="100QPSK">100QPSK</option>
  					<option value="40BPSK">40BPSK</option>
				</select>
				</td>
			</tr>
			<tr style="background-color: gray">
				<td>Profile</td>
				<td>
				<select id=editprofile>
					<option value="10G">10G</option>
  					<option value="40GUNNI">40GUNNI</option>
  					<option value="4X10G">4X10G</option>
  					<option value="10GUII">10GUII</option>
				</select>
				</td>
			</tr>
			<tr>
				<td>Traffic Status</td>
				<td>
				<select id=edittrafficstatus>
					<option value="YES">YES</option>
  					<option value="NO">NO</option>
				</select>
				</td>
			</tr>
		</table>
		</form>
	</div>
		<div id="addfacdialog" title="Add dialog">
	    <form>
		<table style="width: 99%" align="left">
			<tr style="background-color: gray">
				<td>Port</td>
				<td>
				<select id="myFacSelect">
				</select>
				</td>
			</tr>
			<tr>
				<td>Facility</td>
				<td>
				<select id="addFac">
				</select>
				</td>
			</tr>
			<tr style="background-color: gray">
				<td>Service Type</td>
				<td>
				<select id=addServicetype>
					<option value="10G">10G</option>
  					<option value="20G">20G</option>
  					<option value="30G">30G</option>
  					<option value="40G">40G</option>
  					<option value="100G">100G</option>
				</select>
				</td>
			</tr>
			<tr>
				<td>Frequency (HZ)</td>
				<td>
				<select id=addFrequency>
					<option value="10">10</option>
  					<option value="20">20</option>
  					<option value="30">30</option>
  					<option value="40">40</option>
				</select>
				</td>
			</tr>
				<tr style="background-color: gray">
				<td>Wavelength</td>
				<td>
				<select id="addWavelength">
					<option value="1601.2">1601.2</option>
  					<option value="1602.1">1602.1</option>
  					<option value="1603.4">1603.4</option>
  					<option value="1604.6">1604.6</option>
  					<option value="1605.5">1605.5</option>
				</select>
				</td>
			</tr>
			<tr>
				<td>Diffrential Encoding</td>
				<td>
				<select id="addDiffrentialEncoding">
					<option value="NONE">NONE</option>
  					<option value="SOFT">SOFT</option>
  					<option value="HARD">HARD</option>
				</select>
				</td>
			</tr>
			<tr  style="background-color: gray">
				<td>Customer Defined Identifier</td>
				<td><input id="cdfi" type="text" name="cdfi"></td>
			</tr>
		</table>
		</form>
	</div>
		<div id="editfacdialog" title="Edit dialog">
	    <form>
		<table style="width: 99%" align="left">
			<tr style="background-color: gray">
				<td>Port</td>
				<td>
				<select id="myEditFacSelect">
				</select>
				</td>
			</tr>
			<tr>
				<td>Facility</td>
				<td>
				<select id="editFac">
				</select>
				</td>
			</tr>
			<tr style="background-color: gray">
				<td>Service Type</td>
				<td>
				<select id=editServicetype>
					<option value="10G">10G</option>
  					<option value="20G">20G</option>
  					<option value="30G">30G</option>
  					<option value="40G">40G</option>
  					<option value="100G">100G</option>
				</select>
				</td>
			</tr>
			<tr>
				<td>Frequency (HZ)</td>
				<td>
				<select id=editFrequency>
					<option value="10">10</option>
  					<option value="20">20</option>
  					<option value="30">30</option>
  					<option value="40">40</option>
				</select>
				</td>
			</tr>
				<tr style="background-color: gray">
				<td>Wavelength</td>
				<td>
				<select id="editwavelength">
					<option value="1601.2">1601.2</option>
  					<option value="1602.1">1602.1</option>
  					<option value="1603.4">1603.4</option>
  					<option value="1604.6">1604.6</option>
  					<option value="1605.5">1605.5</option>
				</select>
				</td>
			</tr>
			<tr>
				<td>Diffrential Encoding</td>
				<td>
				<select id=editdiffrentialencoding>
					<option value="NONE">NONE</option>
  					<option value="SOFT">SOFT</option>
  					<option value="HARD">HARD</option>
				</select>
				</td>
			</tr>
			<tr  style="background-color: gray">
				<td>Customer Defined Identifier</td>
				<td><input id="editcdfi" type="text" name="cdfi"></td>
			</tr>
		</table>
		</form>
	</div>
	<div id="warn" title="Warning">
	<p id="para">Please select the card..</p>
	</div>
	<div id="deleteDialog" title="Delete...">
	<p id="deletPara">Are you sure ? You want to delete...</p>
	</div>
	<div id="deleteFacDialog" title="Delete...">
	<p id="deleteFacDialogPara">Are you sure ? You want to delete...</p>
	</div>
	<form id="configure" method="post" action="configureServlet">
	</form>
</body>
</html>