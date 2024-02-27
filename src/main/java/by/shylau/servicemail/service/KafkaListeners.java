package by.shylau.servicemail.service;

import by.shylau.servicemail.dto.Message;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
class KafkaListeners {
    private final MailService mailService;

    @KafkaListener(topics = "demo_topic", groupId = "myGroup")
    void listener(Message data) {
        mailService.sendEmail(
                data.getAddress(),
                data.getSubject(),
                data.getText());

        log.info("KafkaListener {}", data);
    }
}