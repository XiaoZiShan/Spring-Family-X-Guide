package hello;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.security.core.Authentication;
import org.springframework.session.FindByIndexNameSessionRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import java.security.Principal;
import java.util.Collections;
import java.util.Map;


@Controller
public class GreetingController implements ApplicationListener<SessionDisconnectEvent> {
    private final SimpMessageSendingOperations messagingTemplate;

    public GreetingController(SimpMessageSendingOperations messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @MessageMapping("/messageuser")
    @SendToUser(value = "/topic/testuser" , broadcast = false)
    public void handleSubscribe(HelloMessage message,@Header String  ReceiverId, @Headers Map<String, Object> headers, Authentication authenticationx) {
        System.out.println(message.getName());
        System.out.println(ReceiverId+"发信人 ID");
        System.out.println(headers.get("ReceiverId")+"收信人 ID");
        messagingTemplate.convertAndSendToUser(ReceiverId,"/topic/testuser",new Greeting(message.getName()));
    }

    @Override
    public void onApplicationEvent(SessionDisconnectEvent sessionDisconnectEvent) {
        HelloMessage activityDTO = new HelloMessage();
        activityDTO.setName(sessionDisconnectEvent.getSessionId());
        System.out.println(activityDTO.getName()+"下线");
        messagingTemplate.convertAndSend("/topic/testuser", activityDTO);
    }
}
