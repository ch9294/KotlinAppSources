package softcampus.co.kr.button

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var listener1 = BtnListener();
        button.setOnClickListener(listener1)

        var listener2 = BtnListener2()
        button2.setOnClickListener(listener2)

        var listener3 = BtnListener3()
        button3.setOnClickListener(listener3)
        button4.setOnClickListener(listener3)

        button5.setOnClickListener { view ->
            textView.text = "다섯 번째 버튼을 눌렀습니다"
        }
        button6.setOnClickListener{ view ->
            textView.text = "여섯 번째 버튼을 눌렀습니다"
        }

        var listener4 = View.OnClickListener { view ->
            when(view.id){
                R.id.button7 ->
                        textView.text = "일곱 번째 버튼을 눌렀습니다"
                R.id.button8 ->
                        textView.text = "여덟 번째 버튼을 눌렀습니다"
            }
        }
        button7.setOnClickListener(listener4)
        button8.setOnClickListener(listener4)
    }

    inner class BtnListener:View.OnClickListener{
        override fun onClick(p0: View?) {
            textView.text = "첫 번째 버튼을 눌렀습니다"
        }
    }

    inner class BtnListener2:View.OnClickListener{
        override fun onClick(p0: View?) {
            textView.text = "두 번째 버튼을 눌렀습니다"
        }
    }

    inner class BtnListener3:View.OnClickListener{
        override fun onClick(p0: View?) {
            when(p0?.id){
                R.id.button3 ->
                        textView.text = "세 번째 버튼을 눌렀습니다"
                R.id.button4 ->
                        textView.text = "네 번째 버튼을 눌렀습니다"
            }
        }
    }
}
