package com.example.fooddelivery

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.fooddelivery.databinding.ActivityLocationBinding

class LocationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLocationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLocationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val countryList = arrayOf("Russia", "Brazil", "Portugal", "Uzbekistan")
        val adapter =
            ArrayAdapter(this@LocationActivity, android.R.layout.simple_list_item_1, countryList)

        binding.listLocationlist.setAdapter(adapter)
        binding.listLocationlist.setOnItemClickListener { parent, view, position, l ->
            val selectedlocation = parent.getItemAtPosition(position) as String
            showDialogPosition(selectedlocation)
        }

    }
    fun showDialogPosition(location : String){
        val dialogView = layoutInflater.inflate(R.layout.alert_dialog, null)
        val dialogBuilder = AlertDialog.Builder(this@LocationActivity)
        dialogBuilder.setView(dialogView)

        val dialog = dialogBuilder.create()

        dialogView.findViewById<AppCompatButton>(R.id.btn_yes).setOnClickListener {

            StartActivityWithLocation(location)
            dialog.dismiss()
        }

        dialog.findViewById<AppCompatButton>(R.id.btn_no)?.setOnClickListener {
            dialog.dismiss()
        }
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()
    }
    private fun StartActivityWithLocation(location: String){
        val intent = Intent(this@LocationActivity, MainActivity :: class.java)
        intent.putExtra(location,location)
        startActivity(intent)
        finish()
    }
}