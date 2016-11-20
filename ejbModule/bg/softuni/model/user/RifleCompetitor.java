package bg.softuni.model.user;

import bg.softuni.model.enumeration.PowerFactor;
import bg.softuni.model.enumeration.RifleDevision;

public class RifleCompetitor extends RegisteredCompetitor {
    private RifleDevision devision;
    private PowerFactor powerFactor;

    public RifleCompetitor() {
        devision = user.getDefaultRifleDevision();
        powerFactor = user.getDefaultHandgunPowerFactor();
    }

    public PowerFactor getPowerFactor() {
        return powerFactor;
    }

    public void setPowerFactor(PowerFactor powerFactor) {
        this.powerFactor = powerFactor;
    }

    public RifleDevision getDevision() {
        return devision;
    }

    public void setDevision(RifleDevision devision) {
        this.devision = devision;
    }
}
