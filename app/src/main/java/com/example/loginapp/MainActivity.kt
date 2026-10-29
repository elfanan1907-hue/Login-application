package com.example.loginapp

import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val emailLayout = findViewById<TextInputLayout>(R.id.emailLayout)
        val passwordLayout = findViewById<TextInputLayout>(R.id.passwordLayout)
        val emailInput = findViewById<TextInputEditText>(R.id.emailInput)
        val passwordInput = findViewById<TextInputEditText>(R.id.passwordInput)
        val signInButton = findViewById<Button>(R.id.signInButton)
        val createAccount = findViewById<TextView>(R.id.createAccountText)
        val forgotPassword = findViewById<TextView>(R.id.forgotPasswordText)

        signInButton.setOnClickListener {
            val email = emailInput.text.toString().trim()
            val password = passwordInput.text.toString()

            emailLayout.error = null
            passwordLayout.error = null

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                emailLayout.error = getString(R.string.error_email)
            } else if (password.length < 6) {
                passwordLayout.error = getString(R.string.error_password)
            } else {
                Toast.makeText(this, R.string.msg_signed_in, Toast.LENGTH_SHORT).show()
            }
        }

        createAccount.setOnClickListener {
            Toast.makeText(this, R.string.msg_create_account, Toast.LENGTH_SHORT).show()
        }

        forgotPassword.setOnClickListener {
            Toast.makeText(this, R.string.msg_forgot_password, Toast.LENGTH_SHORT).show()
        }
    }
}
