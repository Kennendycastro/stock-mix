package com.kennendy.stockmix.estoques;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estoques")
public class EstoqueController {
    
    // C - CREATE

    @PostMapping("/cadastrar")
    public String cadastrarEstoque(){
        return "Estoque criado";
    }

    // R - READ

    @GetMapping("/listar")
    public String listarEstoques(){
        return "Estoques listados";
    }

    @GetMapping("/listarId")
    public String listarPorId(){
        return "Estoques listadops";
    }

    // U - UPDATE
    
    @PutMapping("/atualizar")
    public String atualizarEtoque(){
        return "Estoque atualizado.";
    }


    // D - DELETE

    @DeleteMapping("/deletar")
    public String deletar(){
        return "Estoque deltar";
    }

}
