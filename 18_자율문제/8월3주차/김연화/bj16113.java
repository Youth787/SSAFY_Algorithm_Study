import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = readLine().toInt()
    var base = 0
    for (i in 1 .. n) {
        if (i * 5 == n) {
            base = i
            break
        }
    }

    val signal = readLine().chunked(base)
    val sb = StringBuilder()
    var index = 0

    while (index < base) {
        if (signal[0][index] == '#') {
            if (index + 2 <= base) {
                // 0, 2, 3, 5, 6, 7, 8, 9
                if (signal[0][index + 1] == '#' && signal[0][index + 2] == '#') {
                    sb.append("${converter(index, signal)}")

                    index += 3
                    if (index >= base) break

                    continue
                }
            }

            // 1, 4
            when {
                signal[signal.lastIndex][index] == '#' -> sb.append("1")
                else -> {
                    sb.append("4")

                    index += 3
                    if (index >= base) break
                }
            }
        }

        index++
    }

    bw.write(sb.toString())
    bw.flush()
    bw.close()
}

fun converter(index: Int, signal: List<String>): Int {
    val sb = StringBuilder()
    (0 until 5).forEach { i ->
        (0 until 3).forEach { j ->
            sb.append(signal[i][j + index])
        }
    }

    val arr = arrayOf(
        Pair(0, "####.##.##.####"),
        Pair(2, "###..#####..###"),
        Pair(3, "###..####..####"),
        Pair(5, "####..###..####"),
        Pair(6, "####..####.####"),
        Pair(7, "###..#..#..#..#"),
        Pair(8, "####.#####.####"),
        Pair(9, "####.####..####")
    )

    var result = -1
    for (i in arr.indices) {
        if (sb.toString() == arr[i].second) {
            result = arr[i].first
        }
    }

    return result
}
