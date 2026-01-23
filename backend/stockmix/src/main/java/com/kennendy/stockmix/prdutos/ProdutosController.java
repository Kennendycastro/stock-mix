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
import org.springframework.web.bind.annotation.ResponseStatus;
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
    public ProdutosModel cadastrarProduto(@RequestBody ProdutosModel produto) {

        return produtosService.cadastrarProduto(produto);
    }

    // R - READ

    @GetMapping("/listar")
    public List<ProdutosModel> listarPordutos() {
        return produtosService.listarPordutos();
    }

    @GetMapping("/listar/{id}")
    public ProdutosModel listarProdutosId(@PathVariable Long id) {
        return produtosService.listarProdutosId(id);
    }
    
    // U -UPDATE

    @PutMapping("/atualizar/{id}")
    public ProdutosModel atualizarProduto(@PathVariable Long id, @RequestBody ProdutosModel produtoatualizado) {
        
        return produtosService.atualizarProduto(id, produtoatualizado);
    }

    // D - DELETE

    @DeleteMapping("/deletar/{id}")
    public void deletarProduto(@PathVariable Long id){
        produtosService.deletarProduto(id);
    }
    

}
