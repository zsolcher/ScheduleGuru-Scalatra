package com.ScheduleGuru.app

import org.scalatra._
import scalate.ScalateSupport

class MyScalatraServlet extends ScheduleguruStack {
  //MasterPage
    get("/"){
        <html>
          <head>
          </head>
          <body>
            <p>
                Nothing here, go to the
                <a href = "welcome.html"> welcome page </a>
            </p>
          </body>
        </html>
    }

  	get("/build1.html") {
<html>
        <head>
            <title>build1</title>
            <meta charset="UTF-8"></meta>
            <meta name="description" content=""></meta>
            <meta name="keywords" content=""></meta>
            <link rel="stylesheet" type="text/css" href="./css/master.css"></link>
        </head>
        <body>
        	<center>
            	<h1> Build Schedule 1</h1>
        	</center>
	
    	    <!--menu bar-->
    	    <nav>
                <ul>
                    <li><a href ="welcome.html">Home</a></li>
					<li><a href ="build1.html">Build Schedule</a></li>
				    <li><a href="aboutus.html">About Us</a></li>
                    <li><a href="contact.html">Contact</a></li>
                </ul>
            </nav>
			
<form name="transcriptForm">
	Paste transcript in the area below: <br></br>
	<textarea id="transcriptArea" rows = "20" cols="80"></textarea>
	<br></br>
	<input type="submit" value="Submit"></input>
	<br></br>
	<br></br>
	<br></br>
	Parsed Classes: <br></br>
	<textarea id="parsedclasses" rows = "10" cols="80"></textarea>
</form>		

<a href="build2.html">NEXT</a> 

</body>
 </html>
  }

  get("/build2.html") {
    <html>
        <head>
            <title>build2</title>
            <meta charset="UTF-8"></meta>
            <meta name="description" content=""></meta>
            <meta name="keywords" content=""></meta>
            <link rel="stylesheet" type="text/css" href="./css/master.css"></link>
        </head>
        <body>
        	<center>
            	<h1> Build Schedule 2</h1>
        	</center>
	
    	    <!--menu bar-->
    	    <nav>
                <ul>
                    <li><a href ="welcome.html">Home</a></li>
					<li><a href ="build1.html">Build Schedule</a></li>
				    <li><a href="aboutus.html">About Us</a></li>
                    <li><a href="contact.html">Contact</a></li>
                </ul>
            </nav>
			
<section>
        <div class="page" id="pagePreferences">
            <div class="preferenceArea">
                <label for="selectMajor">Choose your major: </label>
                <select id="selectMajor" onchange="majorOnChangeResponse();">
                    <option>Undecided</option>
                    <option>Anthropology</option>
                    <option>Art</option>
                    <option>Art History</option>
                    <option>Biology</option>
                    <option>Biochemistry *</option>
                    <option>Biochemistry and Molecular Biology *</option>
                    <option>Business Administration</option>
                    <option>Chemistry</option>
                    <option>Applied Chemistry</option>
                    <option>Chemistry with High School Teaching Certification</option>
                    <option>Chinese Studies</option>
                    <option>Ancient Mediterranean Studies</option>
                    <option>Classical Languages *</option>
                    <option>Communication **</option>
                    <option>Computer Science</option>
                    <option>Computing as a Second Major</option>
                    <option>Economics</option>
                    <option>Engineering Science *</option>
                    <option>English</option>
                    <option>Environmental Studies</option>
                    <option>French</option>
                    <option>Geosciences</option>
                    <option>German Studies</option>
                    <option>Greek</option>
                    <option>History</option>
                    <option>Human Communication</option>
                    <option>International Studies</option>
                    <option>Latin</option>
                    <option>Mathematics</option>
                    <option>Mathematical Finance</option>
                    <option>Music</option>
                    <option>Neuroscience *</option>
                    <option>Philosophy</option>
                    <option>Physics</option>
                    <option>Political Science</option>
                    <option>Psychology</option>
                    <option>Religion</option>
                    <option>Russian</option>
                    <option>Sociology</option>
                    <option>Spanish</option>
                    <option>Theatre</option>
                    <option>Urban Studies</option>
                </select>
                <br></br>
				<br></br>
            
                <label for="radioGroupStart">What time do you want the earliest class to start? </label>
						<br></br>               
                <input type="radio" name="radioStart" value="No Preference" onchange="preferedStartOnChange(this);" checked="true">No Preference</input>
                <input type="radio" name="radioStart" value="08:30:00" onchange="preferedStartOnChange(this);">8:30</input>
                <input type="radio" name="radioStart" value="09:30:00" onchange="preferedStartOnChange(this);">9:30</input>
                <input type="radio" name="radioStart" value="10:30:00" onchange="preferedStartOnChange(this);">10:30</input>
                <input type="radio" name="radioStart" value="11:30:00" onchange="preferedStartOnChange(this);">11:30</input>
                <input type="radio" name="radioStart" value="12:30:00" onchange="preferedStartOnChange(this);">12:30</input>
                <br></br>
				<br></br>
                <label for="radioGroupStart">What time do you want the latest class to end? </label>
                <br></br>
                <input type="radio" name="radioEnd" value="No Preference" checked="true" onchange="preferedEndOnChange(this);">No Preference</input>
                <input type="radio" name="radioEnd" value="11:20:00" onchange="preferedEndOnChange(this);">11:20</input>
                <input type="radio" name="radioEnd" value="12:20:00" onchange="preferedEndOnChange(this);">12:20</input>
                <input type="radio" name="radioEnd" value="13:20:00" onchange="preferedEndOnChange(this);">1:20</input>
                <input type="radio" name="radioEnd" value="14:20:00" onchange="preferedEndOnChange(this);">2:20</input>
                <input type="radio" name="radioEnd" value="15:55:00" onchange="preferedEndOnChange(this);">3:55</input>
            	<br></br>
				<br></br>
                <label for="divDaysAvailable">Which days do you want to have class? </label>
                	<br></br>
                	<input type="checkbox" name="days" value="M" checked="true" onchange="preferedDaysOnChange(this);">Monday</input>
                	<input type="checkbox" name="days" value="T" checked="true" onchange="preferedDaysOnChange(this);">Tuesday</input>
                	<input type="checkbox" name="days" value="W" checked="true" onchange="preferedDaysOnChange(this);">Wednesday</input>
                	<input type="checkbox" name="days" value="R" checked="true" onchange="preferedDaysOnChange(this);">Thursday</input>
                	<input type="checkbox" name="days" value="F" checked="true" onchange="preferedDaysOnChange(this);">Friday</input>

                <br></br>
                </div>
        </div>
    </section>	
<br></br>
<a href="build1.html">BACK</a> 
<a href="build3.html">NEXT</a>        
</body>
 </html>
  }


