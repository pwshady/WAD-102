package visual

import javafx.scene.Parent
import jdbc.WADProjectsDao
import tornadofx.Fragment
import tornadofx.hbox
import tornadofx.listview
import tornadofx.observable

class WADOpenProjects : Fragment() {
    override val root: Parent = hbox {
        val dao = WADProjectsDao()
        val allProjects = dao.getAllWADProjectsName().observable()
        listview(allProjects) {  }
    }
}