package com.ScheduleGuru.app

import org.scalatra._
import scalate.ScalateSupport

class BuildSchedule1Servlet(db: MyDatabase) extends ScheduleguruStack {
  
  get("/") {
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

            <li><a href="welcome">Home</a></li>
            <li><a href="build1">Build Schedule</a></li>
            <li><a href="aboutus">About Us</a></li>
            <li><a href="contact">Contact</a></li>
          </ul>
        </nav>
        <form name="transcriptForm">
          Paste transcript in the area below:<br></br>
          <textarea id="transcriptArea" rows="20" cols="80"></textarea>
          <br></br>
          <input type="submit" value="Submit"></input>
          <br></br>
          <br></br>
          <br></br>
          Parsed Classes:<br></br>
          <textarea id="parsedclasses" rows="10" cols="80"></textarea>
        </form>
        <a href="build2">NEXT</a>
      </body>
    </html>
  }

  

  
}