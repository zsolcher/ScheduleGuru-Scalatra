package com.ScheduleGuru.app

import org.scalatra._
import scalate.ScalateSupport

class BuildSchedule5Servlet(db: MyDatabase) extends ScheduleguruStack {
  get("/") {
    <html>
      <head>
        <title>build5</title>
        <meta charset="UTF-8"></meta>
        <meta name="description" content=""></meta>
        <meta name="keywords" content=""></meta>
        <link rel="stylesheet" type="text/css" href="./css/master.css"></link>
      </head>
      <body>
        <center>
          <h1> Build Schedule 5 (Finalize)</h1>
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
        <a href="build4">BACK</a>
      </body>
    </html>
  }
}