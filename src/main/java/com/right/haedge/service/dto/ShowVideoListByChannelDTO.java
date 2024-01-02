package com.right.haedge.service.dto;


import com.right.haedge.controller.dto.ShowChannelVideoListReqDTO;
import com.right.haedge.controller.dto.ShowChannelVideoListRespDTO;
import com.right.haedge.controller.dto.StockDataReqDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
@Builder
public class ShowVideoListByChannelDTO {

    private List<String> videos;
    private String channelId;

    public static ShowChannelVideoListRespDTO dtoToResp(List<String> videos){
        return ShowChannelVideoListRespDTO.builder()
                .videos(videos)
                .build();

    }

    public static ShowVideoListByChannelDTO reqToDto(String channelId, ShowChannelVideoListReqDTO dto) {
        return ShowVideoListByChannelDTO
                .builder()
                .channelId(channelId)
                .videos(dto.getVideos())
                .build();
    }
}
