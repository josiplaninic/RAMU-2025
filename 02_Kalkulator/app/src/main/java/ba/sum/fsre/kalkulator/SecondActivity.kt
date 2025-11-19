package ba.sum.fsre.kalkulator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.sqrt

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)

        val sqrtBtn=findViewById<Button>(R.id.button_sqrt)
        val powBtn=findViewById<Button>(R.id.button_pow)
        val resTxt2=findViewById<TextView>(R.id.text_result2)

        val passedValueTxt1 = findViewById<TextView>(R.id.text_value)
        val valueString = intent.getStringExtra("RESULT_VALUE")
        val passedNumber = valueString?.toDoubleOrNull()

        passedValueTxt1.text= passedNumber.toString()

        sqrtBtn.setOnClickListener{
            if (passedNumber == null)
                resTxt2.text = "Nema važećeg rezultata"
            else
                resTxt2.text = sqrt(passedNumber).toString()
        }
        powBtn.setOnClickListener{
            if (passedNumber == null)
                resTxt2.text = "Nema važećeg rezultata"
            else
                resTxt2.text = (passedNumber * passedNumber).toString()
        }







        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}