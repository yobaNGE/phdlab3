package com.amongus.phdlab3.config;

import com.amongus.phdlab3.dto.ReviewEntityDto;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class MapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        // Define type map for Review -> ReviewDTO
        modelMapper.typeMap(com.amongus.phdlab3.entity.ReviewEntity.class, ReviewEntityDto.class)
                .addMappings(mapper ->
                        mapper.using(ctx -> {
                            List<String> tags = (List<String>) ctx.getSource();
                            return tags == null ? null : String.join(", ", tags);
                        }).map(com.amongus.phdlab3.entity.ReviewEntity::getTags, ReviewEntityDto::setTags));

        // Define type map for ReviewDTO -> Review
        modelMapper.typeMap(ReviewEntityDto.class, com.amongus.phdlab3.entity.ReviewEntity.class)
                .addMappings(mapper ->
                        mapper.using(ctx -> {
                            String tags = (String) ctx.getSource();
                            return tags == null ? null : List.of(tags.split(",\\s*"));
                        }).map(ReviewEntityDto::getTags, com.amongus.phdlab3.entity.ReviewEntity::setTags));

        return modelMapper;
    }
}