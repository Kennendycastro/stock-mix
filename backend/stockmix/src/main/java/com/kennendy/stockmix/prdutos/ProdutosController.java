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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/produtos")
public class ProdutosController {

    private final ProdutosService produtosService;

    public ProdutosController(ProdutosService produtosService) {
        this.produtosService = produtosService;
    }

    // C - CREATE

    @PostMapping("/cadastrar")
    @Operation(summary = "Cadastro de produtos", description = "essa rota cadastra produtos no banco de dados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Produto criado."),
            @ApiResponse(responseCode = "400", description = "Erro ao criar o produto.")
    })
    public ResponseEntity<String> cadastrarProduto(
        @Parameter(description = "O usuário passa os dados do produto a ser criado no corpo da requisição")
        @RequestBody ProdutosDTO produto) {

        ProdutosDTO novoProduto = produtosService.cadastrarProduto(produto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("O prduto foi criado. Nome: " + novoProduto.getNome() + ", ID: " + novoProduto.getIdProduto());
    }

    // R - READ

    @GetMapping("/listar")
    @Operation(summary = "Listagem de produtos", description = "essa rota lista todos os produtos no banco de dados.")
    public List<ProdutosDTO> listarPordutos() {
        return produtosService.listarPordutos();
    }

    @GetMapping("/listar/{id}")
    @Operation( summary = " Lista porduto por id",description = "O Usuário manda os dados para serem atualizados")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Produto encontrado."),
        @ApiResponse(responseCode = "404", description = "produto não encontrado.")
    })
    public ResponseEntity<?> listarProdutosId(
        @Parameter(description = "Usuário manda o id do produto que procura no caminho da requisição.")
        @PathVariable Long id) {
        ProdutosDTO produtoId = produtosService.listarProdutosId(id);

        if (produtoId != null) {

            return ResponseEntity.ok(produtoId);

        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Produto de ID: " + id + " não encontrado");
    }

    // U -UPDATE

    @PutMapping("/atualizar/{id}")
    @Operation(summary = "Atualização de produto.", description = "Atualiza as informações de um porduto pelo seu id")
    public ResponseEntity<?> atualizarProduto(
        @Parameter(description = "O usuário manda o id do produto a ser atualizado no caminho da requisição.")
        @PathVariable Long id,
        @Parameter(description = "O usuário manda os dados do produto a ser atualizado no corpo da requisição.")
        @RequestBody ProdutosDTO produtoatualizado) {

        if (produtosService.listarProdutosId(id) != null) {
            ProdutosDTO produtoAtualizado = produtosService.atualizarProduto(id, produtoatualizado);
            return ResponseEntity.ok(produtoAtualizado);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("O produto de ID: " + id + " Não foi encontrado.");
    }

    // D - DELETE

    @DeleteMapping("/deletar/{id}")
    @Operation(summary = "Deleta um produto", description = "Deleta um produto por id.")
    public ResponseEntity<String> deletarProduto(
        @Parameter(description = "O usuário manda o id do produto a ser deletado no caminho da requisição.")
        @PathVariable Long id) {

        if (produtosService.listarProdutosId(id) != null) {
            produtosService.deletarProduto(id);
            return ResponseEntity.ok("O produto de ID " + id + " foi deletado.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("O produto de ID: " + id + " não foi encontrado.");

    }

}
