package jdbc

import java.sql.DriverManager
import java.sql.PreparedStatement

val url = "jdbc:mysql://localhost:3306/wad?verifyServerCertificate=false&useSSL=false&serverTimezone=UTC"

class WADProjectsDao {
    fun getWADProject(id : Int) : WADProject = TODO()
    fun saveWADProjects(wadProject: WADProject ) : Unit = TODO()
    fun updateWADProject(wadProject: WADProject ) : Unit = TODO()
    fun getOpenWadProjects() : List<String>
    {
        var resultList = mutableListOf<String>()
        Class.forName("com.mysql.cj.jdbc.Driver")
        val connection = DriverManager.getConnection(url,"root", "")
        val stmt : PreparedStatement = connection.prepareStatement("select * from open_projects")
        val rs = stmt.executeQuery()
        while (rs.next())
        {
            resultList.add(rs.getString(2))
        }
        return resultList
    }
}