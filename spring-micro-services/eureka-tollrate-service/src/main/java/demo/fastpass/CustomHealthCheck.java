package demo.fastpass;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CustomHealthCheck implements HealthIndicator {

    int errorCode;

    @Override
    public Health health() {
        System.out.println("Health Check Performed with error code "+errorCode);
        errorCode++;
        if(errorCode > 4 && errorCode < 8){
            return Health.down().withDetail("Custom Error Code",errorCode).build();
        }
        return Health.up().build();
    }
}
