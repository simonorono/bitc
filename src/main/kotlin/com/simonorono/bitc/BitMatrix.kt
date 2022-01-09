package com.simonorono.bitc

/**
 * The BitMatrix class represents a two-dimensional array of booleans. It uses
 * a single instance of the [BitArray] class to store the values.
 *
 * @property rows Amount of rows in the matrix.
 * @property columns Amount of columns in the matrix.
 */
class BitMatrix(val rows: Int, val columns: Int) {
    private val bitArray = BitArray(1.coerceAtLeast(rows * columns))

    private fun checkBounds(row: Int, column: Int) {
        if (row >= rows || column >= columns || row < 0 || column < 0) {
            throw IndexOutOfBoundsException()
        }
    }

    /**
     * Gets the value in row [r] and column [c].
     */
    operator fun get(r: Int, c: Int): Boolean {
        checkBounds(r, c)

        return bitArray[r * columns + c]
    }

    /**
     * Sets the value in row [r] and column [c].
     */
    operator fun set(r: Int, c: Int, value: Boolean) {
        checkBounds(r, c)

        bitArray[r * columns + c] = value
    }

    /**
     * The range of valid rows in the matrix.
     */
    val rowIndices: IntRange
        get() = IntRange(0, rows - 1)

    /**
     * The range of valid columns in the matrix.
     */
    val columnIndices: IntRange
        get() = IntRange(0, columns - 1)
}
