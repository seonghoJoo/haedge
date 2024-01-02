package com.right.haedge.service;

import com.right.haedge.entity.Video;
import com.right.haedge.repository.VideoRepository;
import com.right.haedge.service.dto.ShowVideoListByChannelDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ChannelServiceImpl implements ChannelService{

    private final VideoRepository videoRepository;

    @Override
    public List<String> showVideoList(ShowVideoListByChannelDTO dto) {
        return videoRepository.findByChannelHashedAndVideoHashedNotIn(dto.getChannelId(), dto.getVideos());
    }
}
