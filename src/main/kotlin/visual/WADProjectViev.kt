package visual

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import javafx.beans.property.SimpleStringProperty
import javafx.collections.FXCollections
import javafx.scene.Parent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import tornadofx.*
import kotlin.concurrent.thread

class WADProjectViev : Fragment() {
    val condition : TaskStatus by inject()
    val customerVievModel : CustomerVievModel by inject()
    override val root: Parent = borderpane {
        val typeRequest = FXCollections.observableArrayList("domain name", "no")
        val selectedType = SimpleStringProperty()
        var status = false
        var ps =0

        top = hbox {
            combobox(selectedType, typeRequest)
            val request = textfield()
            button("Start") {

                action {
                    println(selectedType.value)
                    println(request.text)
                    status = true
                    println(status)
                    customerVievModel.refresh()
                }
            }

            button("Stop"){
                action {
                    println(selectedType.value)
                    println(request.text)
                    status = false
                    println(status)
                }
            }
        }
        center = hbox {

        }
        bottom = hbox {
            progressbar(condition.progress)
        }

    }
}

class Customer : JsonModel{

}

class CustomerModel : Controller(){


}

class CustomerVievModel : ItemViewModel<Customer>(){
    val  customerModel : CustomerModel by inject()
    private val retrofit : Retrofit = Retrofit.Builder().baseUrl("https://translate.yandex.net")
        .addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()
    fun refresh(){
        CoroutineScope(Dispatchers.IO).launch {
            val result =
        }
        runAsync{

            thread {
                for (i in 1..5){
                updateProgress(i.toDouble(),5.0)
                Thread.sleep(1000)
            }}
        } ui {

        }
    }
}