 	get("/build3.html") {
    <html>
        <head>
            <title>build3</title>
            <meta charset="UTF-8"></meta>
            <meta name="description" content=""></meta>
            <meta name="keywords" content=""></meta>
            <link rel="stylesheet" type="text/css" href="./css/master.css"></link>
        </head>
        <body>
        	<center>
            	<h1> Build Schedule 3 (Classes in the Major)</h1>
        	</center>
	
    	    <!--menu bar-->
    	    <nav>
                <ul>
                    <li><a href ="welcome.html">Home</a></li>
					<li><a href ="build1.html">Build Schedule</a></li>
				    <li><a href="aboutus.html">About Us</a></li>
                    <li><a href="contact.html">Contact</a></li>
                </ul>
            </nav>
 <section>
        <div  id="majorClassOptions">
			JavaScript for loading classes in major goes here: 
			<br></br>
	 Calendar also goes here
        </div>
    </section>
    

<br></br>
<a href="build2.html">BACK</a> 
<a href="build4.html">NEXT</a>        
</body>
 </html>
  }
	

    get("/build4.html") {
    <html>
        <head>
            <title>MasterPage</title>
            <meta charset="UTF-8"></meta>
            <meta name="description" content=""></meta>
            <meta name="keywords" content=""></meta>
            <link rel="stylesheet" type="text/css" href="./css/master.css"></link>
        </head>
        <body>
        	<center>
            	<h1> ScheduleGuru </h1>
        	</center>
	
    	    <!--menu bar-->
    	    <nav>
                <ul>
                    <li><a href ="welcome.html">Home</a></li>
				    <li><a href="aboutus.html">Our Story</a></li>
                    <li><a href=".html"></a></li>
                </ul>
            </nav>
	
        	<!--icons-->
        	<form>
              <input type="submit" value="settings"></input>
              <input type="submit" value="profile"></input>
              <input type="submit" value="contact us"></input>
              <input type="submit" value="start"></input>
    	    </form>
        </body>
    </html>
  }
	

