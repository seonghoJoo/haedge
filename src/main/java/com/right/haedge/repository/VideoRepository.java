package com.right.haedge.repository;

import com.right.haedge.entity.Video;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long> {

    @Query("SELECT v.videoHashed FROM Video v WHERE v.channel.channelHashed = :channelHashed AND v.videoHashed NOT IN :videoHashed")
    List<String> findByChannelHashedAndVideoHashedNotIn(@Param("channelHashed") String channelHashed,
                                                        @Param("videoHashed") List<String> videoHashed);
}
