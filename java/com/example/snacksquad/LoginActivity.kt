package com.example.snacksquad

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.snacksquad.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private val binding: ActivityLoginBinding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }

    private lateinit var loginbtn : Button
    private lateinit var edituser : EditText
    private lateinit var editpword : EditText
    private lateinit var dbh : DBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.tVnotAccount.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

        loginbtn = findViewById(R.id.bTLogin)
        edituser = findViewById(R.id.editTextTextEmailAddress)
        editpword = findViewById(R.id.editTextTextPassword)
        dbh = DBHelper(this)

        loginbtn.setOnClickListener {
            val usertxt = edituser.text.toString()
            val passtxt = editpword.text.toString()

            if(TextUtils.isEmpty(usertxt) || TextUtils.isEmpty(passtxt)){
                Toast.makeText(this,"Enter Your Username and password ", Toast.LENGTH_SHORT).show()
            }
            else{
                val checkuser = dbh.checkuserpass(usertxt, passtxt)
                if(checkuser==true){
                    Toast.makeText(this,"Login Successfull", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
                else{
                    Toast.makeText(this,"You entered wrong password", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}