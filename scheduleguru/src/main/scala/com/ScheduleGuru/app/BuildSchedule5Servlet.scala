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
            <li><a href="build1">Build Schedule</a></li>
            <li><a href="aboutus">About Us</a></li>
            <li><a href="contact">Contact</a></li>
          </ul>
        </nav>
        <section>
          <b><u>Finalize Schedule</u></b>
          <ul id="cc">
            Javascript for calendar goes here
          </ul>
        </section>
        <section>
          <div class="page" id="finalize">
          </div>
          <input type="submit" value="Finalize"></input>
        </section>
        <br></br>
        <input id="nextButton5" onclick="build5button()" type="button" value="NEXT"></input>
      </body>
    </html>
  }
}
