package com.example.userJWT.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@Builder
@Entity
@Table(name="usuario")

public class UserEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="user_id")
        private Long id;


        @Column(name="Nombre")
        private String nombre ;

        @Column(name="Apellido")
        private String apellido;

        @Column(name="Fecha de nacimiento")
        private String birtDay;





}
