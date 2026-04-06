
package javaapplication4;

/**
 *
 * @author enric
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {// Criando usuário
       
        Usuario user1 = new Usuario("Enrico", "enrico@email.com", "1234");

        // Testando login
        if (user1.login("enrico@email.com", "1234")) {
            System.out.println("Login realizado com sucesso!");
        } else {
            System.out.println("Erro no login!");
        }

        // Criando tarefa
        Tarefa tarefa1 = new Tarefa("Estudar Java", "Revisar POO", user1);

        // Exibindo tarefa
        tarefa1.exibirTarefa();

        // Atualizando status
        tarefa1.atualizarStatus("Concluída");

        System.out.println("\nApós atualização:");
        tarefa1.exibirTarefa();

        // Criando log
        Log log1 = new Log(1, "Tarefa atualizada", "22/03/2026", user1);
        log1.registrarAcao();
        
        new LoginFrame();
        
        new TelaLogin().setVisible(true);

        // TODO code application logic here
    }
    
}
