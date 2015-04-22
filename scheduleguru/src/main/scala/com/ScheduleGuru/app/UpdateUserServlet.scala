package com.ScheduleGuru.app

import org.scalatra._

class UpdateUserServlet(db: MyDatabase) extends ScheduleguruStack {

  post("/updating") {
    val pw1 = params.get("password1").get
    val pw2 = params.get("password2").get

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

      //val uid = db.getUserInfoForUserID()
      //db.updateUser(uid, pw1)

      <html>
        <head>
          <script src="/js/rerouteUpdateUser.js"></script>
        </head>
        <body>
          <script> reroute(true) </script>
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
      </head>
      <body>
        <center>
          <h1> Update Account Settings</h1>
        </center>
        <section id="changePw" class="loginForm cf">
          <form name="updatePw" action="/UpdateUser/updating" method="post">
            <h2>Change Email</h2>
            <br/>
						<label>New Email: </label>
            <input id="password1" name="password1" placeholder="******" type="password"></input>
            <br/>
            <br/>
            <h2>Change Personal Info</h2>
						<label>New First Name: </label>
            <input id="password1" name="password1" placeholder="******" type="password"></input>
            <br/>
            <br/>
						<label>New Last Name: </label>
            <input id="password1" name="password1" placeholder="******" type="password"></input>
            <br/>
            <br/>
						<h2>Change Password</h2>
            <label>New Password: </label>
            <input id="password1" name="password1" placeholder="******" type="password"></input>
            <br/>
            <br/>
            <label>Re-Enter New Password: </label>
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
