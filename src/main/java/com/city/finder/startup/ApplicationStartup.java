package com.city.finder.startup;

import com.city.finder.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {

    /**
     * This event is executed as late as conceivably possible to indicate that
     * the application is ready to service requests.
     */

    @Autowired
    private CityService cityService;

    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {
        cityService.uploadCities();
    }
}