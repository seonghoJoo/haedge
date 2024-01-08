package com.right.haedge.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.*;

@Entity
@Table(name = "channels")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Channel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "channel_hashed", length = 255, unique = true)
    private String channelHashed;

    @Column(length = 255)
    private String name;

    @Column(length = 2047)
    private String thumbnail;

    @OneToMany(mappedBy = "channel", fetch = FetchType.LAZY)
    private List<Video> videos;
}
