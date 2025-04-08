import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.loopj.android.http.RequestParams
import com.modcom.yoghurts.R

class Signup : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signup)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val username = findViewById<EditText>(R.id.username)
        val password = findViewById<EditText>(R.id.password)
        val email = findViewById<EditText>(R.id.email)
        val phone = findViewById<EditText>(R.id.phone)
        val signup = findViewById<Button>(R.id.signup)
        
        signup.setOnClickListener {
            val api = "https://modcom2.pythonanywhere.com/api/signup"
            val params = RequestParams()
            params.put("username", username.text.toString())
            params.put("password", password.text.toString())
            params.put("email", email.text.toString())
            params.put("phone", phone.text.toString())
            val helper = ApiHelper(applicationContext)
            helper.post(api, params)
        }
    }
}