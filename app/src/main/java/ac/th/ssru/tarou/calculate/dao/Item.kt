package ac.th.ssru.tarou.calculate.dao

import android.os.Parcel
import android.os.Parcelable

data class Item(
    var resImage: Int,
    var resTitle: Int,
    var resDetail: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(resImage)
        parcel.writeInt(resTitle)
        parcel.writeInt(resDetail)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Item> {
        override fun createFromParcel(parcel: Parcel): Item {
            return Item(parcel)
        }

        override fun newArray(size: Int): Array<Item?> {
            return arrayOfNulls(size)
        }
    }

}