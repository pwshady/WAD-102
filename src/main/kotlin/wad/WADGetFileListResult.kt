package wad

import com.google.gson.annotations.SerializedName

data class WADGetFileListResult(
 val arrayList: ArrayList<Statistics>
)

data class Statistics(
    @SerializedName("0") var zone : String? = null
)