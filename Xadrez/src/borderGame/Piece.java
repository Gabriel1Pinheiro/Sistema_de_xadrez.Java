package borderGame;

// Classe abstrata que representa uma peça do jogo
public abstract class Piece {
    protected Position position;
    private Board board;

    public Piece(Board board) {
        this.board = board;
        position = null;
    }
    protected Board getBoard() {
        return board;
    }

    // Método abstrato que deve ser implementado pelas subclasses para calcular os movimentos possíveis da peça
    public abstract boolean[][] possibleMoves();

    // Verifica se é possível mover a peça para a posição especificada
    public boolean possibleMove(Position position){
        return possibleMoves()[position.getRow()][position.getColumn()];
    }

    // Verifica se há algum movimento possível para a peça
    public boolean isThereAnyPossibleMove(){
        boolean[][] mat = possibleMoves();
        for (int i = 0; i < mat.length; i++){
            for (int j = 0; j < mat.length; j++){
                if (mat[i][j]){
                    return true;
                }
            }
        }
        return false;
    }

}
