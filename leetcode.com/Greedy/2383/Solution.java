class Solution {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int h = 0;
        for (int i = 0; i < energy.length; i++) {
            if (initialEnergy <= energy[i]) {
                int trainHours = (energy[i] - initialEnergy) + 1;
                initialEnergy += trainHours;
                h += trainHours;
            }
            if (initialExperience <= experience[i]) {
                int trainHours = (experience[i] - initialExperience) + 1;
                initialExperience += trainHours;
                h += trainHours;
            }
            initialEnergy -= energy[i];
            initialExperience += experience[i];
        }
        return h;
    }
}