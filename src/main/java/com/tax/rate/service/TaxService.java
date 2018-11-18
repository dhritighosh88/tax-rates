package com.tax.rate.service;

import com.tax.rate.config.SlabConfig;
import com.tax.rate.model.Slab;
import com.tax.rate.model.TaxRequest;
import com.tax.rate.model.TaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author Dhriti Ghosh
 */
@Service
public class TaxService {

    @Autowired
    private SlabConfig config;

    public TaxResponse calculateTax(TaxRequest request){
        TaxResponse response = new TaxResponse();
        response.setTax((request.getSalary()/100)*getRate(request));
        return response;
    }

    private Integer getRate(TaxRequest request){
        List<Slab> slabList = config.getSlabsByCountry(request.getCountry());
        if(CollectionUtils.isEmpty(slabList))
            return 0;
        for(Slab slab : slabList){
            if(slab.getLowerLimit() == 0 && slab.getUpperLimit() >= request.getSalary())
                return slab.getRate();
            if(slab.getUpperLimit() == 0 && slab.getLowerLimit() <= request.getSalary())
                return slab.getRate();
            if(slab.getLowerLimit() <= request.getSalary() && slab.getUpperLimit() >= request.getSalary())
                return slab.getRate();
        }
        return 0;
    }

}
