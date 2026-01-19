package com.kennendy.stockmix.prdutos;

import java.util.List;

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

    @PutMapping("/Atualizar")
    public String atualizarProduto() {
        return "produto atulizado";
    }

    // D - DELETE

    @DeleteMapping("/Deletar")
    public String deletarProduto() {
        return "produto deletado";
    }

}
