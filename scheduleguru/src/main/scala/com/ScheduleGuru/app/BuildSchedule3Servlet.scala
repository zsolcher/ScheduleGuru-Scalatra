package com.ScheduleGuru.app

import org.scalatra._
import scalate.ScalateSupport

class BuildSchedule3Servlet(db: MyDatabase) extends ScheduleguruStack {
get("/") {
    val major = "CSCI"
    val majorClasses = db.getAllClassesInfoForDepartment(major)
    <html>
      <head>
        <title>build3</title>
        <meta charset="UTF-8"></meta>
        <meta name="description" content=""></meta>
        <meta name="keywords" content=""></meta>
        <link rel="stylesheet" type="text/css" href="./css/master.css"></link>
      </head>
      <body>
        <center>
          <h1> Build Schedule 3 (Classes in the Major)</h1>
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
          <div id="majorClassOptions">
            <table id = "cc" border="1px solid #7986cb" width = "800px" 
								font-weight="bold" textAlign="left" align = "center">
              {
                for (a <- majorClasses) yield <tr><td><input type="checkbox"></input></td><td>
                { a(2)}</td><td>{a(3)}</td><td>{a(1)}</td><td>{a(5)} 
                </td><td>{a(6)+"-"+a(7)} </td><td>{a(10)}</td></tr>
              }
            </table>
            <br></br>
            Calendar also goes here
          </div>
        </section>
        <br></br>
        <a href="build2">BACK</a>
        <a href="build4">NEXT</a>
      </body>
    </html>
  }

}