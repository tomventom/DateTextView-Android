package com.tomventura.datetextviewexample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Using a date object
        val cal = Calendar.getInstance()
        cal.set(1994, Calendar.APRIL, 20, 16, 20, 0)
        dateTextView.setDate(cal.time)

        // Using unix timestamp
        unixTextView.setUnixTime(766858800)
    }
}
