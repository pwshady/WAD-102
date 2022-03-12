package visual

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.sun.javafx.iio.common.ScalerFactory
import javafx.beans.property.SimpleStringProperty
import javafx.collections.FXCollections
import javafx.scene.Parent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import tornadofx.*
import wad.TranslateService

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
                    customerVievModel.refresh(request.text)
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

class CustomerVievModel() : ItemViewModel<Customer>(){
    val  customerModel : CustomerModel by inject()
    private val retrofit : Retrofit = Retrofit.Builder().baseUrl("https://api.domainsdb.info")
        .addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()
    private val service = retrofit.create(TranslateService::class.java)
    fun refresh(req : String){
        runAsync{

            thread {
                for (i in 1..5){
                    CoroutineScope(Dispatchers.IO).launch {
                        val result = service.translate().await()
                        println(result)

                    }
                    updateProgress(i.toDouble(),5.0)
                    Thread.sleep(1000)
                }
            }
        } ui { println("compite")

        }
    }
}
