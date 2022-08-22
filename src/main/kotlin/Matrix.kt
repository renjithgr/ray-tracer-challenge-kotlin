import org.jetbrains.kotlinx.multik.api.mk
import org.jetbrains.kotlinx.multik.api.ndarray
import org.jetbrains.kotlinx.multik.default.linalg.DefaultLinAlgEx.dotMM
import org.jetbrains.kotlinx.multik.ndarray.data.D2
import org.jetbrains.kotlinx.multik.ndarray.data.NDArray


class Matrix private constructor(private var data: NDArray<Int, D2>) {

    operator fun times(b: Matrix) : Matrix {
        val newData = dotMM(data, b.data)
        return Matrix(newData)
    }

    override fun toString(): String {
        return data.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other?.javaClass != javaClass) return false

        other as Matrix

        if (data != other.data) return false

        return true
    }

    override fun hashCode(): Int {
        return data.hashCode()
    }

    companion object {
        fun new(vararg arrays: IntArray): Matrix = Matrix(mk.ndarray(arrayOf(*arrays)))
    }
}