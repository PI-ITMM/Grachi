package com.example.grachi.ui.teacher

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.example.grachi.R
import com.example.grachi.databinding.FragmentTeacherBinding

class TeacherFragment : Fragment() {

    private var _binding: FragmentTeacherBinding? = null
    private val binding get() = _binding!!

    @SuppressLint("ResourceType")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var subjlist = this.requireArguments().getStringArrayList("teachersthings")
        var teachlist = this.requireArguments().getStringArrayList("teachersname")
        _binding = FragmentTeacherBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val subjects: ListView = binding.subj
        val teachers: ListView = binding.teach
        val subjadapter = this.context?.let { ArrayAdapter<String>(it,
            R.layout.textteach,subjlist!!) }

        subjects.adapter = subjadapter
        val teachadapter = this.context?.let { ArrayAdapter<String>(it,
           R.layout.textmark,teachlist!!) }
        teachers.adapter = teachadapter
        return root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}