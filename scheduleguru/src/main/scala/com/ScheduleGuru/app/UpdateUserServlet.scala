package com.ScheduleGuru.app

import org.scalatra._

class UpdateUserServlet(db: MyDatabase) extends ScheduleguruStack {

  post("/updating") {
    val email = params.get("newEmail").get
    val first = params.get("newFirst").get
    val last = params.get("newLast").get
    val pw1 = params.get("newPw1").get
    val pw2 = params.get("newPw2").get
    val userID = params.get("userID").get

    if (pw1 != pw2) {
      //alert to redo input

      <html>
        <head>
          <script src="/js/rerouteUpdateUser.js"></script>
        </head>
        <body>
          <script> reroute(false) </script>
        </body>
      </html>
    } else {
      if(pw1 == "") db.updateUserWithoutPassword(userID,email,first,last)
      else db.updateUserWithPassword(userID,email,pw1,first,last)
      val toSplit = userID+","+email+","+first+","+last
      <html>
        <head>
          <script src="/js/rerouteUpdateUser.js"></script>
        </head>
        <body>
          <script> updateLocalStorage('{toSplit}');reroute(true) </script>
        </body>
      </html>
    }

  }

  get("/") {
    <html>
      <head>
        <title>Welcome</title>
        <meta charset="UTF-8"></meta>
        <meta name="description" content=""></meta>
        <meta name="keywords" content=""></meta>
        <link rel="stylesheet" type="text/css" href="./css/master.css"></link>
        <script src="/js/loadAccountSettings.js"></script>
      </head>
      <body onload="loadAccountSettings()">
        <center>
          <h1> ScheduleGuru </h1>
        </center>
        <!--menu bar-->
        <nav>
          <ul>
            <li><a href="welcome">Home</a></li>
            <li><a href="build2">Build Schedule</a></li>
            <li><a href="updateUser">Account</a></li>
            <li><a href="aboutus">About Us</a></li>
            <li><a href="contact">Contact</a></li>
          </ul>
        </nav>

        <center>
          <h1> Update Account Settings</h1>
        </center>
        <section id="changePw" class="loginForm cf">
          <form name="updatePw" action="/updateUser/updating" method="post">
            <h2>Change Email</h2>
            <br/>
	    <label>New Email: </label>
            <input id="newEmail" name="newEmail"></input>
            <input type="hidden" id="userID" name="userID"></input>
            <br/>
            <br/>
            <h2>Change Personal Info</h2>
	    <label>New First Name: </label>
            <input id="newFirst" name="newFirst"></input>
            <br/>
            <br/>
	    <label>New Last Name: </label>
            <input id="newLast" name="newLast"></input>
            <br/>
            <br/>
	    <h2>Change Password</h2>
            <label>New Password: </label>
            <input id="newPw1" name="newPw1" type="password"></input>
            <br/>
            <br/>
            <label>Re-Enter New Password: </label>
            <input id="newPw2" name="newPw2" type="password"></input>
            <br/>
            <br/>
            <button type="submit">Update Account</button>
            <br/>
          </form>
        </section>
      </body>
    </html>
  }
}
