package com.stackroute.musixservice.config;
import com.stackroute.musixservice.domain.Track;
        import com.stackroute.musixservice.repository.TrackRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
        import org.jboss.logging.Logger;

//import java.util.logging.Logger;

@Component
@PropertySource("classpath:application.properties")
public class ApplicationListenerStartup implements ApplicationListener<ContextRefreshedEvent> {
    private static final Logger logs = Logger.getLogger(ApplicationListenerStartup.class);
    private TrackRepository trackRepository;

    @Autowired
    private Environment env;
    @Autowired
    public ApplicationListenerStartup(TrackRepository trackRepository){
        this.trackRepository=trackRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent){
        logs.info("Inserting data on start");

        Track trackOne = new Track(4,"mungaru male","Singer :Sonu Nigam");
        trackRepository.save(trackOne);
        Track trackTwo = new Track(5,"galipata","Singer : Arman Malik");
        trackRepository.save(trackTwo);
        Track track9 = new Track(Integer.parseInt(env.getProperty("app.trackID")),env.getProperty("app.trackname"),env.getProperty("app.comments"));
        trackRepository.save(track9);

        logs.info("data successfully inserted");
    }
}