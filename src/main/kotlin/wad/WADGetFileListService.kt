package wad

import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query


interface WADGetFileListService {
    @GET("/cdx/search/cdx?fl=timestamp,original,mimetype,statuscode,length&showResumeKey=true")
    fun getFileList(
        @Query("url") url : String,
        @Query("limit") lim : Int,
        @Query("resumeKey") resumeKey : String
    ) : Deferred<String>
}