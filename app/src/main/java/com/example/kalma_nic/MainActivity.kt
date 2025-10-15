package com.example.kalma_nic

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.BounceInterpolator
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.annotation.StringRes
import androidx.core.view.isVisible
import com.example.kalma_nic.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var sections: Map<Int, View>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupSections()
        setupWelcomeAnimation()
        updateWelcomeMessage()
        binding.moodAdviceCard.isVisible = false
        setupMoodButtons()
        setupActionButtons()
        setupBottomNavigation()
        setupInfoCards()
    }

    private fun setupSections() {
        sections = mapOf(
            R.id.nav_home to binding.homeSection,
            R.id.nav_exercises to binding.exercisesSection,
            R.id.nav_progress to binding.progressSection,
            R.id.nav_community to binding.communitySection
        )
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
     * Presenta progresivamente el contenido informativo
     */
    private fun setupInfoCards() {
        binding.infoSectionTitle.alpha = 0f
        binding.infoSectionTitle.translationY = 50f
        binding.infoSectionTitle.animate()
            .alpha(1f)
            .translationY(0f)
            .setStartDelay(800)
            .setDuration(500)
            .setInterpolator(AccelerateDecelerateInterpolator())
            .start()

        val cardPairs = listOf(
            binding.infoOverviewCard to getString(R.string.overview_title),
            binding.infoObjectivesCard to getString(R.string.objectives_title),
            binding.infoKalbotCard to getString(R.string.kalbot_title),
            binding.infoAnxietyCard to getString(R.string.anxiety_title),
            binding.infoRegulationCard to getString(R.string.regulation_title),
            binding.infoSelfCareCard to getString(R.string.self_care_title)
        )

        cardPairs.forEachIndexed { index, (card, title) ->
            card.alpha = 0f
            card.translationY = 80f
            card.animate()
                .alpha(1f)
                .translationY(0f)
                .setStartDelay(950L + index * 140L)
                .setDuration(500)
                .setInterpolator(AccelerateDecelerateInterpolator())
                .start()

            card.setOnClickListener {
                val pulseX = ObjectAnimator.ofFloat(card, "scaleX", 1f, 1.03f, 1f)
                pulseX.duration = 350

                val pulseY = ObjectAnimator.ofFloat(card, "scaleY", 1f, 1.03f, 1f)
                pulseY.duration = 350

                pulseX.start()
                pulseY.start()

                Toast.makeText(this, getString(R.string.info_card_hint, title), Toast.LENGTH_SHORT).show()
            }
        }
    }

    /**
     * Configura los botones de estado de ánimo
     */
    private fun setupMoodButtons() {
        val moodOptions = listOf(
            MoodOption(binding.moodHappy, R.string.mood_happy, R.string.mood_advice_happy),
            MoodOption(binding.moodNeutral, R.string.mood_neutral, R.string.mood_advice_neutral),
            MoodOption(binding.moodSad, R.string.mood_sad, R.string.mood_advice_sad),
            MoodOption(binding.moodAnxious, R.string.mood_anxious, R.string.mood_advice_anxious),
            MoodOption(binding.moodRelaxed, R.string.mood_relaxed, R.string.mood_advice_relaxed)
        )

        moodOptions.forEach { option ->
            option.button.setOnClickListener {
                animateMoodSelection(option.button)
                logMood(option)
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
            val handled = when (item.itemId) {
                R.id.nav_home -> {
                    showSection(R.id.nav_home)
                    true
                }
                R.id.nav_exercises -> {
                    showSection(R.id.nav_exercises)
                    true
                }
                R.id.nav_progress -> {
                    showSection(R.id.nav_progress)
                    true
                }
                R.id.nav_community -> {
                    showSection(R.id.nav_community)
                    true
                }
                else -> false
            }

            if (handled) {
                Toast.makeText(this, item.title, Toast.LENGTH_SHORT).show()
            }

            handled
        }
        binding.bottomNavigation.selectedItemId = R.id.nav_home
        showSection(R.id.nav_home)
    }

    /**
     * Registra el estado de ánimo seleccionado
     */
    private fun logMood(option: MoodOption) {
        val moodLabel = getString(option.labelRes)
        val message = getString(R.string.mood_registered, moodLabel)
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

        // Animación de confirmación en el panda
        animatePandaConfirmation()

        // Aquí se guardaría el estado de ánimo en la base de datos
        // saveMoodToDatabase(mood)

        updateMoodAdvice(moodLabel, option.adviceRes)
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

    private fun showSection(sectionId: Int) {
        sections.forEach { (id, view) ->
            view.isVisible = id == sectionId
        }
        binding.mainScrollView.post {
            binding.mainScrollView.scrollTo(0, 0)
        }
    }

    private fun updateMoodAdvice(moodLabel: String, @StringRes adviceRes: Int) {
        binding.moodAdviceTitle.text = getString(R.string.mood_advice_title, moodLabel)
        binding.moodAdviceDescription.text = getString(adviceRes)
        if (!binding.moodAdviceCard.isVisible) {
            binding.moodAdviceCard.isVisible = true
            binding.moodAdviceCard.alpha = 0f
            binding.moodAdviceCard.animate()
                .alpha(1f)
                .setDuration(300)
                .start()
        }
    }

    private fun updateWelcomeMessage() {
        val email = intent.getStringExtra(EXTRA_USER_EMAIL)
        if (!email.isNullOrBlank()) {
            val name = formatUserName(email)
            binding.welcomeMessage.text = getString(R.string.welcome_message_user, name)
        }
    }

    private fun formatUserName(email: String): String {
        return email.substringBefore("@")
            .split('.', '_')
            .filter { it.isNotBlank() }
            .joinToString(" ") { part ->
                part.replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() }
            }
    }

    private data class MoodOption(
        val button: View,
        @StringRes val labelRes: Int,
        @StringRes val adviceRes: Int
    )

    companion object {
        const val EXTRA_USER_EMAIL = "extra_user_email"
    }
}
