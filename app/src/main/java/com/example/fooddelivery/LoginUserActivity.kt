package com.example.fooddelivery

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.fooddelivery.databinding.ActivityLoginBinding
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.Firebase
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth

class LoginUserActivity : AppCompatActivity() {
    private lateinit var binding : ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.goSignUpUser.setOnClickListener {
            val intent = Intent(this@LoginUserActivity,SignUpUserActivity :: class.java)
            startActivity(intent)
        }
        binding.button3.setOnClickListener {
            if (binding.signInEmail.text.toString().isEmpty() || binding.signInPassword.text.toString().isEmpty()) {
                Toast.makeText(applicationContext, "Fields cannot be empty", Toast.LENGTH_SHORT)
                    .show()
            }else{
                FirebaseAuth.getInstance().signInWithEmailAndPassword(binding.signInEmail.text.toString(), binding.signInPassword.text.toString()).addOnCompleteListener{
                    task -> if(task.isSuccessful) {
                        startActivity(Intent(this@LoginUserActivity,MainActivity::class.java))
                }
                }
            }
        }
    }
}

