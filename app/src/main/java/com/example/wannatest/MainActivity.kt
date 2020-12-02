package com.example.wannatest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var userViewModel: UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        btnSignUp.setOnClickListener {
            signUp(et_name.text.toString(), et_password.text.toString())
        }
    }

    private fun signUp(name: String, password: String) {
        if (name.isNotEmpty() && password.isNotEmpty()) {
            val intent = Intent(this, ProfileActivity::class.java)
            intent.putExtra("name", name)
            startActivity(intent)
            userViewModel.setUsername(name)
        } else {
            if (name.isEmpty()) {
                Toast.makeText(this, "Insert name to continue", Toast.LENGTH_SHORT).show()
            } else if (password.isEmpty()) {
                Toast.makeText(this, "Insert password to continue", Toast.LENGTH_SHORT).show()
            }
        }
    }
}