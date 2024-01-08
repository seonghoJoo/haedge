package com.right.haedge.service;

import com.right.haedge.entity.*;
import com.right.haedge.repository.*;
import com.right.haedge.service.dto.StockDTO;
import com.right.haedge.service.dto.StockSaveDTO;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class StockServiceImpl implements StockService{

    private final VideoRepository videoRepository;
    private final ChannelRepository channelRepository;
    private final StockRepository stockRepository;
    private final RecommendStockRepository recommendStockRepository;
    private final ReasonRepository reasonRepository;

    /**
     *  저장 할 것
     *  channel 없으면 1건
     *  video 없으면 1건
     *  stock 없으면 1건
     *  recommend_stock 다건
     *  reason 다건
     * */
    @Override
    @Transactional
    public void saveRecommendStock(StockSaveDTO saveDto) {

        Channel channel = channelRepository.findByChannelHashed(saveDto.getChannelId())
                .orElseGet(() -> channelRepository.save(Channel.builder()
                                .name(saveDto.getChannelName())
                                .channelHashed(saveDto.getChannelId())
                        .build()));

        Video video = videoRepository.findByVideoHashed(saveDto.getVideoId())
                .orElseGet(() -> videoRepository.save(Video.builder()
                        .channel(channel)
                        .thumbnail(saveDto.getThumbnailUrl())
                        .videoHashed(saveDto.getVideoId())
                        .build()));

        for (StockDTO stockDTO : saveDto.getStocks()) {
            Stock stock = stockRepository.findByName(stockDTO.getName()).orElseGet(() -> stockRepository.save(
                    Stock.builder()
                            .name(stockDTO.getName())
                            .ticker(stockDTO.getTicker())
                            .build()));
            RecommendStock recommendStock = RecommendStock.builder()
                    .stock(stock)
                    .video(video)
                    .weight(stockDTO.getWeight())
                    .rgstDtm(LocalDateTime.now())
                    .build();
            recommendStockRepository.save(recommendStock);
            List<Reason> reasons = stockDTO.getReason().stream()
                    .map(s -> new Reason(s, recommendStock))
                    .collect(Collectors.toList());
            reasonRepository.saveAll(reasons);
        }
    }
}
