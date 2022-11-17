package com.example.grachi.ui.mark

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.example.grachi.R
import com.example.grachi.databinding.FragmentMarkBinding


class MarkFragment : Fragment() {

    private var _binding: FragmentMarkBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var subjlist = this.requireArguments().getStringArrayList("teachersthings")
        var marklist = this.requireArguments().getStringArrayList("marks")
        _binding = FragmentMarkBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val subjects: ListView = binding.subject
        val marks: ListView = binding.mark
        val subjadapter = this.context?.let { ArrayAdapter<String>(it,
            R.layout.textteach,subjlist!!) }

        subjects.adapter = subjadapter
        val teachadapter = this.context?.let { ArrayAdapter<String>(it,
            R.layout.textmark,marklist!!) }
        marks.adapter = teachadapter
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}