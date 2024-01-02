package com.right.haedge.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "reasons")
public class Reason {

    @Id
    private Long id;

    @Column(length = 500)
    private String reason;

    @Column(name = "rgst_dtm")
    private LocalDateTime rgstDtm;

    @Column(name = "uprd_dtm")
    private LocalDateTime uprdDtm;

    @Column(name = "recommend_stock_id", nullable = false)
    private Long recommendStockId;

}
