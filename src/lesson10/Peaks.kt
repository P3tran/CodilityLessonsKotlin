package lesson10

import java.util.ArrayList

/*
* Find the maximum number of blocks that contain picks
* */

class Peaks {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val result = solution(intArrayOf(1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2))
            println("result :  $result")

        }

        fun solution(A: IntArray): Int {

            // main idea:
            // 1) find all the peaks, and put them into a List
            // 2) try to divide the array into a number of groups,
            //    and check if all the groups have at least one peak
            //--> if yes, return the "number of groups"

            val peaksIndexList = ArrayList<Int>()

            for (i in 1 until A.size - 1) {
                if (A[i - 1] < A[i] && A[i] > A[i + 1]) {
                    peaksIndexList.add(i)
                }
            }

            // 2) check the number of Blocks
            val N = A.size

            // from the "biggest possible number" to smaller number
            for (numBlocks in N downTo 1) {

                if (N % numBlocks == 0) { // it is divisible

                    val blockSize = N / numBlocks
                    var ithOkBlock = 0  // the ith block has peak(s)

                    // test all the peaks
                    // if a peak is found in the ith block
                    // then, go to the (i+1)th block
                    for (peaksIndex in peaksIndexList) {
                        if (peaksIndex / blockSize == ithOkBlock) { // peak in the ith block
                            ithOkBlock++ // go to check (i+1)th block
                        }
                    }

                    // ithOkBlock: the number of blocks having peak(s)
                    // if all the blocks have peak(s)
                    // then, return the number of blocks
                    // note: we test from the biggest possible number
                    // so, once we find it, we can just return it
                    // (no need to check the smaller possible numbers)
                    if (ithOkBlock == numBlocks) {
                        return numBlocks
                    }
                }
            }

            return 0
        }
    }
}