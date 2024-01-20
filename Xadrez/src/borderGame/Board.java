package borderGame;
public class Board {
    private int rows;
    private int columns;
    private Piece[][] pieces;

    public Board(int rows, int columns) {
        if (rows < 1 || columns < 1){
            throw new BoardException("Erro ao criar o tabuleiro: deve haver pelo menos 1 linha e 1 coluna");
        }
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }


    // Retorna a peça localizada nas coordenadas especificadas
     public Piece piece(int row, int column){
        if (!positionExists(row, column)){
            throw new BoardException("A posição não foi encontrada no tabuleiro");
        }
         // Retorna a peça na posição especificada
        return pieces[row][column];
     }

    // Retorna a peça localizada na posição especificada
    public Piece piece(Position position){
        if (!positionExists(position)){
            throw new BoardException("A posição não foi encontrada no tabuleiro");
        }
        // Retorna a peça na posição especificada
        return pieces[position.getRow()][position.getColumn()];
    }

    // Remove e retorna a peça na posição especificada
    public Piece removePiece(Position position) {
        if (!positionExists(position)) {
            throw new BoardException("A posição não foi encontrada no tabuleiro");
        }
        // Verifica se há uma peça na posição
        if (piece(position) == null) {
            return null;
        }

        // Remove a peça da posição e retorna a peça removida
        Piece aux = piece(position);
        aux.position = null;
        pieces[position.getRow()][position.getColumn()] = null;
        return aux;
    }

    // Coloca uma peça na posição especificada
    public void placePiece(Piece piece, Position position){
        // Verifica se já existe uma peça na posição
        if (thereIsaAPiece(position)) {
            throw new BoardException("Já existe uma peça na posição " + position);
        }
        // Coloca a peça na posição especificada
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }


    // Verifica se a posição especificada existe no tabuleiro
    public boolean positionExists(int row, int column){
       return row >= 0 && row < rows && column >= 0 && column < columns;
    }
    // Verifica se a posição especificada existe no tabuleiro
    public Boolean positionExists(Position position){
        return  positionExists(position.getRow(), position.getColumn());
    }

    // Verifica se há uma peça na posição especificada
    public boolean thereIsaAPiece(Position position){
        if (!positionExists(position)){
            throw new BoardException("A posição não foi encontrada no tabuleiro");
        }
        // Retorna true se houver uma peça na posição, false caso contrário
       return piece(position) != null;
    }
}
