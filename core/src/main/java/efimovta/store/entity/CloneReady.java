package efimovta.store.entity;

/**
 * If available to clone
 * Useful for generic list deep cloning and ect.
 */
public interface CloneReady<T extends CloneReady> {
    T getClone();
}
