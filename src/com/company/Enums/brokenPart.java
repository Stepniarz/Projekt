package com.company.Enums;

public enum brokenPart {
        BREAKS(1),
        SUSPENSION(2),
        ENGINE(3),
        BODY(4),
        TRANSMISSION(5);

        int value;
        brokenPart(int i) {
            this.value = i;
        }
        public int getBrokenPartIndex(){
            return this.value;
        }
}
