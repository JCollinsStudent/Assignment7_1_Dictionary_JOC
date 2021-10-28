/**
 * The DictionaryObject class defines an object containing a key and a value.
 *
 * @author Joshua Collins
 * @version 1.0
 * @since 2021-10-28
 */ 
public class DictionaryObject {
    public String key;
    public String value;
    
    /**
     * The constructor instantiates a new DictionaryObject with a given key and value.
     * 
     * @param key
     * @param value
     */
    public DictionaryObject(String key, String value) {
        this.key = key;
        this.value = value;
    }
}