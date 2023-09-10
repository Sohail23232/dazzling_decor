package com.example.dazzlingdecor.model
data class  DataModel(
    var total_results:Int,
    var page:Int,
    var per_page:Int,
    var photos:ArrayList<PhotosModel>,
    var next_page:String
)
data class PhotosModel(
    var id:Int,
    var width:Int,
    var height:Int,
    var url:String,
    var photographer:String,
    var photographer_url: String,
    var photographer_id: Int,
    var avg_color:String,
    var src:ImageSourceModel,
    var liked:Boolean,
    var alt:String
)
data class ImageSourceModel(
    var original:String,
    var large2x:String,
    var large:String,
    var medium:String,
    var small:String,
    var portrait:String,
    var landscape:String,
    var tiny:String
)
