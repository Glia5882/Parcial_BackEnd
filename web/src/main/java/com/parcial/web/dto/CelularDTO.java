package com.parcial.web.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)

public class CelularDTO {
    private Long id;
    private String marca;
    private Long serial;
    private Date fechaCompra;
    private Date añoLanzamiento;
    private Long precio;
    private String sistemaOperativo;
    private String gama;
}
