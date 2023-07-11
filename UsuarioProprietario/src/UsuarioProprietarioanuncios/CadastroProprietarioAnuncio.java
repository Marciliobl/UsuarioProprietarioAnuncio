package UsuarioProprietarioanuncios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CadastroProprietarioAnuncio {
    private Map<Integer, Proprietario> proprietarios;

    public CadastroProprietarioAnuncio() {
        this.proprietarios = new HashMap<>();
    }

    public void cadastrarProprietario(int id, String nome, String email, String senha, String endereco, int capacidadeMaxima, String modeloMaquina, int pesoMaquina) {
        Proprietario proprietario = new Proprietario(id, nome, email, senha, endereco, capacidadeMaxima, modeloMaquina, pesoMaquina);
        proprietarios.put(id, proprietario);
    }

    public void criarAnuncio(int idProprietario, String endereco, int capacidadeMaxima, int idUsuario, String email, String senha, String modeloMaquina, int pesoMaquina) {
        Proprietario proprietario = proprietarios.get(idProprietario);
        if (proprietario != null) {
            proprietario.criarAnuncio(endereco, capacidadeMaxima, idUsuario, email, senha, modeloMaquina, pesoMaquina);
        }
    }

    public void deletarAnuncio(int idProprietario, int idAnuncio) {
        Proprietario proprietario = proprietarios.get(idProprietario);
        if (proprietario != null) {
            proprietario.deletarAnuncio(idAnuncio);
        }
    }

    public Proprietario getProprietario(int idProprietario) {
        return proprietarios.get(idProprietario);
    }

    public List<Anuncio> buscarAnunciosPorProprietario(int idProprietario) {
        Proprietario proprietario = proprietarios.get(idProprietario);
        if (proprietario != null) {
            return proprietario.getAnuncios();
        }
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        CadastroProprietarioAnuncio cadastro = new CadastroProprietarioAnuncio();

        // Cadastrar proprietários
        cadastro.cadastrarProprietario(1, "João", "joao@example.com", "senha123", "Rua A, 123", 8, "Modelo 1", 10);
        cadastro.cadastrarProprietario(2, "Maria", "maria@example.com", "senha456", "Rua B, 456", 5, "Modelo 2", 8);
        cadastro.cadastrarProprietario(3, "Pedro", "pedro@example.com", "senha789", "Rua C, 789", 10, "Modelo 3", 12);

        // Criar anúncios
        cadastro.criarAnuncio(1, "Rua A, 123", 8, 1, "joao@example.com", "senha123", "Modelo 1", 10);
        cadastro.criarAnuncio(2, "Rua B, 456", 5, 2, "maria@example.com", "senha456", "Modelo 2", 8);
        cadastro.criarAnuncio(3, "Rua C, 789", 10, 3, "pedro@example.com", "senha789", "Modelo 3", 12);

        // Deletar anúncio
        cadastro.deletarAnuncio(2, 1); // Deleta o primeiro anúncio do proprietário com id 2

        // Obter proprietários
        Proprietario proprietario1 = cadastro.getProprietario(1);
        Proprietario proprietario2 = cadastro.getProprietario(2);
        Proprietario proprietario3 = cadastro.getProprietario(3);

        // Imprimir informações dos proprietários
        System.out.println("Proprietário 1:");
        proprietario1.imprimirInformacoes();
        System.out.println();

        System.out.println("Proprietário 2:");
        proprietario2.imprimirInformacoes();
        System.out.println();

        System.out.println("Proprietário 3:");
        proprietario3.imprimirInformacoes();
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
        private List<Anuncio> anuncios;

        public Proprietario(int id, String nome, String email, String senha, String endereco, int capacidadeMaxima, String modeloMaquina, int pesoMaquina) {
            this.setId(id);
            this.nome = nome;
            this.email = email;
            this.senha = senha;
            this.endereco = endereco;
            this.capacidadeMaxima = capacidadeMaxima;
            this.modeloMaquina = modeloMaquina;
            this.pesoMaquina = pesoMaquina;
            this.anuncios = new ArrayList<>();
        }

        public void criarAnuncio(String endereco, int capacidadeMaxima, int idUsuario, String email, String senha, String modeloMaquina, int pesoMaquina) {
            Anuncio anuncio = new Anuncio(endereco, capacidadeMaxima, idUsuario, email, senha, modeloMaquina, pesoMaquina);
            anuncios.add(anuncio);
        }

        public void deletarAnuncio(int idAnuncio) {
            for (Anuncio anuncio : anuncios) {
                if (anuncio.getIdAnuncio() == idAnuncio) {
                    anuncios.remove(anuncio);
                    break;
                }
            }
        }

        public List<Anuncio> getAnuncios() {
            return anuncios;
        }

        public void imprimirInformacoes() {
            System.out.println("Nome: " + nome);
            System.out.println("E-mail: " + email);
            System.out.println("Senha: " + senha);
            System.out.println("Endereço: " + endereco);
            System.out.println("Capacidade Máxima: " + capacidadeMaxima);
            System.out.println("Modelo da Máquina: " + modeloMaquina);
            System.out.println("Peso da Máquina: " + pesoMaquina);
            System.out.println("Anúncios:");
            for (Anuncio anuncio : anuncios) {
                System.out.println(" - ID: " + anuncio.getIdAnuncio());
                System.out.println("   Endereço: " + anuncio.getEndereco());
                System.out.println("   Capacidade Máxima: " + anuncio.getCapacidadeMaxima());
                System.out.println("   ID do Usuário: " + anuncio.getIdUsuario());
                System.out.println("   E-mail: " + anuncio.getEmail());
                System.out.println("   Senha: " + anuncio.getSenha());
                System.out.println("   Modelo da Máquina: " + anuncio.getModeloMaquina());
                System.out.println("   Peso da Máquina: " + anuncio.getPesoMaquina());
            }
        }

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}
    }

    static class Anuncio {
        private static int nextId = 1;
        private int idAnuncio;
        private String endereco;
        private int capacidadeMaxima;
        private int idUsuario;
        private String email;
        private String senha;
        private String modeloMaquina;
        private int pesoMaquina;

        public Anuncio(String endereco, int capacidadeMaxima, int idUsuario, String email, String senha, String modeloMaquina, int pesoMaquina) {
            this.idAnuncio = nextId++;
            this.endereco = endereco;
            this.capacidadeMaxima = capacidadeMaxima;
            this.idUsuario = idUsuario;
            this.email = email;
            this.senha = senha;
            this.modeloMaquina = modeloMaquina;
            this.pesoMaquina = pesoMaquina;
        }

        public int getIdAnuncio() {
            return idAnuncio;
        }

        public String getEndereco() {
            return endereco;
        }

        public int getCapacidadeMaxima() {
            return capacidadeMaxima;
        }

        public int getIdUsuario() {
            return idUsuario;
        }

        public String getEmail() {
            return email;
        }

        public String getSenha() {
            return senha;
        }

        public String getModeloMaquina() {
            return modeloMaquina;
        }

        public int getPesoMaquina() {
            return pesoMaquina;
        }
    }
}