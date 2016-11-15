package bg.softuni.model.user;

import bg.softuni.model.enumeration.ShotgunDevision;

public class ShotgunCompetitor extends RegisteredCompetitor {
    private ShotgunDevision devision;

    public ShotgunCompetitor() {
        devision = user.getDefaultShotgunDevision();
    }

    public ShotgunDevision getDevision() {
        return devision;
    }

    public void setDevision(ShotgunDevision devision) {
        this.devision = devision;
    }
}
