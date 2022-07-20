package br.com.letscode.letsgoal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Patrocinador {
<<<<<<< HEAD

=======
>>>>>>> e9ccfb31e05aa18302129f0ad9d33a51a5ddd45a
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Descrição é obrigatório")
    private String descricao;
    private String urlLink;
    private String imagemMarca;
    @Column(unique = true)
    private String nome;
}
