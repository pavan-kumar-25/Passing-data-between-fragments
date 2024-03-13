package com.example.p6fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class BlankFragment2 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Retrieve data passed from arguments
        val name = arguments?.getString("name")
        val age = arguments?.getInt("age")

        // Update UI with the retrieved data
        view.findViewById<TextView>(R.id.display_name).text = "Name: ${name ?: "N/A"}"
        view.findViewById<TextView>(R.id.display_age).text = "Age: ${age ?: "N/A"}"
    }

    companion object {
        @JvmStatic
        fun newInstance(name: String, age: Int): BlankFragment2 {
            val fragment = BlankFragment2()
            val args = Bundle()
            args.putString("name", name)
            args.putInt("age", age)
            fragment.arguments = args
            return fragment
        }
    }
}
