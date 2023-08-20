import jogoDaVelha.Jogador
import jogoDaVelha.Partida

fun main() {

    val  jogador1 = Jogador('X', "Jogador 1")
    val jogador2 = Jogador('O', "Jogador 2")

    val partida = Partida(jogador1, jogador2)

    while (!partida.fimDoJogo()){
        partida.mostrarTabuleiro()

    }
}