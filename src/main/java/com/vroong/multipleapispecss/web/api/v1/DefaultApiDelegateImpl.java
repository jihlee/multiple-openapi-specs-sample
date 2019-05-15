package com.vroong.multipleapispecss.web.api.v1;

import com.vroong.multipleapispecss.web.api.v1.model.InlineObject;
import com.vroong.multipleapispecss.web.api.v1.model.InlineResponse200;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class DefaultApiDelegateImpl implements DefaultApiDelegate {
    @Override
    public ResponseEntity<InlineResponse200> apiHelloPost(InlineObject inlineObject) {
        InlineResponse200 response200 = new InlineResponse200();
        String greeting = "Greeting, " + inlineObject.getFullName();

        response200.setGreeting(greeting);
        return ResponseEntity.ok(response200);
    }
}
