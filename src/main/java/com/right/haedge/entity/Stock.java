package com.right.haedge.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "stocks")
public class Stock {

    @Id
    private Long id;

    @Column(length = 255)
    private String ticker;

    @Column(length = 255)
    private String name;

    @Column(length = 2047)
    private String thumbnail;

}
