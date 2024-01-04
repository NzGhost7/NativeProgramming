package com.example.mindsharpener

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var radioGroup: RadioGroup
    private lateinit var editText: EditText
    private lateinit var submitButton: Button
    private lateinit var scoreTextView: TextView

    private var score: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        radioGroup = findViewById(R.id.radio_group_id)
        editText = findViewById(R.id.edittext)
        submitButton = findViewById(R.id.button)
        scoreTextView = findViewById(R.id.Textview8)

        submitButton.setOnClickListener {
            validateAnswer()
            displayQuestion()
        }

        displayQuestion()
    }

    private fun displayQuestion() {
        val level = getSelectedLevel()
        val firstNumber = generateRandomNumber(level)
        val secondNumber = generateRandomNumber(level)
        val operator = generateRandomOperator()

        updateUI(firstNumber, secondNumber, operator)
    }

    private fun validateAnswer() {
        val userAnswer = getUserAnswer()
        val firstNumber = getOperandFromUI(R.id.Textview4)
        val secondNumber = getOperandFromUI(R.id.Textview6)
        val operator = getOperatorFromUI(R.id.Textview5)

        val correctAnswer = calculateAnswer(firstNumber, secondNumber, operator)

        if (userAnswer == correctAnswer) {
            score++
        } else {
            score--
        }
        editText.text.clear()
        updateScoreUI()
    }

    private fun getUserAnswer(): Int {
        return editText.text.toString().toIntOrNull() ?: 0
    }

    private fun generateRandomNumber(level: Int): Int {
        return when (level) {
            3 -> Random.nextInt(10)
            5 -> Random.nextInt(100)
            7 -> Random.nextInt(1000)
            else -> 0
        }
    }

    private fun generateRandomOperator(): Int {
        return Random.nextInt(4)
    }

    private fun calculateAnswer(firstNumber: Int, secondNumber: Int, operator: Int): Int {
        return when (operator) {
            0 -> firstNumber + secondNumber
            1 -> firstNumber - secondNumber
            2 -> firstNumber * secondNumber
            3 -> if (secondNumber != 0) firstNumber / secondNumber else 0
            else -> 0
        }
    }

    private fun updateUI(firstNumber: Int, secondNumber: Int, operator: Int) {
        setOperandToUI(R.id.Textview4, firstNumber)
        setOperandToUI(R.id.Textview6, secondNumber)
        setOperatorToUI(R.id.Textview5, operator)
    }

    private fun setOperandToUI(viewId: Int, operand: Int) {
        findViewById<TextView>(viewId).text = operand.toString()
    }

    private fun getOperandFromUI(viewId: Int): Int {
        return findViewById<TextView>(viewId).text.toString().toInt()
    }

    private fun setOperatorToUI(viewId: Int, operator: Int) {
        val operatorSymbol = when (operator) {
            0 -> "+"
            1 -> "-"
            2 -> "*"
            3 -> "/"
            else -> ""
        }
        findViewById<TextView>(viewId).text = operatorSymbol
    }

    private fun getOperatorFromUI(viewId: Int): Int {
        val operatorSymbol = findViewById<TextView>(viewId).text.toString()
        return when (operatorSymbol) {
            "+" -> 0
            "-" -> 1
            "*" -> 2
            "/" -> 3
            else -> 0
        }
    }

    private fun getSelectedLevel(): Int {
        return when (radioGroup.checkedRadioButtonId) {
            R.id.radio_button_1 -> 3
            R.id.radio_button_2 -> 5
            R.id.radio_button_3 -> 7
            else -> 3
        }
    }

    private fun updateScoreUI() {
        scoreTextView.text = score.toString()
    }
}
