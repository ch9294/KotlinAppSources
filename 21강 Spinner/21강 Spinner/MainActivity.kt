package kr.co.softcampus.spinner

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var data1 = arrayOf("스피너1-1", "스피너1-2", "스피너1-3", "스피너1-4", "스피너1-5")
    var data2 = arrayOf("스피너2-1", "스피너2-2", "스피너2-3", "스피너2-4", "스피너2-5")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var adapter1 = ArrayAdapter(this, android.R.layout.simple_spinner_item, data1)
        var adapter2 = ArrayAdapter(this, android.R.layout.simple_spinner_item, data2)

        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinner.adapter = adapter1
        spinner2.adapter = adapter2

        var listener = SpinnerListener();
        spinner.onItemSelectedListener = listener

        spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                textView.text = data2[p2]
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }

        button.setOnClickListener { view ->
            textView.text = data1[spinner.selectedItemPosition] + "\n"
            textView.append(data2[spinner2.selectedItemPosition])
        }
    }

    inner class SpinnerListener : AdapterView.OnItemSelectedListener{
        override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
            textView.text = data1[p2]
        }

        override fun onNothingSelected(p0: AdapterView<*>?) {

        }
    }
}
