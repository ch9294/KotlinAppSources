package kr.co.softcampus.viewpagerex

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var view_list = ArrayList<View>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        view_list.add(layoutInflater.inflate(R.layout.view1, null))
        view_list.add(layoutInflater.inflate(R.layout.view2, null))
        view_list.add(layoutInflater.inflate(R.layout.view3, null))

        pager.adapter = CustomAdapter()

        pager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                textView.text = "${position} 번재 뷰가 나타났습니다"
            }

            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageSelected(position: Int) {

            }
        })
    }

    inner class CustomAdapter : PagerAdapter(){
        override fun getCount(): Int {
            return view_list.size
        }

        override fun isViewFromObject(view: View?, obj: Any?): Boolean {
            return view == obj
        }

        override fun instantiateItem(container: ViewGroup?, position: Int): Any {

            pager.addView(view_list[position])
            return view_list[position]
        }

        override fun destroyItem(container: ViewGroup?, position: Int, obj: Any?) {
            pager.removeView(obj as View)
        }
    }
}









