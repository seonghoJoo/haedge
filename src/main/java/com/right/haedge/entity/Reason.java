package com.right.haedge.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "reasons")
@NoArgsConstructor
@AllArgsConstructor
public class Reason {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500)
    private String reason;

    @ManyToOne
    @JoinColumn(name = "recommend_stock_id", nullable = false)
    private RecommendStock recommendStock;

    public Reason(String reason, RecommendStock recommendStock) {
        this.reason = reason;
        this.recommendStock = recommendStock;
    }

    public void setRecommendStock(RecommendStock recommendStock) {
        this.recommendStock = recommendStock;
    }
}
