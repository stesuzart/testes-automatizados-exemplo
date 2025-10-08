package br.stesuzart.testecomspring.controller;

import br.stesuzart.testecomspring.entity.Produto;
import br.stesuzart.testecomspring.service.ProdutoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class ProdutoControllerTest {
    @Mock
    private ProdutoService produtoService;
    private Produto produto;
    private List<Produto> produtoLista;

    @InjectMocks
    private ProdutoController productController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        produto = new Produto(1l, "TV 55", "TV 55 POLEGADAS LED, LG", 500l);
        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
    }

    // Método utilizado para escrever objeto em String
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void adicionarProdutoHttpTest() throws Exception{
        when(produtoService.adicionarProduto(Mockito.any())).thenReturn(produto);
        mockMvc.perform(post("/api/v1/produtos").
                contentType(MediaType.APPLICATION_JSON).
                content(asJsonString(produto))).andExpect(status().isCreated());
        verify(produtoService, times(1)).adicionarProduto(Mockito.any());
    }

    @Test
    public void listarProdutosHttpTest() throws Exception {
        when(produtoService.listarProdutos()).thenReturn(produtoLista);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/produtos").
                        contentType(MediaType.APPLICATION_JSON).
                        content(asJsonString(produto))).
                andDo(MockMvcResultHandlers.print());

        verify(produtoService).listarProdutos();
        verify(produtoService, times(1)).listarProdutos();
    }

    @Test
    public void removerProdutoHttpTest() throws Exception {
        when(produtoService.removerProduto(produto.getId())).thenReturn(produto);
        mockMvc.perform(delete("/api/v1/produtos/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(produto)))
                .andExpect(MockMvcResultMatchers.status().isOk()).
                andDo(MockMvcResultHandlers.print());
    }
}