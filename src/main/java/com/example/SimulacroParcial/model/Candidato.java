package com.example.SimulacroParcial.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Candidato {

        @Id
        @GeneratedValue
        private Integer id;
        private Integer dni;
        private String nombre;
        private String apellido;
        private Integer cantidadVotos;

        public void recirVoto(){
                cantidadVotos++;
        }

}
