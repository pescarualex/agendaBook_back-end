package org.fasttrackit.config;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperConfiguration {

    private static ObjectMapper objectMapper;

    public static ObjectMapper getObjectMapper() {

        if (objectMapper == null) {
            objectMapper = new ObjectMapper();
        }

        return objectMapper;
    }

}
