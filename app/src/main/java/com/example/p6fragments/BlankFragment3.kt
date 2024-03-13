package com.example.p6fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class BlankFragment3 : Fragment() {

    interface OnDataFromActivityListener {
        fun onDataReceived(name: String, age: Int)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank3, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            val name = it.getString("name", "")
            val age = it.getInt("age", 0)

            view.findViewById<TextView>(R.id.display_name1).text = "Name: $name"
            view.findViewById<TextView>(R.id.display_age1).text = "Age: $age"
        }
    }

    companion object {
        fun newInstance(name: String, age: Int) =
            BlankFragment3().apply {
                arguments = Bundle().apply {
                    putString("name", name)
                    putInt("age", age)
                }
            }
    }
}
