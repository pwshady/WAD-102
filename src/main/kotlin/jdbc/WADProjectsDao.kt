package jdbc

import java.sql.DriverManager
import java.sql.PreparedStatement
import java.util.*

class WADProjectsDao {
    private val driver : String
    private val url : String
    private val user : String
    private val pass : String
    init{
        val properties = Properties()
        properties.load(Any::class.java.getResourceAsStream("/database.properties"))
        driver = properties["driver"].toString()
        url = properties["url"].toString()
        user = properties["user"].toString()
        pass = properties["pass"].toString()
    }
    fun getWADProject(id : Int) : WADProject = TODO()
    fun saveWADProject(wadProject: WADProject ) : Unit = TODO()
    fun updateWADProject(wadProject: WADProject ) : Unit = TODO()
    fun getAllWADProjectsName() : List<String>
    {
        var resultList = mutableListOf<String>()
        Class.forName(driver)
        val connection = DriverManager.getConnection(url,user, pass)
        val stmt : PreparedStatement = connection.prepareStatement("select name from all_projects")
        val rs = stmt.executeQuery()
        var wad : String? = null
        while (rs.next())
        {
            wad = rs.getString(1)
            resultList.add(wad)
        }
        return resultList
    }
    fun addProject(wadProject: WADProject, tableName : String) : Unit
    {

    }

    fun getOpenWADProjects() : List<WADProject>
    {
        var resultList = mutableListOf<WADProject>()
        Class.forName(driver)
        val connection = DriverManager.getConnection(url,user, pass)
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
                rs.getString(6)
            )
            resultList.add(wad)
        }
        return resultList
    }
}