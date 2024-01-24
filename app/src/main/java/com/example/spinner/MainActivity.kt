package com.example.spinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    lateinit var spinner: Spinner
    lateinit var result: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //the spinner option items is defined in the Strings.xml file of the resources folder(.res)
    spinner = findViewById(R.id.spinnerCountry)
        result = findViewById(R.id.result)

        spinner.onItemSelectedListener = this

        //We will use an 'adapter' (Adapters are used for Listviews,Spinners and GridViews)
        //adapters serve as a link between an arraylist of items and the display view

        //we start by defining the adapter in question
        var arrayAdapter  = ArrayAdapter.createFromResource(
            this@MainActivity,
            R.array.countries,
            android.R.layout.simple_spinner_item //this is provided by default by androi d studio
        )

        //then we define the dropdown view(since we are using a spinner in this case) of the adapter
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line) //this also is by default in android studio

        //then we connect the previously defined adapter to our spinner item list
        spinner.adapter = arrayAdapter


    }

    //these two functions are created when implementing the interface of the adapter onClickListener in the
    //activity declaration line

    //when the user selects an option from the spinner(there are four parameters to this class)
    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

        if(parent != null){
            result.text = parent!!.getItemAtPosition(position).toString() //the !! guarantees the line doesn't return a null result
        }
    }


    //this gets executed when no items are selected, but wont apppy to this example since we
    //obviously select something
    override fun onNothingSelected(p0: AdapterView<*>?) {

    }
}