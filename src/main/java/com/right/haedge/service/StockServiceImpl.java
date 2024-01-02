package com.right.haedge.service;

import com.right.haedge.service.dto.StockSaveDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StockServiceImpl implements StockService{

    @Override
    public void saveRecommendStock(StockSaveDTO reqToDto) {
        log.info("{}", reqToDto);
    }
}
