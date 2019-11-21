package ac.th.ssru.tarou.calculate.view

import ac.th.ssru.tarou.calculate.R
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView

class ItemCustomView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {
    var ivImg:ImageView? = null
    var tvTitle:TextView? = null
    var tvDetail:TextView? = null

    init {
        initInflate(context)
        bindView()
    }

    private fun initInflate(context: Context) {
        View.inflate(context, R.layout.item_custom_view, this)
    }

    private fun bindView() {
        ivImg = findViewById(R.id.ivImg)
        tvTitle = findViewById(R.id.tvTitle)
        tvDetail = findViewById(R.id.tvDetail)
    }

    fun setImage(resId:Int){
        ivImg?.setImageResource(resId)
    }
    fun setTitle(resId:Int){
        tvTitle?.setText(resId)
    }
    fun setDetail(resId:Int){
        tvDetail?.setText(resId)
    }

}