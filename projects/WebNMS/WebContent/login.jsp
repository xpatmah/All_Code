<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Craft Terminal</title>
<link rel="stylesheet" type="text/css" href="webNms.css">
<script type="text/javascript">
function alertName(){
		alert("Not a valid User");
} 
</script> 
</head>
<body>
<div id="divclass">
<header>
<table class="lamp">
<tr>
  <th>
    <img src="images/changedImage1.jpg" >
  </th>
</tr>
</table>
</header>
<section>
<form method="post" action="loginServletClient">
<table style="width:99%" align="left">
  <tr style="background-color:gray">
    <td>User Name     </td>
    <td><input type="text" name="userName"></td> 
  </tr>
  <tr>
    <td>Password   </td>
    <td><input type="password" name="pwd" maxlength="20" autocomplete="off" ></td> 
  <!--   <td><input type="text" name="pwd" maxlength="20" autocomplete="off" ></td>  -->
    
 <!--  </tr>
  <tr style="background-color:gray">
     <td>NE IP </td>
     <td><input type="text" name="ip"></td> 
  </tr>
  <tr>
  <td >Port </td>
  <td> <input type="text" name="port"></td> 
  </tr> -->
  <tr style="background-color:gray">
    <td>TimeOut(Min.)</td>
    <td> <input type="text" name="timeOut"></td> 
  </tr>
  <tr>
  <td>
  </td>
  <td><input type="submit" value="Connect" class="button"></td>
  </tr>
</table>
</form> 
</section>
<footer>
 <table class="lamp">
<tr>
  <th>
    <img src="images/BITS_IMAGE2.png">
  </th>
</tr>
</table>
</footer>
</div>
</body>
</html>
