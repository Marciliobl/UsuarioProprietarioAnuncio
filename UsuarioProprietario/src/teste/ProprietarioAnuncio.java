package teste;

import java.util.HashMap;
import java.util.Map;

public class ProprietarioAnuncio
 {
    private Map<Integer, Proprietario> proprietarios;

    public ProprietarioAnuncio() {
        this.proprietarios = new HashMap<>();
    }

    public void cadastrarProprietario(int id, String nome, String email, String senha, String endereco, int capacidadeMaxima, String modeloMaquina, int pesoMaquina) {
        Proprietario proprietario = new Proprietario(id, nome, email, senha, endereco, capacidadeMaxima, modeloMaquina, pesoMaquina);
        proprietarios.put(id, proprietario);
    }

    public Proprietario getProprietario(int id) {
        return proprietarios.get(id);
    }

    public static void main(String[] args) {
        ProprietarioAnuncio cadastroProprietarios = new ProprietarioAnuncio();

        // Cadastrar proprietários
        cadastroProprietarios.cadastrarProprietario(1, "João", "joao@example.com", "senha123", "Rua A, 123", 8, "Modelo 1", 10);
        cadastroProprietarios.cadastrarProprietario(2, "Maria", "maria@example.com", "senha456", "Rua B, 456", 5, "Modelo 2", 8);
        cadastroProprietarios.cadastrarProprietario(3, "Pedro", "pedro@example.com", "senha789", "Rua C, 789", 10, "Modelo 3", 12);

        // Obter proprietários
        Proprietario proprietario1 = cadastroProprietarios.getProprietario(1);
        Proprietario proprietario2 = cadastroProprietarios.getProprietario(2);
        Proprietario proprietario3 = cadastroProprietarios.getProprietario(3);

        // Imprimir informações dos proprietários
        System.out.println("Proprietário 1:");
        System.out.println("Nome: " + proprietario1.getNome());
        System.out.println("E-mail: " + proprietario1.getEmail());
        System.out.println("Senha: " + proprietario1.getSenha());
        System.out.println("Endereço: " + proprietario1.getEndereco());
        System.out.println("Capacidade Máxima: " + proprietario1.getCapacidadeMaxima());
        System.out.println("Modelo da Máquina: " + proprietario1.getModeloMaquina());
        System.out.println("Peso da Máquina: " + proprietario1.getPesoMaquina());
        System.out.println();

        System.out.println("Proprietário 2:");
        System.out.println("Nome: " + proprietario2.getNome());
        System.out.println("E-mail: " + proprietario2.getEmail());
        System.out.println("Senha: " + proprietario2.getSenha());
        System.out.println("Endereço: " + proprietario2.getEndereco());
        System.out.println("Capacidade Máxima: " + proprietario2.getCapacidadeMaxima());
        System.out.println("Modelo da Máquina: " + proprietario2.getModeloMaquina());
        System.out.println("Peso da Máquina: " + proprietario2.getPesoMaquina());
        System.out.println();

        System.out.println("Proprietário 3:");
        System.out.println("Nome: " + proprietario3.getNome());
        System.out.println("E-mail: " + proprietario3.getEmail());
        System.out.println("Senha: " + proprietario3.getSenha());
        System.out.println("Endereço: " + proprietario3.getEndereco());
        System.out.println("Capacidade Máxima: " + proprietario3.getCapacidadeMaxima());
        System.out.println("Modelo da Máquina: " + proprietario3.getModeloMaquina());
        System.out.println("Peso da Máquina: " + proprietario3.getPesoMaquina());
        System.out.println();
    }

    static class Proprietario {
        private int id;
        private String nome;
        private String email;
        private String senha;
        private String endereco;
        private int capacidadeMaxima;
        private String modeloMaquina;
        private int pesoMaquina;

        public Proprietario(int id, String nome, String email, String senha, String endereco, int capacidadeMaxima, String modeloMaquina, int pesoMaquina) {
            this.id = id;
            this.nome = nome;
            this.email = email;
            this.senha = senha;
            this.endereco = endereco;
            this.capacidadeMaxima = capacidadeMaxima;
            this.modeloMaquina = modeloMaquina;
            this.pesoMaquina = pesoMaquina;
        }

        public int getId() {
            return id;
        }

        public String getNome() {
            return nome;
        }

        public String getEmail() {
            return email;
        }

        public String getSenha() {
            return senha;
        }

        public String getEndereco() {
            return endereco;
        }

        public int getCapacidadeMaxima() {
            return capacidadeMaxima;
        }

        public String getModeloMaquina() {
            return modeloMaquina;
        }

        public int getPesoMaquina() {
            return pesoMaquina;
        }
    }
}