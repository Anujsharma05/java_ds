package java_17.records;

/**
 * Immutable and final by default
 * Cannot become parent or subtype (ie no inheritance) because implicitly extends Record class
 * Cannot have instance fields, only components defined in parameters
 * Implicitly generate constructor, getters, equals, hashcode, toString
 * Static fields methods allowed
 * It can implement interfaces
 */
public record CarRecord(String regNumber, String owner) {}
