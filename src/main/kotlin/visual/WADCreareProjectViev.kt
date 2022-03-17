package visual

import io.reactivex.Observable
import javafx.beans.property.SimpleObjectProperty
import javafx.scene.Parent
import javafx.scene.control.DatePicker
import javafx.scene.control.TextArea
import javafx.scene.control.TextField
import javafx.scene.paint.Color
import javafx.util.converter.LocalDateStringConverter
import tornadofx.*
import validation.ValidationProject
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.math.max

class WADCreareProjectViev : Fragment() {
    override val root: Parent = form {
        var name : TextField by singleAssign()
        var domenName : TextField by singleAssign()
        var from : TextField by singleAssign()
        var dateFrom : DatePicker by singleAssign()
        var to : TextField by singleAssign()
        var dateTo : DatePicker by singleAssign()
        var directory : TextField by singleAssign()
        var errorList : TextArea by singleAssign()
        var errorText = MutableList(5,{Pair("",0)})
        val dateFromValue = SimpleObjectProperty<LocalDate>()
        val dateToValue = SimpleObjectProperty<LocalDate>()
        val min = "19970101000000"
        val max ="20221230000000"
        fun statusUpdating (errorText : List<Pair<String,Int>>):Unit
        {
            errorList.textProperty().set(errorText.map { task -> task.first }.joinToString(separator =""))
        }
        fieldset("Create project") {
            field("Project name") {
                name = textfield()
                errorText.set(0, Pair(ValidationProject.nameValidation(name.text).first,ValidationProject.nameValidation(name.text).second))
                name.focusedProperty().onChange {
                    println("on")
                }
                name.textProperty().onChange {
                    errorText.set(0, Pair(ValidationProject.nameValidation(name.text).first,ValidationProject.nameValidation(name.text).second))
                    statusUpdating(errorText);
                }
            }
            field("Domen name"){
                domenName = textfield()
                errorText.set(1, Pair(ValidationProject.domenNameValidation(domenName.text).first,ValidationProject.domenNameValidation(domenName.text).second))
                domenName.textProperty().onChange {
                    errorText.set(1, Pair(ValidationProject.domenNameValidation(domenName.text).first,ValidationProject.domenNameValidation(domenName.text).second))
                    statusUpdating(errorText);
                }
            }
            field("Date from"){
                hbox {
                    from = textfield()
                    dateFrom = datepicker(dateFromValue){
                        //val pattern = "yyyyMMdd"
                        //val dateFormatter = DateTimeFormatter.ofPattern(pattern)
                        //converter = LocalDateStringConverter(dateFormatter,dateFormatter)
                        value = LocalDate.now()
                    }
                    button("min") {
                        action {
                            from.text = min
                        }
                    }
                    dateFrom.valueProperty().onChange {
                        from.text = "${dateFrom.value.toString().replace("-","")}000000"
                    }
                    errorText.set(2, Pair(ValidationProject.dateTimeValidation(from.text,min,"","from")
                        .first,ValidationProject.dateTimeValidation(from.text,min,"", "from").second))
                    from.textProperty().onChange {
                        errorText.set(2, Pair(ValidationProject.dateTimeValidation(from.text,min,"","from")
                            .first,ValidationProject.dateTimeValidation(from.text,min,"","from").second))
                        statusUpdating(errorText);
                    }
                }
            }
            field("Date to"){
                hbox{
                    to = textfield()
                    dateTo = datepicker(dateToValue){
                        value = LocalDate.now()
                    }
                    button("max") {
                        action {
                            to.text = max
                        }
                    }
                    dateTo.valueProperty().onChange {
                        to.text = "${dateTo.value.toString().replace("-","")}000000"
                    }
                    errorText.set(3, Pair(ValidationProject.dateTimeValidation(to.text,"",max,"to")
                        .first,ValidationProject.dateTimeValidation(to.text,"",max, "to").second))
                    to.textProperty().onChange {
                        errorText.set(3, Pair(ValidationProject.dateTimeValidation(to.text,"",max,"to")
                            .first,ValidationProject.dateTimeValidation(to.text,"",max, "to").second))
                        statusUpdating(errorText);
                    }
                }
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
            statusUpdating(errorText);
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