package com.right.haedge.controller;

import com.right.haedge.common.Const;
import com.right.haedge.controller.dto.StockDataReqDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequiredArgsConstructor
@RestController
@Slf4j
public class StockDataController {

    @PostMapping
    public ResponseEntity<Void> stockData(
            @RequestHeader Map<Object, String> headers,
        @Valid @RequestBody StockDataReqDTO reqDTO){

        log.info("{}", reqDTO);

        return ResponseEntity.status(Const.CREATED).build();
    }
}
