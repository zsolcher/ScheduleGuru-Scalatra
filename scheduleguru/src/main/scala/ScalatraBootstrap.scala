import org.scalatra._
import org.slf4j.LoggerFactory
import com.ScheduleGuru.app._
import javax.servlet.ServletContext
import slick.driver.JdbcDriver.api._
import slick.driver.MySQLDriver.simple._
import java.sql.Connection
import java.sql.DriverManager
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException
import java.sql.Statement;

class ScalatraBootstrap extends LifeCycle {

  private var connect: java.sql.Connection = null;

  override def init(context: ServletContext) {
    Class.forName("com.mysql.jdbc.Driver");
    // Setup the connection with the DB
    val username = "kjames";
    val pswd = "0757477";
    connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/ScheduleGuru", username, pswd);
    //val db = Database.forURL("jdbc:mysql://localhost:3306/ScheduleGuru", "kjames", "0757477", "com.mysql.jdbc.Driver")
    context.mount(new MyScalatraServlet(new MyDatabase(connect)), "/*")

  }

  override def destroy(context: ServletContext) {
    super.destroy(context)
  }
}
