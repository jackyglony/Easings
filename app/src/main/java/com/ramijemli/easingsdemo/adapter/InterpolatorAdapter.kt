package com.ramijemli.easingsdemo.adapter


import android.content.Context
import android.util.SparseArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import androidx.recyclerview.widget.RecyclerView
import com.ramijemli.easings.EasingInterpolator
import com.ramijemli.easings.Easings
import com.ramijemli.easingsdemo.R
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_interpolator.*


const val SINUSOIDAL_IN = 0
const val SINUSOIDAL_OUT = 1
const val SINUSOIDAL_IN_OUT = 2

const val QUADRATIC_IN = 3
const val QUADRATIC_OUT = 4
const val QUADRATIC_IN_OUT = 5

const val CUBIC_IN = 6
const val CUBIC_OUT = 7
const val CUBIC_IN_OUT = 8

const val QUARTIC_IN = 9
const val QUARTIC_OUT = 10
const val QUARTIC_IN_OUT = 11

const val QUINTIC_IN = 12
const val QUINTIC_OUT = 13
const val QUINTIC_IN_OUT = 14

const val EXPONENTIAL_IN = 15
const val EXPONENTIAL_OUT = 16
const val EXPONENTIAL_IN_OUT = 17

const val CIRCULAR_IN = 18
const val CIRCULAR_OUT = 19
const val CIRCULAR_IN_OUT = 20

const val BACK_IN = 21
const val BACK_OUT = 22
const val BACK_IN_OUT = 23

const val ELASTIC_IN = 24
const val ELASTIC_OUT = 25
const val ELASTIC_IN_OUT = 26

const val BOUNCE_IN = 27
const val BOUNCE_OUT = 28
const val BOUNCE_IN_OUT = 29

class InterpolatorAdapter(mContext: Context?) : RecyclerView.Adapter<InterpolatorAdapter.InterpolatorViewHolder>() {


    private var mData: SparseArray<String>? = null

    init {
        mData = SparseArray(12)
        mData?.apply {
            val titles = mContext?.resources?.getStringArray(R.array.interpolator_titles)
            for (i in 0 until titles?.size!!) {
                mData?.append(i, titles[i])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InterpolatorViewHolder =
            InterpolatorViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_interpolator, parent, false))

    override fun onBindViewHolder(viewHolder: InterpolatorViewHolder, position: Int) = viewHolder.bind(position)

    override fun getItemCount(): Int = mData?.size()!!

    inner class InterpolatorViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
        LayoutContainer {

        fun bind(position: Int) {
            chart.setInterpolator(
                    when (position) {
                        SINUSOIDAL_IN -> EasingInterpolator(Easings.SIN_IN)
                        SINUSOIDAL_OUT -> EasingInterpolator(Easings.SIN_OUT)
                        SINUSOIDAL_IN_OUT -> EasingInterpolator(Easings.SIN_IN_OUT)

                        QUADRATIC_IN -> EasingInterpolator(Easings.QUAD_IN)
                        QUADRATIC_OUT -> EasingInterpolator(Easings.QUAD_OUT)
                        QUADRATIC_IN_OUT -> EasingInterpolator(Easings.QUAD_IN_OUT)

                        CUBIC_IN -> EasingInterpolator(Easings.CUBIC_IN)
                        CUBIC_OUT -> EasingInterpolator(Easings.CUBIC_OUT)
                        CUBIC_IN_OUT -> EasingInterpolator(Easings.CUBIC_IN_OUT)

                        QUARTIC_IN -> EasingInterpolator(Easings.QUART_IN)
                        QUARTIC_OUT -> EasingInterpolator(Easings.QUART_OUT)
                        QUARTIC_IN_OUT -> EasingInterpolator(Easings.QUART_IN_OUT)

                        QUINTIC_IN -> EasingInterpolator(Easings.QUINT_IN)
                        QUINTIC_OUT -> EasingInterpolator(Easings.QUINT_OUT)
                        QUINTIC_IN_OUT -> EasingInterpolator(Easings.QUINT_IN_OUT)

                        EXPONENTIAL_IN -> EasingInterpolator(Easings.EXP_IN)
                        EXPONENTIAL_OUT -> EasingInterpolator(Easings.EXP_OUT)
                        EXPONENTIAL_IN_OUT -> EasingInterpolator(Easings.EXP_IN_OUT)

                        CIRCULAR_IN -> EasingInterpolator(Easings.CIRC_IN)
                        CIRCULAR_OUT -> EasingInterpolator(Easings.CIRC_OUT)
                        CIRCULAR_IN_OUT -> EasingInterpolator(Easings.CIRC_IN_OUT)

                        BACK_IN -> EasingInterpolator(Easings.BACK_IN)
                        BACK_OUT -> EasingInterpolator(Easings.BACK_OUT)
                        BACK_IN_OUT -> EasingInterpolator(Easings.BACK_IN_OUT)

                        ELASTIC_IN -> EasingInterpolator(Easings.ELASTIC_IN)
                        ELASTIC_OUT -> EasingInterpolator(Easings.ELASTIC_OUT)
                        ELASTIC_IN_OUT -> EasingInterpolator(Easings.ELASTIC_IN_OUT)

                        BOUNCE_IN -> EasingInterpolator(Easings.BOUNCE_IN)
                        BOUNCE_OUT -> EasingInterpolator(Easings.BOUNCE_OUT)
                        BOUNCE_IN_OUT -> EasingInterpolator(Easings.BOUNCE_IN_OUT)
                        else -> LinearInterpolator()
                    }
            )
            title.text = mData?.get(adapterPosition)
        }
    }
}
