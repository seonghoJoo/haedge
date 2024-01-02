package com.right.haedge.service;

import com.right.haedge.service.dto.ShowVideoListByChannelDTO;
import java.util.*;

public interface ChannelService {
    List<String> showVideoList(ShowVideoListByChannelDTO dto);
}
