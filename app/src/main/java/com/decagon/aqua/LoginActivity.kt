package com.decagon.aqua

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.decagon.aqua.databinding.ActivityLoginBinding
import com.decagon.aqua.databinding.ActivityLoginBinding.inflate
import com.decagon.aqua.features.consumer.authentication.CustomerLoginFragment

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflate(layoutInflater)
        setContentView(binding.root)
        // initializing support fragment manager
        supportFragmentManager.beginTransaction().replace(R.id.nav_Container, CustomerLoginFragment())
            .commit()
    }
}
