package ac.th.ssru.tarou.calculate

import ac.th.ssru.tarou.calculate.dao.Item
import android.app.Activity
import android.content.ClipData
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PageDetailActivity: AppCompatActivity() {
    /*var resImage: Int? = 0
    var resTitle: Int? =0
    var resDetail: Int? =0*/

    var item: Item? = null

    var ivImage: ImageView? = null
    var ivBack: ImageView? = null
    var tvTitle: TextView? = null
    var tvDetail: TextView? = null
    var btnBuy: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page_detail)

        getData()
        bindView()
        initView()
    }

    private fun getData() {
        val extra = intent.extras
        item = extra?.getParcelable(DATA_KEY)
    }

    private fun initView() {
        ivBack?.setOnClickListener{onBackPressed()}
        btnBuy?.setOnClickListener{onBuyItem(item)}
        if (item !=null) {

            ivImage?.setImageResource(item!!.resImage)
            tvTitle?.setText(item!!.resTitle)
            tvDetail?.setText(item!!.resDetail)

        }

    }

    private fun onBuyItem(item: Item?) {
        val data = Intent()
        data.putExtra(DATA_KEY, item)
        setResult(Activity.RESULT_OK, data)
        finish()
    }

    override fun onBackPressed() {
        setResult(Activity.RESULT_CANCELED)
        finish()
    }
    private fun bindView() {
        ivImage = findViewById(R.id.ivImage)
        tvTitle = findViewById(R.id.tvTitle)
        tvDetail = findViewById(R.id.tvDetail)
        ivBack = findViewById(R.id.ivBack)
        btnBuy = findViewById(R.id.btnBuy)

    }

/*    private fun getData() {
        val arge = intent.extras
        resImage = arge?.getInt(IMAGE_KEY, R.drawable.junk)
        resTitle = arge?.getInt(TITLE_KEY, R.string.str_title1)
        resDetail = arge?.getInt(DETAIL_KEY, R.string.str_detail1)

    }*/

    companion object {
        const val  DATA_KEY: String = "data"
        /*const val  IMAGE_KEY:String = "image"
        const val  TITLE_KEY:String = "title"
        const val  DETAIL_KEY:String = "detail"*/
    }

}