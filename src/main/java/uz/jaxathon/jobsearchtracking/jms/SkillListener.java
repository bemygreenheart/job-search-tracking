package uz.jaxathon.jobsearchtracking.jms;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import uz.jaxathon.jobsearchtracking.entities.Skill;
import uz.jaxathon.jobsearchtracking.repos.SkillRepository;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Component
public class SkillListener {

    private final SkillRepository skillRepository;

    @JmsListener(destination = "${skill.create.queue}")
    public void handleCreate(Skill skill){
        skillRepository.save(skill);
        log.debug("JMS Listener: Successfully saved skill");
    }

    @JmsListener(destination = "${skill.update.queue}")
    public void handleUpdate(Skill skill){
        skillRepository.save(skill);
        log.debug("JMS Listener: Successfully updated skill");
    }

    @JmsListener(destination = "${skill.delete.queue}")
    public void handleDelete(Long id){
        Optional<Skill> skill = skillRepository.findById(id);
        if(skill.isPresent()){
            skillRepository.delete(skill.get());
            log.debug("JMS Listener: Successfully deleted skill");
        }else{
            log.warn("JMS Listener: Skill with given id = " + id +" does not exist");
        }

    }


}
