package com.example.madpractical_8_20012011124

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import com.example.madpractical_8_20012011124.R.*

class SplashActivity : AppCompatActivity(), Animation.AnimationListener {
    lateinit var guni_image: ImageView
    lateinit var logo_framebyframeanimation: AnimationDrawable
    lateinit var twinanimation: Animation
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_splash)

        guni_image=findViewById(id.img)
        guni_image.setBackgroundResource(drawable.uvpce_logo_list)
        logo_framebyframeanimation=guni_image.background as AnimationDrawable
        twinanimation = AnimationUtils.loadAnimation(this, anim.twin_animation)
        twinanimation.setAnimationListener(this)
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus)
        {
            logo_framebyframeanimation.start()
            guni_image.startAnimation(twinanimation)
        }
        else
        {
            logo_framebyframeanimation.stop()
        }
    }

    override fun onAnimationStart(p0: Animation?) {

    }

    override fun onAnimationEnd(p0: Animation?) {
        Intent(this,MainActivity::class.java).also { startActivity(it) }
        overridePendingTransition(anim.scale_centre_in, anim.scale_centre_out)
        finish()
    }

    override fun onAnimationRepeat(p0: Animation?) {

    }
}