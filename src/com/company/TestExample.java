package com.company;

class TestExample {

    public static void main(String[] args) {
        ListUnluckyVassal listUnluckyVassal = new ListUnluckyVassal();
        LazyKing lazyKing = new LazyKing();
        listUnluckyVassal.writeListUnluckyVassal(lazyKing.getPollResults());
        listUnluckyVassal.sortVassalForKing();
        listUnluckyVassal.printReportForKing();

    }
}
