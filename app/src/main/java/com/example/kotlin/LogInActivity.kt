package com.example.kotlin

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kotlin.databinding.ActivityIogInBinding


class LogInActivity : AppCompatActivity() {
    var binding: ActivityIogInBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityIogInBinding.inflate(layoutInflater)

        this.enableEdgeToEdge()

        setContentView(binding!!.getRoot())

        ViewCompat.setOnApplyWindowInsetsListener(binding!!.main) { v: View, insets: WindowInsetsCompat ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding!!.logInButton.setOnClickListener {
            val emailText: String = binding!!.emailInput.getText().toString()
            val passwordText: String = binding!!.passwordInput.getText().toString()
            val passwordText2: String = binding!!.forgotPasswordText.getText().toString()
            if (emailText == "admin" && passwordText == "admin") {
                val intent = Intent(this, MainActivity2::class.java)
                startActivity(intent)
                finish()
            }
        }


        binding!!.forgotPasswordText.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
            finish()
        }
    }
}