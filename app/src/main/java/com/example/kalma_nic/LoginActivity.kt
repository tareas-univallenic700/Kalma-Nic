package com.example.kalma_nic

import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kalma_nic.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    private val demoUsers = listOf(
        DemoUser("abril.jimenez@kalma.app", "Kalma123"),
        DemoUser("carlos.martinez@kalma.app", "Kalma123"),
        DemoUser("estefany.rojas@kalma.app", "Kalma123"),
        DemoUser("leonardo.perez@kalma.app", "Kalma123"),
        DemoUser("marcela.garcia@kalma.app", "Kalma123")
    )

    private val userLookup = demoUsers.associateBy { it.email.lowercase() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupDemoAccounts()
        setupActions()
    }

    private fun setupDemoAccounts() {
        binding.demoAccountList.text = demoUsers.joinToString(separator = "\n") { user ->
            "• ${user.email}"
        }
    }

    private fun setupActions() {
        binding.loginButton.setOnClickListener { attemptLogin() }

        binding.passwordInput.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                attemptLogin()
                true
            } else {
                false
            }
        }
    }

    private fun attemptLogin() {
        clearErrors()

        val email = binding.emailInput.text?.toString()?.trim().orEmpty()
        val password = binding.passwordInput.text?.toString()?.trim().orEmpty()

        if (email.isEmpty()) {
            binding.emailLayout.error = getString(R.string.login_error_email_required)
            return
        }

        if (password.isEmpty()) {
            binding.passwordLayout.error = getString(R.string.login_error_password_required)
            return
        }

        val user = userLookup[email.lowercase()]

        if (user == null) {
            binding.emailLayout.error = getString(R.string.login_error_unknown_email)
            return
        }

        if (user.password != password) {
            binding.passwordLayout.error = getString(R.string.login_error_invalid_password)
            return
        }

        Toast.makeText(this, getString(R.string.login_success), Toast.LENGTH_SHORT).show()

        val intent = Intent(this, MainActivity::class.java).apply {
            putExtra(MainActivity.EXTRA_USER_EMAIL, user.email)
        }

        startActivity(intent)
        finish()
    }

    private fun clearErrors() {
        binding.emailLayout.error = null
        binding.passwordLayout.error = null
    }

    private data class DemoUser(val email: String, val password: String)
}
