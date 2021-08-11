import java.util.*;

class List {
    private ArrayList<String> itemList = new ArrayList<String>();

    public void addItem(String item) {
        itemList.add(item);
    }

    public void deleteItem(int number) {
        for(int i=0; i < itemList.size(); i++) {
            if(i == (number-1)) {
                itemList.remove(i);
            }
        }
    }

    public String printItems() {
        String list = "";
        //System.out.println("\nВаш список:");
        for(int i=0; i<itemList.size(); i++) {
           list = (i+1) + ". " + itemList.get(i);
        }
        return list;
    }
}