package jogoDaVelha

class Tabuleiro (private val size: Int = 3) {
    private val tabuleiro: Array<Array<Char>> = Array(size) { Array(size){' '} }
    fun mostrarTabuleiro(){
        for (linha in tabuleiro){
            for (cell in linha){
                print("$cell")
            }
            println()
        }
    }
    fun fazerJogada(linha: Int, coluna: Int, player: Char): Boolean{
        if(linha < 0 || linha >= size || coluna < 0 || coluna >= size || tabuleiro[linha][coluna] != ' '){
            return false
    }
        tabuleiro[linha][coluna] = player
        return true
    }
}