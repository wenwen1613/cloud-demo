package org.example.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Service;

/**
 * @author Oops
 * @date 2021年04月06日 下午5:23
 */
@Service
public class HealthStatusService implements HealthIndicator {

    private Boolean status = true;

    @Override
    public Health health() {
        if (status){
            return new Health.Builder().up().build();
        }
        return new Health.Builder().down().build();
    }

    public String getStatus() {
        return this.status.toString();
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
