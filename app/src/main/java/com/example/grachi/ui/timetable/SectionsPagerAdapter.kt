package com.example.grachi.ui.timetable
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.PagerAdapter
import com.example.grachi.R

private val TAB_TITLES = arrayOf(
    R.string.Понедельник,
    R.string.Вторник,
    R.string.Среда,
    R.string.Четверг,
    R.string.Пятница,
    R.string.Суббота
)
private val DAYS = arrayListOf<String>("ПОНЕДЕЛЬНИК", "ВТОРНИК","СРЕДА","ЧЕТВЕРГ","ПЯТНИЦА","СУББОТА")
/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */

class SectionsPagerAdapter(private val context: Context, ranks: ArrayList<ArrayList<String>>
) : PagerAdapter() {

    private val mContext: Context
    private val mRanks: ArrayList<ArrayList<String>>

    override fun getCount(): Int {
        return TAB_TITLES.size
    }
    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val timetablelist: ListView
        val days: TextView
        val inflater = mContext
            .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val itemView: View = inflater.inflate(
            R.layout.fragment_timetable_navigation, container,
            false
        )
        timetablelist = itemView.findViewById(R.id.section_label)
        days = itemView.findViewById(R.id.day)
        days.text = DAYS[position]
        val adapt = this.context?.let { ArrayAdapter<String>(it,
            R.layout.texttime,mRanks[position]) }
        timetablelist.adapter = adapt
        container.addView(itemView)
        return itemView
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as ConstraintLayout)
    }

    init {
        mContext = context
        mRanks = ranks
    }
}