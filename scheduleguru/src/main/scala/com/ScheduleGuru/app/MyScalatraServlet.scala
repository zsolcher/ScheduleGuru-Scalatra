package com.ScheduleGuru.app

import org.scalatra._
import scalate.ScalateSupport

class MyScalatraServlet(db: MyDatabase) extends ScheduleguruStack {
  //MasterPage
  get("/") {
    <html>
      <head>
        <script src="./js/rerouteByLogin.js"></script>
      </head>
      <body>
        <p>
          Redirection page based on whether or not you are logged in
        </p>
      </body>
    </html>
  }

  get("/database") {
    val classId = db.getClassIDForSubjectClassSection("CSCI", "1320", "1")
    val classInfo = db.getClassInfoForClassID("50438")
    val csCourses = db.getAllClassesInfoForDepartment("CSCI")
    <html>
      <head>
        <script src="./js/mesh_scala.js"></script>
      </head>
      <body onload="save();">
        <p>
        </p>
      </body>
    </html>
  }

  post("/giveBackString"){
    println("got here and gave back");
    "updated javascript!"
  }

  

  get("/welcome") {
    <html>
      <head>
        <title>Home</title>
        <meta charset="UTF-8"></meta>
        <meta name="description" content=""></meta>
        <meta name="keywords" content=""></meta>
        <link rel="stylesheet" type="text/css" href="./css/master.css"></link>
      </head>
      <body>
        <center>
          <h1> ScheduleGuru </h1>
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
        <div id="letterArea">
          <center>
            <h2>A Letter to the User</h2>
          </center>
          <hr></hr>
          <p>
            <h3>
              Dear User,
              <br>
              </br>
              Here's a brief overview on how to use the ScheduleGuru App.
            If you have not already signed up for an account, please do so now.
            If you are already a registered user, please proceed to login.
            Once you have logged in, you will be greeted by a homepage, in which
            you can change your account settings and view your progress.
            Click on "start" in order to begin the process of preparing your schedule.
            Use the left and right buttons to navigate through the different stages.
            You may also click on any point of the progress bar to go back to a previous section.
            Have fun scheduling!
              <br>
              </br>
              Best,
              <br>
              </br>
              ScheduleGuru Team
              <br>
              </br>
              P.S. Please
              <a href="contact">email</a>
              us with any feedback :)
              <br>
              </br>
            </h3>
          </p>
        </div>
      </body>
    </html>
  }

  
  get("/aboutus") {
    <html>
      <head>
        <title>About Us</title>
        <meta charset="UTF-8"></meta>
        <meta name="description" content=""></meta>
        <meta name="keywords" content=""></meta>
        <link rel="stylesheet" type="text/css" href="./css/master.css"></link>
        <link rel="stylesheet" type="text/css" href="./css/table.css"></link>
      </head>
      <body>
        <center>
          <h1> Our Story</h1>
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
        <section id="aboutus">
          <p style="background:white; opacity:0.8;">
            <center style="font-size: 20px; font-family:cursive, verdana;">
              Our story begin many many days ago, when we were first assigned to this project. We took this journey in an attempt to improve our current model of TigerPaws -- which is a terrible, archiac way of scheduling classes.
              <br/>
              <br/>
              Meet the Team:
              <br/>
              <table>
                <tr>
                  <td>
                    <img src="./imgs/rb.jpeg" alt="Rob Bierman"/>
                  </td>
                  <td>
                    Rob Bierman
                    <br/>
                    <br/>
                    Fro like a mf
                  </td>
                </tr>
                <tr>
                  <td>
                    <img src="./imgs/kj.jpeg" alt="Kendrick James"/>
                  </td>
                  <td>
                    Kendrick James
                    <br/>
                    <br/>
                    Balla
                  </td>
                </tr>
                <tr>
                  <td>
                    <img src="./imgs/ll.jpeg" alt="Lu Liu"/>
                  </td>
                  <td>
                    Lu Liu
                    <br/>
                    <br/>
                    Need to figure out how to crop pics
                  </td>
                </tr>
                <tr>
                  <td>
                    <img src="./imgs/co.jpeg" alt="Caleb Olson"/>
                  </td>
                  <td>
                    Caleb Olson
                    <br/>
                    <br/>
                    #Bitches
                  </td>
                </tr>
                <tr>
                  <td>
                    <img src="./imgs/zs.jpeg" alt="Zach Solcher"/>
                  </td>
                  <td>
                    Zach Solcher
                    <br/>
                    <br/>
                    Webmaster
                  </td>
                </tr>
              </table>
            </center>
          </p>
        </section>
      </body>
    </html>
  }

  get("/contact") {
    <html>
      <head>
        <title>Contact</title>
        <meta charset="UTF-8"></meta>
        <meta name="description" content=""></meta>
        <meta name="keywords" content=""></meta>
        <link rel="stylesheet" type="text/css" href="./css/master.css"></link>
      </head>
      <body>
        <center>
          <h1> Contact Us</h1>
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
        <form name="feedbackForm" action="MAILTO:rbierman@trinity.edu" method="post" enctype="text/plain">
          Name:<br></br>
          <input type="text" name="contact_name"></input><br></br>
          Email:<br></br>
          <input type="text" name="contact_email" value="your email"></input><br></br>
          Subject:<br></br>
          <input type="text" name="contact_message" value="type your feedback here" size="50"></input><br></br>
		  Message:<br></br>
          <textarea id="feedbackArea" rows="20" cols="80">
          </textarea>
          <br></br>
          <input type="submit" value="Send"></input>
        </form>
      </body>
    </html>
  }
}
