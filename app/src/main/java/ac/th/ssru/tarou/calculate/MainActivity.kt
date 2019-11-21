package ac.th.ssru.tarou.calculate

/*import ac.th.ssru.tarou.calculate.PageDetailActivity.Companion.DETAIL_KEY
import ac.th.ssru.tarou.calculate.PageDetailActivity.Companion.IMAGE_KEY
import ac.th.ssru.tarou.calculate.PageDetailActivity.Companion.TITLE_KEY*/
import ac.th.ssru.tarou.calculate.PageDetailActivity.Companion.DATA_KEY
import ac.th.ssru.tarou.calculate.dao.Item
import ac.th.ssru.tarou.calculate.utils.Cart
import ac.th.ssru.tarou.calculate.utils.Mock
import ac.th.ssru.tarou.calculate.view.ItemCustomView
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes


class MainActivity : AppCompatActivity()/*, View.OnClickListener*/ {
    var itemList: MutableList<Item> = mutableListOf()
    var llContainer: LinearLayout? = null
    var tvCart: TextView? = null
    var rlCart: RelativeLayout? = null
/*
    var llImg1: ItemCustomView? = null
    var llImg2: ItemCustomView? = null
    var llImg3: ItemCustomView? = null
    var llImg4: ItemCustomView? = null
    var llImg5: ItemCustomView? = null
    var llImg6: ItemCustomView? = null
    var llImg7: ItemCustomView? = null
    var llImg8: ItemCustomView? = null
*/


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bindView()
        initView()
    }

    private fun initView() {
        rlCart?.setOnClickListener { onOpenCartPage() }
        itemList = Mock.getListItem()


        for (item in itemList) {
            val itemView = ItemCustomView(llContainer?.context!!)
            itemView.setImage(item.resImage)
            itemView.setTitle(item.resTitle)
            itemView.setDetail(item.resDetail)
            itemView.setOnClickListener { onOpenPageDetail(item) }
            llContainer?.addView(itemView)
        }

    }

    private fun onOpenCartPage() {
        val intent = Intent(this, CartActivity::class.java)
        startActivityForResult(intent, WANT_PAID_REQUEST_CODE)
    }

    private fun onOpenPageDetail(item: Item) {
        val intent = Intent(this, PageDetailActivity::class.java)
        intent.putExtra(DATA_KEY, item)
        startActivityForResult(intent, WANT_BY_REQUEST_CODE)
    }

    private fun bindView() {
        rlCart = findViewById(R.id.rlCart)
        tvCart = findViewById(R.id.tvCart)
        llContainer = findViewById(R.id.llContainer)
    }


    /*private fun initView() {
        llImg1?.setOnClickListener(this)
        llImg2?.setOnClickListener(this)
        llImg3?.setOnClickListener(this)
        llImg4?.setOnClickListener(this)
        llImg5?.setOnClickListener(this)
        llImg6?.setOnClickListener(this)
        llImg7?.setOnClickListener(this)
        llImg8?.setOnClickListener(this)

        llImg1?.setImage(R.drawable.junk)
        llImg2?.setImage(R.drawable.lu)
        llImg3?.setImage(R.drawable.mei)
        llImg4?.setImage(R.drawable.mer)
        llImg5?.setImage(R.drawable.moi)
        llImg6?.setImage(R.drawable.ori)
        llImg7?.setImage(R.drawable.rea)
        llImg8?.setImage(R.drawable.rein)

        llImg1?.setTitle(R.string.str_title1)
        llImg2?.setTitle(R.string.str_title2)
        llImg3?.setTitle(R.string.str_title3)
        llImg4?.setTitle(R.string.str_title4)
        llImg5?.setTitle(R.string.str_title5)
        llImg6?.setTitle(R.string.str_title6)
        llImg7?.setTitle(R.string.str_title7)
        llImg8?.setTitle(R.string.str_title8)

        llImg1?.setDetail(R.string.str_detail1)
        llImg2?.setDetail(R.string.str_detail2)
        llImg3?.setDetail(R.string.str_detail3)
        llImg4?.setDetail(R.string.str_detail4)
        llImg5?.setDetail(R.string.str_detail5)
        llImg6?.setDetail(R.string.str_detail6)
        llImg7?.setDetail(R.string.str_detail7)
        llImg8?.setDetail(R.string.str_detail8)
    }

    private fun bindView() {
        llImg1 = findViewById(R.id.llImg1)
        llImg2 = findViewById(R.id.llImg2)
        llImg3 = findViewById(R.id.llImg3)
        llImg4 = findViewById(R.id.llImg4)
        llImg5 = findViewById(R.id.llImg5)
        llImg6 = findViewById(R.id.llImg6)
        llImg7 = findViewById(R.id.llImg7)
        llImg8 = findViewById(R.id.llImg8)


    }*/

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if (requestCode == WANT_BY_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                val item: Item? = data?.extras?.getParcelable(DATA_KEY)
                if (item != null) {
                    Cart.addItem(item)
                    updateCart()
                } else {
                    Toast.makeText(
                        this,
                        "should be item is not null",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        } else if (requestCode == WANT_PAID_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                Toast.makeText(
                    this,
                    "Thx for paid",
                    Toast.LENGTH_SHORT
                ).show()
                Cart.removeItem()
                updateCart()
            } else if (resultCode == Activity.RESULT_CANCELED) {
                Toast.makeText(
                    this,
                    "Paid cart cancel!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        super.onActivityResult(requestCode, resultCode, data)
    }

    private fun updateCart() {
        tvCart?.text = "${Cart.getItemList().size}"
    }

    companion object {
        const val WANT_BY_REQUEST_CODE = 999
        const val WANT_PAID_REQUEST_CODE = 888
    }
}