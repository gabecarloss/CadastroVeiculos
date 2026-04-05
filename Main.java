import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void ordenarPorNome(ArrayList<Veiculo>lista) {
        for (int i = 0; i < lista.size() - 1; i++) {
            for (int j = 0; j < lista.size() - 1 - i; j++) {

                Veiculo atual = lista.get(j);
                Veiculo proximo = lista.get(j + 1);

                if (atual.getNome().compareToIgnoreCase(proximo.getNome()) > 0) {

                    lista.set(j, proximo);
                    lista.set(j + 1, atual);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Veiculo> lista = new ArrayList<>();

        while (true){
            System.out.println("""
    \nSeja bem-vindo ao SCV!
    
    Selecione uma das opções abaixo:
    1 - Cadastrar veículo
    2 - Verificar veículos cadastrados
    3 - Remover veículo por índice
    4 - Remover veículo por placa
    5 - Buscar veículo por nome
    6 - Editar veículo cadastrado
    7 - Sair
    """);

            int numero = scanner.nextInt();
            scanner.nextLine();

            if (numero == 1) {
                System.out.println("\nDigite o nome do veículo que deseja cadastrar: ");
                String nome = scanner.nextLine();

                while (nome.isEmpty()){
                    System.out.println("Você deve digitar um nome.");
                    nome = scanner.nextLine();
                }

                System.out.println("\nDigite a marca do veículo que deseja cadastrar: ");
                String marca = scanner.nextLine();

                while (marca.isEmpty()){
                    System.out.println("Você deve digitar uma marca.");
                    marca = scanner.nextLine();
                }

                System.out.println("\nDigite a placa do veículo que deseja cadastrar: ");
                String placa = scanner.nextLine();

                while (placa.isEmpty()){
                    System.out.println("Você deve digitar uma placa.");
                    placa = scanner.nextLine();
                }

                boolean existe = false;
                for (Veiculo veiculo : lista) {
                    if (veiculo.getPlaca().equalsIgnoreCase(placa)) {
                        existe = true;
                        break;
                    }
                }

//                    ESSE SISTEMA REALIZA A VALIDAÇÃO DE DUPLICATAS ATRAVÉS DA PLACA DO VEÍCULO, NÃO DO NOME, ASSIM POSSIBILITANDO MELHOR CONTROLE DA FROTA DE VEÍCULOS.

                if (existe){
                    System.out.println("\nJá foi cadastrado um veículo com essa placa.");
                } else {
                        Veiculo v = new Veiculo(nome, marca, placa);
                        lista.add(v);
                        System.out.println("\nVeículo " + nome + ", da marca " + marca + ", de placa " + placa + " cadastrado com sucesso!");
                }
            }

            else if (numero == 2) {

                ordenarPorNome(lista);

                if (lista.size() > 0) {
                    System.out.println("\nVeículos cadastrados: ");
                    for (int i = 0; i < lista.size(); i++) {
                        System.out.println(i + " - " + lista.get(i));
                    }
                } else {
                    System.out.println("\nNenhum veículo foi cadastrado.");
                }
                System.out.println("\nTotal de veículos cadastrados: " + lista.size() + ".");
            }

            else if (numero == 3){
                if (lista.isEmpty()){
                    System.out.println("\nNenhum veículo disponível.");
                } else {
                    System.out.println("\nDigite o índice do veículo que deseja remover: ");
                    int indice = scanner.nextInt();
                        if (indice >= 0 && indice < lista.size()) {
                        Veiculo removido = lista.get(indice);
                        lista.remove(indice);
                        System.out.println("\nVeículo removido: " + removido);
                    } else {
                        System.out.println("\nVeículo não encontrado.");
                    }
                }
            }

            else if (numero == 4) {
                if (lista.isEmpty()) {
                    System.out.println("Nenhum veículo disponível.");
                } else {
                    System.out.println("\nDigite a placa do veículo que deseja remover: ");
                    String removerPlaca = scanner.nextLine();
                    boolean existe = false;

                    for (int i = 0; i < lista.size(); i++) {
                        Veiculo veiculo = lista.get(i);

                        if (veiculo.getPlaca().equalsIgnoreCase(removerPlaca)) {
                            lista.remove(i);
                            System.out.println("\nVeículo " + veiculo + " removido.");

                            existe = false;
                            break;
                        }
                        if (!existe) {
                            System.out.println("\nNão foi encontrado nenhum veículo correspondente com essa placa.");

//                          AO INVÉS DE ADICIONAR A OPÇÃO ALTERNATIVA DE REMOÇÃO ATRAVÉS DO NOME, DECIDI ADICIONAR ATRAVÉS DA PLACA, JÁ QUE É A METODOLOGIA DE VALIDAÇÃO DE DUPLICATAS DO SISTEMA.

                        }
                    }
                }
            }

            else if (numero == 5) {

                ordenarPorNome(lista);

                System.out.println("\nDigite o nome do veículo: ");
                String nomeVeiculo = scanner.nextLine();

                boolean encontrado = false;

                for (Veiculo veiculo : lista) {
                    if (veiculo.getNome().equalsIgnoreCase(nomeVeiculo)) {
                        System.out.println("\nVeículo encontrado: " + veiculo);
                        encontrado = true;
                    }
                }
                if (!encontrado) {
                    System.out.println("\nNenhum veículo encontrado com esse nome.");
                }

                System.out.println("\nTotal de veículos cadastrados: " + lista.size() + ".");
            }

            else if (numero == 6) {

                if (lista.isEmpty()){
                    System.out.println("Nenhum veículo disponível.");
                } else {
                    System.out.println("\nDigite -1 para editar o nome, -2 para editar a marca e -3 para editar a placa.");
                    int resposta = scanner.nextInt();

                    if (resposta == -1) {
                        System.out.println("Digite o índice do veículo que deseja alterar o nome: ");
                        int indice = scanner.nextInt();
                        scanner.nextLine();

                        if (indice >= 0 && indice < lista.size()) {
                            Veiculo veiculo = lista.get(indice);
                            System.out.println("\nDigite o novo nome: ");
                            String novoNome = scanner.nextLine();

                            if (novoNome.isEmpty()) {
                                System.out.println("\nO nome não pode estar vazio");
                            } else {
                                veiculo.setNome(novoNome);
                                System.out.println("\nNome do veículo " + indice + " alterado com sucesso!");
                            }
                        }
                    }

                    if (resposta == -2) {
                        System.out.println("Digite o índice do veículo que deseja alterar a marca: ");
                        int indice = scanner.nextInt();
                        scanner.nextLine();

                        if (indice >= 0 && indice < lista.size()) {
                            Veiculo veiculo = lista.get(indice);
                            System.out.println("\nDigite a nova marca: ");
                            String novaMarca = scanner.nextLine();

                            if (novaMarca.isEmpty()) {
                                System.out.println("\nA marca não pode estar vazia.");
                            } else {
                                veiculo.setMarca(novaMarca);
                                System.out.println("\nMarca do veículo " + indice + " alterada com sucesso!");
                            }
                        }
                    }

                    if (resposta == -3) {
                        System.out.println("Digite o índice do veículo que deseja alterar a placa: ");
                        int indice = scanner.nextInt();
                        scanner.nextLine();

                        if (indice >= 0 && indice < lista.size()) {
                            Veiculo veiculo = lista.get(indice);
                            System.out.println("\nDigite a nova placa: ");
                            String novaPlaca = scanner.nextLine();

                            if (novaPlaca.isEmpty()) {
                                System.out.println("\nA placa não pode estar vazia.");
                            } else {
                                veiculo.setPlaca(novaPlaca);
                                System.out.println("\nPlaca do veículo " + indice + " alterada com sucesso!");
                            }
                        }
                    }
                }
            }

            else if (numero == 7){
                System.out.println("\nSaindo...");
                break;
            }
        }
    }
}
