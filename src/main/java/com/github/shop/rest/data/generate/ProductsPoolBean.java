package com.github.shop.rest.data.generate;

import com.github.inchestnov.generatorstarter.AbstractStringPool;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
public class ProductsPoolBean extends AbstractStringPool implements ProductsPool {

    /* Products from https://catalogloader.com/projects/skachat-bazu-tovarov-magazina */
    @Value("classpath:products.txt")
    private Resource resource;

    protected Resource getResource() {
        return resource;
    }

    @Override
    public String getRandomProduct() {
        return getRandomValue();
    }

}
