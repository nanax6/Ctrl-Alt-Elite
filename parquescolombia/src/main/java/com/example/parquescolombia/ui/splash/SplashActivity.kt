package com.example.parquescolombia.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import com.example.parquescolombia.R
import com.example.parquescolombia.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val splashScreen = AnimationUtils.loadAnimation(this, R.anim.splash_fadein)
        imageViewTeamLogo.startAnimation(splashScreen)
        logo_splash_imageView.startAnimation(splashScreen)
        textViewBy.startAnimation(splashScreen)

        @Suppress("DEPRECATION")
        Handler().postDelayed(
            {
                startActivity(
                    Intent(this@SplashActivity,
                        SplashActivity2::class.java)
                )
                finish()
            }, 3000
        )

    }



}