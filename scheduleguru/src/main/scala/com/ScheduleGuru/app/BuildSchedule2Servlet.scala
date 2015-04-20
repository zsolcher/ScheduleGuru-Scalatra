package com.ScheduleGuru.app

import org.scalatra._
import scalate.ScalateSupport

class BuildSchedule2Servlet(db: MyDatabase) extends ScheduleguruStack {
  post("/getPreferences"){
    
  }
  
get("/") {
    <html>
      <head>
        <title>build1</title>
        <meta charset="UTF-8"></meta>
        <meta name="description" content=""></meta>
        <meta name="keywords" content=""></meta>
        <link rel="stylesheet" type="text/css" href="./css/master.css"></link>
        <script src="/js/saveDataAcrossPages.js"></script>
				<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
      </head>
      <body>
        <center>
          <h1> Build Schedule 1</h1>
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
          <div class="page" id="pagePreferences">
            <div class="preferenceArea">
              <label for="selectMajor">Choose your major: </label>
              <select id="selectMajor">
                <option>Undecided (CSCI)</option>
                <option>Anthropology (ANTH)</option>
                <option>Art (ART)</option>
                <option>Art History (ARTH)</option>
                <option>Biology (BIOL)</option>
                <option>Business Administration (BUSN)</option>
                <option>Chemistry (CHEM)</option>
                <option>Chinese Studies (CHIN)</option>
                <option>Classical Languages (CLAS)</option>
                <option>Communication (COMM)</option>
                <option>Computer Science (CSCI)</option>
                <option>Economics (ECON)</option>
                <option>Engineering Science (ENGR)</option>
                <option>English (ENGL)</option>
                <option>French (FREN)</option>
                <option>Geosciences (GEOS)</option>
                <option>German Studies (GERM)</option>
                <option>History (HIST)</option>
                <option>Human Communication (HCOM)</option>
                <option>Mathematics (MATH)</option>
                <option>Music (MUSC)</option>
                <option>Neuroscience (NEUR)</option>
                <option>Philosophy (PHIL)</option>
                <option>Physics (PHYS)</option>
                <option>Psychology (PSYC)</option>
                <option>Religion (RELI)</option>
                <option>Russian (RUSS)</option>
                <option>Sociology (SOCI)</option>
                <option>Spanish (SPAN)</option>
                <option>Theatre (THTR)</option>
                <option>Urban Studies (URBS)</option>
              </select>
              <br></br>
              <br></br>
              <label for="radioGroupStart">What time do you want the earliest class to start? </label>
              <br></br>
              <input type="radio" name="radioStart" value="No Preference" onchange="preferedStartOnChange(this);" checked="true">No Preference</input>
              <input type="radio" name="radioStart" value="08:30:00" onchange="preferedStartOnChange(this);">8:30</input>
              <input type="radio" name="radioStart" value="09:30:00" onchange="preferedStartOnChange(this);">9:30</input>
              <input type="radio" name="radioStart" value="10:30:00" onchange="preferedStartOnChange(this);">10:30</input>
              <input type="radio" name="radioStart" value="11:30:00" onchange="preferedStartOnChange(this);">11:30</input>
              <input type="radio" name="radioStart" value="12:30:00" onchange="preferedStartOnChange(this);">12:30</input>
              <br></br>
              <br></br>
              <label for="radioGroupStart">What time do you want the latest class to end? </label>
              <br></br>
              <input type="radio" name="radioEnd" value="No Preference" checked="true">No Preference</input>
              <input type="radio" name="radioEnd" value="11:20:00">11:20</input>
              <input type="radio" name="radioEnd" value="12:20:00">12:20</input>
              <input type="radio" name="radioEnd" value="13:20:00">1:20</input>
              <input type="radio" name="radioEnd" value="14:20:00">2:20</input>
              <input type="radio" name="radioEnd" value="15:55:00">3:55</input>
              <br></br>
              <br></br>
              <label for="divDaysAvailable">Which days do you want to have class? </label>
              <br></br>
              <input type="checkbox" name="days" value="M" checked="true">Monday</input>
              <input type="checkbox" name="days" value="T" checked="true">Tuesday</input>
              <input type="checkbox" name="days" value="W" checked="true">Wednesday</input>
              <input type="checkbox" name="days" value="R" checked="true">Thursday</input>
              <input type="checkbox" name="days" value="F" checked="true">Friday</input>
              <br></br>
            </div>
          </div>
        </section>
        <br></br>
        <input id="nextButton2" onclick="build2button()" type="button" value="NEXT"></input>
      </body>
    </html>
  }
}
