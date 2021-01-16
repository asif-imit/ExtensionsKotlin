package com.app.extensions



import android.view.LayoutInflater
import android.view.View
import android.view.animation.Animation
import android.view.animation.OvershootInterpolator
import android.view.animation.ScaleAnimation
import com.google.android.material.floatingactionbutton.FloatingActionButton

/**
 * This file contains method that will provide method
 * for visibility manipulation of the view
 * */


val View.layoutInflater: LayoutInflater
    get() = LayoutInflater.from(this.context)

/**
 * @property com.app.extensions.gone()
 * This method will hide the view can be called upon any view
 * it will set the visibility of the view as View.GONE
 * */
fun View.gone() {
    if (this is FloatingActionButton) {
        if (this.isOrWillBeShown) {
            this.hide()
        }
    } else {
        this.visibility = View.GONE
    }
}

fun View.goneAlpha(duration: Long = 300) {
    this.animate()
        .alpha(0f)
        .setDuration(duration)
        .withEndAction {
            this.visibility = View.GONE
        }
}


/**
 * @property com.app.extensions.invisible()
 * This method will hide the view can be called upon any view
 * it will set the visibility of the view as View.INVISIBLE
 * */
fun View.invisible() {
    if (this is FloatingActionButton) {
        if (this.isOrWillBeShown) {
            this.hide()
        }
    } else {
        this.visibility = View.INVISIBLE
    }
}


/**
 * @property com.app.extensions.show()
 * This method will show the view can be called upon any view
 * it will set the visibility of the view as View.VISIBLE
 * */
fun View.show() {
    if (isVisible())return
    if (this is FloatingActionButton) {
        if (this.isOrWillBeHidden) {
            this.post {this.show()}
        }
    } else {
        this.post { this.visibility = View.VISIBLE }
    }
}

fun View.showAlpha(duration: Long = 300) {
    if (isVisible())return
    this.post {
        this.alpha = 0f
        this.visibility = View.VISIBLE
        this.animate()
            .setDuration(duration)
            .alpha(1f)
    }
}

fun View.visible(visible: Boolean) {
    if (visible) this.show() else this.gone()
}

/**
 * @property com.app.extensions.isVisible()
 * @return Boolean values to indicate that
 * if the view is visible or not, upon which it is called
 * */
fun View.isVisible() = this.visibility == View.VISIBLE


fun View.showWithAlpha() {
    if (isVisible())return
    this.post {
        this.alpha = 0f
        this.visibility = View.VISIBLE
        this.animate().alpha(1f).duration = 1800
    }
}

fun View.hideWithAlpha() {
    if (isNotVisible())return
    this.post {
        this.alpha = 1f
        this.visibility = View.VISIBLE
        this.animate().alpha(0f).duration = 2000
    }
}

fun View.isNotVisible(): Boolean {
    return !isVisible()
}

fun View.fabStyleGone() {
    if (isNotVisible())return
    this.post {
        this.pivotX = 0.5f
        this.pivotY = 0.5f
        this.animate()
            .setDuration(500)
            .scaleX(0f)
            .scaleY(0f)
            .withEndAction {
                this.gone()
                this.scaleX = 1f
                this.scaleY = 1f
            }
    }
}

fun View.fabStyleShow(tension: Float = 2.5f,override: Boolean=false) {
    if (!override&&isVisible())return
    this.post {
        val anim = ScaleAnimation(
            0f,
            1.0f,
            0f,
            1.0f,
            Animation.RELATIVE_TO_SELF,
            .5f,
            Animation.RELATIVE_TO_SELF,
            .5f
        )
        this.show()
        anim.interpolator = OvershootInterpolator(tension)
        anim.duration = 600
        this.startAnimation(anim)
    }
}

fun View.rotate(angle: Float, runnable: Runnable? = null) {
    this.post {
        this.animate()
            .withEndAction(runnable)
            .rotationBy(angle)
    }
}

fun View.scaleYToOne() {
    this.post {
        this.show()
        this.scaleY = 0f
        this.pivotX = 1f
        this.pivotY = 0f
        this.animate()
            .setDuration(200)
            .scaleY(1.0f)
    }
}

fun  View.scaleYToZero(runnable: Runnable?=null) {
    this.post {
        this.pivotX = 1f
        this.pivotY = 0f
        this.animate()
            .setDuration(200)
            .withEndAction(runnable)
            .scaleY(0f)
    }
}