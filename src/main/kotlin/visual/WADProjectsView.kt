package visual

import javafx.scene.Parent
import jdbc.WADProjectsDao
import tornadofx.*


class WADProjectsView() : View() {
    override val root: Parent = borderpane() {
        println("3")
        val dao = WADProjectsDao()
        val projectList = dao.getOpenWADProjects()
        println(projectList)
        center = tabpane(){
            for (i in 0..projectList.size-1){
                tab(projectList[i].name) {
                    this += WADProjectViev(projectList[i])
                }
            }
        }
        right = vbox {
            button("Press Me"){
                action {
                    find<WADOpenProjects>().openWindow(owner = null)
                }

            }
            button("t1").action {
                find<WADCreateProjectViev>().openWindow(owner = null)

            }
        }
    }
}