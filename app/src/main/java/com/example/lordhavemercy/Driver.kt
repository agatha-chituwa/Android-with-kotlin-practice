package com.example.lordhavemercy

import android.util.Log

class Driver(var name: String) {
//    var drivername = ""
//
//    init {
//        drivername = name
//    }

    val car = Car()
    
    fun showDetails(){
        Log.i("classag", "driver name is $name")
    }
}