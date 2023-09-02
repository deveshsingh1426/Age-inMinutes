package eu.tutorials.myapplication

import android.app.DatePickerDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    var Datedisplay : TextView? = null
    var textView5 : TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button : Button = findViewById(R.id.button)
        Datedisplay = findViewById(R.id.Datedisplay)
        textView5 = findViewById(R.id.textView5)
        button.setOnClickListener {
            clickDatepicker()
        }

    }
    fun clickDatepicker(){
        val myclander = Calendar.getInstance()
        val year = myclander.get(Calendar.YEAR)
        val month = myclander.get(Calendar.MONTH)
        val day = myclander.get(Calendar.DAY_OF_MONTH)
        DatePickerDialog(this,DatePickerDialog.OnDateSetListener{
            view, year, month, dayOfMonth ->
            Toast.makeText(this,"year was $year, month was ${month+1}",Toast.LENGTH_LONG).show()
            val selectedDate ="$dayOfMonth/${month+1}/$year"
            Datedisplay?.text = selectedDate

            val sdf = SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH)
            val theDate = sdf.parse(selectedDate)
            val seletectedDateInMinutes = theDate.time / 60000
            val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
            val currentDateInMinutes = currentDate.time/ 60000
            val diffrenceInMinutes = currentDateInMinutes - seletectedDateInMinutes
            textView5?.text = diffrenceInMinutes.toString()
        },year,month,day).show()
    }

}