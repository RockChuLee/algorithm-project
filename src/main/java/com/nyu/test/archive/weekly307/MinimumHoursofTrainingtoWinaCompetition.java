package com.nyu.test.archive.weekly307;

public class MinimumHoursofTrainingtoWinaCompetition {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {

        int n = energy.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (initialEnergy <= energy[i]) {
                ans += energy[i] - initialEnergy + 1;
                initialEnergy = 1;
            } else {
                initialEnergy -= energy[i];
            }

            if (initialExperience <= experience[i]) {
                ans += experience[i] - initialExperience + 1;
                initialExperience = experience[i] + 1 + experience[i];
            } else {
                initialExperience += experience[i];
            }
        }
        return ans;
    }

}
