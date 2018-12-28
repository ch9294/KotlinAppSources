package kr.co.softcampus.customadapter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var data = arrayOf("데이터1", "데이터2", "데이터3", "데이터4", "데이터5", "데이터6")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // var adapter = ArrayAdapter<String>(this, R.layout.row, R.id.textView2, data)
        var adapter = ListAdapter()
        listView.adapter = adapter
    }

    inner class ListAdapter : BaseAdapter(){

        var listener = BtnListener()

        override fun getCount(): Int {
            return data.size
        }

        override fun getItem(p0: Int): Any? {
            return null
        }

        override fun getItemId(p0: Int): Long {
            return 0
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View? {
            var convertView:View? = p1

            if(p1 == null){
                convertView = layoutInflater.inflate(R.layout.row, null)
            }

            var text:TextView? = convertView?.findViewById<TextView>(R.id.textView2)
            var button1:Button? = convertView?.findViewById<Button>(R.id.button1)
            var button2:Button? = convertView?.findViewById<Button>(R.id.button2)

            button1?.setOnClickListener(listener)
            button2?.setOnClickListener(listener)

            button1?.tag = p0
            button2?.tag = p0

            text?.text = data[p0]

            return convertView
        }
    }

    inner class BtnListener :View.OnClickListener{
        override fun onClick(p0: View?) {

            var position = p0?.tag as Int

            when(p0?.id){
                R.id.button1 ->
                        textView.text = "${position} : 첫 번째 버튼을 눌렀습니다"
                R.id.button2 ->
                        textView.text = "${position} : 두 번째 버튼을 눌렀습니다"
            }
        }
    }
}










