package io.github.stardew.mini.model.game;

// TimeSystem.java
public class TimeSystem {
    private float dayProgress; // 0 to 1 representing the day

    public void update(float delta) {
        dayProgress += delta / 120; // 2-minute day cycle
        if (dayProgress >= 1) {
            dayProgress = 0;
            // Handle new day
        }
    }
}
