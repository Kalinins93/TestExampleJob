package com.company;

import java.util.*;


class TestExample{

    public static void main(String[] args) {
        SetUnluckyVassal setUnluckyVassal = new SetUnluckyVassal();
        LazyKing lazyKing = new LazyKing();
        setUnluckyVassal.writeSetUnluckyVassal(lazyKing.getPollResults());
        setUnluckyVassal.sortVassalForKing();
        setUnluckyVassal.printReportForKing();

    }
}
