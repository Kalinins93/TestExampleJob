package com.company;

import java.util.*;

public class ListUnluckyVassal {
    public ArrayList<UnluckyVassal> listVassals;

    public ListUnluckyVassal() {
        this.listVassals = new ArrayList<>();
        UnluckyVassal king = new UnluckyVassal("Король");
        this.listVassals.add(king);
    }

    public UnluckyVassal findUnluckyVassal(String name) {
        for (UnluckyVassal element : this.listVassals) {
            if (element.getName().contains(name)) {
                return element;
            }
        }
        return null;
    }

    public List<UnluckyVassal> addList(String string, UnluckyVassal parent) {
        String[] list = string.split(", ");
        List<UnluckyVassal> listvassal = new ArrayList<>();
        for (String vassal : list
        ) {
            if (this.findUnluckyVassal(vassal) == null) {
                UnluckyVassal tempUnluckyVassal = new UnluckyVassal(vassal);
                tempUnluckyVassal.setParent(parent);
                this.listVassals.add(tempUnluckyVassal);
                listvassal.add(tempUnluckyVassal);
            } else {
                this.findUnluckyVassal(vassal).setParent(parent);
                listvassal.add(this.findUnluckyVassal(vassal));
            }
        }
        return listvassal;
    }

    public void addVassalKing(UnluckyVassal child) {
        if (this.listVassals.get(0).getVassals() == null) {
            List<UnluckyVassal> listvassal = new ArrayList<>();
            listvassal.add(child);
            this.listVassals.get(0).setVassals(listvassal);
        } else {
            this.listVassals.get(0).getVassals().add(child);
        }
    }

    public void writeListUnluckyVassal(List<String> pollResults) {
        for (String items : pollResults) {
            if (!items.contains(":")) {
                if (this.findUnluckyVassal(items) == null) {
                    UnluckyVassal unluckyVassal = new UnluckyVassal();
                    unluckyVassal.setName(items);
                    this.listVassals.add(unluckyVassal);
                }
            } else {
                String name = items.substring(0, items.lastIndexOf(':'));
                String values = items.substring(items.lastIndexOf(':') + 2);

                if (this.findUnluckyVassal(name) == null) {
                    UnluckyVassal unluckyVassal = new UnluckyVassal();
                    unluckyVassal.setName(name);
                    unluckyVassal.setVassals(this.addList(values, unluckyVassal));
                    this.listVassals.add(unluckyVassal);
                } else {
                    this.findUnluckyVassal(name).setVassals(this.addList(values, this.findUnluckyVassal(name)));
                }
            }
        }
    }

    public void sortVassalForKing() {
        for (UnluckyVassal element : this.listVassals) {
            if (element.getParent() == null && !element.getName().equals("Король")) {
                this.listVassals.get(this.listVassals.lastIndexOf(element)).setParent(this.findUnluckyVassal("Король"));
            }
        }
        for (UnluckyVassal element : this.listVassals) {
            if (element.getParent() != null && element.getParent().getName().equals("Король")) {
                addVassalKing(element);
            }
        }
        for (UnluckyVassal element : this.listVassals) {
            if (element.getVassals() != null)
                element.vassals.sort(Comparator.comparing(UnluckyVassal::getName));
        }
    }

    public void printVassals(List<UnluckyVassal> list, int level) {
        for (UnluckyVassal el : list
        ) {
            String levels = "--";
            int i = 0;
            while (i < level) {
                levels = levels + levels;
                i++;
            }
            System.out.println(levels + el.getName());
            if (el.getVassals() != null) {
                printVassals(el.getVassals(), level + 1);
            }
        }
    }

    public void printReportForKing() {
        for (UnluckyVassal element : this.listVassals) {
            if (element.getParent() == null) {
                System.out.println(element.getName());
                printVassals(element.getVassals(), 0);
            }
        }
    }
}