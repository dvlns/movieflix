package com.movieflix.mapper;

import com.movieflix.controller.request.CategoryRequest;
import com.movieflix.controller.request.StreamingRequest;
import com.movieflix.controller.response.CategoryResponse;
import com.movieflix.controller.response.StreamingResponse;
import com.movieflix.entity.Category;
import com.movieflix.entity.Streaming;

public class StreamingMapper {

    public static Streaming toStreaming(StreamingRequest request){
        return Streaming.builder()
                .name(request.name())
                .build();
    }

    public static StreamingResponse toStreamingResponse(Streaming streaming){
        return StreamingResponse.builder()
                .id(streaming.getId())
                .name(streaming.getName())
                .build();
    }
}
