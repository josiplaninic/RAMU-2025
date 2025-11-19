package ba.sum.fsre.kalkulator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val numberEdt1 = findViewById<EditText>(R.id.edit_number1)
        val numberEdt2 = findViewById<EditText>(R.id.edit_number2)
        val resultTxt = findViewById<TextView>(R.id.text_result)

        val addBtn=findViewById<Button>(R.id.button_add)
        val subBtn=findViewById<Button>(R.id.button_sub)
        val mulBtn=findViewById<Button>(R.id.button_mul)
        val divBtn=findViewById<Button>(R.id.button_div)

        val openSecond=findViewById<Button>(R.id.open_second)

        openSecond.setOnClickListener {
            val intent=Intent(this, SecondActivity::class.java)
            val  currentResult = resultTxt.text.toString()
            intent.putExtra("RESULT_VALUE", currentResult)

            startActivity(intent)
        }

        addBtn.setOnClickListener{
            val num1 = numberEdt1.text.toString().toInt()
            val num2 = numberEdt2.text.toString().toInt()
            resultTxt.text = (num1+num2).toString()
        }

        subBtn.setOnClickListener{
            val num1 = numberEdt1.text.toString().toInt()
            val num2 = numberEdt2.text.toString().toInt()
            resultTxt.text = (num1-num2).toString()
        }

        mulBtn.setOnClickListener{
            val num1 = numberEdt1.text.toString().toInt()
            val num2 = numberEdt2.text.toString().toInt()
            resultTxt.text = (num1*num2).toString()
        }

        divBtn.setOnClickListener{
            val num1 = numberEdt1.text.toString().toInt()
            val num2 = numberEdt2.text.toString().toInt()
            resultTxt.text = (num1/num2).toString()
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}