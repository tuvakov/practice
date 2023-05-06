import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class FirstMissingPositiveTest {

    private val subject = FirstMissingPositive()

    @ParameterizedTest
    @MethodSource("arguments")
    fun firstMissingPositive(arr: IntArray, expected: Int) {
        val result = subject.firstMissingPositive(arr)
        assertEquals(expected, result)
    }

    @ParameterizedTest
    @MethodSource("arguments")
    fun firstMissingPositive2(arr: IntArray, expected: Int) {
        val result = subject.firstMissingPositive2(arr)
        assertEquals(expected, result)
    }

    companion object {
        @JvmStatic
        fun arguments(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    intArrayOf(2, 3, 4, 5), 1
                ),
                Arguments.of(
                    intArrayOf(1, 2, 3, 5, 6, 7, 8), 4
                ),
                Arguments.of(
                    intArrayOf(1, 2, 3, 4, 5, 6, 7, 8), 9
                ),
                Arguments.of(
                    intArrayOf(-1, -2, -3, 4, 5, 6, 7, 8), 1
                ),
                Arguments.of(
                    intArrayOf(-1, -2, -3, 1, 2, 3, 5, 6, 7, 8), 4
                ),
                Arguments.of(
                    intArrayOf(1, 2, 0), 3
                ),
                Arguments.of(
                    intArrayOf(3, 4, -1, 1), 2
                ),
                Arguments.of(
                    intArrayOf(7, 8, 9, 11, 12), 1
                ),
                Arguments.of(
                    intArrayOf(1), 2
                ),
                Arguments.of(
                    intArrayOf(1, 1), 2
                ),
                Arguments.of(
                    intArrayOf(1, 2, 3, 4, 4, 8), 5
                ),
                Arguments.of(
                    intArrayOf(-10, -11, -12, -13, -11), 1
                ),
                Arguments.of(
                    intArrayOf(-10, -11, -12, 0, 2, 1), 3
                )
            )
        }
    }
}