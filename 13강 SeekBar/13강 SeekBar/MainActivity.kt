package softcampus.co.kr.seekbar

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener { view ->
            textView.text = "seek1 : " + seekBar.progress
            textView2.text = "seek2 : " + seekBar2.progress
        }
        button2.setOnClickListener { view ->
            seekBar.incrementProgressBy(1)
            seekBar2.incrementProgressBy(1)
        }
        button3.setOnClickListener{ view ->
            seekBar.incrementProgressBy(-1)
            seekBar2.incrementProgressBy(-1)
        }

        var listener = SeekListener()
        seekBar.setOnSeekBarChangeListener(listener)

        seekBar2.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                textView2.text = "seek2 : " + p1
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }
        })
    }
    inner class SeekListener:SeekBar.OnSeekBarChangeListener{
        // SeekBar의 값이 변경되었을 때
        override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
            textView.text = "seek1 : " + p1
        }
        // 값을 변경하기 위해 사용자가 터치했을 때
        override fun onStartTrackingTouch(p0: SeekBar?) {

        }
        // 값을 변경한 후 터치를 때었을 때
        override fun onStopTrackingTouch(p0: SeekBar?) {

        }
    }
}












