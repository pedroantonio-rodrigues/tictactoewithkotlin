package jogoDaVelha

class Partida(private val jogador1: Jogador, private val jogador2: Jogador) {
    var jogadorAtual = jogador1
    val tabuleiro = Tabuleiro()

    fun jogar() {
        while (!fimDoJogo()) {
            mostrarTabuleiro()
            println("${jogadorAtual.nome}, é sua vez.")

            val linha = lerInt("Informe a linha: ")
            val coluna = lerInt("Informe a coluna: ")

            if (fazerJogada(linha, coluna)) {
                if (tabuleiro.verificaVitoria(jogadorAtual.symbol)) {
                    mostrarTabuleiro()
                    println("Parabéns, ${jogadorAtual.nome}! Você venceu!")
                    return
                }
                if (tabuleiro.cheio()) {
                    mostrarTabuleiro()
                    println("Empate! O tabuleiro está cheio.")
                    return
                }
                println("Jogada válida. Alternando jogadores.")
                escolheJogador() // Move essa linha aqui, após a verificação de vitória/empate
            } else {
                println("Jogada inválida. Tente novamente.")
            }
        }
    }

    private fun lerInt(prompt: String): Int {
        print(prompt)
        return readLine()?.toIntOrNull() ?: -1
    }

    fun escolheJogador() {
        jogadorAtual = if (jogadorAtual == jogador1) jogador2 else jogador1
    }

    fun mostrarTabuleiro() {
        tabuleiro.mostrarTabuleiro()
    }

    fun fazerJogada(linha: Int, coluna: Int): Boolean {
        if (tabuleiro.fazerJogada(linha, coluna, jogadorAtual.symbol)) {
            escolheJogador()
            return true
        }
        return false
    }

    fun fimDoJogo(): Boolean {
        return tabuleiro.verificaVitoria(jogador1.symbol) || tabuleiro.verificaVitoria(jogador2.symbol) || tabuleiro.cheio()
    }
}