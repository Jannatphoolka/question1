    package com.example.q1

    import android.content.Intent
    import android.os.Bundle
    import android.widget.*
    import androidx.appcompat.app.AppCompatActivity

    class MainActivity : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            val textViewQ1: TextView = findViewById(R.id.textViewQ1)
            val data = intent.getStringExtra("dataKey")
            textViewQ1.text = data

            val editTextNumber1 = findViewById<EditText>(R.id.editTextNumber1)
            val editTextNumber2 = findViewById<EditText>(R.id.editTextNumber2)
            val spinnerOperations = findViewById<Spinner>(R.id.spinnerOperations)
            val buttonCalculate = findViewById<Button>(R.id.buttonCalculate)
            val textViewResult = findViewById<TextView>(R.id.textViewResult)
            val buttonq3: Button = findViewById(R.id.buttonq3)

            buttonCalculate.setOnClickListener {
                val number1 = editTextNumber1.text.toString().toDoubleOrNull()
                val number2 = editTextNumber2.text.toString().toDoubleOrNull()
                val operation = spinnerOperations.selectedItem.toString()

                if (number1 == null || number2 == null) {
                    Toast.makeText(this, "Please enter valid numbers", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                val result = when (operation) {
                    "Addition" -> number1 + number2
                    "Subtraction" -> number1 - number2
                    "Multiplication" -> number1 * number2
                    "Division" -> {
                        if (number2 != 0.0) {
                            number1 / number2
                        }
                        else {
                            Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show()
                            return@setOnClickListener
                        }
                    }
                    else -> 0.0
                }

                textViewResult.text = result.toString()
            }
            buttonq3.setOnClickListener {
                val intentQ3 = Intent().setClassName("com.example.q3", "com.example.q3.MainActivity")
                intentQ3.putExtra("dataKey", "Hello Q3")
                startActivity(intentQ3)
            }
        }
    }
