package softcampus.co.kr.textview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var text2:TextView? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        text2 = findViewById<TextView>(R.id.textView2)
        text2?.text = "문자열2"
        // text2?.setText("문자열2")

        textView3.text = "문자열3"
    }
}
