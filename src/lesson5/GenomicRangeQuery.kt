package lesson5

class GenomicRangeQuery {

    /*
    * Calculate presence of minimum valued symbols in string.
    * Represent the data as occurrences array, calculate prefix sums
    * and subtract to find min valued item
    * */

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val result = solution("ACGTTGCACAGTGAGACTCTCGACAGCTAG" , intArrayOf(4,3,5,6,7,16), intArrayOf(0, 1, 2, 1, 4, 10))
            result.forEach {
                print(" $it")
            }
        }

        fun solution(S: String, P: IntArray, Q: IntArray): IntArray {
            val occ = Array(S.length) { IntArray(4) {0} }
            val result = IntArray(P.size)

            for (i in S.indices) {
                when (S[i]) {
                    'A' -> occ[i][0] = 1
                    'C' -> occ[i][1] = 1
                    'G' -> occ[i][2] = 1
                    'T' -> occ[i][3] = 1
                }
            }

            for (i in 1 until S.length) {
                for (j in 0..3) {
                    occ[i][j] += occ[i - 1][j]
                }
            }

            for(i in P.indices) {
                val start = P[i]
                val end = Q[i]
                for(a in 0..3) {
                    var sub = 0
                    if(start - 1 > 0)
                        sub = occ[start-1][a]
                    if(occ[end][a] - sub > 0) {
                        result[i] = a + 1
                        break;
                    }
                }
            }
            return result

        }

    }
}
