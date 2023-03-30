package com.oasis.unitconverter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.test.espresso.remote.Converter;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et_fromUnit,et_toUnit;
    Button cv_convert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_fromUnit = findViewById(R.id.editText_from);
        et_toUnit = findViewById(R.id.editText_to);
        String[] values  ={"Inch","Centimeter","Meter","Kilometer","Celcius","Farenheit","Kelvin","Kilogram","Gram","Milligram"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,values);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner fromSpinner = (Spinner) findViewById(R.id.spinner_from);
        Spinner toSpinner = (Spinner) findViewById(R.id.spinner_to);
        fromSpinner.setAdapter(adapter);
        toSpinner.setAdapter(adapter);
        cv_convert = findViewById(R.id.button_convert);
        cv_convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fromString = (String) fromSpinner.getSelectedItem();
                String toString = (String) toSpinner.getSelectedItem();
                String tempInput = et_fromUnit.getText().toString();
                if(tempInput.equals("") || tempInput == null){
                    et_fromUnit.setError("Please enter some value");
                }else{
                    if (fromString.equals(values[0])) {
                        if (toString.equals(values[0])) {
                            et_toUnit.setText(tempInput);
                        } else if (toString.equals(values[1])) {
                            et_toUnit.setText(inchToCm(Double.parseDouble(tempInput)));
                        } else if (toString.equals(values[2])) {
                            et_toUnit.setText(inchToMeter(Double.parseDouble(tempInput)));
                        } else if (toString.equals(values[3])) {
                            et_toUnit.setText(inchToKilometer(Double.parseDouble(tempInput)));
                        }else{
                            Toast.makeText(getApplicationContext(),"Please! Select a valid unit.",Toast.LENGTH_SHORT).show();
                        }
                    }else if(fromString.equals(values[1])){
                        if(toString.equals(values[1])){
                            et_toUnit.setText(tempInput);
                        }else if (toString.equals(values[0])) {
                            et_toUnit.setText(cmToInch(Double.parseDouble(tempInput)));
                        } else if (toString.equals(values[2])) {
                            et_toUnit.setText(cmToMeter(Double.parseDouble(tempInput)));
                        } else if (toString.equals(values[3])) {
                            et_toUnit.setText(cmToKilometer(Double.parseDouble(tempInput)));
                        }else{
                            Toast.makeText(getApplicationContext(),"Please! Select a valid unit.",Toast.LENGTH_SHORT).show();
                        }
                    }else if(fromString.equals(values[2])){
                        if(toString.equals(values[2])){
                            et_toUnit.setText(tempInput);
                        }else if (toString.equals(values[0])) {
                            et_toUnit.setText(meterToInch(Double.parseDouble(tempInput)));
                        } else if (toString.equals(values[1])) {
                            et_toUnit.setText(meterToCm(Double.parseDouble(tempInput)));
                        } else if (toString.equals(values[3])) {
                            et_toUnit.setText(meterToKilometer(Double.parseDouble(tempInput)));
                        }else{
                            Toast.makeText(getApplicationContext(),"Please! Select a valid unit.",Toast.LENGTH_SHORT).show();
                        }
                    }else if(fromString.equals(values[3])){
                        if(toString.equals(values[3])){
                            et_toUnit.setText(tempInput);
                        }else if (toString.equals(values[0])) {
                            et_toUnit.setText(kilometerToInch(Double.parseDouble(tempInput)));
                        } else if (toString.equals(values[1])) {
                            et_toUnit.setText(kilometerToCm(Double.parseDouble(tempInput)));
                        } else if (toString.equals(values[2])) {
                            et_toUnit.setText(kilometerToMeter(Double.parseDouble(tempInput)));
                        }else{
                            Toast.makeText(getApplicationContext(),"Please! Select a valid unit.",Toast.LENGTH_SHORT).show();
                        }
                    }else if(fromString.equals(values[4])){
                        if(toString.equals(values[4])){
                            et_toUnit.setText(tempInput);
                        }else if (toString.equals(values[5])) {
                            et_toUnit.setText(celciusToFarenheit(Double.parseDouble(tempInput)));
                        } else if (toString.equals(values[6])) {
                            et_toUnit.setText(celciusToKelvin(Double.parseDouble(tempInput)));
                        }else{
                            Toast.makeText(getApplicationContext(),"Please! Select a valid unit.",Toast.LENGTH_SHORT).show();
                        }
                    }else if(fromString.equals(values[5])){
                        if(toString.equals(values[5])){
                            et_toUnit.setText(tempInput);
                        }else if (toString.equals(values[4])) {
                            et_toUnit.setText(fahrenheitToCelcius(Double.parseDouble(tempInput)));
                        } else if (toString.equals(values[6])) {
                            et_toUnit.setText(fahrenheitToKelvin(Double.parseDouble(tempInput)));
                        }else{
                            Toast.makeText(getApplicationContext(),"Please! Select a valid unit.",Toast.LENGTH_SHORT).show();
                        }
                    }else if(fromString.equals(values[6])){
                        if(toString.equals(values[6])){
                            et_toUnit.setText(tempInput);
                        }else if (toString.equals(values[4])) {
                            et_toUnit.setText(kelvinToCelcius(Double.parseDouble(tempInput)));
                        } else if (toString.equals(values[5])) {
                            et_toUnit.setText(kelvinToFahrenheit(Double.parseDouble(tempInput)));
                        }else{
                            Toast.makeText(getApplicationContext(),"Please! Select a valid unit.",Toast.LENGTH_SHORT).show();
                        }
                    }else if(fromString.equals(values[7])){
                        if(toString.equals(values[7])){
                            et_toUnit.setText(tempInput);
                        }else if (toString.equals(values[8])) {
                            et_toUnit.setText(kgToGram(Double.parseDouble(tempInput)));
                        } else if (toString.equals(values[9])) {
                            et_toUnit.setText(kgToMilligram(Double.parseDouble(tempInput)));
                        }else{
                            Toast.makeText(getApplicationContext(),"Please! Select a valid unit.",Toast.LENGTH_SHORT).show();
                        }
                    }else if(fromString.equals(values[8])){
                        if(toString.equals(values[8])){
                            et_toUnit.setText(tempInput);
                        }else if (toString.equals(values[7])) {
                            et_toUnit.setText(gramToKg(Double.parseDouble(tempInput)));
                        } else if (toString.equals(values[9])) {
                            et_toUnit.setText(gramToMg(Double.parseDouble(tempInput)));
                        }else{
                            Toast.makeText(getApplicationContext(),"Please! Select a valid unit.",Toast.LENGTH_SHORT).show();
                        }
                    }else if(fromString.equals(values[9])){
                        if(toString.equals(values[9])){
                            et_toUnit.setText(tempInput);
                        }else if (toString.equals(values[7])) {
                            et_toUnit.setText(mgToKg(Double.parseDouble(tempInput)));
                        } else if (toString.equals(values[8])) {
                            et_toUnit.setText(mgToGram(Double.parseDouble(tempInput)));
                        }else{
                            Toast.makeText(getApplicationContext(),"Please! Select a valid unit.",Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });

    }
    public void convert(View view){

    }
    private String inchToCm(double inch){
        double cm = 2.54 * inch;
        return String.valueOf(cm);
    }
    private String inchToMeter(double inch){
        double m = 0.254 * inch;
        return String.valueOf(m);
    }
    private String inchToKilometer(double inch){
        double km = inch * 2.54 * .00001;
        return String.valueOf(km);
    }
    private String kilometerToInch(double km){
        double inch = km * 39370.1;
        return String.valueOf(inch);
    }
    private String kilometerToCm(double km){
        double cm = km * 100000;
        return String.valueOf(cm);
    }
    private String kilometerToMeter(double km){
        double m = km * 1000;
        return String.valueOf(m);
    }
    private String cmToInch(double cm){
        double inch = cm * 0.3937;
        return String.valueOf(inch);
    }
    private String cmToMeter(double cm){
        double m = cm * 0.01;
        return String.valueOf(m);
    }
    private String cmToKilometer(double cm){
        double km = cm * 0.00001;
        return String.valueOf(km);
    }
    private String meterToInch(double m){
        double inch = m * 39.3701;
        return String.valueOf(inch);
    }
    private String meterToCm(double m){
        double cm = m * 100;
        return String.valueOf(cm);
    }
    private String meterToKilometer(double m){
        double km = m * 0.001;
        return String.valueOf(km);
    }
    private String celciusToKelvin(double celsius) {
        double kelvin = celsius + 273.15;
        return String.valueOf(kelvin);
    }
    private String celciusToFarenheit(double celsius) {
        double fahrenheit = (celsius * 9 / 5) + 32;
        return String.valueOf(fahrenheit);
    }
    private String fahrenheitToKelvin(double fahrenheit) {
        double kelvin = 273.5 + ((fahrenheit - 32.0) * (5.0 / 9.0));
        return String.valueOf(kelvin);
    }
    private String fahrenheitToCelcius(double fahrenheit) {
        double celcius = (fahrenheit - 32) * 5 / 9;
        return String.valueOf(celcius);
    }
    private String kelvinToCelcius(double kelvin) {
        double celcius = kelvin - 273.15;
        return String.valueOf(celcius);
    }
    private String kelvinToFahrenheit(double kelvin) {
        double fahrenheit = (kelvin - 273.15) * 1.8 + 32;
        return String.valueOf(fahrenheit);
    }
    private String kgToGram(double kg) {
        double gram = kg * 1000;
        return String.valueOf(gram);
    }
    private String kgToMilligram(double kg) {
        double mg = kg * 100000;
        return String.valueOf(mg);
    }
    private String gramToKg(double g) {
        double kg = g * 0.001;
        return String.valueOf(kg);
    }
    private String gramToMg(double g) {
        double mg = g * 100;
        return String.valueOf(mg);
    }
    private String mgToKg(double mg) {
        double kg = mg * 0.00001;
        return String.valueOf(kg);
    }
    private String mgToGram(double mg) {
        double g = mg * 0.01;
        return String.valueOf(g);
    }



}