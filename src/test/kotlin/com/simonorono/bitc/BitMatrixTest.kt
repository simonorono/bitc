package com.simonorono.bitc

import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class BitMatrixTest {
    @Test
    fun `test initialization`() {
        val bitMatrix = BitMatrix(20, 30)

        assertEquals(20, bitMatrix.rows)
        assertEquals(30, bitMatrix.columns)
    }

    private fun testGetterAndSetterInMatrix(bitMatrix: BitMatrix) {
        for (i in bitMatrix.rowIndices) {
            for (j in bitMatrix.columnIndices) {
                bitMatrix[i, j] = i == j
            }
        }

        for (i in bitMatrix.rowIndices) {
            for (j in bitMatrix.columnIndices) {
                if (i == j) {
                    assertTrue { bitMatrix[i, j] }
                } else {
                    assertFalse { bitMatrix[i, j] }
                }
            }
        }
    }

    @Test
    fun `test getter and setter`() {
        testGetterAndSetterInMatrix(BitMatrix(3, 5))
        testGetterAndSetterInMatrix(BitMatrix(5, 3))
        testGetterAndSetterInMatrix(BitMatrix(200, 300))
        testGetterAndSetterInMatrix(BitMatrix(300, 200))
    }

    @Test
    fun `test out of bounds exceptions`() {
        val bitMatrix = BitMatrix(5, 5)

        assertDoesNotThrow {
            bitMatrix[0, 0]
            bitMatrix[4, 4]
        }

        assertThrows<IndexOutOfBoundsException> { bitMatrix[5, 5] }
        assertThrows<IndexOutOfBoundsException> { bitMatrix[1, 5] }
        assertThrows<IndexOutOfBoundsException> { bitMatrix[10, 10] }
    }
}