package kata.spring.service;

import org.springframework.stereotype.Service;


@Service
public class EventAssistService {
    
    public int calcByAssist(int i){
        return i*12+i*i;
    }
}
