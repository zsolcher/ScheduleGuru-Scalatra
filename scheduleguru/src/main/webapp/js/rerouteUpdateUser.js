/**
 * 
 */

var currentUser = "none";
getCurrentUser();

function reroute(isMatch) {
	if(isMatch == true) {
		
	} else {
		alert("Passwords do not match, please re-enter them.");
		window.location.href = "/UpdateUser";
	}
}

function getCurrentUser(){
	var data = "is this writing or what?";
	var xmlhttp = new XMLHttpRequest();
	xmlhttp.onreadystatechange=function(){
		if (xmlhttp.readyState==4 && xmlhttp.status==200){
			currentUser = xmlhttp.responseText;
		}
	}
	xmlhttp.open("POST",window.location.origin+"/login/currentUser",false);
	xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
   	xmlhttp.send(data);
}
