import br.desafio.dominio.*;

import java.time.LocalDate;
import java.util.*;

public class Main {

    private static Set<Conteudo> conteudos = new HashSet<>();
    public static void main(String[] args) {

        gerarConteudos();

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição Bootcamp Java Developer");
        bootcamp.getConteudos().addAll(conteudos);
        conteudos.clear();

        Dev dev1 = new Dev("Camila");
        dev1.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos:" + dev1.getNome() + dev1.getConteudosInscritos());
        dev1.progredir();
        dev1.progredir();
        System.out.println("-");
        System.out.println("Conteúdos Inscritos:" + dev1.getNome() + dev1.getConteudosInscritos());
        System.out.println("Conteúdos Concluídos:" + dev1.getNome() + dev1.getConteudosConcluidos());
        System.out.println("XP:" + dev1.calcularTotalXp());

        System.out.println("-------");

        Dev dev2 = new Dev("Osnir");
        dev2.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos:" + dev2.getNome() + dev2.getConteudosInscritos());
        dev2.progredir();
        dev2.progredir();
        dev2.progredir();
        System.out.println("-");
        System.out.println("Conteúdos Inscritos João:" + dev2.getNome() + dev2.getConteudosInscritos());
        System.out.println("Conteúdos Concluidos João:" + dev2.getNome() + dev2.getConteudosConcluidos());
        System.out.println("XP:" + dev2.calcularTotalXp());
    }

    public static void gerarConteudos() {
        try (Scanner scanner = new Scanner(System.in)){
            System.out.print("Quantos conteudos você gostaria de gerar? ");
            int numeroConteudos = scanner.nextInt();

            for (int i = 0; i < numeroConteudos; i++) {
                int escolhaConteudo = 0;
                while (escolhaConteudo != 1 && escolhaConteudo != 2) {
                    System.out.print("Qual conteúdo você gostaria de gerar? Digite 1 para Curso. Digite 2 para Mentoria. ");
                    escolhaConteudo = scanner.nextInt();

                    if (escolhaConteudo == 1) {
                        criarCurso(scanner);
                    } else if (escolhaConteudo == 2) {
                        criarMentoria(scanner);
                    } else {
                        System.err.println("Ops.. Você digitou o número errado! Tente novamente");
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void criarCurso(Scanner scanner) {
        scanner.nextLine();
        Curso curso = new Curso();

        System.out.println("Digite o titulo do curso: ");
        String titulo = scanner.nextLine();
        System.out.println("Digite a descrição do curso: ");
        String descricao = scanner.nextLine();
        System.out.println("Digite a carga horária do curso: ");
        int cargaHoraria = scanner.nextInt();

        curso.setTitulo(titulo);
        curso.setDescricao(descricao);
        curso.setCargaHoraria(cargaHoraria);

        conteudos.add(curso);
    }

    public static void criarMentoria(Scanner scanner) {
        scanner.nextLine();
        Mentoria mentoria = new Mentoria();

        System.out.println("Digite o titulo da mentoria: ");
        String titulo = scanner.nextLine();
        System.out.println("Digite a descrição da mentoria: ");
        String descricao = scanner.nextLine();
        System.out.println("Digite o dia da mentoria: ");
        int dia = scanner.nextInt();
        System.out.println("Digite o mês da mentoria: ");
        int mes = scanner.nextInt();

        mentoria.setTitulo(titulo);
        mentoria.setDescricao(descricao);
        mentoria.setData(LocalDate.of(LocalDate.now().getYear(), mes, dia));

        conteudos.add(mentoria);
    }
}