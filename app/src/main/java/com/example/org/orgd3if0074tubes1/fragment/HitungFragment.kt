package com.example.org.orgd3if0074tubes1.fragment

import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.resources.Compatibility.Api21Impl.inflate
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.org.orgd3if0074tubes1.R

class HitungFragment : Fragment(){

    private lateinit var bindingFragment: HitungFragment

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_about) {
            findNavController().navigate(
                R.id.action_hitungFragment_to_aboutFragment2)
            return true
        }
        return super.onOptionsItemSelected(item)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        var binding = HitungFragment.inflate(layoutInflater, container, false)
        setHasOptionsMenu(true)


        var p: EditText? = null
        var l: EditText? = null
        var hitung: Button? = null
        var hasil: TextView? = null

        p = findViewById<View>(R.id.panjang) as EditText
        l = findViewById<View>(R.id.lebar) as EditText
        hitung = findViewById<View>(R.id.button) as Button
        hasil = findViewById<View>(R.id.txt_hasil) as TextView
        hitung!!.setOnClickListener {
            //jika tidak mengisi panjang dan lebar sekaligus maka akan tampil notifikasi

            if (p!!.length() == 0 && l!!.length() == 0) {
                Toast.makeText(
                    context,
                    "Panjang dan lebar tidak boleh Kosong",
                    Toast.LENGTH_LONG
                ).show()
            } else if (p!!.length() == 0) {
                Toast.makeText(context, "Panjang tidak boleh kososng", Toast.LENGTH_LONG).show()
            } else if (l!!.length() == 0) {
                Toast.makeText(context, "Lebar tidak boleh kosong", Toast.LENGTH_LONG).show()
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