package com.ifpe.fabrica.demo.model.entities;

import java.util.List;

public class Setor {

   private int codigo;
   private String nome;
   private List<Funcionario> funcionarios;

   public Setor(){}
   
   public Setor(int codigo, String nome) {
      this.codigo = codigo;
      this.nome = nome;
   }
   public List<Funcionario> getFuncionarios() {
      return funcionarios;
   }
   public void setFuncionarios(List<Funcionario> funcionarios) {
      this.funcionarios = funcionarios;
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
}
