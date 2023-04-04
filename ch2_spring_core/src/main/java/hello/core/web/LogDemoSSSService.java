package hello.core.web;

import hello.core.common.LLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogDemoSSSService {
    private final LLogger lLogger;
    public void logic(String testID) {
        lLogger.log("service id = " + testID);
    }
}
