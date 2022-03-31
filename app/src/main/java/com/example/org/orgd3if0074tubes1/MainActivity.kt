package com.example.org.orgd3if0074tubes1

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity



class MainActivity : AppCompatActivity() {

    var p: EditText? = null
    var l: EditText? = null
    var hitung: Button? = null
    var hasil: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        p = findViewById<View>(R.id.panjang) as EditText
        l = findViewById<View>(R.id.lebar) as EditText
        hitung = findViewById<View>(R.id.button) as Button
        hasil = findViewById<View>(R.id.txt_hasil) as TextView
        hitung!!.setOnClickListener {
            //jika tidak mengisi panjang dan lebar sekaligus maka akan tampil notifikasi

            if (p!!.length() == 0 && l!!.length() == 0) {
                Toast.makeText(
                    application,
                    "Panjang dan lebar tidak boleh Kosong",
                    Toast.LENGTH_LONG
                ).show()
            } else if (p!!.length() == 0) {
                Toast.makeText(application, "Panjang tidak boleh kososng", Toast.LENGTH_LONG).show()
            } else if (l!!.length() == 0) {
                Toast.makeText(application, "Lebar tidak boleh kosong", Toast.LENGTH_LONG).show()
            } else {
                val isipanjang = p!!.text.toString()
                val isilebar = l!!.text.toString()
                val p = isipanjang.toDouble()
                val l = isilebar.toDouble()
                val hs = LuasPersegiPanjang(p, l)
                val output = hs.toString()
                hasil!!.text = output
            }
        }
    }

    fun LuasPersegiPanjang(p: Double, l: Double): Double {
        return p * l
    }
}