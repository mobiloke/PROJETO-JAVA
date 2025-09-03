import java.util.Scanner;

public class FormSatisfacao {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Formulário de Satisfação - Atendimento de Demandas ===");
        System.out.println("Por favor, responda às perguntas para avaliarmos o atendimento.\n");

      
        System.out.print("Digite seu nome completo: ");
        String nome = scanner.nextLine().trim();

        
        while (nome.isEmpty()) {
            System.out.print("Nome inválido! Por favor, digite seu nome completo: ");
            nome = scanner.nextLine().trim();
        }

        
        System.out.println("\nQual tipo de demanda você teve? Escolha uma opção:");
        System.out.println("1 - Suporte Técnico");
        System.out.println("2 - Solicitação de Informação");
        System.out.println("3 - Reclamação");
        System.out.println("4 - Sugestão");
        System.out.println("5 - Outro");

        int tipoDemanda = 0;
        while (tipoDemanda < 1 || tipoDemanda > 5) {
            System.out.print("Digite o número correspondente (1 a 5): ");
            if (scanner.hasNextInt()) {
                tipoDemanda = scanner.nextInt();
                if (tipoDemanda < 1 || tipoDemanda > 5) {
                    System.out.println("Opção inválida! Escolha um número entre 1 e 5.");
                }
            } else {
                System.out.println("Entrada inválida! Digite um número.");
                scanner.next();
            }
        }

        scanner.nextLine();

      
        int nota = 0;
        while (nota < 1 || nota > 5) {
            System.out.print("\nPor favor, avalie o atendimento de 1 a 5: ");
            if (scanner.hasNextInt()) {
                nota = scanner.nextInt();
                if (nota < 1 || nota > 5) {
                    System.out.println("Nota inválida! Digite um número entre 1 e 5.");
                }
            } else {
                System.out.println("Entrada inválida! Digite um número.");
                scanner.next();
            }
        }

        scanner.nextLine(); 

        System.out.print("\nDeixe um comentário sobre o atendimento (opcional, pressione Enter para pular): ");
        String comentario = scanner.nextLine().trim();

        
        System.out.println("\n=== Resumo da sua avaliação ===");
        System.out.println("Nome: " + nome);
        System.out.println("Tipo de Demanda: " + tipoDemandaToString(tipoDemanda));
        System.out.println("Nota dada: " + nota);

        if (comentario.isEmpty()) {
            System.out.println("Comentário: (nenhum comentário fornecido)");
        } else {
            System.out.println("Comentário: " + comentario);
        }

        System.out.println("\nMensagem final:");
        switch (nota) {
            case 5:
                System.out.println("Excelente! Muito obrigado pelo seu feedback positivo!");
                break;
            case 4:
                System.out.println("Ótimo! Agradecemos sua avaliação e vamos continuar melhorando.");
                break;
            case 3:
                System.out.println("Bom! Seu feedback é importante para que possamos melhorar.");
                break;
            case 2:
                System.out.println("Sentimos muito que sua experiência não tenha sido boa. Vamos trabalhar para melhorar.");
                break;
            case 1:
                System.out.println("Lamentamos muito que sua experiência tenha sido ruim. Por favor, entre em contato conosco para que possamos ajudar.");
                break;
            default:
                System.out.println("Obrigado por sua avaliação!");
        }

        System.out.println("\nObrigado por participar do nosso formulário!");

        scanner.close();
    }
    private static String tipoDemandaToString(int tipo) {
        return switch (tipo) {
            case 1 -> "Suporte Técnico";
            case 2 -> "Solicitação de Informação";
            case 3 -> "Reclamação";
            case 4 -> "Sugestão";
            case 5 -> "Outro";
            default -> "Desconhecido";
        };
    }
}
