package com.ifpe.fabrica.demo.model.entities;

public class ProblemaDTO {
   private String tipo;
   private int funcionarioId;
   private int setorId;

   public String getTipo() {
      return tipo;
   }

   public void setTipo(String tipo) {
      this.tipo = tipo;
   }

   public int getFuncionarioId() {
      return funcionarioId;
   }

   public void setFuncionarioId(int funcionarioId) {
      this.funcionarioId = funcionarioId;
   }

   public int getSetorId() {
      return setorId;
   }

   public void setSetorId(int setorId) {
      this.setorId = setorId;
   }
}
