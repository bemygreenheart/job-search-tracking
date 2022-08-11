package uz.jaxathon.jobsearchtracking.jms;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;
import uz.jaxathon.jobsearchtracking.entities.Skill;

import javax.validation.Valid;

@RequiredArgsConstructor
@Component
public class SkillProducer {
    private final JmsTemplate jmsTemplate;

    @Value("${skill.create.queue}")
    private String createQueue;
    @Value("${skill.update.queue}")
    private String updateQueue;
    @Value("${skill.delete.queue}")
    private String deleteQueue;

    public void sendUpdate(Skill skill){
        MessageCreator messageCreator = session -> session.createObjectMessage(skill);
        jmsTemplate.send(createQueue, messageCreator);
    }

    public void sendCreate(Skill skill){
        MessageCreator messageCreator = session -> session.createObjectMessage(skill);
        jmsTemplate.send(updateQueue, messageCreator);
    }

    public void sendDelete(Long id){
        jmsTemplate.convertAndSend(deleteQueue, id);
    }

}
