package com.right.haedge.service.dto;

import lombok.*;

import java.util.List;

@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor
public  class StockDTO {
    private String name;
    private int weight;
    private String ticker;
    private List<String> tags;
    private List<String> reason;
}