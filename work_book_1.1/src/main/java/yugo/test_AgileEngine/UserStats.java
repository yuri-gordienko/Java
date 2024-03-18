package yugo.test_AgileEngine;

import java.util.Optional;

class UserStats {

    private Optional<Long> visitCount;

    public UserStats(Long visitCount) {
        this.visitCount = Optional.ofNullable(visitCount);
    }

    public Optional<Long> getVisitCount() {
        return visitCount;
    }
}
