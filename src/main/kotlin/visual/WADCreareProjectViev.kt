package visual

import io.reactivex.Observable
import javafx.scene.Parent
import javafx.scene.control.TextArea
import javafx.scene.control.TextField
import javafx.scene.paint.Color
import tornadofx.*
import validation.ValidationProject
import java.util.*

class WADCreareProjectViev : Fragment() {
    override val root: Parent = form {
        var name: TextField by singleAssign()
        var domenName = ""
        var from = ""
        var to = ""
        var directory : TextField by singleAssign()
        var errorList : TextArea by singleAssign()
        var errorText = MutableList(5,{Pair("",0)})
        fieldset("Create project") {
            field("Project name") {
                name = textfield()
                errorText.set(0, Pair(ValidationProject.nameValidation(name.text).first,ValidationProject.nameValidation(name.text).second))
                name.focusedProperty().onChange {
                    println("on")
                }
                name.textProperty().onChange {
                    //errorText[0] = ValidationProject.nameValidation(name.text)
                    //errorList.textProperty().set(errorText[0])
                }
            }
            field("Domen name"){
                textfield()
            }
            field("Date from"){
                textfield()
            }
            field("Date to"){
                textfield()
            }
            field("Files directory"){
                directory = textfield()
                directory.disableProperty().set(true)
            }
            errorList = textarea(){
                style{
                    fontSize = 20.px
                    backgroundColor += c("red")
                    textFill = c("black")
                }
            }
            errorList.disableProperty().set(true)
            errorList.textProperty().set(errorText.joinToString(separator = ""))
            println("aaaaaaaaaa"+errorText.map { task -> task.first }.joinToString(separator =""))
        }
        println(name)
        hbox {
            button("Create") {
                setOnAction {
                    errorList.textProperty().set(errorText.toString())
                }
            }
            button("Cancel") {
                setOnAction {
                    close()
                }
            }
        }
    }
}