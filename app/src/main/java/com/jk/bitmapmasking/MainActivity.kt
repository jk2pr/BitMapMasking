package com.jk.bitmapmasking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.opengl.ETC1.getWidth
import android.opengl.ETC1.getHeight
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val inputOrg = assets.open("org.jpg")
        val bitMapOrg = BitmapFactory.decodeStream(inputOrg)


        val inputQR = assets.open("qr.jpg")
        val bitMapQR = BitmapFactory.decodeStream(inputQR)

        btgo.setOnClickListener {


         val result=   mergeToPin(bitMapOrg,bitMapQR)

            imageView.setImageBitmap(result)
        }

    }




   private fun mergeToPin(back: Bitmap, front: Bitmap): Bitmap {
        val result = Bitmap.createBitmap(back.width, back.height, back.config)
        val canvas = Canvas(result)
        val widthBack = back.width
        val widthFront = front.width
        val move = ((widthBack - widthFront) / 2).toFloat()
        canvas.drawBitmap(back, 0f, 0f, null)
        canvas.drawBitmap(front, move, move, null)
        return result
    }
}
