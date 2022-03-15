package visual

import javafx.scene.Parent
import javafx.scene.control.TextField
import tornadofx.*


class WADCreareProject : Fragment() {
    override val root: Parent = form {
        var name: TextField by singleAssign()
        var domenName = ""
        var fileTableName = ""
        var from = ""
        var to = ""
        var directory = ""
        fieldset("Create project") {
            field("Project name") {
                name = textfield()
                name.focusedProperty().onChange {
                    println("1")
                }
                name.textProperty().onChange { println("7") }
            }
            field("Domen name"){
                textfield()
            }
            field("File table name"){
                textfield()
            }
            field("Date from"){
                textfield()
            }
            field("Date to"){
                textfield()
            }
            field("Files directory"){
                textfield()
            }
        }
        println(name)
    }
}