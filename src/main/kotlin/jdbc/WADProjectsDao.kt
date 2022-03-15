package jdbc

import java.sql.DriverManager
import java.sql.PreparedStatement

val url = "jdbc:mysql://localhost:3306/wad?verifyServerCertificate=false&useSSL=false&serverTimezone=UTC"

class WADProjectsDao {
    fun getWADProject(id : Int) : WADProject = TODO()
    fun saveWADProject(wadProject: WADProject ) : Unit = TODO()
    fun updateWADProject(wadProject: WADProject ) : Unit = TODO()
    fun getAllWADProject() : List<String>
    {
        var resultList = mutableListOf<String>()
        val connection = DriverManager.getConnection(url,"root", "")
        val stmt : PreparedStatement = connection.prepareStatement("select * from open_projects")
        val rs = stmt.executeQuery()
        var wad : String? = null
        while (rs.next())
        {
            wad = rs.getString(2)
            resultList.add(wad)
        }
        return resultList
    }
    fun getOpenWadProjects() : List<WADProject>
    {
        var resultList = mutableListOf<WADProject>()
        Class.forName("com.mysql.cj.jdbc.Driver")
        val connection = DriverManager.getConnection(url,"root", "")
        val stmt : PreparedStatement = connection.prepareStatement("select * from open_projects")
        val rs = stmt.executeQuery()
        var wad : WADProject? = null
        while (rs.next())
        {
            wad = WADProject(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5),
                rs.getString(6),
                rs.getString(7)
            )
            resultList.add(wad)
        }
        return resultList
    }
}