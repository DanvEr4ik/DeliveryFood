package com.example.fooddelivery

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.fooddelivery.databinding.ActivitySignUpUserBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class SignUpUserActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.goLoginUserPage.setOnClickListener {
            val intent = Intent(this@SignUpUserActivity,LoginUserActivity :: class.java)
            startActivity(intent)
        }

        binding.button3.setOnClickListener {
            if (binding.signUpEmail.text.isEmpty() || binding.signUpPassword.text.isEmpty() || binding.signUpUser.text.isEmpty()) {
                Toast.makeText(applicationContext, "Fields cannot be empty", Toast.LENGTH_SHORT).show()
            } else {
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(
                    binding.signUpEmail.text.toString(),
                    binding.signUpPassword.text.toString()
                ).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val userInfo = hashMapOf(
                            "email" to binding.signUpEmail.text.toString(),
                            "username" to binding.signUpUser.text.toString(),
                            "password" to binding.signUpPassword.text.toString(),
                        )
                        FirebaseDatabase.getInstance().reference.child("Users")
                            .child(FirebaseAuth.getInstance().currentUser!!.uid)
                            .setValue(userInfo)

                        startActivity(Intent(this@SignUpUserActivity, MainActivity::class.java))
                    }
                }
            }
        }
    }
}
