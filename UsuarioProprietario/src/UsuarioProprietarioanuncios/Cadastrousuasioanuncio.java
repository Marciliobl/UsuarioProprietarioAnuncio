package UsuarioProprietarioanuncios;

import java.util.ArrayList;
import java.util.List;

public class Cadastrousuasioanuncio {
    private List<Anuncio> anuncios;

    public Cadastrousuasioanuncio() {
        this.anuncios = new ArrayList<>();
    }

    public void criarAnuncio(String proprietario, String endereco, int capacidadeMaxima, int idUsuario, String email, String senha, String modeloMaquina, int pesoMaquina) {
        Anuncio anuncio = new Anuncio(proprietario, endereco, capacidadeMaxima, idUsuario, email, senha, modeloMaquina, pesoMaquina);
        anuncios.add(anuncio);
    }

    public void deletarAnuncio(int idUsuario, int idAnuncio) {
        for (Anuncio anuncio : anuncios) {
            if (anuncio.getIdUsuario() == idUsuario && anuncio.getIdAnuncio() == idAnuncio) {
                anuncios.remove(anuncio);
                break;
            }
        }
    }

    public List<Anuncio> getAnuncios() {
        return anuncios;
    }

    public List<Anuncio> buscarAnunciosPorProprietario(String proprietario) {
        List<Anuncio> anunciosPorProprietario = new ArrayList<>();
        for (Anuncio anuncio : anuncios) {
            if (anuncio.getProprietario().equals(proprietario)) {
                anunciosPorProprietario.add(anuncio);
            }
        }
        return anunciosPorProprietario;
    }

    public static void main(String[] args) {
        Cadastrousuasioanuncio cadastro = new Cadastrousuasioanuncio();

        // Criar anúncios
        cadastro.criarAnuncio("João", "Rua A, 123", 8, 1, "joao@example.com", "senha123", "Modelo 1", 10);
        cadastro.criarAnuncio("Maria", "Rua B, 456", 5, 2, "maria@example.com", "senha456", "Modelo 2", 8);
        cadastro.criarAnuncio("Pedro", "Rua C, 789", 10, 3, "pedro@example.com", "senha789", "Modelo 3", 12);

        // Obter anúncios
        List<Anuncio> anuncios = cadastro.getAnuncios();
        System.out.println("Anúncios:");
        for (Anuncio anuncio : anuncios) {
            System.out.println("Proprietário: " + anuncio.getProprietario());
            System.out.println("Endereço: " + anuncio.getEndereco());
            System.out.println("Capacidade Máxima: " + anuncio.getCapacidadeMaxima());
            System.out.println("ID do Usuário: " + anuncio.getIdUsuario());
            System.out.println("E-mail: " + anuncio.getEmail());
            System.out.println("Senha: " + anuncio.getSenha());
            System.out.println("Modelo da Máquina: " + anuncio.getModeloMaquina());
            System.out.println("Peso da Máquina: " + anuncio.getPesoMaquina());
            System.out.println();
        }

        // Buscar anúncios por proprietário
        String proprietario = "Maria";
        List<Anuncio> anunciosPorProprietario = cadastro.buscarAnunciosPorProprietario(proprietario);
        System.out.println("Anúncios de " + proprietario + ":");
        for (Anuncio anuncio : anunciosPorProprietario) {
            System.out.println("Endereço: " + anuncio.getEndereco());
            System.out.println("Capacidade Máxima: " + anuncio.getCapacidadeMaxima());
            System.out.println("ID do Usuário: " + anuncio.getIdUsuario());
            System.out.println("E-mail: " + anuncio.getEmail());
            System.out.println("Senha: " + anuncio.getSenha());
            System.out.println("Modelo da Máquina: " + anuncio.getModeloMaquina());
            System.out.println("Peso da Máquina: " + anuncio.getPesoMaquina());
            System.out.println();
        }

        // Deletar anúncio
        cadastro.deletarAnuncio(2, 1); // Deleta o primeiro anúncio do usuário com id 2

        // Imprimir anúncios atualizados
        anuncios = cadastro.getAnuncios();
        System.out.println("Anúncios atualizados:");
        for (Anuncio anuncio : anuncios) {
            System.out.println("Proprietário: " + anuncio.getProprietario());
            System.out.println("Endereço: " + anuncio.getEndereco());
            System.out.println("Capacidade Máxima: " + anuncio.getCapacidadeMaxima());
            System.out.println("ID do Usuário: " + anuncio.getIdUsuario());
            System.out.println("E-mail: " + anuncio.getEmail());
            System.out.println("Senha: " + anuncio.getSenha());
            System.out.println("Modelo da Máquina: " + anuncio.getModeloMaquina());
            System.out.println("Peso da Máquina: " + anuncio.getPesoMaquina());
            System.out.println();
        }
    }

    class Anuncio {
        private String proprietario;
        private String endereco;
        private int capacidadeMaxima;
        private int idUsuario;
        private String email;
        private String senha;
        private String modeloMaquina;
        private int pesoMaquina;
        private int idAnuncio;

        private static int nextId = 1;

        public Anuncio(String proprietario, String endereco, int capacidadeMaxima, int idUsuario, String email, String senha, String modeloMaquina, int pesoMaquina) {
            this.proprietario = proprietario;
            this.endereco = endereco;
            this.capacidadeMaxima = capacidadeMaxima;
            this.idUsuario = idUsuario;
            this.email = email;
            this.senha = senha;
            this.modeloMaquina = modeloMaquina;
            this.pesoMaquina = pesoMaquina;
            this.idAnuncio = nextId++;
        }

        public String getProprietario() {
            return proprietario;
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

        public int getIdAnuncio() {
            return idAnuncio;
        }
    }
}