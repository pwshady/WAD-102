package wad

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.create


class CreateProject(domenName : String, projectName : String, path : String) {
    init{
        println(projectName)
    }
    init{
        val retrofit : Retrofit = Retrofit.Builder().baseUrl("https://web.archive.org")
            .addConverterFactory(ScalarsConverterFactory.create()).addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
        var resumeKey = ""
        var allFiles = 0
        val service = retrofit.create(WADGetFileListService::class.java)
        CoroutineScope(Dispatchers.IO).launch {
            do {
                val result = service.getFileList("pozdravok.ru*",10000,resumeKey).await()
                val fileList = result.split("\n")
                resumeKey = fileList[fileList.size-2]
                allFiles += fileList.size - 3
                //println(fileList[fileList.size-3])
                //println(fileList[fileList.size-2])
                //println(allFiles)
                if (fileList[fileList.size - 3] == ""){
                    println("prod")
                    println(allFiles)
                }else{
                    println("end")
                    println("all files: " + (allFiles + 2).toString() )
                }
            } while (fileList[fileList.size - 3] == "")
        }
    }
}