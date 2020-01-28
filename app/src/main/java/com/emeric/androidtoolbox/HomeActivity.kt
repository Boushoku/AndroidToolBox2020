package com.emeric.androidtoolbox

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        lifeCycleButton.setOnClickListener {
            startActivity(Intent(this, LifeCycleActivity::class.java))
        }

        saveButton.setOnClickListener { startActivity(Intent(this, SaveActivity::class.java)) }

        permissionButton.setOnClickListener {
            startActivity(Intent(this, PermissionActivity::class.java))
        }

        logoutButton.setOnClickListener {
            val userPref = getSharedPreferences(Constants.UserPreferencesName, Context.MODE_PRIVATE)
            val editor = userPref.edit()
            editor.clear()
            editor.apply()
            val intent = Intent(this, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
            finish()
        }
    }
}
