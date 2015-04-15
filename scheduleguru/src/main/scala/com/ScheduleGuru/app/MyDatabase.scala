package edu.trinity.cs

import edu.trinity.cs._
import java.sql.ResultSet
import java.sql.SQLException
import java.sql.PreparedStatement
import java.sql.Connection

class MyDatabase(connect: Connection) {

  def getClassIDForSubjectClassSection(subject: String, classNumber: String, sectionNumber: String): Int = {
    try {

      val preparedStatement = connect.prepareStatement("SELECT * from AllClasses WHERE Department = ? AND Number = ? AND Section = ?");
      preparedStatement.setString(1, subject);
      preparedStatement.setString(2, classNumber);
      preparedStatement.setInt(3, Integer.parseInt(sectionNumber))
      val resultSet = preparedStatement.executeQuery()

      resultSet.next()

      //Basically this is saying, if the result set wasn't null, we found a class so return it
      if (!resultSet.isAfterLast()) {
        resultSet.getInt("ClassID");
      } else {
        -1
      }

    } catch {
      case e: Exception => { e.printStackTrace(); -2 }
    }
  }

  def getClassInfoForClassID(classID: String): List[String] = {
    var list: List[String] = null
    try {
      val preparedStatement = connect.prepareStatement("SELECT * from AllClasses WHERE ClassID = ?");
      preparedStatement.setString(1, classID);
      val resultSet = preparedStatement.executeQuery()
      resultSet.next()

      //Basically this is saying, if the result set wasn't null, we found a class so return it
      if (!resultSet.isAfterLast()) {
        // ClassID, Name, Department, Number, Section, Days, StartTime, EndTime, Building, RoomNum, Prof, CC, CCSection, Notes
        list ++ resultSet.getInt("ClassID").toString
        list ++ resultSet.getString("Name")
        list ++ resultSet.getString("Department")
        list ++ resultSet.getString("Number")
        list ++ resultSet.getInt("Section").toString()
        list ++ resultSet.getString("Days")
        list ++ resultSet.getTime("StartTime").toString
        list ++ resultSet.getTime("EndTime").toString
        list ++ resultSet.getString("Building")
        list ++ resultSet.getString("RoomNum")
        list ++ resultSet.getString("Prof")
        list ++ resultSet.getInt("CC").toString
        list ++ resultSet.getInt("CCSection").toString
        list ++ resultSet.getString("Notes")
      }
    } catch {
      case e: Exception => e.printStackTrace()
    }

    list
  }

  def inputSameClass(id: Int, classIDOfSame: Int) = {
    try {
      val preparedStatement = connect.prepareStatement("INSERT into SameClasses values (?, ?)");
      preparedStatement.setString(1, "" + id);
      preparedStatement.setString(2, "" + classIDOfSame);
      preparedStatement.executeUpdate();
    } catch {
      case e: Exception => e.printStackTrace()
    }

  }

  def insertClassTaken(userID: String, id: Int) = {
    val preparedStatement = connect.prepareStatement("INSERT into ClassesTaken values (?, ?)");
    preparedStatement.setString(1, "" + userID);
    preparedStatement.setString(2, "" + id);
    preparedStatement.executeUpdate();
  }

  def clearTable(tableName: String) {
    // Clears the
    try {
      val preparedStatement = connect.prepareStatement("DELETE from " + tableName);
      preparedStatement.execute();
    } catch {
      case e: Exception => e.printStackTrace()
    }

  }

  def insertNewClassFromTranscript(subject: String, classNumber: String, name: String): Int = {
    try {
      val preparedStatement = connect.prepareStatement("INSERT into  AllClasses values (default, ?, ?, ?, ? , ?, ?, ?, ?, ?, ?, ?, ?, ?)");

      // ClassID,Name, Department,Number, Section, Days, StartTime, EndTime, Building, RoomNum, Prof, CC, CCSection,Notes
      // Parameters start with 1

      preparedStatement.setString(1, name); // Name
      preparedStatement.setString(2, subject); // Department
      preparedStatement.setString(3, classNumber); // Number
      preparedStatement.setInt(4, 1); // Section
      preparedStatement.setString(5, "TBA"); // Days
      preparedStatement.setString(6, "00:00:00"); // StartTime
      preparedStatement.setString(7, "00:00:00"); // EndTime
      preparedStatement.setString(8, "TBA"); // Building
      preparedStatement.setString(9, "TBA"); // RoomNum
      preparedStatement.setString(10, "TBA"); // Prof
      preparedStatement.setBoolean(11, false); // CC
      preparedStatement.setInt(12, -1); // CCSection
      preparedStatement.setString(13, "Added from a transcript"); // Notes

      preparedStatement.executeUpdate();
    } catch {
      case e: Exception => println("Failed inserting transcript class")
    }
    getClassIDForSubjectClassSection(subject, classNumber, "1");
  }
}