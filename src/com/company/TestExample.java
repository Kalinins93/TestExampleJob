package com.company;

import java.util.*;


class TestExample{

    public static void main(String[] args) {
        ListUnluckyVassal listUnluckyVassal = new ListUnluckyVassal();
        LazyKing lazyKing = new LazyKing();
        listUnluckyVassal.writeListUnluckyVassal(lazyKing.getPollResults());
        listUnluckyVassal.sortVassalForKing();
        for(UnluckyVassal el: listUnluckyVassal.listVassals)
        { if(el.getVassals()!=null)
           el.vassals.sort(Comparator.comparing(UnluckyVassal::getName));
        }
        listUnluckyVassal.printReportForKing();

    }
}
