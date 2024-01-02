package com.right.haedge.controller.dto;

import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@ToString
@Getter
public class ShowChannelVideoListReqDTO implements Serializable {
    private static final long serialVersionUID = 2158419746939747203L;
    private List<String> videos;
}
