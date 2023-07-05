package com.example.calculator

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import net.objecthunter.exp4j.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // get the buttons
        val tvOne = findViewById<TextView>(R.id.tvOne)
        val tvTwo = findViewById<TextView>(R.id.tvTwo)
        val tvThree = findViewById<TextView>(R.id.tvThree)
        val tvFour = findViewById<TextView>(R.id.tvFour)
        val tvFive = findViewById<TextView>(R.id.tvFive)
        val tvSix = findViewById<TextView>(R.id.tvSix)
        val tvSeven = findViewById<TextView>(R.id.tvSeven)
        val tvEight = findViewById<TextView>(R.id.tvEight)
        val tvNine = findViewById<TextView>(R.id.tvNine)
        val tvZero = findViewById<TextView>(R.id.tvZero)
        val tvPlus = findViewById<TextView>(R.id.tvPlus)
        val tvMinus = findViewById<TextView>(R.id.tvMinus)
        val tvMul = findViewById<TextView>(R.id.tvMul)
        val tvDivide = findViewById<TextView>(R.id.tvDivide)
        val tvDot = findViewById<TextView>(R.id.tvDot)
        val tvClear = findViewById<TextView>(R.id.tvClear)
        val tvEquals = findViewById<TextView>(R.id.tvEquals)
        val tvBack = findViewById<TextView>(R.id.tvBack)
        val tvExpression = findViewById<TextView>(R.id.tvExpression)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        tvOne.setOnClickListener { tvExpression.text = tvExpression.text.toString() + "1" }

        tvTwo.setOnClickListener { tvExpression.text = tvExpression.text.toString() + "2" }

        tvThree.setOnClickListener { tvExpression.text = tvExpression.text.toString() + "3" }

        tvFour.setOnClickListener { tvExpression.text = tvExpression.text.toString() + "4" }

        tvFive.setOnClickListener { tvExpression.text = tvExpression.text.toString() + "5" }

        tvSix.setOnClickListener { tvExpression.text = tvExpression.text.toString() + "6" }

        tvSeven.setOnClickListener { tvExpression.text = tvExpression.text.toString() + "7" }

        tvEight.setOnClickListener { tvExpression.text = tvExpression.text.toString() + "8" }

        tvNine.setOnClickListener { tvExpression.text = tvExpression.text.toString() + "9" }

        tvZero.setOnClickListener { tvExpression.text = tvExpression.text.toString() + "0" }

        /*Operators*/

        tvPlus.setOnClickListener { tvExpression.text = tvExpression.text.toString() + "+" }

        tvMinus.setOnClickListener { tvExpression.text = tvExpression.text.toString() + "-" }

        tvMul.setOnClickListener { tvExpression.text = tvExpression.text.toString() + "*" }

        tvDivide.setOnClickListener { tvExpression.text = tvExpression.text.toString() + "/" }

        tvDot.setOnClickListener { tvExpression.text = tvExpression.text.toString() + "." }

        tvClear.setOnClickListener {
            tvExpression.text = ""
            tvResult.text = ""
        }

        tvEquals.setOnClickListener {
            val text = tvExpression.text.toString()
            val expression = ExpressionBuilder(text).build()

            val result = expression.evaluate()
            val longResult = result.toLong()
            if (result == longResult.toDouble()) {
                tvResult.text = longResult.toString()
            } else {
                tvResult.text = result.toString()
            }
        }

        tvBack.setOnClickListener {
            val text = tvExpression.text.toString()
            if (text.isNotEmpty()) {
                var temp = text.reversed()
                tvExpression.text = temp.drop(1).reversed()
            }

            tvResult.text = ""
        }
    }
}
