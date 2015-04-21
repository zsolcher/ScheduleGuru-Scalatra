package com.ScheduleGuru.app

import org.scalatra._
import scalate.ScalateSupport

class BuildSchedule5Servlet(db: MyDatabase) extends ScheduleguruStack {
  get("/") {
    <html>
      <head>
        <title>build4</title>
        <meta charset="UTF-8"></meta>
        <meta name="description" content=""></meta>
        <meta name="keywords" content=""></meta>
        <link rel="stylesheet" type="text/css" href="./css/master.css"></link>
        <script src="js/saveDataAcrossPages.js"></script>
        <script src="js/calendar.js"></script>
      </head>
      <body id="build5body" onload="createCalendarUnderDiv('build5body');">
        <center>
          <h1> Build Schedule 4 (Finalize)</h1>
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
        <section>
          <b><u>Final Schedule</u></b>
        </section>
        <input id="backButton5" onclick="build5backbutton()" type="button" value="BACK"></input>
      </body>
    </html>
  }
}
