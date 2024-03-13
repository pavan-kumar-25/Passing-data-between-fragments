package com.example.p6fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText

class BlankFragment1 : Fragment() {

    interface OnDataSubmittedListener {
        fun onDataSubmitted(name: String, age: Int)
    }

    private var dataSubmittedListener: OnDataSubmittedListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnDataSubmittedListener) {
            dataSubmittedListener = context
        } else {
            throw RuntimeException("$context must implement OnDataSubmittedListener")
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_blank1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nameInput = view.findViewById<EditText>(R.id.name_input)
        val ageInput = view.findViewById<EditText>(R.id.age_input)
        val btnSubmit = view.findViewById<Button>(R.id.btnsubmit)

        btnSubmit.setOnClickListener {
            val name = nameInput.text.toString()
            val age = ageInput.text.toString().toIntOrNull() ?: 0
            dataSubmittedListener?.onDataSubmitted(name, age)
        }
    }
}
