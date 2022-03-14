package wad

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory


class CreateProject(domenName : String, projectName : String, path : String) {
    init{
        println(projectName)
    }
    init{
        val retrofit : Retrofit = Retrofit.Builder().baseUrl("https://web.archive.org/cdx/search/cdx?url=roboscan.ru&output=json")
            .addConverterFactory(ScalarsConverterFactory.create()).addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()

        val service = retrofit.create(WADGetFileListService::class.java)
        CoroutineScope(Dispatchers.IO).launch {
            val result = service.getFileList().await()
            println(result)
        }
    }
}