package com.mvvm.test.ui.activity

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mvvm.test.R

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var a="hello"
        a add "world"
       var b = 1..10;
        Log.d("@@",b.toString());

    }

   infix fun String.add(a:String): String{
        return  this+a;
    }
}