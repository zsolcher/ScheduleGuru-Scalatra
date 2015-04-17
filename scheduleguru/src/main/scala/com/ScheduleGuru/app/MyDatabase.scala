package com.ScheduleGuru.app

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

  def getClassInfoForClassID(classID: String): Array[String] = {
    var classArr = new Array[String](14)
    try {
      val preparedStatement = connect.prepareStatement("SELECT * from AllClasses WHERE ClassID = ?");
      preparedStatement.setString(1, classID);
      val resultSet = preparedStatement.executeQuery()
      resultSet.next()

      //Basically this is saying, if the result set wasn't null, we found a class so return it
      if (!resultSet.isAfterLast()) {
        // ClassID, Name, Department, Number, Section, Days, StartTime, EndTime, Building, RoomNum, Prof, CC, CCSection, Note
        classArr(0) = resultSet.getInt("ClassID").toString
        classArr(1) = resultSet.getString("Name")
        classArr(2) = resultSet.getString("Department")
        classArr(3) = resultSet.getString("Number")
        classArr(4) = resultSet.getInt("Section").toString()
        classArr(5) = resultSet.getString("Days")
        classArr(6) = resultSet.getTime("StartTime").toString
        classArr(7) = resultSet.getTime("EndTime").toString
        classArr(8) = resultSet.getString("Building")
        classArr(9) = resultSet.getString("RoomNum")
        classArr(10) = resultSet.getString("Prof")
        classArr(11) = resultSet.getInt("CC").toString
        classArr(12) = resultSet.getInt("CCSection").toString
        classArr(13) = resultSet.getString("Note")
      }
    } catch {
      case e: Exception => e.printStackTrace()
    }

    classArr
  }

  def getAllClassesInfoForDepartment(dep: String): Array[Array[String]] = {

    var outerArr = List[Array[String]]()

    try {
      val preparedStatement = connect.prepareStatement("SELECT * from AllClasses WHERE Department = ?");
      preparedStatement.setString(1, dep);
      val resultSet = preparedStatement.executeQuery()
      resultSet.next()

      //Basically this is saying, if the result set wasn't null, we found a class so return it
      while (!resultSet.isAfterLast()) {
        var classArr = new Array[String](14)
        // ClassID, Name, Department, Number, Section, Days, StartTime, EndTime, Building, RoomNum, Prof, CC, CCSection, Note
        classArr(0) = resultSet.getInt("ClassID").toString
        classArr(1) = resultSet.getString("Name")
        classArr(2) = resultSet.getString("Department")
        classArr(3) = resultSet.getString("Number")
        classArr(4) = resultSet.getInt("Section").toString()
        classArr(5) = resultSet.getString("Days")
        classArr(6) = resultSet.getTime("StartTime").toString
        classArr(7) = resultSet.getTime("EndTime").toString
        classArr(8) = resultSet.getString("Building")
        classArr(9) = resultSet.getString("RoomNum")
        classArr(10) = resultSet.getString("Prof")
        classArr(11) = resultSet.getInt("CC").toString
        classArr(12) = resultSet.getInt("CCSection").toString
        classArr(13) = resultSet.getString("Note")
        outerArr ::= classArr
        resultSet.next
      }
    } catch {
      case e: Exception => e.printStackTrace()
    }

    outerArr.toArray
  }

  def getAllCCClassesInfoForDays_Start_End(days: String, startT: String, endT: String): Array[Array[String]] = {

    var outerArr = List[Array[String]]()

    try {
      var daysString = ""
      for (c <- days) {
        daysString += " AND Days LIKE \"%" + c + "%\""
      }
      val preparedStatement = connect.prepareStatement("Select * from AllClasses WHERE StartTime > ? AND EndTime < ? AND CC = 1" + daysString);
      preparedStatement.setString(1, startT)
      preparedStatement.setString(2, endT)
      print(preparedStatement.toString())
      val resultSet = preparedStatement.executeQuery()
      resultSet.next()

      //Basically this is saying, if the result set wasn't null, we found a class so return it
      while (!resultSet.isAfterLast()) {
        var classArr = new Array[String](14)
        // ClassID, Name, Department, Number, Section, Days, StartTime, EndTime, Building, RoomNum, Prof, CC, CCSection, Note
        classArr(0) = resultSet.getInt("ClassID").toString
        classArr(1) = resultSet.getString("Name")
        classArr(2) = resultSet.getString("Department")
        classArr(3) = resultSet.getString("Number")
        classArr(4) = resultSet.getInt("Section").toString()
        classArr(5) = resultSet.getString("Days")
        classArr(6) = resultSet.getTime("StartTime").toString
        classArr(7) = resultSet.getTime("EndTime").toString
        classArr(8) = resultSet.getString("Building")
        classArr(9) = resultSet.getString("RoomNum")
        classArr(10) = resultSet.getString("Prof")
        classArr(11) = resultSet.getInt("CC").toString
        classArr(12) = resultSet.getInt("CCSection").toString
        classArr(13) = resultSet.getString("Note")
        outerArr ::= classArr
        resultSet.next
      }
    } catch {
      case e: Exception => e.printStackTrace()
    }

    outerArr.toArray
  }

  def getUserInfoForUserID(userID: String): Array[String] = {
    var classArr = new Array[String](6)
    try {
      val preparedStatement = connect.prepareStatement("SELECT * from Users WHERE UserID = ?");
      preparedStatement.setString(1, userID);
      val resultSet = preparedStatement.executeQuery()
      resultSet.next()

      //Basically this is saying, if the result set wasn't null, we found a class so return it
      if (!resultSet.isAfterLast()) {
        // UserID, Email, Password, Major, Year, FirstName, LastName
        classArr(0) = resultSet.getInt("Email").toString
        classArr(1) = resultSet.getString("Password")
        classArr(2) = resultSet.getString("Major")
        classArr(3) = resultSet.getInt("Year").toString
        classArr(4) = resultSet.getString("FirstName")
        classArr(5) = resultSet.getString("LastName")
      }
    } catch {
      case e: Exception => e.printStackTrace()
    }

    classArr
  }

  def updateUser(userID: String, email: String, password: String, major: String, year: String, firstName: String, lastName: String) {
    try {
      val preparedStatement = connect.prepareStatement("UPDATE Users SET Password = ?, Major = ?, Year = ?, FirstName = ?, LastName = ?, Email = ? WHERE UserID = ?");
      preparedStatement.setString(1, password);
      preparedStatement.setString(2, major);
      preparedStatement.setString(3, year);
      preparedStatement.setString(4, firstName);
      preparedStatement.setString(5, lastName);
      preparedStatement.setString(6, email);
      preparedStatement.setString(7, userID);
      preparedStatement.executeUpdate()

    } catch {
      case e: Exception => e.printStackTrace()
    }
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
