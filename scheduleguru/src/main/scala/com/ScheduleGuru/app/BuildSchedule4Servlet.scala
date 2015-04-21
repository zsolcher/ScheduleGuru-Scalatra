package com.ScheduleGuru.app

import org.scalatra._
import scalate.ScalateSupport

class BuildSchedule4Servlet(db: MyDatabase) extends ScheduleguruStack {
  var sT = ""
  var eT = ""
  var mwf = ""
  var tr = ""

  post("/getPreferences") {
    sT = params.get("sT").get
    eT = params.get("eT").get
    mwf = params.get("mwf").get
    tr = params.get("tr").get
    if (sT == "No Preference")
      sT = "00:00:00"
    if (eT == "No Preference")
      eT = "23:59:59"
    if (mwf == "MWF" && tr == "TR") {
      tr = ""
      mwf = ""
    }
  }

  get("/") {

    val possibleCCClasses = db.getAllCCClassesInfoForDays_Start_End(mwf + tr, sT, eT)
    <html>
      <head>
        <title>build3</title>
        <meta charset="UTF-8"></meta>
        <meta name="description" content=""></meta>
        <meta name="keywords" content=""></meta>
        <link rel="stylesheet" type="text/css" href="./css/master.css"></link>
        <script src="js/saveDataAcrossPages.js"></script>
        <script src="js/calendar.js"></script>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
      </head>
      <body id="build4body" onload="createCalendarUnderDiv('build4body')">
        <center>
          <h1> Build Schedule 3 (CC classes)</h1>
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
          <p>
            These are the Common Curriculum classes that fit within your time preferences and do not conflict with a class you are taking for your major. Please select all you would like to take. There is an additional step where you may select non-Common Curriculum classes if you so wish.
          </p>
          <b><u>Understanding Cultural Heritage</u></b>
          <div id="tbleDiv" style="width: 750px; float: left;">
          <table id="cctable1" border="1px solid #7986cb" width="750px" font-weight="bold" textAlign="left" align="center">
            {
              possibleCCClasses.map(a => <tr>
                                           <td> <input type="checkbox" onclick="testCheckBoxes(this)" name="ccclasses" id={ a(2) + " " + a(3) + " " + a(5) + " " + a(6) + " " + a(7) }></input></td>
                                           <td>{ a(2) }</td>
                                         <td>{ a(3) }</td><td>{ a(1) }</td><td>{ a(5) }</td><td>{ a(6) + "-" + a(7) } </td><td>{ a(10) }</td>
                </tr>)
            }
          </table>
        </div>
        </section>
        <section>
          <div class="page" id="finalize">
          </div>
        </section>
        <br></br>
        <!-- input id="backButton4" onclick="build4backbutton()" type="button" value="BACK"></input-->
        <input id="nextButton4" onclick="build4button()" type="button" value="NEXT"></input>
      </body>
    </html>
  }
}
