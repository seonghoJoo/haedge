package com.right.haedge.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "recommend_stocks")
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RecommendStock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stock_id", nullable = false)
    private Stock stock;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "video_id", nullable = false)
    private Video video;

    @Column(name = "rgst_dtm")
    private LocalDateTime rgstDtm;

    @Column(name = "uprd_dtm")
    private LocalDateTime uprdDtm;

    @Column(precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "weight")
    private int weight;

    @OneToMany(mappedBy = "recommendStock")
    private List<Reason> reasons;

    public void addReason(Reason reason) {
        if (reasons == null) {
            reasons = new ArrayList<>();
        }
        reasons.add(reason);
        reason.setRecommendStock(this);
    }

}
