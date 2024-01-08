package com.right.haedge.entity;

import com.right.haedge.service.dto.StockDTO;
import com.right.haedge.service.dto.StockSaveDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "videos")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "video_hashed", length = 255)
    private String videoHashed;

    @Column(length = 2047)
    private String thumbnail;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "channel_id")
    private Channel channel;

    @OneToMany(mappedBy = "video", fetch = FetchType.LAZY)
    private List<RecommendStock> recommendStocks;

}
