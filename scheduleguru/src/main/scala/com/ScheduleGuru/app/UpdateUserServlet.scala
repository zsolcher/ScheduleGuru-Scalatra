package com.ScheduleGuru.app

import org.scalatra._

class UpdateUserServlet(db: MyDatabase) extends ScheduleguruStack {

  var currentUser = "none"

  post("/checking") {
    val givenUsername = params.get("username")
    val givenPassword = params.get("password")
    println("trying to check the login for " + givenUsername.get + " and " + givenPassword.get)
    val userInfo = db.getUserInfoForEmail(givenUsername.get)
    if (givenPassword.get == userInfo(2)) {
      currentUser = givenUsername.get;
    } else {
      currentUser = "none";
    }
    <html>
      <head>
        <script src="/js/rerouteByLogin.js"></script>
      </head>
      <body>
        <p>
          Redirection page based on whether or not you are logged in
        </p>
      </body>
    </html>
  }

  //Should I create another post method (post("/createuser")
  
  post("/createuser") {
    val fname = params.get("fname").get
    val lname = params.get("lname").get
    val email = params.get("email").get
    val pw1 = params.get("password1").get
    val pw2 = params.get("password2").get
    
    println("fname = " + fname)
    println("lname = " + lname)
    println("email = " + email)
    println("pw1 = " + pw1)
    println("pw2 = " + pw2)

    if(pw1 != pw2) {
      currentUser = "none";
    } else {
      db.createUser(fname, lname, email, pw1)
      currentUser = email;
    }
    
    <html>
      <head>
        <script src="/js/rerouteByLogin.js"></script>
      </head>
      <body>
        <p>
          Redirection page based on whether or not you are logged in.
        </p>
      </body>
    </html>
  }
  
  post("/currentUser") {
    println("Got to current user") 
    currentUser
  }

  get("/") {
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
        <section id="loginBox" class="loginForm cf">
          <form name="login" action="/login/checking" method="POST">
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
            <button type="submit">Login</button>
            <br/>
          </form>
        </section>
        <section id="registerBox" class="loginForm cf">
          <form name="newUser" action="/login/createuser" method="post">
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
            <input id="password1" name="password1" placeholder="******" type="password"></input>
            <br/>
            <br/>
            <label>Re-Enter Password: </label>
            <input id="password2" name="password2" placeholder="******" type="password"></input>
            <br/>
            <br/>
            <button type="submit">Create Account</button>
            <br/>
          </form>
        </section>
      </body>
    </html>
  }
}