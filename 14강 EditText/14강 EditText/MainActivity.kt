package softcampus.co.kr.edittext

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener { view ->
            textView.text = editText.text
        }

        button2.setOnClickListener{ view ->
            // editText.setText("문자열")
            editText.setText("")
        }

        /*
        var listener1 = EnterListener()
        editText.setOnEditorActionListener(listener1)
        */
        editText.setOnEditorActionListener { tv, i, keyEvent ->
            textView.text = editText.text
            false
        }
    /*
        var watcher = EditWatcher()
        editText.addTextChangedListener(watcher)
        */
        editText.addTextChangedListener(object:TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                textView.text = p0
            }

            override fun afterTextChanged(p0: Editable?) {

            }
        })
    }

    inner class EnterListener:TextView.OnEditorActionListener{
        override fun onEditorAction(p0: TextView?, p1: Int, p2: KeyEvent?): Boolean {
            textView.text = editText.text;
            return false;
        }
    }

    inner class EditWatcher:TextWatcher{
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            textView.text = p0
        }

        override fun afterTextChanged(p0: Editable?) {

        }
    }
}









