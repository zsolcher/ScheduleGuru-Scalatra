var currentUser = "none";
getCurrentUser();
if(currentUser != "none") window.location.href = "welcome";
else window.location.href = "login";

function getCurrentUser(){
	var data = "is this writting or what?";
	var xmlhttp = new XMLHttpRequest();
	xmlhttp.onreadystatechange=function(){
		if (xmlhttp.readyState==4 && xmlhttp.status==200){
			currentUser = xmlhttp.responseText;
			alert("from ajax"+currentUser);
		}
	}
	xmlhttp.open("POST",window.location.origin+"/currentUser",false);
	xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
   	xmlhttp.send(data);
}
