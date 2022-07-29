package com.jane.mypost

data class Posts(
    var userId:Int,
    var id:Int,
    var title:String,
    var body:String
)
data class  Comment(
    var postid:Int,
    var id:Int,
    var body:String,
    var name:String,
    var email:String,
)
