package com.ScheduleGuru.app

import org.scalatra._
import scalate.ScalateSupport

class BuildSchedule3Servlet(db: MyDatabase) extends ScheduleguruStack {
  var major = "CSCI"
  var majorClasses = db.getAllClassesInfoForDepartment(major)
 
  get("/:major") {
    println("printing: "+params("major"))
    major = params("major")
    majorClasses = db.getAllClassesInfoForDepartment(major)

    <html>
      <head>
        <title>build2</title>
        <meta charset="UTF-8"></meta>
        <meta name="description" content=""></meta>
        <meta name="keywords" content=""></meta>
        <link rel="stylesheet" type="text/css" href="../css/master.css"></link>
        <script src="../js/saveDataAcrossPages.js"></script>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
		<script src="../js/calendar.js"></script>
      </head>
      <body id="body3build" onload="createCalendarUnderDiv('body3build');">
        <center>
          <h1> Build Schedule 2 (Classes in the Major)</h1>
        </center>
        <section>
          <div id="majorClassOptions">
            <div id="tbleDiv" style="width:750px; float:left;">
            <table id="majortable" border="1px solid #7986cb" width="750px" font-weight="bold" textAlign="left" align="center">
              {
                var counter = 0;
                var checkBoxID = "chckBox" + counter.toString()
                for (a <- majorClasses) yield <tr><td>
                                                    <input type="checkbox" onclick="testCheckBoxes(this)" name="majorclasses" id={ a(2) + " " + a(3) + " " + a(5) + " " + a(6) + " " + a(7) }></input>
                                                  </td><td>
                                                         { a(2) }
                                                       </td><td>{ a(3) }</td><td>{ a(1) }</td><td>
                                                                                                { a(5) }
                                                                                              </td><td>{ a(6) + "-" + a(7) } </td><td>{ a(10) }</td></tr>

              }
            </table>
          </div>
          </div>
        </section>
        <br></br>
        <input id="nextButton3" onclick="build3button()" type="button" value="NEXT"></input>
      </body>
    </html>
  }

}
