package wad

import kotlinx.coroutines.Deferred
import retrofit2.http.GET


interface WADGetFileListService {
    @GET("/cdx/search/cdx?url=archive.org&limit=5&output=json")
    fun getFileList(
        //@Query("domain") domain :String
    ) : Deferred<String>
}