package com.right.haedge.controller.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class ShowChannelVideoListRespDTO {
    private List<String> videos;
}
