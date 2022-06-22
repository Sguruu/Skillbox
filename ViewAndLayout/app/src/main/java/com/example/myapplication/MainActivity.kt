package com.example.myapplication

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity() {

    companion object {
        private const val TOAST_TEXT = "Логин прошел успешно"
    }

    private lateinit var constraintLayout: ConstraintLayout
    private lateinit var imageView: ImageView
    private lateinit var textView: TextView
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var checkbox: CheckBox
    private lateinit var button: Button
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        initListener()
    }

    private fun initView() {
        constraintLayout = findViewById(R.id.constraintLayout)
        imageView = findViewById(R.id.imageView)
        textView = findViewById(R.id.textView)
        emailEditText = findViewById(R.id.emailEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        checkbox = findViewById(R.id.checkbox)
        button = findViewById(R.id.button)
        createProgressBar()
        isEnableButton()
    }

    private fun initListener() {
        button.setOnClickListener {
            val handler = Handler(Looper.getMainLooper())

            checkbox.isEnabled = false
            button.isEnabled = false

            constraintLayout.addView(progressBar)
            handler.postDelayed({
                constraintLayout.removeView(progressBar)
                checkbox.isEnabled = true
                button.isEnabled = true
                Toast.makeText(this, TOAST_TEXT, Toast.LENGTH_LONG)
                    .show()
            }, 2000)
        }

        emailEditText.addTextChangedListener { isEnableButton() }
        passwordEditText.addTextChangedListener { isEnableButton() }
        checkbox.setOnCheckedChangeListener { _, _ -> isEnableButton() }
    }

    /***
     * Программное создание progressBar
     */
    private fun createProgressBar() {
        val params: ConstraintLayout.LayoutParams = ConstraintLayout.LayoutParams(
            ConstraintLayout.LayoutParams.WRAP_CONTENT,
            ConstraintLayout.LayoutParams.WRAP_CONTENT
        )

        params.startToStart = constraintLayout.id
        params.bottomToBottom = constraintLayout.id
        params.topToTop = constraintLayout.id
        params.endToEnd = constraintLayout.id

        progressBar = ProgressBar(this).apply {
            layoutParams = ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.WRAP_CONTENT,
                ConstraintLayout.LayoutParams.WRAP_CONTENT
            )
        }

        progressBar.layoutParams = params

        emailEditText.text.toString()
    }

    /***
     * Проверка на условия, для активации - деактивации кнопки
     */
    private fun isEnableButton() {
        button.isEnabled =
            emailEditText.text.toString() != "" &&
            passwordEditText.text.toString() != "" &&
            checkbox.isChecked
    }
}
