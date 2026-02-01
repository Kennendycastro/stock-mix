package com.kennendy.stockmix.prdutos;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produtos")
public class ProdutosController {

    private ProdutosService produtosService;

    public ProdutosController(ProdutosService produtosService) {
        this.produtosService = produtosService;
    }

    // C - CREATE

    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrarProduto(@RequestBody ProdutosDTO produto) {

        ProdutosDTO novoProduto =produtosService.cadastrarProduto(produto);
        return ResponseEntity.status(HttpStatus.CREATED)
            .body("O prduto foi criado. Nome: "+novoProduto.getNome() +", ID: "+novoProduto.getIdProduto());
    }

    // R - READ

    @GetMapping("/listar")
    public List<ProdutosDTO> listarPordutos() {
        return produtosService.listarPordutos();
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarProdutosId(@PathVariable Long id) {
        ProdutosDTO produtoId = produtosService.listarProdutosId(id);

        if (produtoId != null) {

            return ResponseEntity.ok(produtoId);
                 
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body("Produto de ID: "+id+ " não encontrado");
    }
    
    // U -UPDATE

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<?> atualizarProduto(@PathVariable Long id, @RequestBody ProdutosDTO produtoatualizado) {

      if (produtosService.listarProdutosId(id) != null) {
            ProdutosDTO produtoAtualizado = produtosService.atualizarProduto(id, produtoatualizado);
            return ResponseEntity.ok(produtoAtualizado);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body("O produto de ID: "+id+" Não foi encontrado.");
    }

    // D - DELETE

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarProduto(@PathVariable Long id){

       if (produtosService.listarProdutosId(id) != null) {
            produtosService.deletarProduto(id);
            return ResponseEntity.ok("O produto de ID "+id+" foi deletado.");       
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body("O produto de ID: "+id+" não foi encontrado.");

        
       
    }
    

}
