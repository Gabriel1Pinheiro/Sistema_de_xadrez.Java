package borderGame;

// Classe de exceção personalizada para erros relacionados ao tabuleiro do jogo
public class BoardException extends RuntimeException {
    // Número de versão para controle de serialização
    private static final long serialVersionUID = 1L;
    public BoardException(String msg){
        // Chama o construtor da superclasse (RuntimeException) com a mensagem
        super(msg);
    }

}
