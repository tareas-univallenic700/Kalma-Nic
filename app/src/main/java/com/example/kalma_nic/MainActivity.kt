package com.example.kalma_nic

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.os.Bundle
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.BounceInterpolator
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.animation.doOnEnd
import com.example.kalma_nic.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupWelcomeAnimation()
        setupMoodButtons()
        setupActionButtons()
        setupBottomNavigation()
    }

    /**
     * Configura la animación de bienvenida del panda rojo
     */
    private fun setupWelcomeAnimation() {
        // Animación de entrada del logo
        binding.logoKalma.alpha = 0f
        binding.logoKalma.animate()
            .alpha(1f)
            .setDuration(1000)
            .setStartDelay(300)
            .start()

        // Animación de entrada del panda rojo
        binding.mascotCard.alpha = 0f
        binding.mascotCard.scaleX = 0.5f
        binding.mascotCard.scaleY = 0.5f
        
        binding.mascotCard.animate()
            .alpha(1f)
            .scaleX(1f)
            .scaleY(1f)
            .setDuration(800)
            .setInterpolator(BounceInterpolator())
            .setStartDelay(600)
            .start()

        // Animación de saludo del panda
        animatePandaWave()
    }

    /**
     * Anima el saludo del panda rojo
     */
    private fun animatePandaWave() {
        val waveAnimation = ObjectAnimator.ofFloat(binding.redPandaFace, "rotation", 0f, -15f, 15f, -10f, 10f, 0f)
        waveAnimation.duration = 2000
        waveAnimation.interpolator = AccelerateDecelerateInterpolator()
        waveAnimation.startDelay = 1500
        waveAnimation.start()
    }

    /**
     * Configura los botones de estado de ánimo
     */
    private fun setupMoodButtons() {
        val moodButtons = listOf(
            binding.moodHappy to "feliz",
            binding.moodNeutral to "neutral", 
            binding.moodSad to "triste",
            binding.moodAnxious to "ansioso",
            binding.moodRelaxed to "relajado"
        )

        moodButtons.forEach { (button, mood) ->
            button.setOnClickListener {
                animateMoodSelection(button)
                logMood(mood)
            }
        }
    }

    /**
     * Anima la selección de estado de ánimo
     */
    private fun animateMoodSelection(button: View) {
        // Animación de escala
        val scaleAnimation = ObjectAnimator.ofFloat(button, "scaleX", 1f, 1.2f, 1f)
        scaleAnimation.duration = 300
        scaleAnimation.start()

        val scaleYAnimation = ObjectAnimator.ofFloat(button, "scaleY", 1f, 1.2f, 1f)
        scaleYAnimation.duration = 300
        scaleYAnimation.start()

        // Animación de rotación sutil
        val rotationAnimation = ObjectAnimator.ofFloat(button, "rotation", 0f, 5f, -5f, 0f)
        rotationAnimation.duration = 400
        rotationAnimation.start()
    }

    /**
     * Configura los botones de acción
     */
    private fun setupActionButtons() {
        binding.breathingButton.setOnClickListener {
            Toast.makeText(this, "Iniciando ejercicio de respiración...", Toast.LENGTH_SHORT).show()
            // Aquí se implementaría la navegación al ejercicio de respiración
        }

        binding.progressButton.setOnClickListener {
            Toast.makeText(this, "Mostrando progreso...", Toast.LENGTH_SHORT).show()
            // Aquí se implementaría la navegación a la pantalla de progreso
        }
    }

    /**
     * Configura la navegación inferior
     */
    private fun setupBottomNavigation() {
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    Toast.makeText(this, "Inicio", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_exercises -> {
                    Toast.makeText(this, "Ejercicios", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_progress -> {
                    Toast.makeText(this, "Progreso", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_community -> {
                    Toast.makeText(this, "Comunidad", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
        binding.bottomNavigation.selectedItemId = R.id.nav_home
    }

    /**
     * Registra el estado de ánimo seleccionado
     */
    private fun logMood(mood: String) {
        val message = getString(R.string.mood_registered, mood)
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        
        // Animación de confirmación en el panda
        animatePandaConfirmation()
        
        // Aquí se guardaría el estado de ánimo en la base de datos
        // saveMoodToDatabase(mood)
    }

    /**
     * Anima la confirmación del panda cuando se registra un estado de ánimo
     */
    private fun animatePandaConfirmation() {
        val bounceAnimation = ObjectAnimator.ofFloat(binding.redPandaFace, "scaleX", 1f, 1.3f, 1f)
        bounceAnimation.duration = 500
        bounceAnimation.interpolator = BounceInterpolator()
        bounceAnimation.start()

        val bounceYAnimation = ObjectAnimator.ofFloat(binding.redPandaFace, "scaleY", 1f, 1.3f, 1f)
        bounceYAnimation.duration = 500
        bounceYAnimation.interpolator = BounceInterpolator()
        bounceYAnimation.start()
    }
}
