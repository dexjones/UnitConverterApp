package com.example.unitconverterapp

import org.junit.Assert.assertEquals
import org.junit.Test

class ConverterTest {

    @Test
    fun testTemperatureConversion() {
        // Celsius to Fahrenheit
        val celsiusToFahrenheit = Converter.convertTemperature(0.0, "Celsius", "Fahrenheit")
        assertEquals(32.0, celsiusToFahrenheit, 0.01)

        // Fahrenheit to Celsius
        val fahrenheitToCelsius = Converter.convertTemperature(32.0, "Fahrenheit", "Celsius")
        assertEquals(0.0, fahrenheitToCelsius, 0.01)

        // Celsius to Kelvin
        val celsiusToKelvin = Converter.convertTemperature(0.0, "Celsius", "Kelvin")
        assertEquals(273.15, celsiusToKelvin, 0.01)

        // Kelvin to Celsius
        val kelvinToCelsius = Converter.convertTemperature(273.15, "Kelvin", "Celsius")
        assertEquals(0.0, kelvinToCelsius, 0.01)

        // Fahrenheit to Kelvin
        val fahrenheitToKelvin = Converter.convertTemperature(32.0, "Fahrenheit", "Kelvin")
        assertEquals(273.15, fahrenheitToKelvin, 0.01)

        // Kelvin to Fahrenheit
        val kelvinToFahrenheit = Converter.convertTemperature(273.15, "Kelvin", "Fahrenheit")
        assertEquals(32.0, kelvinToFahrenheit, 0.01)
    }

    @Test
    fun testLengthConversion() {
        // Meters to Kilometers
        val metersToKilometers = Converter.convertLength(1000.0, "Meter", "Kilometer")
        assertEquals(1.0, metersToKilometers, 0.01)

        // Kilometers to Meters
        val kilometersToMeters = Converter.convertLength(1.0, "Kilometer", "Meter")
        assertEquals(1000.0, kilometersToMeters, 0.01)

        // Foot to Meter
        val footToMeter = Converter.convertLength(3.28084, "Foot", "Meter")
        assertEquals(1.0, footToMeter, 0.01)

        // Mile to Kilometer
        val mileToKilometer = Converter.convertLength(1.0, "Mile", "Kilometer")
        assertEquals(1.60934, mileToKilometer, 0.01)
    }

    @Test
    fun testWeightConversion() {
        // Kilograms to Pounds
        val kilogramsToPounds = Converter.convertWeight(1.0, "Kilogram", "Pound")
        assertEquals(2.20462, kilogramsToPounds, 0.01)

        // Pounds to Kilograms
        val poundsToKilograms = Converter.convertWeight(2.20462, "Pound", "Kilogram")
        assertEquals(1.0, poundsToKilograms, 0.01)

        // Grams to Milligrams
        val gramsToMilligrams = Converter.convertWeight(1.0, "Gram", "Milligram")
        assertEquals(1000.0, gramsToMilligrams, 0.01)

        // Metric Ton to Kilograms
        val metricTonToKilograms = Converter.convertWeight(1.0, "Metric Ton", "Kilogram")
        assertEquals(1000.0, metricTonToKilograms, 0.01)
    }

    @Test
    fun testSpeedConversion() {
        // Mile/Hour to Kilometer/Hour
        val mphToKph = Converter.convertSpeed(1.0, "Mile/Hour", "Kilometers/Hour")
        assertEquals(1.60934, mphToKph, 0.01)

        // Kilometer/Hour to Mile/Hour
        val kphToMph = Converter.convertSpeed(1.0, "Kilometers/Hour", "Mile/Hour")
        assertEquals(0.621371, kphToMph, 0.01)

        // Foot/Second to Meter/Second
        val fpsToMps = Converter.convertSpeed(1.0, "Foot/Second", "Meter/Second")
        assertEquals(0.3048, fpsToMps, 0.01)

        // Meter/Second to Kilometer/Hour
        val mpsToKph = Converter.convertSpeed(1.0, "Meter/Second", "Kilometers/Hour")
        assertEquals(3.6, mpsToKph, 0.01)
    }
}
