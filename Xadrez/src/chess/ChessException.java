package chess;

import borderGame.BoardException;

// Classe de exceção personalizada para erros relacionados ao tabuleiro do jogo
public class ChessException  extends BoardException {
    // Número de versão para controle de serialização
    private static final long serialVersionUID = 1L;

    public ChessException(String msg){
        // Chama o construtor da superclasse (RuntimeException) com a mensagem
        super(msg);
    }
}
