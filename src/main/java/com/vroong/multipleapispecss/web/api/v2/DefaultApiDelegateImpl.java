package com.vroong.multipleapispecss.web.api.v2;

import com.vroong.multipleapispecss.web.api.v2.model.InlineObject;
import com.vroong.multipleapispecss.web.api.v2.model.InlineResponse200;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class DefaultApiDelegateImpl implements DefaultApiDelegate {
    @Override
    public ResponseEntity<InlineResponse200> apiHelloPost(InlineObject inlineObject) {
        InlineResponse200 response = new InlineResponse200();
        String hello = "Hello, " + inlineObject.getFirstName() + " " + inlineObject.getLastName();

        response.setHello(hello);
        return ResponseEntity.ok(response);
    }
}
