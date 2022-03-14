package wad

import kotlinx.coroutines.Deferred
import retrofit2.http.GET


interface WADGetFileListService {
    @GET("")
    fun getFileList(
        //@Query("domain") domain :String
    ) : Deferred<WADGetFileListResult>
}