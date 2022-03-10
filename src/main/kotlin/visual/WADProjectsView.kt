package visual

import javafx.scene.Parent
import jdbc.WADProjectsDao
import tornadofx.*


class WADProjectsView() : View() {
    override val root: Parent = borderpane() {
        println("3")
        val dao = WADProjectsDao()
        val projectList = dao.getOpenWadProjects()
        println(projectList)
        center = tabpane(){
            for (i in 0..projectList.size-1){
                tab(projectList[i]) {
                    this += WADProjectViev::class
                }
            }
        }
        right = vbox {
            button("Press Me"){
                action {  }
                //textFill = javafx.scene.paint.Color.RED
                //action { this.textFill = javafx.scene.paint.Color.GREEN }

            }
            button("t1").action {

            }
        }
    }
}