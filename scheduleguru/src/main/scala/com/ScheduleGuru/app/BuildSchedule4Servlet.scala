package com.ScheduleGuru.app

import org.scalatra._
import scalate.ScalateSupport

class BuildSchedule4Servlet(db: MyDatabase) extends ScheduleguruStack {
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
      <body id="build4body" onload="createCalendarUnderDiv('build4body')">
        <center>
          <h1> Build Schedule 4 (CC classes)</h1>
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
          <p>
            These are the Common Curriculum classes that fit within your time preferences and do not conflict with a class you are taking for your major. Please select all you would like to take. There is an additional step where you may select non-Common Curriculum classes if you so wish.
          </p>
          <b><u>Understanding Cultural Heritage</u></b>
          <ul id="cc">
            load CC courses here, for all 5 sections of CC
          </ul>
        </section>
        <section>
          <div class="page" id="finalize">
          </div>
        </section>
        <br></br>
        <input id="nextButton4" onclick="build4button()" type="button" value="NEXT"></input>
      </body>
    </html>
  }
}
