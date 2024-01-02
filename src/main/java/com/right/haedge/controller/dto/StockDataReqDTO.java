package com.right.haedge.controller.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.lang.NonNull;

import java.io.Serializable;
import java.util.List;

@ToString
@Getter
public class StockDataReqDTO implements Serializable {

    private static final long serialVersionUID = 2158419746939747203L;

    @NotBlank
    private String videoId;
    @NotBlank
    private String channelId;

    private List<@Valid  Stock> stocks;

    private String thumbnailUrl;


    @ToString
    @Getter
    public static class Stock {
        @NotBlank(message = "주식명 입력")
        private String name;

        @PositiveOrZero(message = "매수 매도 추천 필수")
        @Max(value = 100)
        private int weight;

        private String ticker;
        private List<String> tags;
        private List<String> reason;
    }
}
