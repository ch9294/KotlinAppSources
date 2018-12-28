package softcampus.co.kr.checkbox

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener { view ->
            textView.text = ""

            if(checkBox.isChecked == true){
                textView.append("체크박스1이 체크되었습니다\n")
            }
            if(checkBox2.isChecked == true){
                textView.append("체크박스2가 체크되었습니다\n")
            }
            if(checkBox3.isChecked == true){
                textView.append("체크박스3이 체크되었습니다\n")
            }
        }

        button2.setOnClickListener{ view ->
            checkBox.isChecked = true;
            checkBox2.isChecked = true;
            checkBox3.isChecked = true;
        }

        button3.setOnClickListener { view ->
            checkBox.isChecked = false;
            checkBox2.isChecked = false;
            checkBox3.isChecked = false;
        }

        button4.setOnClickListener{ view ->
            checkBox.toggle()
            checkBox2.toggle()
            checkBox3.toggle()
        }

        var listener1 = CheckBoxListener()
        checkBox.setOnCheckedChangeListener(listener1)
        
        checkBox2.setOnCheckedChangeListener { compoundButton, b ->
            if(b == true){
                textView.text = "이벤트 : 체크박스2가 체크되었습니다"
            } else {
                textView.text = "이벤트 : 체크박스2가 체크 해제 되었습니다"
            }
        }

        checkBox3.setOnCheckedChangeListener { compoundButton, b ->
            if(b == true){
                textView.text = "이벤트 : 체크박스3이 체크되었습니다"
            } else {
                textView.text = "이벤트 : 체크박스3이 체크 해제 되었습니다"
            }
        }
    }

    inner class CheckBoxListener : CompoundButton.OnCheckedChangeListener{
        override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {
            if(p1 == true){
                textView.text = "이벤트 : 체크박스1이 체크되었습니다"
            } else {
                textView.text = "이벤트 : 체크박스1이 체크 해제 되었습니다"
            }
        }
    }
}






