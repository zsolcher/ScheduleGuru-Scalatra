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
    
  }


    get("/build3.html") {
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
