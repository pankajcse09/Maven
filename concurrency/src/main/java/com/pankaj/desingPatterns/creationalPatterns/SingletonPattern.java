
/**
 * A class of which only a single instance can exist Ensure a class has only one
 * instance, and provide a global point of access to it. Encapsulated
 * "just-in-time initialization" or "initialization on first use"
 * 
 * @Problem Application needs one, and only one, instance of an object.
 * Additionally, lazy initialization and global access are necessary.
 * 
 * @version 1.0
 * @author 557027(Pankaj Bharti)
 */
 
 public class SingletonPattern{
   /**
	 * Check list 
	 * 1. Define a private static attribute in the "single instance" class. 
	 * 2. Define a public static accessor function in the class. 
	 * 3. Do "lazy initialization" (creation on first use) in the accessor function.
	 * 4. Define all constructors to be protected or private. 
	 * 5. Clients may only use the accessor function to manipulate the Singleton.
	 */
	 
	 private SingletonPattern(){}
	 private static SingletonPattern INSTANCE;
	 /** Bill Pugh Singleton Implementation */
	public static class SingletonHelper {
		private static final SingletonPattern instance = new SingletonPattern();
	}

	/** Bill Pugh Singleton Implementation */
	public static SingletonPattern getBillPughInstance() {
		return SingletonHelper.instance;
	}

	/** Lazy initialization method to implement Singleton pattern */
	public static SingletonPattern getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new SingletonPattern();
		}
		return INSTANCE;
	}

	/**
	 * Thread Safe Singleton initialization method 
	 * to implement Singleton pattern
	 */
	public static synchronized SingletonPattern getThreadSafeInstance() {
		if (INSTANCE == null) {
			INSTANCE = new SingletonPattern();
		}
		return INSTANCE;
	}

	/**
	 * Double checked locking implementation method
	 * to implement Singleton pattern
	 */
	public static SingletonPattern getInstanceUsingDoubleLocking() {
		if (INSTANCE == null) {
			synchronized (SingletonPattern.class) {
				if (INSTANCE == null) {
					INSTANCE = new SingletonPattern();
				}
			}
		}
		return INSTANCE;
	}
	 
 }
