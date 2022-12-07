package leetcode.dfs

/*
 * https://leetcode.com/problems/flood-fill/
 */

class FloodFill {

    fun floodFill(
        image: Array<IntArray>,
        sr: Int,
        sc: Int,
        color: Int
    ): Array<IntArray> {
        innerFloodFill(image, sr, sc, color)
        return image
    }

    private fun innerFloodFill(
        image: Array<IntArray>,
        sr: Int,
        sc: Int,
        color: Int
    ) {
        val sourceColor = image[sr][sc]

        if (sourceColor == color) return

        image[sr][sc] = color

        // up
        if (sr - 1 >= 0 && image[sr - 1][sc] == sourceColor) {
            innerFloodFill(image, sr - 1, sc, color)
        }

        // down
        if (sr + 1 < image.size && image[sr + 1][sc] == sourceColor) {
            innerFloodFill(image, sr + 1, sc, color)
        }

        // left
        if (sc - 1 >= 0 && image[sr][sc - 1] == sourceColor) {
            innerFloodFill(image, sr, sc - 1, color)
        }

        // right
        if (sc + 1 < image[sr].size && image[sr][sc + 1] == sourceColor) {
            innerFloodFill(image, sr, sc + 1, color)
        }
    }
}