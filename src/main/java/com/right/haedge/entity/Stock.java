package com.right.haedge.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "stocks")
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255)
    private String ticker;

    @Column(length = 255)
    private String name;

    @Column(length = 2047)
    private String thumbnail;

    @OneToMany(mappedBy = "stock", fetch = FetchType.LAZY)
    private List<RecommendStock> recommendStocks;
}
