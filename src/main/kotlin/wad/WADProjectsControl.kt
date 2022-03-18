package wad

import javafx.stage.Stage
import jdbc.WADProjectsDao
import tornadofx.launch
import visual.WADProjecstApp
import visual.WADProjectsView
import kotlin.concurrent.thread
import kotlin.reflect.full.createInstance


fun main()
{
    println("1")
    val dao = WADProjectsDao()
    val projectList = dao.getOpenWADProjects()
    println(projectList)
    launch<WADProjecstApp>()
    println("2")
    //val app = WADProjecstApp(viev)
    //app::class
    //Class.forName("com.mysql.cj.jdbc.Driver")
    //val connection  = DriverManager.getConnection(
   //     "jdbc:mysql://localhost:3306/test?verifyServerCertificate=false&useSSL=false&serverTimezone=UTC",
    //    "root",
    //    ""
    //)

    //val updateStmt = connection.prepareStatement("update salespeople set comm=50 where snum=1010")
    //updateStmt.executeUpdate()

    // comm -> 50 для Ivanov




//    val stmt : PreparedStatement
//            = connection.prepareStatement("insert into salespeople (snum, sname, city, comm) values (?, ?, ?, ?)")
//    // 1010 Ivanov Moscow 14
//    stmt.setInt   (1, 1010)
//    stmt.setString(2, "Ivanov")
//    stmt.setString(3, "Moscow")
//    stmt.setInt   (4, 14)
//    stmt.executeUpdate()


    /*
    val stmt: Statement = connection.createStatement();
    val rs = stmt.executeQuery("select * from salespeople")
    while (rs.next())
    {
        val string = "${rs.getInt(1)} ${rs.getString(2)} ${rs.getString(3)}"
        println(string)
    }
     */
}