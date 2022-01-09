package com.simonorono.bitc

class BitArray(val size: Int) {
    private val innerArray = Array(
        1.coerceAtLeast(
            Math.ceil(size.toDouble() / Int.SIZE_BITS.toDouble()).toInt()
        )
    ) { 0 }

    private fun checkBounds(idx: Int) {
        if (idx < 0 || idx > size) {
            throw IndexOutOfBoundsException()
        }
    }

    operator fun get(idx: Int): Boolean {
        checkBounds(idx)

        return (innerArray[idx / Int.SIZE_BITS] and (1 shl (idx % Int.SIZE_BITS))) != 0
    }

    operator fun set(idx: Int, value: Boolean) {
        checkBounds(idx)

        val current = innerArray[idx / Int.SIZE_BITS]

        if (value) {
            innerArray[idx / Int.SIZE_BITS] =
                current or (1 shl (idx % Int.SIZE_BITS))
        } else {
            innerArray[idx / Int.SIZE_BITS] =
                current and (1 shl (idx % Int.SIZE_BITS)).inv()
        }
    }

    val indices: IntRange
        get() = IntRange(0, size - 1)
}
