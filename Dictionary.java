import java.util.ArrayList;

/**
 * The Dictionary class defines an object containing an ArrayList of key:value pairs.
 *
 * @author Joshua Collins
 * @version 1.0
 * @since 2021-10-28
 */ 
public class Dictionary {

    // The ArrayList of DictionaryObjects
    ArrayList<DictionaryObject> dictionaryList;

    /**
     * The constructor to instantiate a new dictionary and sets dictionaryList equal to an empty ArrayList.
     */
    public Dictionary() {
        this.dictionaryList = new ArrayList<DictionaryObject>();
    }

    /**
     * The addAtIndex method allows insertion into dictionaryList at a given index.
     * 
     * @param index insertion index
     * @param entry object to be inserted
     */
    public void addAtIndex(int index, DictionaryObject entry) {
        dictionaryList.add(index, entry);
    }

    /**
     * The add method allows insertion into a sorted dictionaryList at the correct position.
     * 
     * @param key
     * @param value
     */
    public void add(String key, String value) {
        int insertIndex = 0;
        DictionaryObject entry = new DictionaryObject(key, value);
        for (int i=0; i < dictionaryList.size(); i++) {
            if (dictionaryList.get(i).key.compareToIgnoreCase(entry.key) < 0) {
                insertIndex = i;

            }
        }
        insertIndex++;
        dictionaryList.add(insertIndex, entry);
        return;
    }

    /**
     * The remove method allows the removal of an object from dictionaryList at a given index.
     * 
     * @param index removal index
     */
    public void remove(int index) {
        dictionaryList.remove(index);
    }

    /**
     * The size method returns the size of dictionaryList.
     * 
     * @return the size of the dictionaryList
     */
    public int size() {
        return dictionaryList.size();
    }

    /**
     * The print method iterates through dictionaryList to print the keys and values.
     */
    public void print() {
        for (DictionaryObject obj : dictionaryList) {
            System.out.println("key: " + obj.key);
            System.out.println("value: " + obj.value);
            System.out.println();
        }
    }

    /**
     * The sortByKey method sorts dictionaryList alphabetically by key.
     */
    public void sortByKey() {
        ArrayList<String> keys = new ArrayList<String>();
        for (DictionaryObject obj : dictionaryList) {
            keys.add(obj.key);
        }
        keys.sort(String::compareToIgnoreCase);

        ArrayList<DictionaryObject> newDictionaryList = new ArrayList<DictionaryObject>();
        for (String key : keys) {
            for (DictionaryObject obj : dictionaryList) {
                if (key == obj.key) {
                    newDictionaryList.add(new DictionaryObject(obj.key, obj.value));
                }
            }
        }
        dictionaryList = newDictionaryList;
    }

    /**
     * The get method returns an object from dictionaryList at a given index.
     * 
     * @param index the index of the object to be returned
     * @return object at given index
     */
    public DictionaryObject get(int index) {
        return dictionaryList.get(index);
    }

    /**
     * The toArrayList method returns the contents of the dictionary as an ArrayList. 
     * 
     * @return dictionaryList
     */
    public ArrayList<DictionaryObject> toArrayList() {
        return this.dictionaryList;
    }
}