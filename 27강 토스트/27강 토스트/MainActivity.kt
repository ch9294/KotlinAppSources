package kr.co.softcampus.toast

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener { view ->
            var t1 = Toast.makeText(this, "토스트 메시지 입니다", Toast.LENGTH_SHORT)
            t1.show()
        }

        button2.setOnClickListener { view ->
            var v1 = layoutInflater.inflate(R.layout.custom_toast, null)

            v1?.setBackgroundResource(android.R.drawable.toast_frame)

            var image_view: ImageView? = v1.findViewById<ImageView>(R.id.imageView)
            image_view?.setImageResource(R.drawable.img_android)

            var text_view:TextView? = v1.findViewById<TextView>(R.id.textView)
            text_view?.text = "토스트 메시지 입니다"
            text_view?.setTextColor(Color.WHITE)

            var t2 = Toast(this)
            t2.view = v1

            t2.setGravity(Gravity.CENTER, 0, 100)
            t2.show()
        }
    }
}
