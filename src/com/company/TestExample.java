package com.company;

import java.util.*;


class TestExample{

    public static void main(String[] args) {
        SetUnluckyVassal setUnluckyVassal = new SetUnluckyVassal();
        LazyKing lazyKing = new LazyKing();
        setUnluckyVassal.writeSetUnluckyVassal(lazyKing.getPollResults());
        setUnluckyVassal.sortVassalForKing();
        for(UnluckyVassal el: setUnluckyVassal.sortedSet)
        { if(el.getVassals()!=null)
           el.vassals.sort(Comparator.comparing(UnluckyVassal::getName));
        }
        setUnluckyVassal.printReportForKing();

    }
}
