package com.simonorono.bitc

import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import java.lang.IndexOutOfBoundsException
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class BitArrayTest {
    @Test
    fun `test initialization`() {
        val bitArrayTest = BitArray(20)

        assertEquals(20, bitArrayTest.size)
    }

    @Test
    fun `test array indices`() {
        val bitArray = BitArray(200)

        assertEquals(0, bitArray.indices.first)
        assertEquals(199, bitArray.indices.last)

        for (idx in bitArray.indices) {
            bitArray[idx] = idx % 2 == 0
        }

        for (idx in bitArray.indices) {
            if (idx % 2 == 0) {
                assertTrue { bitArray[idx] }
            } else {
                assertFalse { bitArray[idx] }
            }
        }
    }

    @Test
    fun `test getter and setter`() {
        val bitArray = BitArray(2000)

        for (idx in bitArray.indices) {
            bitArray[idx] = idx % 2 == 0
        }

        for (idx in bitArray.indices) {
            if (idx % 2 == 0) {
                assertTrue { bitArray[idx] }
            } else {
                assertFalse { bitArray[idx] }
            }
        }
    }

    @Test
    fun `test out of bounds exceptions`() {
        val bitArray = BitArray(30)

        assertDoesNotThrow {
            for (idx in bitArray.indices) {
                bitArray[idx]
            }
        }

        assertThrows<IndexOutOfBoundsException> {
            bitArray[-1]
        }

        assertThrows<IndexOutOfBoundsException> {
            bitArray[31]
        }
    }
}
