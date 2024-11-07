package br.com.aula.conexao.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InserirAluno {

    public InserirAluno(Connection conexao, Scanner scanner) {
        String sql = "INSERT INTO alunos (nome, idade) VALUES (?, ?)";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            System.out.print("Digite o nome do aluno: ");
            String nome = scanner.nextLine();
            System.out.print("Digite a idade do aluno: ");
            int idade = scanner.nextInt();

            stmt.setString(1, nome);
            stmt.setInt(2, idade);
            stmt.executeUpdate();
            System.out.println("Dados inseridos com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao inserir dados: " + e.getMessage());
        }
    }
}