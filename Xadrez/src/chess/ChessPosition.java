package chess;

import borderGame.Position;

public class ChessPosition {
    private char column;
    private int row;

    public ChessPosition(char column, int row) {
        // Verifica se os valores de coluna e linha estão dentro dos limites válidos
        if(column < 'a' || column > 'h' || row < 1 || row > 8){
            throw new ChessException("Erro ao instanciar ChessPosition. Os valores válidos são de a1 a h8.");
        }
        this.column = column;
        this.row = row;
    }

    public char getColumn() {
        return column;
    }
    public int getRow() {
        return row;
    }

    // Método para converter a posição ChessPosition para Position do jogo
    protected Position toPosition(){
        return new Position(8 - row, column - 'a');
    }

    // Método estático para criar uma instância de ChessPosition a partir de uma Position do jogo
    protected static ChessPosition fromPosition(Position position){
        return new ChessPosition((char) ('a' + position.getColumn()), 8 - position.getRow());
    }

    // Sobrescrita do método toString para representar a posição como uma string
    @Override
    public String toString(){
        return "" + column + row;
    }

}
