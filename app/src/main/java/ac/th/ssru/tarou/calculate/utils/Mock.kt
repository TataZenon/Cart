package ac.th.ssru.tarou.calculate.utils

import ac.th.ssru.tarou.calculate.R
import ac.th.ssru.tarou.calculate.dao.Item

object Mock {
    private val resImageList: MutableList<Int> =
        mutableListOf(
            R.drawable.junk,
            R.drawable.lu,
            R.drawable.mei,
            R.drawable.mer,
            R.drawable.moi,
            R.drawable.ori,
            R.drawable.rea,
            R.drawable.rein
        )
    private val resTitleList: MutableList<Int> =
        mutableListOf(
            R.string.str_title1,
            R.string.str_title2,
            R.string.str_title3,
            R.string.str_title4,
            R.string.str_title5,
            R.string.str_title6,
            R.string.str_title7,
            R.string.str_title8
        )
    private val resDetailList: MutableList<Int> =
        mutableListOf(
            R.string.str_detail1,
            R.string.str_detail2,
            R.string.str_detail3,
            R.string.str_detail4,
            R.string.str_detail5,
            R.string.str_detail6,
            R.string.str_detail7,
            R.string.str_detail8
        )

    private val listItem: MutableList<Item> = mutableListOf()
    fun getListItem(): MutableList<Item> {
        if (listItem.isEmpty()) {
            createItem().apply {
                return listItem
            }
        } else {
            return listItem
        }
    }

    private fun createItem() {
        for ((index, img) in resImageList.withIndex()) {
            val item = Item(img, resTitleList[index], resDetailList[index])
            listItem.add(item)
        }
    }
}

