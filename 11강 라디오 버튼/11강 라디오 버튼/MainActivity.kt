package softcampus.co.kr.radiobutton

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioGroup
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener{ view ->

            when(group1.checkedRadioButtonId){
                R.id.radioButton ->
                        textView.text = "라디오 1-1이 선택되었습니다"
                R.id.radioButton2 ->
                        textView.text = "라디오 1-2가 선택되었습니다"
                R.id.radioButton3 ->
                        textView.text = "라디오 1-3이 선택되었습니다"
            }

            when(group2.checkedRadioButtonId){
                R.id.radioButton4 ->
                        textView2.text = "라디오 2-1이 선택되었습니다"
                R.id.radioButton5 ->
                        textView2.text = "라디오 2-2가 선택되었습니다"
                R.id.radioButton6 ->
                        textView2.text = "라디오 2-3이 선택되었습니다"
            }
        }
        /*
        var listener = RadioListener()
        group1.setOnCheckedChangeListener(listener)
        group2.setOnCheckedChangeListener(listener)
        */
        group1.setOnCheckedChangeListener { radioGroup, i ->
            when(i){
                R.id.radioButton ->
                    textView.text = "체크 이벤트 : 라디오 1-1 체크"
                R.id.radioButton2 ->
                    textView.text = "체크 이벤트 : 라디오 1-2 체크"
                R.id.radioButton3 ->
                    textView.text = "체크 이벤트 : 라디오 1-3 체크"
            }
        }

        group2.setOnCheckedChangeListener{ radioGroup, i ->
            when(i){
                R.id.radioButton4 ->
                    textView.text = "체크 이벤트 : 라디오 2-1 체크"
                R.id.radioButton5 ->
                    textView.text = "체크 이벤트 : 라디오 2-2 체크"
                R.id.radioButton6 ->
                    textView.text = "체크 이벤트 : 라디오 2-3 체크"
            }
        }

        button2.setOnClickListener{view ->
            radioButton3.isChecked  = true
            radioButton6.isChecked = true
        }
    }

    inner class RadioListener:RadioGroup.OnCheckedChangeListener{
        override fun onCheckedChanged(p0: RadioGroup?, p1: Int) {

            when(p0?.id){
                R.id.group1 ->
                        when(p1){
                            R.id.radioButton ->
                                    textView.text = "체크 이벤트 : 라디오 1-1 체크"
                            R.id.radioButton2 ->
                                    textView.text = "체크 이벤트 : 라디오 1-2 체크"
                            R.id.radioButton3 ->
                                    textView.text = "체크 이벤트 : 라디오 1-3 체크"
                        }
                R.id.group2 ->
                        when(p1){
                            R.id.radioButton4 ->
                                    textView.text = "체크 이벤트 : 라디오 2-1 체크"
                            R.id.radioButton5 ->
                                    textView.text = "체크 이벤트 : 라디오 2-2 체크"
                            R.id.radioButton6 ->
                                    textView.text = "체크 이벤트 : 라디오 2-3 체크"
                        }
            }
        }
    }
}








