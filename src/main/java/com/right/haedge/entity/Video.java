package com.right.haedge.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "videos")
public class Video {

    @Id
    private Long id;

    @Column(name = "video_hashed", length = 255)
    private String videoHashed;

    @Column(name = "rgst_dtm")
    private LocalDateTime rgstDtm;

    @Column(name = "uprd_dtm")
    private LocalDateTime uprdDtm;

    @Column(length = 2047)
    private String thumbnail;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "channel_id")
    private Channel channel;

    @OneToMany(mappedBy = "video", fetch = FetchType.LAZY)
    private Set<RecommendStock> recommendStocks;

}
