import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class StorageFacility {

    private HashMap<String, ArrayList<String>> facility;

    public StorageFacility() {
        this.facility = new HashMap<>();
    }

    public void add(String unit, String item) {
        this.facility.putIfAbsent(unit,new ArrayList<>());
        this.facility.get(unit).add(item);
    }

    public ArrayList<String> contents(String storageUnit) {
        return this.facility.getOrDefault(storageUnit,new ArrayList<>());
    }

    public void remove(String storageUnit, String item) {
        if (this.facility.containsKey(storageUnit)) {
            ArrayList<String> contents = this.facility.get(storageUnit);

            int itemIndex = 0;
            for (String content : contents) {
                if (item.equals(content)) {
                    break;
                }
                itemIndex++;
            }

            if (this.facility.get(storageUnit).size() == 1) {
                this.facility.remove(storageUnit);
            } else {
                this.facility.get(storageUnit).remove(itemIndex);
            }
        }
    }

    public ArrayList<String> storageUnits() {
        ArrayList<String> storageUnits = new ArrayList<>();
        for (String units : this.facility.keySet()) {
            storageUnits.add(units);
        }
        return storageUnits;
    }

}
