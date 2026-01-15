package com.kennendy.stockmix.prdutos;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produtos")
public class ProdutosController {
    
    //C - CREATE

    @PostMapping("/cadatrar")
    public String cadastrarProduto(){
        return "Produto cadastrado";
    }

    //R - READ

    @GetMapping("/listar")
    public String listarPordutos(){
        return "Produtos listados";
    }

    @GetMapping("/listarId")
    public String listarProdutosId(){
        return "Produtos listado por id";
    }

    @GetMapping("/listarPorEstoque")
    public String listarPorEstoque(){
        return "Produtos por Estoque";
    }

    // U -UPDATE

    @PutMapping("/Atualizar")
    public String atualizarProduto(){
        return "produto atulizado";
    }

    // D - DELETE

    @DeleteMapping("/Deletar")
    public String deletarProduto(){
        return "produto deletado";
    }


}
