package validation


class ValidationProject {
    companion object {
        fun nameValidation(name : String) : Pair<String,Int>
        {
            val regex = "^[A-Za-z0-9]*$".toRegex()
            if (name == ""){
                return Pair("The name field should not be empty",2)
            } else if (!regex.matches(name)) {
                return Pair("The name field should consist only of A-Za-z",2)
            } else{
                return Pair("",0)
            }
        }
    }
}