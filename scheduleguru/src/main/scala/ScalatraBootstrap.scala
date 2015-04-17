import java.sql.DriverManager

import org.scalatra.LifeCycle

import com.ScheduleGuru.app._

import javax.servlet.ServletContext

class ScalatraBootstrap extends LifeCycle {

  private var connect: java.sql.Connection = null;

  override def init(context: ServletContext) {
    Class.forName("com.mysql.jdbc.Driver");
    // Setup the connection with the DB
    val username = "kjames";
    val pswd = "0757477";
    connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/ScheduleGuru", username, pswd);
    //val db = Database.forURL("jdbc:mysql://localhost:3306/ScheduleGuru", "kjames", "0757477", "com.mysql.jdbc.Driver")
    val db = new MyDatabase(connect)
    context.mount(new MyScalatraServlet(db), "/*")
    context.mount(new MyLoginServlet(db), "/login")
    context.mount(new BuildSchedule1Servlet(db),"/build1")
    context.mount(new BuildSchedule2Servlet(db),"/build2")
    context.mount(new BuildSchedule3Servlet(db),"/build3")
    context.mount(new BuildSchedule4Servlet(db),"/build4")
    context.mount(new BuildSchedule5Servlet(db),"/build5")

  }

  override def destroy(context: ServletContext) {
    super.destroy(context)
  }
}
