import java.util.Random;
import java.util.Scanner;
import AparelhoTelefonico;
import Iphone;

public class UsuarioIphone {
    public static void main(String[] args) {
        Iphone iphone = new Iphone();
        Scanner scan = new Scanner(System.in);
        Random random = new Random();
        boolean tocandoMusica = false;
        boolean tocarTelefone;

        while (true) {
            System.out.println("O que deseja fazer?"
                + "\n1 - Tocar uma música"
                + "\n2 - Pausar uma música"
                + "\n3 - Selecionar uma música"
                + "\n4 - Ligar para alguém"
                + "\n5 - Telefone está tocando?"
                + "\n6 - Exibir Página da Internet"
                + "\n7 - Adicionar Nova Aba"
                + "\n8 - Atualizar Página"
                + "\n0 - Desligar");

            int opcao = scan.nextInt();
            scan.nextLine();  

            switch (opcao) {
                case 1:
                    iphone.tocar();
                    tocandoMusica = true;
                    break;
                case 2:
                    if (!tocandoMusica) {
                        System.out.println("Não há nenhuma música tocando");
                    } else {
                        iphone.pausar();
                        tocandoMusica = false;
                    }
                    break;
                case 3:
                    iphone.selecionarMusica();
                    break;
                case 4:
                    AparelhoTelefonico.ligar();
                    break;
                case 5:
                    tocarTelefone = random.nextBoolean();
                    if (tocarTelefone) {
                        System.out.println("Telefone está tocando...");
                        System.out.println("Deseja atender a ligação? (s/n)");
                        String resposta = scan.nextLine();
                        if (resposta.equalsIgnoreCase("s")) {
                            AparelhoTelefonico.atender();
                        } else {
                            AparelhoTelefonico.iniciarCorreioVoz();
                        }
                    } else {
                        System.out.println("Telefone não está tocando.");
                    }
                    break;
                case 6:
                    System.out.println("O que deseja pesquisar?");
                    String pagina = scan.nextLine();
                    iphone.exibirPagina(pagina);
                    break;
                case 7:
                    iphone.adicionarNovaAba();
                    break;
                case 8:
                    iphone.atualizarPagina();
                    break;
                case 0:
                    System.out.println("Desligando...");
                    scan.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
