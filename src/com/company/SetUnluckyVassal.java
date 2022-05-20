package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class SetUnluckyVassal {
    public ArrayList<UnluckyVassal> sortedSet;

    public SetUnluckyVassal() {
        this.sortedSet = new ArrayList<>();
        UnluckyVassal king = new UnluckyVassal("Король");
        this.sortedSet.add(king);
    }

    public ArrayList<UnluckyVassal> getSortedSet() {
        return sortedSet;
    }


    public UnluckyVassal findUnluckyVassal(String name) {
        for (UnluckyVassal element : this.sortedSet) {
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
                this.sortedSet.add(tempUnluckyVassal);
                listvassal.add(tempUnluckyVassal);
            } else {
                this.findUnluckyVassal(vassal).setParent(parent);
                listvassal.add(this.findUnluckyVassal(vassal));
            }
        }
        listvassal.stream().sorted(Comparator.comparing(UnluckyVassal::getName))
                .collect(Collectors.toList());
        return listvassal;
    }
    public void addVassalKing( UnluckyVassal child) {
        if(this.sortedSet.get(0).getVassals()==null){
            List<UnluckyVassal> listvassal = new ArrayList<>();
            listvassal.add(child);
            this.sortedSet.get(0).setVassals(listvassal);
        }
        else
        {
            this.sortedSet.get(0).getVassals().add(child);
        }

    }
    public void writeSetUnluckyVassal(List<String> pollResults) {
        for (String items : pollResults) {
            if (!items.contains(":")) {
                if (this.findUnluckyVassal(items) == null) {
                    UnluckyVassal unluckyVassal = new UnluckyVassal();
                    unluckyVassal.setName(items);
                    this.sortedSet.add(unluckyVassal);
                }
            } else {

                String name = items.substring(0, items.lastIndexOf(':'));
                String values = items.substring(items.lastIndexOf(':') + 2);

                if (this.findUnluckyVassal(name) == null) {
                    UnluckyVassal unluckyVassal = new UnluckyVassal();
                    unluckyVassal.setName(name);
                    unluckyVassal.setVassals(this.addList(values, unluckyVassal));
                    this.sortedSet.add(unluckyVassal);
                } else {
                    this.findUnluckyVassal(name).setVassals(this.addList(values, this.findUnluckyVassal(name)));
                }
            }
        }
    }

    public void sortVassalForKing() {
        for (UnluckyVassal element : this.sortedSet) {
            if (element.getParent()== null&& element.getName()!="Король") {
                this.sortedSet.get(this.sortedSet.lastIndexOf(element)).setParent(this.findUnluckyVassal("Король"));
 }


        }
        List<UnluckyVassal> list=null;
        for (UnluckyVassal element : this.sortedSet) {
            if (element.getParent()!=null&&element.getParent().getName()=="Король")
            {
              addVassalKing(element);
            }
        }
    }
    public void printVassals(List<UnluckyVassal> list, int level){
            for (UnluckyVassal el: list
                 ) {
                String levels = new String("--");
                int i=0;
                while (i<level){
                    levels= levels+levels;
                    i++;
                }
                System.out.println(levels+el.getName());
                if(el.getVassals()!=null){
                    printVassals(el.getVassals(),level+1);
                }


    }}
    public void printReportForKing() {
        for (UnluckyVassal element : this.sortedSet) {

            if (element.getParent() == null) {
                System.out.println(element.getName());

                    printVassals(element.getVassals(),0);
            }



    }
    }
}