    get("/build5.html") {
    <html>
        <head>
            <title>MasterPage</title>
            <meta charset="UTF-8"></meta>
            <meta name="description" content=""></meta>
            <meta name="keywords" content=""></meta>
            <link rel="stylesheet" type="text/css" href="./css/master.css"></link>
        </head>
        <body>
        	<center>
            	<h1> ScheduleGuru </h1>
        	</center>
	
    	    <!--menu bar-->
    	    <nav>
                <ul>
                    <li><a href ="welcome.html">Home</a></li>
				    <li><a href="aboutus.html">Our Story</a></li>
                    <li><a href=".html"></a></li>
                </ul>
            </nav>
	
        	<!--icons-->
        	<form>
              <input type="submit" value="settings"></input>
              <input type="submit" value="profile"></input>
              <input type="submit" value="contact us"></input>
              <input type="submit" value="start"></input>
    	    </form>
        </body>
    </html>
  }
	
  	get("/welcome.html") {
    	<html>
        <head>
            <title>Home</title>
            <meta charset="UTF-8"></meta>
            <meta name="description" content=""></meta>
            <meta name="keywords" content=""></meta>
            <link rel="stylesheet" type="text/css" href="./css/master.css"></link>
        </head>
        <body>
        	<center>
            	<h1> ScheduleGuru </h1>
        	</center>
	
    	    <!--menu bar-->
    	    <nav>
                <ul>
                    <li><a href ="welcome.html">Home</a></li>
					<li><a href ="build1.html">Build Schedule</a></li>
				    <li><a href="aboutus.html">About Us</a></li>
                    <li><a href="contact.html">Contact</a></li>
                </ul>
            </nav>
			
<div id="letterArea">
        <center>
			<h2>A Letter to the User</h2>
        </center>
        <hr></hr>
        <p>
            <h3>
				Dear User,
				<br>
				</br>
				Here's a brief overview on how to use the ScheduleGuru App.
            If you have not already signed up for an account, please do so now.
            If you are already a registered user, please proceed to login.
            Once you have logged in, you will be greeted by a homepage, in which
            you can change your account settings and view your progress.
            Click on "start" in order to begin the process of preparing your schedule.
            Use the left and right buttons to navigate through the different stages.
            You may also click on any point of the progress bar to go back to a previous section.
            Have fun scheduling!
				<br>
				</br>
				Best,
				
				<br>
				</br>
				ScheduleGuru Team
				<br>
				</br>
				P.S. Please 
				<a href="contact.html">email</a> 
				us with any feedback :)
				<br>
				</br>
				
				
			</h3>
        </p>
</div>
       
