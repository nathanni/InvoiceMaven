package com.atriumwindows.test;

import com.atriumwindows.service.HeaderService;
import org.junit.Test;

/**
 * Created by nni on 12/15/2015.
 */
public class TestHeaderService {

    HeaderService headerService = new HeaderService();

    @Test
    public void test() {
        System.out.println(headerService.getHeader("02145938"));
    }

}
