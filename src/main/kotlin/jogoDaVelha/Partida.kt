package jogoDaVelha

class Partida(private val jogador1: Jogador, private val jogador2: Jogador){
    private var jogadorAtual = jogador1
    private val tabuleiro = Tabuleiro()

    fun escolheJogador(){
        jogadorAtual = if (jogadorAtual == jogador1) jogador2 else jogador1
    }

    fun mostrarTabuleiro() {
        TODO("Not yet implemented")
    }

    fun fimDoJogo(): Boolean {
        return true
    }
}
