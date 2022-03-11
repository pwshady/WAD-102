package wad

import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface TranslateService {
    @GET("/api/v1.5/tr.json/translate?key=trnsl.1.1.20170331T163527Z.6d3042c2a9aad0e7.2ce36155bc4a0c5b432344b88b634c25287243c2")
    fun translate(
        @Query("text") text : String,
        @Query("lang") direction : String) : Deferred<String>

}