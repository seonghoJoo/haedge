package com.right.haedge.entity;


import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "channels")
public class Channel {

    @Id
    private Long id;

    @Column(name = "channel_hashed", length = 255, unique = true)
    private String channelHashed;

    @Column(length = 255)
    private String name;

    @Column(length = 2047)
    private String thumbnail;

    @OneToMany(mappedBy = "channel", fetch = FetchType.LAZY)
    private Set<Video> videos;
}
