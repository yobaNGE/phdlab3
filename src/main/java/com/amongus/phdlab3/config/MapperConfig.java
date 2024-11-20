package com.amongus.phdlab3.config;

import com.amongus.phdlab3.dto.ReviewDTO;
import com.amongus.phdlab3.entity.ReviewEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class MapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        // Define type map for Review -> ReviewDTO
        modelMapper.typeMap(ReviewEntity.class, ReviewDTO.class)
                .addMappings(mapper ->
                        mapper.map(ReviewEntity::getId, ReviewDTO::setId)) // Example explicit mapping
                .addMappings(mapper ->
                        mapper.using(ctx -> {
                            List<String> tags = (List<String>) ctx.getSource();
                            return tags == null ? null : String.join(", ", tags);
                        }).map(ReviewEntity::getTags, ReviewDTO::setTags));

        // Define type map for ReviewDTO -> Review
        modelMapper.typeMap(ReviewDTO.class, ReviewEntity.class)
                .addMappings(mapper ->
                        mapper.using(ctx -> {
                            String tags = (String) ctx.getSource();
                            return tags == null ? null : List.of(tags.split(",\\s*"));
                        }).map(ReviewDTO::getTags, ReviewEntity::setTags));

        return modelMapper;
    }
}