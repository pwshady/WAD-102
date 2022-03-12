package wad

import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query
import javax.json.JsonObject

interface TranslateService {
    @GET("/v1/info/api")
    fun translate(
        //@Query("domain") domain :String
    ) : Deferred<TranslateResult>

}