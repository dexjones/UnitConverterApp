package com.example.unitconverterapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val unitTypeSpinner: Spinner = findViewById(R.id.unitTypeSpinner)
        val fromUnitSpinner: Spinner = findViewById(R.id.fromUnitSpinner)
        val toUnitSpinner: Spinner = findViewById(R.id.toUnitSpinner)
        val inputEditText: EditText = findViewById(R.id.inputEditText)
        val resultTextView: TextView = findViewById(R.id.resultTextView)
        val convertButton: Button = findViewById(R.id.convertButton)

        val unitTypes = arrayOf("Length", "Mass", "Temperature", "Speed")
        unitTypeSpinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, unitTypes)

        unitTypeSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: android.view.View?, position: Int, id: Long) {
                val unitType = parent.getItemAtPosition(position).toString()
                updateUnitSpinners(unitType, fromUnitSpinner, toUnitSpinner)
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

        convertButton.setOnClickListener {
            val unitType = unitTypeSpinner.selectedItem.toString()
            val fromUnit = fromUnitSpinner.selectedItem.toString()
            val toUnit = toUnitSpinner.selectedItem.toString()
            val inputValue = inputEditText.text.toString().toDoubleOrNull()

            if (inputValue != null) {
                val result = when (unitType) {
                    "Temperature" -> Converter.convertTemperature(inputValue, fromUnit, toUnit)
                    "Length" -> Converter.convertLength(inputValue, fromUnit, toUnit)
                    "Mass" -> Converter.convertWeight(inputValue, fromUnit, toUnit)
                    "Speed" -> Converter.convertSpeed(inputValue, fromUnit, toUnit)
                    else -> 0.0
                }
                resultTextView.text = result.toString()
            } else {
                resultTextView.text = "Invalid input"
            }
        }
    }

    private fun updateUnitSpinners(unitType: String, fromSpinner: Spinner, toSpinner: Spinner) {
        val fromUnits: Array<String>
        val toUnits: Array<String>

        when (unitType) {
            "Temperature" -> {
                fromUnits = arrayOf("Celsius", "Fahrenheit", "Kelvin")
                toUnits = arrayOf("Celsius", "Fahrenheit", "Kelvin")
            }
            "Length" -> {
                fromUnits = arrayOf("Kilometer", "Dekameter", "Hectometer", "Meter", "Decimeter", "Centimeter", "Millimeter", "Mile", "Yard", "Foot", "Inch")
                toUnits = arrayOf("Kilometer", "Dekameter", "Hectometer", "Meter", "Decimeter", "Centimeter", "Millimeter", "Mile", "Yard", "Foot", "Inch")
            }
            "Mass" -> {
                fromUnits = arrayOf("Kilogram", "Dekagram", "Hectogram", "Gram", "Decigram", "Centigram", "Milligram", "Metric Ton", "Imperial Ton", "Pound", "Ounce")
                toUnits = arrayOf("Kilogram", "Dekagram", "Hectogram", "Gram", "Decigram", "Centigram", "Milligram", "Metric Ton", "Imperial Ton", "Pound", "Ounce")
            }
            "Speed" -> {
                fromUnits = arrayOf("Mile/Hour", "Kilometers/Hour", "Foot/Second", "Meter/Second")
                toUnits = arrayOf("Mile/Hour", "Kilometers/Hour", "Foot/Second", "Meter/Second")
            }
            else -> {
                fromUnits = arrayOf()
                toUnits = arrayOf()
            }
        }

        fromSpinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, fromUnits)
        toSpinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, toUnits)
    }
}
