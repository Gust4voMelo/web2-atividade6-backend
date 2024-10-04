package com.ifpe.fabrica.demo.controllers;

import org.springframework.web.bind.annotation.*;

import com.ifpe.fabrica.demo.model.entities.Funcionario;
import com.ifpe.fabrica.demo.model.entities.Problema;
import com.ifpe.fabrica.demo.model.entities.ProblemaDTO;
import com.ifpe.fabrica.demo.model.entities.Setor;
import com.ifpe.fabrica.demo.model.repositories.FuncionarioRepository;
import com.ifpe.fabrica.demo.model.repositories.ProblemasRepository;
import com.ifpe.fabrica.demo.model.repositories.SetorRepository;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://127.0.0.1:5501")
public class FabricaController {

   private final FuncionarioRepository funcionarioRepository = FuncionarioRepository.current;
   private final ProblemasRepository problemasRepository = new ProblemasRepository();
   private final SetorRepository setorRepository = SetorRepository.current;

   @PostMapping("/setores")
   public void criarSetor(@RequestBody Setor setor) throws SQLException {
      setorRepository.create(setor);
   }

   @GetMapping("/setores")
   public List<Setor> listarSetores() throws SQLException {
      return setorRepository.findAll();
   }

   @PostMapping("/funcionarios")
   public void criarFuncionario(@RequestBody Funcionario funcionario) throws SQLException {
      funcionarioRepository.create(funcionario);
   }

   @GetMapping("/funcionarios")
   public List<Funcionario> listarFuncionarios() throws SQLException {
      return funcionarioRepository.findAll();
   }

   @GetMapping("/problemas")
   public List<Problema> listarProblemas() throws SQLException {
      return problemasRepository.findAll();
   }

   @GetMapping("/setores/{setorId}/problemas")
   public List<Problema> listarProblemasPorSetor(@PathVariable("setorId") int setorId) throws SQLException {
      Setor setor = setorRepository.read(setorId);
      return problemasRepository.findAll(); 
   }

   @PostMapping("/problemas")
   public void reportarProblema(@RequestBody ProblemaDTO problemaDTO) throws SQLException {
      Funcionario funcionario = funcionarioRepository.read(problemaDTO.getFuncionarioId());
      Setor setor = setorRepository.read(problemaDTO.getSetorId());
      Problema problema = new Problema(problemaDTO.getTipo(), LocalDateTime.now(), funcionario, setor);
      problemasRepository.create(problema);
   }

   @PutMapping("/setores/{codigo}")
   public void atualizarSetor(@PathVariable("codigo") int codigo, @RequestBody Setor setor) throws SQLException {
      setor.setCodigo(codigo);
      setorRepository.update(setor);
   }

   @PutMapping("/funcionarios/{codigo}")
   public void atualizarFuncionario(@PathVariable("codigo") int codigo, @RequestBody Funcionario funcionario)
         throws SQLException {
      funcionario.setCodigo(codigo);
      funcionarioRepository.update(funcionario);
   }

   @DeleteMapping("/setores/{codigo}")
   public void deletarSetor(@PathVariable("codigo") int codigo) throws SQLException {
      setorRepository.delete(codigo);
   }

   @DeleteMapping("/funcionarios/{codigo}")
   public void deletarFuncionario(@PathVariable("codigo") int codigo) throws SQLException {
      funcionarioRepository.delete(codigo);
   }
}