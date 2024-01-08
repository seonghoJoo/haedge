package com.right.haedge.service;

import com.right.haedge.repository.VideoRepository;
import com.right.haedge.service.dto.ShowVideoListByChannelDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ChannelServiceImpl implements ChannelService{

    private final VideoRepository videoRepository;

    @Transactional(readOnly = true)
    @Override
    public List<String> showVideoList(ShowVideoListByChannelDTO dto) {
        List<String> result = videoRepository.findByChannelHashedAndVideoHashedIn(dto.getChannelId(), dto.getVideos());
        return removeDuplicatedInList(dto.getVideos(), result);
    }

    private <T> List<T> removeDuplicatedInList(List<T> origin, List<T> targets){
        origin.removeAll(targets);
        return origin;
    }
}
