package com.right.haedge.service.dto;

import com.right.haedge.controller.dto.StockDataReqDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
@Builder
public class StockSaveDTO {

    private String videoId;
    private String channelId;
    private String channelName;
    private String thumbnailUrl;
    private List<StockDTO> stocks;


    public static StockSaveDTO reqToDto(StockDataReqDTO dto){
        return StockSaveDTO.builder()
                .videoId(dto.getVideoId())
                .channelId(dto.getChannelId())
                .channelName(dto.getChannelName())
                .thumbnailUrl(dto.getThumbnailUrl())
                .stocks(dto.getStocks()
                        .stream()
                        .map(stock-> new StockDTO(stock.getName(), stock.getWeight(),stock.getTicker(), stock.getReason()))
                        .toList())
                .build();
    }
}
