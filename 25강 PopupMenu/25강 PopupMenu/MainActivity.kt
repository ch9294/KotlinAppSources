package kr.co.softcampus.popupmenu

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.PopupMenu
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener { view ->
            var pop = PopupMenu(this, textView)

            menuInflater.inflate(R.menu.popup_menu, pop.menu)

           // var listener = PopupListener()
           // pop.setOnMenuItemClickListener(listener)

            pop.setOnMenuItemClickListener { item ->
                when(item.itemId){
                    R.id.item1 ->
                            textView.text = "메뉴 1번을 눌렀습니다"
                    R.id.item2 ->
                            textView.text = "메뉴 2번을 눌렀습니다"
                    R.id.item3 ->
                            textView.text = "메뉴 3번을 눌렀습니다"
                }
                false
            }

            pop.show()
        }
    }

    inner class PopupListener:PopupMenu.OnMenuItemClickListener{
        override fun onMenuItemClick(p0: MenuItem?): Boolean {
            when(p0?.itemId){
                R.id.item1 ->
                        textView.text = "메뉴 1번을 눌렀습니다"
                R.id.item2 ->
                        textView.text = "메뉴 2번을 눌렀습니다"
                R.id.item3 ->
                        textView.text = "메뉴 3번을 눌렀습니다"
            }
            return false
        }
    }
}










