package com.right.haedge.controller;

import com.right.haedge.controller.dto.ShowChannelVideoListReqDTO;
import com.right.haedge.controller.dto.ShowChannelVideoListRespDTO;
import com.right.haedge.controller.dto.StockDataReqDTO;
import com.right.haedge.service.ChannelService;
import com.right.haedge.service.StockService;
import com.right.haedge.service.dto.ShowVideoListByChannelDTO;
import com.right.haedge.service.dto.StockSaveDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * 백단 서버를 위한 컨트롤러
 * python을 이용한 데이터 삽입시 이용하는 서버입니다.
 * */
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1")
@Slf4j
public class StockDataController {

    private final StockService stockService;
    private final ChannelService channelService;

    @PostMapping(value = "/stock")
    public ResponseEntity<Void> stockData(@RequestHeader Map<Object, String> headers, @Valid @RequestBody StockDataReqDTO reqDTO){

        stockService.saveRecommendStock(StockSaveDTO.reqToDto(reqDTO));

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(value = "/channel")
    public ResponseEntity<ShowChannelVideoListRespDTO> showChannelVideoList(@RequestHeader Map<Object, String> headers,
                                                     @RequestParam(name = "channelId", required = true) String channelId,
                                                     @RequestBody ShowChannelVideoListReqDTO reqDTO
                                                     ){

        List<String> result = channelService.showVideoList(ShowVideoListByChannelDTO.reqToDto(channelId, reqDTO));

        return ResponseEntity.status(HttpStatus.OK)
                .body(ShowVideoListByChannelDTO.dtoToResp(result));
    }
}
