package com.ifpe.fabrica.demo.model.entities;

public class Funcionario {

   private int codigo;
   private String nome;
   private String email;
   private String senha;
   private Setor setor;

   public Funcionario() {
   }

   public Funcionario(int codigo, String nome, String email, String senha, Setor setor) {
      this.codigo = codigo;
      this.nome = nome;
      this.email = email;
      this.senha = senha;
      this.setor = setor;
   }

   public Setor getSetor() {
      return setor;
   }

   public void setSetor(Setor setor) {
      this.setor = setor;
   }

   public int getCodigo() {
      return codigo;
   }

   public void setCodigo(int codigo) {
      this.codigo = codigo;
   }

   public String getNome() {
      return nome;
   }

   public void setNome(String nome) {
      this.nome = nome;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getSenha() {
      return senha;
   }

   public void setSenha(String senha) {
      this.senha = senha;
   }

}
