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

  get("/welcome.html") {
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
		<nav>
			<ul>
				<li><a href="welcome.html">Home</a></li>
				<li><a href="aboutus.html">Our Story</a></li>
				<li><a href="contact.html">Contact us</a></li>
			</ul>
		</nav>

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
	<nav>
		<ul>
			<li><a href="welcome.html">Home</a></li>
			<li><a href="aboutus.html">Our Story</a></li>
			<li><a href="contact.html">Contact us</a></li>
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
	<title>Welcome</title>
	<meta charset="UTF-8"/>
	<meta name="description" content=""/>
	<meta name="keywords" content=""/>
	<link rel="stylesheet" type="text/css" href="./css/master.css"/>
</head>

<body>
	<center>
		<h1> Welcome to ScheduleGuru</h1>
	</center>

	<!--menu bar-->
	<nav>
		<ul>
			<li><a href="welcome.html">Home</a></li>
			<li><a href="aboutus.html">Our Story</a></li>
			<li><a href="contact.html">Contact us</a></li>
		</ul>
	</nav>

    <p>
        This is the contact us page
    </p>

</body>

</html>
  }
}
