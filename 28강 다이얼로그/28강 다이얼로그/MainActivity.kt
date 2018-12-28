package kr.co.softcampus.dialogbasic

import android.app.DatePickerDialog
import android.app.ProgressDialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AlertDialog
import android.widget.DatePicker
import android.widget.EditText
import android.widget.TimePicker
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    var pro:ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener { view ->
            var builder = AlertDialog.Builder(this)
            builder.setTitle("기본 다이얼로그")
            builder.setMessage("다이얼로그의 본문입니다")
            builder.setIcon(R.mipmap.ic_launcher)

            var listener = object:DialogInterface.OnClickListener{
                override fun onClick(p0: DialogInterface?, p1: Int) {
                    when(p1){
                        DialogInterface.BUTTON_POSITIVE ->
                                textView.text = "기본 다이얼로그 : Positive"
                        DialogInterface.BUTTON_NEUTRAL ->
                                textView.text = "기본 다이얼로그 : Neutral"
                        DialogInterface.BUTTON_NEGATIVE ->
                                textView.text = "기본 다이얼로그 : Negative"
                    }
                }
            }

            builder.setPositiveButton("Positive", listener)
            builder.setNeutralButton("Neutral", listener)
            builder.setNegativeButton("Negative", listener)

            builder.show()
        }

        button2.setOnClickListener { view ->
            var builder = AlertDialog.Builder(this)
            builder.setTitle("커스텀 다이얼로그")
            builder.setIcon(R.mipmap.ic_launcher)

            var v1 = layoutInflater.inflate(R.layout.dialog, null)
            builder.setView(v1)

            var listener = object:DialogInterface.OnClickListener{
                override fun onClick(p0: DialogInterface?, p1: Int) {
                    var alert = p0 as AlertDialog
                    var edit1:EditText? = alert.findViewById<EditText>(R.id.editText)
                    var edit2:EditText? = alert.findViewById<EditText>(R.id.editText2)

                    textView.text = "edit1 : ${edit1?.text}\n"
                    textView.append("edit2 : ${edit2?.text}")
                }
            }

            builder.setPositiveButton("확인", listener)
            builder.setNegativeButton("취소", null)

            builder.show()
        }

        button3.setOnClickListener { view ->
            var calendar = Calendar.getInstance()
            var year = calendar.get(Calendar.YEAR)
            var month = calendar.get(Calendar.MONTH)
            var day = calendar.get(Calendar.DAY_OF_MONTH)

            var listener = object:DatePickerDialog.OnDateSetListener{
                override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
                    textView.text = "${p1}년 ${p2 + 1}월 ${p3}일"
                }
            }
            var picker = DatePickerDialog(this, listener, year, month, day)
            picker.show()
        }

        button4.setOnClickListener { view ->
            var calendar = Calendar.getInstance()
            var hour = calendar.get(Calendar.HOUR)
            var minute = calendar.get(Calendar.MINUTE)

            var listener = object:TimePickerDialog.OnTimeSetListener{
                override fun onTimeSet(p0: TimePicker?, p1: Int, p2: Int) {
                    textView.text = "${p1}시 ${p2}분"
                }
            }
            var picker = TimePickerDialog(this, listener, hour, minute, true)
            picker.show()
        }

        button5.setOnClickListener { view ->
            pro = ProgressDialog.show(this, "타이틀입니다", "메시지입니다")

            var handler = Handler()
            var thread = object:Runnable{
                override fun run() {
                    pro?.cancel()
                }
            }
            handler.postDelayed(thread, 5000)
        }
    }
}










