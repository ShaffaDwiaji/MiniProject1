package com.currency.miniproject1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val emailInput: EditText = findViewById(R.id.email)
        val passwordInput: EditText = findViewById(R.id.password)
        val loginButton: Button = findViewById(R.id.login)

        loginButton.setOnClickListener {
            val email = emailInput.text.toString().trim()
            Log.d("LoginActivity", "Email yang terinput: $email")
            val password = passwordInput.text.toString()

            if (email.isEmpty()) {
                emailInput.error = "Email tidak boleh kosong"
            } else {
                emailInput.error = null
            }

            if (password.isEmpty()) {
                passwordInput.error = "Password tidak boleh kosong"
            } else {
                passwordInput.error = null
            }

            if (email.isNotEmpty() && password.isNotEmpty()) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }
}


