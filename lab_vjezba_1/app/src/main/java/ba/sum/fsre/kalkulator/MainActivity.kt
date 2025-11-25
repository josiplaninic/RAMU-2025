package ba.sum.fsre.kalkulator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import kotlin.math.abs

class MainActivity : AppCompatActivity() {

    private lateinit var display: TextView

    private var currentInput = "0"
    private var storedOperand: Double? = null
    private var currentOperator: String? = null
    private var justCalculated = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        display = findViewById(R.id.text_display)
        display.text = "0"

        val numberButtons = listOf(
            R.id.btn_0, R.id.btn_1, R.id.btn_2, R.id.btn_3, R.id.btn_4,
            R.id.btn_5, R.id.btn_6, R.id.btn_7, R.id.btn_8, R.id.btn_9
        )

        numberButtons.forEach { id ->
            findViewById<Button>(id).setOnClickListener {
                handleNumberPress((it as Button).text.toString())
            }
        }

        val operators = mapOf(
            R.id.btn_add to "+",
            R.id.btn_sub to "-",
            R.id.btn_mul to "×",
            R.id.btn_div to "÷"
        )

        operators.forEach { (id, op) ->
            findViewById<Button>(id).setOnClickListener {
                handleOperatorPress(op)
            }
        }

        findViewById<Button>(R.id.btn_ac).setOnClickListener { handleAC() }
        findViewById<Button>(R.id.btn_del).setOnClickListener { handleDel() }
        findViewById<Button>(R.id.btn_eq).setOnClickListener { calculateResult() }
    }

    private fun handleNumberPress(num: String) {
        if (justCalculated) {
            currentInput = "0"
            justCalculated = false
        }

        currentInput = if (currentInput == "0") num else currentInput + num
        display.text = currentInput
    }

    private fun handleOperatorPress(op: String) {
        if (currentInput == "Error") {
            handleAC()
            return
        }

        storedOperand = currentInput.toDouble()
        currentOperator = op
        currentInput = "0"
        display.text = "0"
    }

    private fun handleAC() {
        currentInput = "0"
        storedOperand = null
        currentOperator = null
        justCalculated = false
        display.text = "0"
    }

    private fun handleDel() {
        if (justCalculated) {
            handleAC()
            return
        }

        currentInput = if (currentInput.length > 1)
            currentInput.dropLast(1)
        else
            "0"

        display.text = currentInput
    }

    private fun calculateResult() {
        val op = currentOperator ?: return
        val first = storedOperand ?: return
        val second = currentInput.toDoubleOrNull() ?: return

        val result = when (op) {
            "+" -> first + second
            "-" -> first - second
            "×" -> first * second
            "÷" -> if (second == 0.0) {
                display.text = "Error"
                justCalculated = true
                return
            } else first / second
            else -> return
        }

        display.text = result.toString()
        currentInput = result.toString()
        storedOperand = null
        currentOperator = null
        justCalculated = true
    }
}
