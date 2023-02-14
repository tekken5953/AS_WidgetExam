package com.example.widgetexam2

import android.annotation.SuppressLint
import android.content.ComponentName
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn: Button = findViewById(R.id.mainBtn)
        btn.setOnClickListener {
            onUpdateWidgetData()
            finish()
            Log.d("TAG_WIDGET", "업데이트 완료")
        }
    }

    private fun onUpdateWidgetData() {
        sendBroadcast(Intent(UPDATE_TIME).apply {
            component = ComponentName(this@MainActivity, WidgetProvider::class.java)
        })
    }

    companion object {
        const val UPDATE_TIME = "com.example.widgetexam2.action.UPDATE_DATA"

        fun currentDateTime() : String {
            @SuppressLint("SimpleDateFormat") val format = SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분")
            val calendar = Calendar.getInstance()
            calendar.timeInMillis = System.currentTimeMillis()
            return format.format(calendar.time)
        }
    }
}