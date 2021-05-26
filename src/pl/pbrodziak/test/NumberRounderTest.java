package pl.pbrodziak.test;

import pl.pbrodziak.NumberRounder;

class NumberRounderTest {
    public static void main(String[] args) {
        shouldRoundToTwoPlaces();
    }


    static void shouldRoundToTwoPlaces() {
        assert NumberRounder.roundedToXDecimalPlaces(101.0982, 2) == 101.10 : "Bład";
    }

}
