package com.example.darfe.kotlinex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_calculadoraconstrain.*

class MainActivity : AppCompatActivity() {

    var value:String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadoraconstrain)

        btnSum.setOnClickListener(this::operar)
        btnRes.setOnClickListener(this::operar)
        btnMul.setOnClickListener(this::operar)
        btnDiv.setOnClickListener(this::operar)

        value = savedInstanceState?.getString("Value") ?: "00"
        rta.text = value

    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString("value" , value)
        super.onSaveInstanceState(outState)

    }

    fun operar(view: View){

        val n1= "0${num1.text}".toInt()
        val n2= "0${num2.text}".toInt()

        value = when(view.id){

            R.id.btnSum -> n1 + n2
            R.id.btnRes -> n1 - n2
            R.id.btnMul -> n1 * n2

            else -> n1/n2

        }.toString()

        rta.text = value

    }
}
