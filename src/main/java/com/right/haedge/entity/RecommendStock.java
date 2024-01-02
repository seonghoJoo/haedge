package com.right.haedge.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "recommend_stocks")
public class RecommendStock {

    @Id
    private Long id;

    @Column(name = "stock_id", nullable = false)
    private Long stockId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "video_id", nullable = false)
    private Video video;

    @Column(name = "rgst_dtm")
    private LocalDateTime rgstDtm;

    @Column(name = "uprd_dtm")
    private LocalDateTime uprdDtm;

    @Column(precision = 10, scale = 2)
    private BigDecimal price;

}
