package com.palak.testing;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

// Mockito Exercise 2: Verifying Interactions
public class MockitoVerifyInteractionTest {
    @Test
    public void testVerifyInteraction() {
        ExternalApi mockApi = mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        service.fetchData();

        verify(mockApi, times(1)).getData();
    }

    @Test
    public void testVerifyMethodWithArgument() {
        ExternalApi mockApi = mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        service.processAndSend("Hello");

        verify(mockApi).sendData("Processed: Hello");
    }
}
