import jogoDaVelha.Jogador
import jogoDaVelha.Partida

fun main() {
    val jogador1 = Jogador('X', "Jogador 1")
    val jogador2 = Jogador('O', "Jogador 2")

    val partida = Partida(jogador1, jogador2)

    while (!partida.fimDoJogo()) {
        partida.mostrarTabuleiro()

        println("${partida.jogadorAtual.nome}, é sua vez.")
        val linha = lerInt("Informe a linha: ")
        val coluna = lerInt("Informe a coluna: ")

        if (partida.fazerJogada(linha, coluna)) {
        } else {
            println("Jogada inválida. Tente novamente.")
        }
    }

    partida.mostrarTabuleiro()
    if (partida.tabuleiro.verificaVitoria(jogador1.symbol)) {
        println("Parabéns, ${jogador1.nome}! Você venceu!")
    } else if (partida.tabuleiro.verificaVitoria(jogador2.symbol)) {
        println("Parabéns, ${jogador2.nome}! Você venceu!")
    } else {
        println("Empate! O tabuleiro está cheio.")
    }
}

private fun lerInt(prompt: String): Int {
    print(prompt)
    return readLine()?.toIntOrNull() ?: -1
}
