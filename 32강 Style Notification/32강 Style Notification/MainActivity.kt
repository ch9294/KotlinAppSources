package kr.co.softcampus.stylenotification

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.NotificationCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener { view ->
            var builder = getNotificationBuilder("style", "style Notification")
            builder.setContentTitle("Big Picture")
            builder.setContentText("Big Picture Notification")
            builder.setSmallIcon(android.R.drawable.ic_media_next)

            var big = NotificationCompat.BigPictureStyle(builder)
            var bitmap = BitmapFactory.decodeResource(resources, R.drawable.img_android)
            big.bigPicture(bitmap)
            big.setBigContentTitle("Big Content Title")
            big.setSummaryText("Summary Text")

            var notification = builder.build()
            var manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(10, notification)
        }

        button2.setOnClickListener { view ->
            var builder = getNotificationBuilder("style", "style Notification")
            builder.setContentTitle("Big Text")
            builder.setContentText("Big Text Notification")
            builder.setSmallIcon(android.R.drawable.ic_media_next)

            var big = NotificationCompat.BigTextStyle(builder)
            big.setSummaryText("Summary Texxt")
            big.setBigContentTitle("Big content Title")
            big.bigText("동해물과 백두산이 마르고 닳도록 하느님이 보우하사 우리나라 만세")

            var notification = builder.build()
            var manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(20, notification)
        }

        button3.setOnClickListener { view ->
            var builder = getNotificationBuilder("style", "style Notification")
            builder.setContentTitle("InBox")
            builder.setContentText("InBox Notification")
            builder.setSmallIcon(android.R.drawable.ic_media_next)

            var inbox = NotificationCompat.InboxStyle(builder)
            inbox.setSummaryText("Summary Text")

            inbox.addLine("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
            inbox.addLine("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb")
            inbox.addLine("cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc")
            inbox.addLine("dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd")

            var notification = builder.build()
            var manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(30, notification)
        }
    }

    fun getNotificationBuilder(id:String, name:String) : NotificationCompat.Builder{
        var builder : NotificationCompat.Builder? = null

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            var manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            var channel = NotificationChannel(id, name, NotificationManager.IMPORTANCE_HIGH)
            channel.enableLights(true)
            channel.lightColor = Color.RED
            channel.enableVibration(true)
            manager.createNotificationChannel(channel)

            builder = NotificationCompat.Builder(this, id)
        } else {
            builder = NotificationCompat.Builder(this)
        }

        return builder
    }
}












