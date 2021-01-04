import java.util.*

/**
给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。

注意:

可以认为区间的终点总是大于它的起点。
区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
示例 1:

输入: [ [1,2], [2,3], [3,4], [1,3] ]

输出: 1

解释: 移除 [1,3] 后，剩下的区间没有重叠。
示例 2:

输入: [ [1,2], [1,2], [1,2] ]

输出: 2

解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
示例 3:

输入: [ [1,2], [2,3] ]

输出: 0

解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
 */

class NonOverlappingIntervals {
    fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
        if (intervals == null || intervals.size < 2) return 0
        Arrays.sort(intervals) { a1, a2 ->
            a1[1] - a2[1]
        }
        var removed = 0
        var preArray: IntArray = intervals[0]
        for (i in 1 until intervals.size) {
            val cur = intervals[i]
            if (cur[0] >= preArray[1]) {
                preArray = cur
            } else {
                removed++
            }
        }
        return removed
    }
}

fun main() {
    NonOverlappingIntervals().eraseOverlapIntervals(arrayOf(intArrayOf(1, 2), intArrayOf(2, 3)))
}