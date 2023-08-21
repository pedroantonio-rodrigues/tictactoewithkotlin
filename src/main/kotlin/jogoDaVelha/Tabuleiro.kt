package jogoDaVelha

class Tabuleiro(private val size: Int = 3) {

    private val tabuleiro: Array<Array<Char>> = Array(size) { Array(size) { ' ' } }

    fun mostrarTabuleiro() {
        for (linha in tabuleiro) {
            for (cell in linha) {
                print("$cell ")
            }
            println()
        }
    }

    fun fazerJogada(linha: Int, coluna: Int, player: Char): Boolean {
        if (linha < 0 || linha >= size || coluna < 0 || coluna >= size || tabuleiro[linha][coluna] != ' ') {
            return false
        }
        tabuleiro[linha][coluna] = player
        return true
    }

    // Verifica vitória
    fun verificaVitoria(symbol: Char): Boolean {
        // Verifica linhas e colunas
        for (i in 0 until size) {
            if (tabuleiro[i].all { it == symbol } || tabuleiro.all { it[i] == symbol }) {
                return true
            }
        }

        // Verifica diagonal principal
        if (tabuleiro.all { it[size - tabuleiro.indexOf(it) - 1] == symbol }) {
            return true
        }

        // Verifica diagonal secundária
        if (tabuleiro.all { it[tabuleiro.indexOf(it)] == symbol }) {
            return true
        }

        return false
    }

    // Verifica se o tabuleiro está cheio
    fun cheio(): Boolean {
        return tabuleiro.all { linha -> linha.all { cell -> cell != ' ' } }
    }
}
