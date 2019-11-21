package ac.th.ssru.tarou.calculate.utils

import ac.th.ssru.tarou.calculate.dao.Item

object Cart {
    private val itemList: MutableList<Item> = mutableListOf()

    fun getItemList() : MutableList<Item> {
        return itemList
    }

    fun addItem(item: Item) {
        itemList.add(item)
    }

    fun removeItem() {
        itemList.clear()
    }
}