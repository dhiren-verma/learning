package designPatterns.creational.prototype;

import java.util.HashMap;
import java.util.Map;

public class StoreManager {
	
	private Map<StoreType, Store> stores;
	
	private StoreManager() {
		stores = new HashMap<>();
	}
	
	private static class StoreManagerHelper {
		private static final StoreManager STORE_INSTANCE = new StoreManager(); 
	}
	
	public static StoreManager getStoreManager() {
		return StoreManagerHelper.STORE_INSTANCE;
	}
	
	public void addNewStore(StoreType storeType, Store store) {
		stores.put(storeType, store);
	}
	
	public Store getStore(StoreType storeType) {
		return stores.get(storeType);
	}
	
	public void removeStore(StoreType storeType) {
		stores.remove(storeType);
	}
	
}
