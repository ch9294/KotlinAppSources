package kr.co.softcampus.listviewcustom1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var data = arrayOf("데이터1", "데이터2", "데이터3", "데이터4", "데이터5", "데이터6")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // var adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, data)
        var adapter = ArrayAdapter(this, R.layout.row1, R.id.textView2, data)

        listView.adapter = adapter

        listView.setOnItemClickListener { adapterView, view, i, l ->
            textView.text = data[i]
        }
    }
}
