package com.simonorono.bitc

/**
 * The BitArray class represents an array of booleans. It stores them packed
 * inside regular integers to not waste the overhead of storing booleans.
 *
 * @property size The size of the array
 */
class BitArray(val size: Int) {
    private val innerArray = IntArray(
        1.coerceAtLeast(
            Math.ceil(size.toDouble() / Int.SIZE_BITS.toDouble()).toInt()
        )
    ) { 0 }

    private fun checkBounds(idx: Int) {
        if (idx < 0 || idx > size) {
            throw IndexOutOfBoundsException()
        }
    }

    /**
     * Retrieve the value at position [idx].
     */
    operator fun get(idx: Int): Boolean {
        checkBounds(idx)

        return (innerArray[idx / Int.SIZE_BITS] and (1 shl (idx % Int.SIZE_BITS))) != 0
    }

    /**
     * Sets the value at position [idx].
     */
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

    /**
     * The range of indices of the array.
     */
    val indices: IntRange
        get() = IntRange(0, size - 1)
}
