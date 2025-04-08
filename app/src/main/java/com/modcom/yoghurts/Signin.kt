package com.modcom.yoghurts
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.loopj.android.http.RequestParams
import com.modcom.yoghurts.ApiHelper
import com.modcom.yoghurts.R

class Signin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signin)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val email = findViewById<EditText>(R.id.email)
        val password = findViewById<EditText>(R.id.password)
        val signin = findViewById<Button>(R.id.signin)

        signin.setOnClickListener {
            val api = "https://modcom2.pythonanywhere.com/api/signin"
            val params = RequestParams()
            params.put("email", email.text.toString().trim())
            params.put("password", password.text.toString().trim())

            val helper = ApiHelper(applicationContext)
            helper.post2(api, params)
        }
    }
}