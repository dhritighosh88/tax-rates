package com.tax.rate.config;

import com.tax.rate.model.Slab;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Dhriti Ghosh
 */
@Setter
@Getter
@Configuration
@ConfigurationProperties("slabs")
public class SlabConfig {
    public List<Slab> slab;

    public List<Slab> getSlabsByCountry(String country){
        return slab.stream()
                        .filter(s -> s.getCountry().equalsIgnoreCase(country)).collect(Collectors.toList());
    }
}
