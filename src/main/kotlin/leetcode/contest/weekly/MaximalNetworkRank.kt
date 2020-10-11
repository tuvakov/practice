package leetcode.contest.weekly

/*
 * Link: https://leetcode.com/problems/maximal-network-rank/
 */

class MaximalNetworkRank {
    fun maximalNetworkRank(n: Int, roads: Array<IntArray>): Int {
        val infra = Array(n) { HashSet<Int>() }
        for (road in roads) {
            val (a, b) = road
            infra[a].add(b)
            infra[b].add(a)
        }

        var answer = 0
        for (i in 0..infra.lastIndex) {
            for (j in i + 1..infra.lastIndex) {
                val l = infra[i].size + infra[j].size
                answer = if (i in infra[j])
                    maxOf(answer, l - 1)
                else
                    maxOf(answer, l)
            }
        }
        return answer
    }
}