        </body>
 </html>
  }

  	get("/login.html"){
   	<html>

	<head>
		<title>Welcome</title>
        <meta charset="UTF-8"></meta>
        <meta name="description" content=""></meta>
        <meta name="keywords" content=""></meta>
        <link rel="stylesheet" type="text/css" href="./css/master.css"></link>
	</head>

	<body>
		<center>
			<h1> Welcome to ScheduleGuru</h1>
		</center>

		<!--menu bar-->
		<!--nav>
			<ul>
				<li><a href="welcome.html">Home</a></li>
				<li><a href="aboutus.html">Our Story</a></li>
				<li><a href="contact.html">Contact us</a></li>
			</ul>
		</nav-->

		<!--icons-->
		<section id = "loginBox" class="loginForm cf">
			<form name="login" action="" method="post">
				<h2>Registered User</h2>
				<br/>
					<label>Username: </label>
                    <input id="name" name="username" placeholder="email address" type="text"></input>
				<br/>
				<br/>
				<!--password-->
				<label>Password: </label>
                <input id="password" name="password" placeholder="******" type="password"></input>
				<br/>
				<!--submit button-->
				<br/>
				<button type ="button">Login</button>
				<br/>
			</form>
		</section>

		<section id ="loginBox" class="loginForm cf">
			<form name="login" action="" method="post">
				<h2>New User</h2>
				<br/>
				<label>Firstname: </label>
                <input id="fname" name="fname" placeholder="" type="text"></input>
				<br/>
			
				<br/>
				<label>Lastname: </label>
                <input id="lname" name="lname" placeholder="" type="text"></input>
				<br/>
				
				<br/>
				<label>E-mail: </label>
                <input id="email" name="email" placeholder="guru@google.com" type="text"></input>
				<br/>
			
				<br/>
				<label>Password: </label>
                <input id="password" name="password" placeholder="******" type="password"></input>
				<br/>
			
				<br/>
				<label>Re-Enter Password: </label>
                <input id="password" name="password" placeholder="******" type="password"></input>
				<br/>
				
				<br/>
				<button type ="button">Create Account</button>
				<br/>
			</form>
		</section>
	</body>
</html>
  }

	get("/aboutus.html"){
		<html>

		<head>
	<title>About Us</title>
	<meta charset="UTF-8"></meta>
	<meta name="description" content=""></meta>
	<meta name="keywords" content=""></meta>
	<link rel="stylesheet" type="text/css" href="./css/master.css"></link>
</head>

<body>
	<center>
		<h1> Our Story</h1>
	</center>

	<!--menu bar-->
	<nav>
		<ul>
			  		<li><a href ="welcome.html">Home</a></li>
					<li><a href ="build1.html">Build Schedule</a></li>
				    <li><a href="aboutus.html">About Us</a></li>
                    <li><a href="contact.html">Contact</a></li>
		</ul>
	</nav>

	<section id="aboutus">
		<p style="background:white; opacity:0.8;">
			<center style="font-size: 20px; font-family:cursive, verdana;">
				Our story begin many many days ago, when we were first assigned to this project. We took this journey in an attempt to improve our current model of TigerPaws -- which is a terrible, archiac way of scheduling classes.

				<br/>
				<br/> Meet the Team:
				<br/>


				<table>

					<tr>
						<td>
							<img src="./imgs/rb.jpeg" alt="Rob Bierman" />
						</td>

						<td>
							Rob Bierman
							<br/>
							<br/>
							Our fearless hobbit
						</td>
					</tr>


					<tr>
						<td>
							<img src="./imgs/kj.jpeg" alt="Kendrick James" />
						</td>

						<td>
							Kendrick James
							<br/>
							<br/>
							No description needed.
						</td>
					</tr>
					
					
					<tr>
						<td>
							<img src="./imgs/ll.jpeg" alt="Lu Liu" />
						</td>

						<td>
							Lu Liu
							<br/>
							<br/>
							Need to figure out how to crop pics
						</td>
					</tr>
					
					<tr>
						<td>
							<img src="./imgs/co.jpeg" alt="Caleb Olson" />
						</td>

						<td>
							Caleb Olson
							<br/>
							<br/>
							Where's the Algorithm?!
						</td>
					</tr>
					
					<tr>
						<td>
							<img src="./imgs/zs.jpeg" alt="Zach Solcher" />
						</td>

						<td>
							Zach Solcher
							<br/>
							<br/>
							Webmaster
						</td>
					</tr>
				</table>
			</center>
		</p>
	</section>

</body>

</html>
  }

get("/contact.html"){
<html>

<head>
	<title>Contact</title>
	<meta charset="UTF-8"></meta>
	<meta name="description" content=""></meta>
	<meta name="keywords" content=""></meta>
	 <link rel="stylesheet" type="text/css" href="./css/master.css"></link>
</head>

<body>
	<center>
		<h1> Contact Us</h1>
	</center>

				    <!--menu bar-->
    	    <nav>
                <ul>
                    <li><a href ="welcome.html">Home</a></li>
					<li><a href ="build1.html">Build Schedule</a></li>
				    <li><a href="aboutus.html">About Us</a></li>
                    <li><a href="contact.html">Contact</a></li>
                </ul>
            </nav>

<form name="feedbackForm">
	We welcome your feedback: <br></br>
	<textarea id="feedbackArea" rows = "20" cols="80">
		
	</textarea>
	<br></br>
	<input type="submit" value="Send"></input>
</form>
	

</body>

</html>
  }
}
