<!DOCTYPE html>
<html>
<script>
	document.getElementById("firstNameBox").innerHTML = currentUser['FirstName'];
	document.getElementById("lastNameBox").innerHTML = currentUser['LastName'];
	document.getElementById("majorBox").innerHTML = currentUser['Major'];
	var gradeLevel = "Not Known";
	if(currentUser['Year'] == "1") gradeLevel = "Freshman";
	else if(currentUser['Year'] == "2") gradeLevel = "Sophomore";
	else if(currentUser['Year'] == "3") gradeLevel = "Junior";
	else if(currentUser['Year'] == "4") gradeLevel = "Senior";
	else if(currentUser['Year'] == "5") gradeLevel = "Super Senior";
	
	document.getElementById("gradeBox").innerHTML = gradeLevel;
	document.getElementById("emailBox").innerHTML = currentUser['Email'];
</script>

<div id="currentSettingsArea">
		<h1 id="title">Current Settings</h1>
			<center>
			
			<h3 style="color:white"> First Name:</h3>
			<p id="firstNameBox"><p>

			<h3 style="color:white"> Last Name:</h3> 
			<p id="lastNameBox"><p>

			<h3 style="color:white"> Major:</h3> 
			<p id="majorBox"><p>

			<h3 style="color:white"> Email:</h3> 
			<p id="gradeBox"><p>

			<h3 style="color:white"> Major:</h3> 
			<p id="emailBox"><p>
</div>

<div id="updateSettingsArea">
		<h1 id="title">Update Settings</h1>
        <form id="accountSettingsForm" action="" method="post">
			<center>
			
			<br>
		<label>Firstname: </label>
		<input id="txtFname" name="acct_fname" placeholder="" type="text">
		<br>
		
		<br>
		<label>Lastname: </label>
		<input id="txtLname" name="acct_lname" placeholder="" type="text">
		<br>
		
		<br>
		<label>Major: </label>
		<select>
			<option>Ancient Mediterranean Studies</option>
			<option>Biochemistry and Molecular Biology</option>
			<option>Chemistry</option>
			<option>Computer Science</option>
			<option>Engineering Science</option>
			<option>French</option>
			<option>International Studies</option>			
			<option>Mathematics</option>
			<option>Philosophy</option>
			<option>Urban Studies</option>
		</select>
		<br>
	
		<br>
		<label>Grade: </label>
		<select>
			<option>Freshman</option>
			<option>Sophomore</option>
			<option>Junior</option>
			<option>Senior</option>
			<option>Super Senior</option>
		</select>
		<br>
		
		<br>
		<label>Email: </label>
		<input id="login_email" name="txtEmail" placeholder="guru@gmail.com" type="text">
		<br>


</div>

</html>
