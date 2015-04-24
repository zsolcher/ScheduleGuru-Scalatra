

function loadAccountSettings() {
	console.log("This is getting called.");
	document.getElementById("newEmail").innerHTML = localStorage.userEmail;
	document.getElementById("newFirst").innerHTML = localStorage.userFirst;
	document.getElementById("newLast").innerHTML = localStorage.userLast;
}
