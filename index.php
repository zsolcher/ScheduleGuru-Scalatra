<!doctype html>

<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Home</title>
    <meta name="description" content="The HTML5 Herald">
    <meta name="author" content="2011-08-24" >

    <!--  CSS/Fonts Imports  -->
    <link rel="stylesheet" href="css/index.css">
    <link rel="stylesheet" href="css/buildScheduleArea.css">
	<link rel="stylesheet" href="css/table.css">
	<link rel="shortcut icon" href="favicon.ico">

	<!--TODO-->
	<link rel="stylesheet" href="css/accountSettingsArea.css">   

	<link href='http://fonts.googleapis.com/css?family=Berkshire+Swash' rel='stylesheet' type='text/css'>
    <!--  CSS/Fonts Imports  -->

  
    <!--  JQuery Import  -->
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <!--  JQuery Import  -->

<title>ScheduleGuru</title>

</head>

<body>
<script>
	var userEmail = localStorage.getItem("userEmail");
	if(userEmail == null) window.location.href = "login.php";
	getUserData(userEmail);
	var currentUser = Object();
	var fields = Array('UserID','Email','Major','FirstName','LastName','Year');
	for(var i = 0; i < fields.length; ++i) currentUser[fields[i]] = result[fields[i]];
	result = {};
</script>

	<!--menu bar-->
	<nav>
		<ul>
			<li><a href="homeArea.php">HomeArea</a>
			</li>
			<li><a href="buildScheduleArea.php">Build Schedule</a>
			</li>
			<li><a href="savedSchedulesArea.php">Saved Schedules</a>
			</li>
			<li><a href="accountSettingsArea.php">Account Settings</a>
			</li>
			<li><a href="aboutUsArea.php">About Us</a>
			</li>
		</ul>
	</nav>
	
	 <div id="progressBar">
    <ul id="buildScheduleTabs">
        <li id="tab1">Upload Transcript</li>
        <li id="tab2">Preferences</li>
        <li id="tab3">Major</li>
        <li id="tab4">Common Curriculum</li>
        <li id="tab5">Finalize</li>
    </ul>
    </div>

    <div id="homeArea">
    <script type="text/javascript">
    	$( "#homeArea" ).load( "homeArea.php" );
    </script>
    </div>

    <div id="buildScheduleArea"  horizontal center center-justified layout>
        <script type="text/javascript">
            $( "#buildScheduleArea" ).load( "buildScheduleArea.php" );
        </script>

        <script src="js/buildScheduleArea.js"></script>
    </div>

    <div id="savedSchedulesArea">
        <script type="text/javascript">
    		$( "#savedSchedulesArea" ).load( "savedSchedulesArea.php" );
    	</script>
    </div>

    <div id="accountSettingsArea">
		<script type="text/javascript">
    		$( "#accountSettingsArea" ).load( "accountSettingsArea.php" );
    	</script>
    </div>

    <div id="aboutUsArea">
        <script type="text/javascript">
    		$( "#aboutUsArea" ).load( "aboutUsArea.php" );
    	</script>
    </div>


<script src="js/initialize_master.js"></script>
<script src="js/calendar.js"></script>
<script src="js/buildClassTable.js"></script>

</body>
</html>
