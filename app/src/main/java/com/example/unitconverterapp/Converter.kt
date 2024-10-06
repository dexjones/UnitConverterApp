package com.example.unitconverterapp

object Converter {

    // Temperature conversions between Celsius, Fahrenheit, and Kelvin
    fun convertTemperature(value: Double, fromUnit: String, toUnit: String): Double {
        return when (fromUnit to toUnit) {
            "Celsius" to "Fahrenheit" -> value * 9 / 5 + 32
            "Fahrenheit" to "Celsius" -> (value - 32) * 5 / 9
            "Celsius" to "Kelvin" -> value + 273.15
            "Kelvin" to "Celsius" -> value - 273.15
            "Fahrenheit" to "Kelvin" -> (value - 32) * 5 / 9 + 273.15
            "Kelvin" to "Fahrenheit" -> (value - 273.15) * 9 / 5 + 32
            else -> value
        }
    }

    // Length conversions
    fun convertLength(value: Double, fromUnit: String, toUnit: String): Double {
        val conversionMap = mapOf(
            "Kilometer" to 1000.0, "Dekameter" to 10.0, "Hectometer" to 100.0, "Meter" to 1.0,
            "Decimeter" to 0.1, "Centimeter" to 0.01, "Millimeter" to 0.001,
            "Mile" to 1609.34, "Yard" to 0.9144, "Foot" to 0.3048, "Inch" to 0.0254
        )

        val fromFactor = conversionMap[fromUnit] ?: 1.0
        val toFactor = conversionMap[toUnit] ?: 1.0
        return value * fromFactor / toFactor
    }

    // Mass conversions
    fun convertWeight(value: Double, fromUnit: String, toUnit: String): Double {
        val conversionMap = mapOf(
            "Kilogram" to 1000.0, "Dekagram" to 10.0, "Hectogram" to 100.0, "Gram" to 1.0,
            "Decigram" to 0.1, "Centigram" to 0.01, "Milligram" to 0.001,
            "Metric Ton" to 1000000.0, "Imperial Ton" to 1016000.0, "Pound" to 453.592, "Ounce" to 28.3495
        )

        val fromFactor = conversionMap[fromUnit] ?: 1.0
        val toFactor = conversionMap[toUnit] ?: 1.0
        return value * fromFactor / toFactor
    }

    // Speed conversions
    fun convertSpeed(value: Double, fromUnit: String, toUnit: String): Double {
        val conversionMap = mapOf(
            "Mile/Hour" to 0.44704, // 1 mph = 0.44704 m/s
            "Kilometers/Hour" to 0.277778, // 1 km/h = 0.277778 m/s
            "Foot/Second" to 0.3048, // 1 ft/s = 0.3048 m/s
            "Meter/Second" to 1.0 // Base unit is m/s
        )

        val fromFactor = conversionMap[fromUnit] ?: 1.0
        val toFactor = conversionMap[toUnit] ?: 1.0
        return value * fromFactor / toFactor
    }
}
