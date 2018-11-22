package com.tomventura.datetextview

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*

class DateTextView(context: Context, attrs: AttributeSet) : TextView(context, attrs) {

    companion object {
        private const val DEFAULT_DATE_FORMAT = "dd/MM/yyyy HH:mm:ss"
    }

    private var dateFormat = DEFAULT_DATE_FORMAT

    private val simpleDateFormat = SimpleDateFormat(dateFormat, Locale.getDefault())

    init {
        setupAttributes(attrs)
    }

    private fun setupAttributes(attrs: AttributeSet) {
        val typedArray = context.theme.obtainStyledAttributes(attrs, R.styleable.DateTextView, 0, 0)
        val dateFormatAttribute: String? = typedArray.getString(R.styleable.DateTextView_dateFormat)
        dateFormat = dateFormatAttribute ?: DEFAULT_DATE_FORMAT

        typedArray.recycle()
    }

    private fun format(date: Date): String {
        return try {
            simpleDateFormat.format(date)
        } catch (e: Exception) {
            e.printStackTrace()
            ""
        }
    }

    fun setUnixTime(unixTime: Long) {
        val date = Date(unixTime * 1000L)
        text = format(date)
        invalidate()
    }

    fun setDate(date: Date) {
        text = format(date)
        invalidate()
    }
}