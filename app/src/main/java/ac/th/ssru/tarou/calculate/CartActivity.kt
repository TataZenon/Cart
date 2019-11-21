package ac.th.ssru.tarou.calculate

import ac.th.ssru.tarou.calculate.dao.Item
import ac.th.ssru.tarou.calculate.utils.Cart
import ac.th.ssru.tarou.calculate.view.ItemCustomView
import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

class CartActivity : AppCompatActivity() {
    var itemList: MutableList<Item> = mutableListOf()
    var price: Double = 0.0
    var ivBack: ImageView? = null
    var tvPrice: TextView? = null
    var btnPaid: Button? = null
    var llContainer: LinearLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        bindView()
        initView()
    }

    private fun initView() {
        ivBack?.setOnClickListener { onBackPressed() }
        btnPaid?.setOnClickListener{ onPaidRequest()}

        itemList = Cart.getItemList()
        price = itemList.size * 200.0
        tvPrice?.text = price.toString()

        for (item in itemList){
            val itemView = ItemCustomView(llContainer?.context!!)
            itemView.setImage(item.resImage)
            itemView.setTitle(item.resTitle)
            itemView.setDetail(item.resDetail)
            //itemView.setOnClickListener{ onOpenPageDetail(item)}
            llContainer?.addView(itemView)
        }
    }

    private fun onPaidRequest() {
        setResult(Activity.RESULT_OK)
        finish()
    }

    override fun onBackPressed() {
        setResult(Activity.RESULT_CANCELED)
        finish()
    }


    private fun bindView() {
        ivBack = findViewById(R.id.ivBack)
        tvPrice = findViewById(R.id.tvPrice)
        btnPaid = findViewById(R.id.btnPaid)
        llContainer = findViewById(R.id.llContainer)

    }
}
