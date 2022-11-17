package com.example.grachi.ui.Table

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.grachi.databinding.FragmentTimetableBinding
import com.example.grachi.ui.timetable.SectionsPagerAdapter
import com.google.android.material.tabs.TabLayout


import androidx.viewpager.widget.PagerAdapter


class TimetableFragment : Fragment(){
    private var monday: ArrayList<String>? = null
    private var tuesday: ArrayList<String>? = null
    private var wednesday: ArrayList<String>? = null
    private var thursday: ArrayList<String>? = null
    private var friday: ArrayList<String>? = null
    private var saturday: ArrayList<String>? = null
    private var _binding: FragmentTimetableBinding? = null


    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        monday = this.arguments?.getStringArrayList("monday")
        tuesday = this.arguments?.getStringArrayList("tuesday")
        wednesday = this.arguments?.getStringArrayList("wednesday")
        thursday = this.arguments?.getStringArrayList("thursday")
        friday = this.arguments?.getStringArrayList("friday")
        saturday = this.arguments?.getStringArrayList("saturday")
        _binding = FragmentTimetableBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val viewPager: ViewPager = binding.viewPager
        val tabs: TabLayout =binding.tabs
        val mondayday = ArrayList<String>()
        val tuesdayday = ArrayList<String>()
        val wednesdayday = ArrayList<String>()
        val thursdayday = ArrayList<String>()
        val fridayday = ArrayList<String>()
        val saturdayday = ArrayList<String>()
        for (i in 0..7)
        {
            if (!monday?.get(i).equals(" ")) mondayday.add("${i+1}. "+monday?.get(i))
            if (!tuesday?.get(i).equals(" ")) tuesdayday.add("${i+1}. "+tuesday?.get(i))
            if (!wednesday?.get(i).equals(" ")) wednesdayday.add("${i+1}. "+wednesday?.get(i))
            if (!thursday?.get(i).equals(" ")) thursdayday.add("${i+1}. "+thursday?.get(i))
            if (!friday?.get(i).equals(" ")) fridayday.add("${i+1}. "+friday?.get(i))
            if (!saturday?.get(i).equals(" ")) saturdayday.add("${i+1}. "+saturday?.get(i))
        }

        val days = arrayListOf<ArrayList<String>>()
        days.add(mondayday)
        days.add(tuesdayday)
        days.add(wednesdayday)
        days.add(thursdayday)
        days.add(fridayday)
        days.add(saturdayday)
        tabs.setupWithViewPager(viewPager)
        val adapter: PagerAdapter = SectionsPagerAdapter(this.requireActivity(), days)
        viewPager.adapter = adapter
        viewPager.currentItem = 0
        return root
    }


    override fun onDestroyView() {

        super.onDestroyView()
        _binding = null
    }

}

