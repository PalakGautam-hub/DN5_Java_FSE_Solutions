package com.palak.testing;

public class MyService {
    private final ExternalApi externalApi;

    public MyService(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }

    public String fetchData() {
        return externalApi.getData();
    }

    public void processAndSend(String data) {
        externalApi.sendData("Processed: " + data);
    }
}
