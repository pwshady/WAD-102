package jdbc

data class WADProject (
    var id : Int,
    var name : String,
    var domenName : String,
    var fileTable : String,
    var to : String,
    var from : String,
    var path : String,
)