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

  }

  override def destroy(context: ServletContext) {
    super.destroy(context)
  }
}
